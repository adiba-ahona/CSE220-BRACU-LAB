public class ArrayQueue implements Queue{
    int size;
    int start;
    int front;
    int rear;
    Object [] data;
    
    public ArrayQueue(){
        start=0;
        size =0;
        rear =-1;
        front =-1;
        data = new Object[5];
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
    public void enqueue(Object e) throws QueueOverflowException{
    }
    public Object dequeue() throws QueueUnderflowException{
        return null;
    }
    public Object peek() throws QueueUnderflowException{
             if(size==0){
        throw new StackUnderflowException();
      }else{
        if(size>0){ 
          size--;
        }
      }
    return front.val;
    }
    }
    public String toString(){
        return " ";
    }
    public Object[] toArray(){
        return null;
    }
    public int search(Object e){
    return -1;
    }
}