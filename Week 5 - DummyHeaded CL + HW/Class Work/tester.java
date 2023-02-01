public class tester{
  public static void main(String []args){
    int [] a = {40,50,10,20,30};
    DummyHeadedCircularList d = new DummyHeadedCircularList();
    d.buildFromArray(a,2,5);
    d.printList();// this should print 10,20,30,40,50
    
    int [] a1 = {10,20,30,40};
    LinkedList L = new LinkedList(a1);
    L.printList();
    DummyHeadedCircularList d1 = new DummyHeadedCircularList();
    d1.buildFromList(L.head);
    d1.printList();
    d1.addElement(40,3);
    d1.printList();
    d1.deleteElement(2);
    d1.printList();
 
    LinkedList h4 = new LinkedList(a1); 
    Node revH=h4.reverseList();
    LinkedList h5 = new LinkedList(revH); 
    h5.printList(); 
  
  }
}