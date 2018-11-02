public class LinkedList implements List{
	public Node head; 
	public int size; 
	public LinkedList list;

	public LinkedList(){
		size=0;
    list = new LinkedList();
		
	}

	public void add(Object obj) {
        Node newNode = new Node(obj);

        if (size==0) {
            head=newNode;
            size++;
            return;
        }
        Node node = get(size-1);
        node.setNext(newNode);

    }

    public void add(int pos, Object obj){
    	if(pos<0||pos>size){
    		throw new IndexOutOfBoundsException("Index is out of the limits of the list");
    	}
    	if(pos==0){
    		Node newNode = new Node(obj);
    		newNode.next=head;
    		head = newNode;
    		size++;
    	}
    	Node previous = get(pos-1);
    	Node newNode = new Node(obj);
    	newNode.next = previous.next;
    	previous.next = newNode;
    }

   	public Node get(int pos){
      if(pos<0||pos>size){
          throw new IndexOutOfBoundsException("Index is not in the list");
      }
      
   		Node current = head;
   		for(int i=0; i<pos; i++){
        current=current.next;
      }
      return current;



   	}

   	public Object remove(int pos){
   		if(pos<0||pos>size){
    		throw new IndexOutOfBoundsException("Index is out of the limits of the list");
    	}
    	if(pos==0){
    		Node current = head;
    		head = head.next;
    		size--;
    		return current.getValue();
    	} else {
    		
    		Node previous = get(pos-1);
    		Node current = get(pos);
        Node temp = current;
        current = current.next;
    		previous.next = current;
    		size--;
    		return temp;
    	}

   	}

    public int size(){
      return size;
    }


}



