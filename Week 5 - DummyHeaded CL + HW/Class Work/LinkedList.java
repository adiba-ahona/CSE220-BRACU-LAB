public class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(int [] a){
    Node new_node = new Node (a[0], null);
    head = new_node;
    for(int i =1; i< a.length; i++){
      Node array_node = new Node (a[i], null);
      new_node.next = array_node;
      new_node = new_node.next;
    }
      
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head = h;
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    int count =0;
    Node new_node = head;
    while (new_node != null){
      count ++;
      new_node = new_node.next;
    }
    return count ; // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList(){
    Node new_node = head;
    while (new_node != null){
      System.out.print(new_node.element +" ");
      new_node = new_node.next;
    }
    
    System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    int count =0;
    Node new_node = head;
    Node return_node = null;
    while (new_node != null){
      if(count == idx){
        return_node = new_node;
        break;
      }
      count++;
      new_node = new_node.next;
    }
    return return_node; // please remove this line!
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    int count =0;
    Node new_node = head;
    //Node return_node = null;
    while (new_node != null){
      if(count == idx){
        return new_node.element;
        //break;
      }
      count++;
      new_node = new_node.next;
    }
    return null; // please remove this line!
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, int elem){
 int i=0;
    for (Node n=head; n!=null; n=n.next)
    {
      if(i==idx){
        int temp = n.element;
        n.element = elem;
      return temp;
      }
      else{
      i++;
      }
    }
    return null; // please remove this line!
  }
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(int elem){
    // TO DO
            int i=0;
    for (Node n=head; n!=null; n=n.next)
    {
      if(n.element==elem){
      return i;
      }
      else{
      i++;
      }
    }
    return -1; // please remove this line!
  }
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    // TO DO
    return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    // TO DO
        Node copyfield = new Node(head.element, null);
    Node tail = copyfield;
    for(Node n=head.next; n!=null; n=n.next){
   Node p = new Node(n.element, null);
     tail.next = p;
     tail=tail.next;
    }
    return copyfield; // please remove this line!
  }
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    Node x=head;
    Node rHead= new Node(head.element, null);
    for (x=head.next; x!=null; x=x.next){
      rHead= new Node(x.element, rHead);
    }
    return rHead;
    //return null; // please remove this line!
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(int elem, int idx){
    // TO DO
    if(idx>=0 && idx<=countNode()){
      Node n = new Node(elem, null);
      if(idx==0){
        n.next = head;
        head = n;
      }
      else if(idx==countNode()){
        Node h = head;
        while(h.next!=null){
          h = h.next;
        }
        h.next=n;
      }
      else{
        Node h = head;
        for(int i=0; i<idx-1; i++){
          h = h.next;
        }
        Node t = h.next;
        n.next=t;
        h.next = n;
      }
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
    // TO DO
     if(index==0){
    Node x = head;
    head = head.next;
    x = null;
    }
    else{
    Node h = head;
    for(int i=0; i<index-1; i++){
    h = h.next;
    }
    Node x = h.next;
    Node y = x.next;
    h.next = y;
    x = null;
    }
    return null; // please remove this line!
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    // TO DO
        if(head!=null){
      Node tail=nodeAt(countNode()-1);
      tail.next=head;
      Node temp=head;
      head=head.next;
      temp.next=null;
    }
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    // TO DO
        int size = countNode();
    Node newHead = nodeAt(size-1);
    nodeAt(size-2).next = null;
    newHead.next = head;
    head = newHead;
  }
}