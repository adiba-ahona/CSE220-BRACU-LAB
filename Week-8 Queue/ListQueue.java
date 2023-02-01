public class ListQueue implements Queue{
    int size;
    Node front;
    Node rear;
    
    public ListQueue(){
        size = 0;
        front = null;
        rear =null;
    }
    
        public int size(){
        return -1;
    }
    
    public boolean isEmpty(){
        return false;
    }
    
    public void enqueue(Object e) throws QueueOverflowException{
    }
    
    public Object dequeue() throws QueueUnderflowException{
        return null;
    }
    
    public Object peek() throws QueueUnderflowException{
        return null;
    }
    
    public String toString(){
        return "";
    }
    
    public Object[] toArray(){
        return null;
    }
    
    public int search(Object e){
    return -1;
    }
}