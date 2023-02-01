public class ListStack implements Stack{
    int size;
    Node top;
  
    
    public ListStack(){
        size = 0;
        top = null;
    }
    public int size(){
      return size;
    }
    public boolean isEmpty(){
      if(size==0){
      return true;
      }else{
      return false;
      }
    }
    public void push(Object e) throws StackOverflowException{
    Node n= new Node(e , null);
    n.next= top;
    top = n;
    size++;
    }
    public Object pop() throws StackUnderflowException{
      if(size==0){
             throw new StackUnderflowException();
      }
      else{
      Object temp = top.val;
      top = top.next;
      return top.val;
      }
    }
    public Object peek() throws StackUnderflowException{
      if(size==0){
        throw new StackUnderflowException();
      }else{
        if(size>0){ 
          size--;
        }
      }
    return top.val;
    }   
  public String toString(){
  String str = "[" ;
  for(Node n = top; n!=null; n=n.next)
  {
  str = str + n.val; 
  }
    str = str + "]";
    return str;
  }
  public Object[] toArray(){
   Object [] arr = new Object[size];
     Node temp = top;
    for(int i=0; i<size; i++){
      arr[i] = temp.val;
      temp = temp.next;
    }
    return arr;
  }
  public int search(Object e){
      Node temp = top; 
      int count = 0;
    if(size <= count) 
      return -1;
    else{
      do{
        if(temp.val != e){
          if(size == 1) return -1;
          else{
            count++;
            temp = temp.next;
          }
        }
        else
          return count;
      } while(count < size-1);
      return count;
    }
  }
}