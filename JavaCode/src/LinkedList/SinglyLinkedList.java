package LinkedList;

import node.Node;

public class SinglyLinkedList<E> {
	
	private Node<E> head;
	
	
	
	//Constructor
	public SinglyLinkedList(){
		head=null;
	}
	
	
	
	public boolean isEmpty(){
		return head==null;
	}
	
	
	public void addNode(E data){
		
		head=addNode(head,data);
		
	}
	
	
	
	private Node<E> addNode(Node<E> head2, E data) {
	
		if(head2==null){
			
			return new Node<E>(data);
			
			
		}
		else
			 head2.setNext(addNode(head2.getNext(),data));
		
		
		
		return head2;
		
		
		
	}



	// Reverse Linked List
	
	public void reverseLinklist(){
		reverse(head);
	}
	
	
	private void reverse(Node<E> head2) {
		
		if(head2.getNext()==null)
		{
			
			//Now set the new Head for our linked list i.e. last node.
			head=head2;
			return ;
		}
		else{
			
			//Go to the next Node
			reverse(head2.getNext());
			
			//When the recursion fold back, we will be at the second last 
			//temp will hold the last Node
			Node temp=head2.getNext();
			//set temp's next to current node
			temp.setNext(head2);
			//set head2's next to null
			head2.setNext(null);
		
			
			
			
		}
		
		
		
		
	}



	public void display(){
		
		display(head);
		
		
	}

	private void display(Node<E> head2) {
		if(head2==null)
			return;
		//Display the contain of the node
		
		System.out.print(head2.getData()+" ");
		//recursively move to next node
		display(head2.getNext());
		
	}
	
	
	
	
	public static void main(String[] args) {
		SinglyLinkedList<String> slinkedlist=new SinglyLinkedList<String>();
		
		slinkedlist.addNode("Chico");
		slinkedlist.addNode("Yuba");
		slinkedlist.addNode("SF");
		slinkedlist.addNode("LA");
		slinkedlist.display();
		
		slinkedlist.reverseLinklist();
		System.out.println();
		slinkedlist.display();
		
		
	}
	
	
	
	
	
	

}
