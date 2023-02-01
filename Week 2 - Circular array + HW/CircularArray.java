public class CircularArray{
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    cir = lin; start = st; size = sz;
    Object[] temp = new Object[lin.length];
    for(int i=0, j=start; i<lin.length; i++){
      temp[(j++)%lin.length] = cir[i];
    }
    cir = temp;
  }
  
  // Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
    for(int i=0; i<cir.length; i++){
      System.out.print(cir[i]);
      if(i<cir.length-1){
        System.out.print(", ");
      }
    }
    System.out.println();
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    Object[] temp = cir;
    for(int j=0, i=start; j<size; j++, i++){
      System.out.print(temp[(i)%temp.length]);
      if(j<size-1){
        System.out.print(", ");
      }
    }
    System.out.println();
  }
  
  public void printBackward(){
    Object[] tempCir = cir;
    for(int j=0, i=(start+size-1)%tempCir.length; j<size; j++, i--){
      if(i<0){
        i = tempCir.length-1;
        System.out.print(tempCir[i]);
      } else{
        System.out.print(tempCir[i]);
      }
      if(j<size-1){
        System.out.print(", ");
      }
    }
    System.out.println();
  }
  
  // With no null cells
  public void linearize(){
    Object[] tempCir = new Object[size];
    for(int i=0, j=start; i<size; i++){
      tempCir[i] = cir[(j++)%cir.length];
    }
    cir = tempCir;
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    Object[] tempCir = new Object[newcapacity];
    for(int i=0, j=start; i<size; i++, j++){
      tempCir[j%tempCir.length] = cir[j%cir.length];
    }
    cir = tempCir;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    Object[] tempCir = new Object[newcapacity];
    for(int i=0, j=start; i<size; i++, j++){
      tempCir[i] = cir[j%cir.length];
    }
    cir = tempCir;
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    if(size == cir.length){
      resizeStartUnchanged(cir.length+3);
    }
    Object[] tempCir = cir;
    for(int i=(start+size)%tempCir.length; i>=(start+pos); i--){
      tempCir[(i)%tempCir.length] =  tempCir[i-1];
    }
    tempCir[(start+pos)%tempCir.length] = elem;
    size++;
  }
  
  public void insertByLeftShift(Object elem, int pos){
    if(size == cir.length){
      resizeStartUnchanged(cir.length+3);
    }
    Object[] tempCir = cir;
    for(int i=start; i<=(start+pos)%tempCir.length; i++){
      if(i-1 < 0){
        i = tempCir.length-1;
      }
      tempCir[i-1] = tempCir[i];
    }
    tempCir[(start+pos)%tempCir.length] = elem;
    size++; start--;
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
    Object[] tempCir = cir;
    for(int i=start+pos; i<start+size; i++){
      tempCir[i%tempCir.length] = tempCir[(i+1)%tempCir.length];
    }
    size--;
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    Object[] tempCir = cir;
    for(int i=(start+pos)%tempCir.length; i>=start; i--){
      if((i-1) < 0){
        i = tempCir.length-1;
      }
      tempCir[i] = tempCir[i-1];
    }
    start++; size--;
  }
  
  //This method will check whether the array is palindrome or not
  public void palindromeCheck(){
    int notPal = 0;
    
    if(size%2 != 0){
      int n = start+(size-1)/2;
      for(int i=1; i<(size+1)/2; i++){
        if(cir[(n-i)%cir.length] != cir[(n+i)%cir.length]){
          notPal++;
        }
      }
    }
    else{
      for(int i=0; i<=(size/2); i++){
        if(cir[(start+((size/2)-1)+i)%cir.length] != cir[(start+(size/2)-i)%cir.length]){
          notPal++;
        }
      }
    }
    
    if(notPal > 0){
      System.out.println("This array is NOT a palindrome");
    }
    else{
      System.out.println("This array is a palindrome");
    }
  }
  
//  This method will sort the values by keeping the start unchanged
//  public void sort(){
//    for(int i=start; i<(start+size)-1; i++){
//      for(int j=i+1; j<start+size; j++){
//        if((int)cir[j%cir.length]<(int)cir[i%cir.length]){ // WHY DO I HAVE TO CONVERT DATA TYPE HERE ???
//          int temp = (int)cir[j%cir.length];
//          cir[j%cir.length] = (int)cir[i%cir.length];
//          cir[i%cir.length] = temp;
//        }
//      }
//    }
//  }
  
  //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
  public boolean equivalent(CircularArray k){
    boolean equal = true;
    if(k.size != size){
      equal = false;
    }
    else{
      for(int i=start, j=k.start; i<start+size; i++, j++){
        if(k.cir[j%k.cir.length] != cir[i%cir.length]){
          equal = false;
          break;
        }
      }
    }
    return equal;
  }
}
