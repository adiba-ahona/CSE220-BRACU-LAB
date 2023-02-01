public class TestCircularArray{
  
  String [] cir;
  int size;
  int start;
  
  public TestCircularArray(String[]lin, int st, int sz){
    // Initialize the gloabal variables with the local ones
    // For the array, please copy the elements one by one from lin to cir
    // DO NO copy the address
    // Copy lin[0] to cir[st]
    cir =new String[lin.length];
    this.size = sz;
    this.start = st;
    // TO DO
    int count = start;
    for(int i=0;i<size;++i){
    cir[count]=lin[i];
    count =(count+1)%cir.length;
    }
    display();
    
  }
  
  public void sort(){
    // Sort the cir array using bubble/selection sort
    // Alert! The numbers in the array are in Strings
    // convert them to integer first
    // hint: Integet.parseInt()
    
    // TO DO
      for(int i=start;i<start+size;++i){
          for(int j=i;j<start+size;++j){
             int v =i%cir.length;
             int l =j%cir.length;
              if(Integer.parseInt(cir[v])>Integer.parseInt(cir[l])){
              String temp=cir[v];
              cir[v]=cir[l];
              cir[l]=temp;
              }
              }
        }
    
    display();
  }
  
  public int countOdd(){
    /* From the cir array, you have to count the number of odd numbers.
     * It is not as easy as it looks. Firstly, notice that the numbers are given as strings. 
     * To determine whether a number is odd,you first have to sum up the digits. 
     * For example if one number is "234", you have to find the result of 2+3+4. 
     * If the summation is odd then consider the number as odd.
     * Then return the count.
     */
    int count = 0; int st = start;
     for(int i =0;i<size;i++){
       String word = cir[st];
       int num = 0;
       for(int j=0;j<word.length();j++){
         num = num + (int)(word.charAt(j));
       }
       if (num%2!=0){
         count++;
       }
       st = (st+1)%cir.length;
     }
    return count;
  }
  
  public int countEven(){
    /* From the cir array, you have to count the number of even numbers.
     * It is not as easy as it looks. Firstly, notice that the numbers are given as strings. 
     * To determine whether a number is even, you first have to sum up the digits. 
     * For example if one number is "234", you have to find the result of 2+3+4. 
     * If the summation is even then consider the number as even.
     * Then return the count.
     */
    
    // TO DO
     int count = 0; int st = start;
     for(int i =0;i<size;i++){
       String word = cir[st];
       int num = 0;
       for(int j=0;j<word.length();j++){
         num = num + (int)(word.charAt(j));
       }
       if (num%2==0){
         count++;
       }
       st = (st+1)%cir.length;
     }
    return count;
  }
  
 public void insert(String item,int offset) throws CircularArrayException{
//    /* If there are no empty spaces, throw CircularArrayException
//     * This class must be created
//     * you must createhe CircularArrayException object send the name of the particular exception as String in the constructor
//     * one of them is done for you
//     * 
//     * If there is/are empty space(s), insert using LEFT shift.
//     * Offset means how far from start. The index has been calculated for you.
//     * Offset cannot be more than size
//     * Note that the element pointed by start will also shift, hence change the start at the end
//     * increment size
//     */
    
    if (offset<0 || offset>size){
      throw new CircularArrayException("Invalid offset");
    }
    
    if (size==cir.length){
      throw new CircularArrayException("Array full");
    }
    
    int idx = (start+offset)%cir.length;  
    
    // TO DO
    
      for(int i=start;i<=start+offset;++i){
      cir[i-1]=cir[i];
      i=i%cir.length; 
      }
      cir[idx]=item;
      start--;
      size++;
    display();
  }
  
  public String delete (int offset)throws CircularArrayException{
    /* If there are no empty spaces, throw CircularArrayException
     * This class must be created
     * you must send the name of the particular exception as String in the constructor
     * shown in insert()
     * 
     * Delete using right shift.
     * Note that the element pointed by start will also shift, hence change the start at the end
     * decrement size
     * return the delete element
     */
    
    // TO DO
    int to = (start+offset)%cir.length;
     int from =to-1;
     if(from<0){
     from=start;
     }
     while(to!=start){
         cir[to]=cir[from];
     to =(to-1);
     if(to<0){
     to=cir.length-1;
     }
     from =(from-1);
     if(from<0){
     from=start;
     }
     }
     cir[start]=null;
     size--;
     start=(start+1)%cir.length;

    display();
    return null;
  }
  
  public void display(){
    int i = 0;
    int st = start;
    while(i<size){
      System.out.print(cir[st]+" ");
      i++;
      st = (st+1)%cir.length;
    }
    System.out.println();
  }
  
  
}