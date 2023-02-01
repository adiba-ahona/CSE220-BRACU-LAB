public class QueueTester{
  public static void main(String[]args){
 ListQueue a = new ListQueue();
    try{
    a.enqueue(10);
    a.enqueue(20);
    a.enqueue(30);
    a.enqueue(40);
    a.enqueue(50);
    a.enqueue(60);
    }
    catch(QueueOverflowException e){
      System.err.println(e);
    }
    
    Object[]x=a.toArray();
    for(int i=0;i<x.length;i++){
        if(i<x.length-1){
            System.out.print(x[i]+", ");
        }
        else{
            System.out.println(x[i]+".");
        }
    }
   

    System.out.println(a.toString());
    System.out.println("Size of the Queue: "+a.size());
    System.out.println("Offset from the Queue: "+a.search(20));
    try{
    a.dequeue();
    a.dequeue();
    
    }
    catch(QueueUnderflowException e){
      System.err.println(e);
    }
    
    System.out.println(a.toString());
    
    System.out.println("Offset from the Queue: "+a.search(50));
    
    try{
    a.dequeue();
    a.dequeue();
    
    }catch(QueueUnderflowException e){
      System.err.println(e);
    }
    System.out.println(a.toString());
    try{
    System.out.println("Peek: "+a.peek());
    }
    catch(QueueUnderflowException e){
      System.err.println(e);
    }
    try{
    a.dequeue();
    a.dequeue();
    a.dequeue();
    }catch(QueueUnderflowException e){
      System.err.println(e);
    }
    System.out.println(a.toString());
    System.out.println("Size of the Queue: "+a.size());
    x=a.toArray();
    for(int i=0;i<x.length;i++){
        if(i<x.length-1){
            System.out.print(x[i]+", ");
        }
        else{
            System.out.println(x[i]+".");
        }
    }
    
  }
  }
