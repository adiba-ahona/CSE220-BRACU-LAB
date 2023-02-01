public class QueueWithLLTester{
  public static void main (String []args){
    
 Object [] a7 = {10,20,30,40,50,60,70};
   ArrayQueue a=new ArrayQueue();
   System.out.println(a.Size());
   a.IsEmpty();
   a.Enqueue(1);
   a.Enqueue(2);
   a.Enqueue(3);
   a.Enqueue(4);
   a.Enqueue(5);
   
   System.out.println(a.Size());
   a.Dequeue();
   a.Dequeue();
   a.Dequeue();
   
   System.out.println(a.Size()); //etai print deini dekhe output ashena cse111 stuff
   
   System.out.println(a.peek());
   
   System.out.println(a.toString());
   
   a.Search(5);
   System.out.println(a.Search(5));
   
   a.Search(6);
   System.out.println(a.Search(6));
  }
  }