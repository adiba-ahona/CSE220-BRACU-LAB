public class DummyHeadedCircularList{
  Node head;
  
  /* Build a Dummy Headed Circular List from the given circular array
   */
  public void buildFromArray(int[]cir,int st,int size){
    head = new Node (0,null);
    Node tail = new Node (cir[st], null);
    head.next = tail;
    int count = st;
    for(int i=1; i<size; i++){
      count = (count+1)%cir.length;
      Node new_node = new Node (cir[count], null);
      tail.next = new_node;
      tail = tail.next;
    }
    tail.next = head;
    // TO DO
  }
  
  /* Build a Dummy Headed Circular List from the given Non Dummy Headed Non Circular List 
   */
  public void buildFromList(Node h){
    head = new Node (0,null);
    head.next = h;
    Node tail = head.next;
    for(Node n = h.next; n!=null;n=n.next){
      tail.next = n;
      tail = tail.next;
    }
    tail.next = head;
    // TO DO
  }
  
  /* Build a Dummy Headed Circular List from the given Non Dummy Headed Non Circular List
   * The elements of the new Dummy Headed list must in reverse order
   */
  public void buildReverse(Node h){
    // TO DO
    head = new Node(0, null);
    Node x = h;
    Node rhead = new Node(h.element , null);
    for(x = h.next; x!= null; x = x.next){
    rhead = new Node(x.element, rhead);
    }
    head.next =rhead;
   
    Node tail = head;
    while(tail.next!= null)
    {
    tail = tail.next;
    }
    tail.next = head;
  }
  /* Insert the element in the given index.
   * Index 0 is the index after the dummy head
   */ 
    public int countNode(){
    // TO DO
    int count = 0;
    for(Node n = head.next; n!= head;  n= n.next){
    count++;
    }
    return count;
    }
  public void addElement(int element, int index){
    // TO DO
      if(index>=0 && index<=countNode()){
      Node n = new Node(element, null);
      if(index==0){
        n.next = head;
        head = n;
      }
      else if(index==countNode()){
        Node h = head;
        while(h.next!=null){
          h = h.next;
        }
        h.next=n;
      }
      else{
        Node h = head;
        for(int i=0; i<index-1; i++){
          h = h.next;
        }
        Node t = h.next;
        n.next=t;
        h.next = n;
      }
    }
  }
  
  /* Delete the element from the given index.
   * Index 0 is the index after the dummy head
   */ 
  public void deleteElement(int index){
    // TO DO
        if(index==0){
    Node x = head;
    head = head.next;
    x = head;
    }
    else{
    Node h = head.next;
    for(int i=1; i<index-1; i++){
    h = h.next;
    }
    Node x = h.next;
    Node y = x.next;
    h.next = y;
    x = head;
    }
  }
  public void printList(){
    Node new_node = head.next;
    while (new_node != head){
      System.out.print(new_node.element +" ");
      new_node = new_node.next;
    }
    //System.out.print(new_node.element);
    
    System.out.println();
  }

}
  