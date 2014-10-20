package LinkedList;

import node.*;

public class DoublyLinkedList {

	
	private Node<String> root;
	
	
	
	  public DoublyLinkedList() {

		  root=null;

	}
	
	
	public void add(String data){
		
		root=add(root,data);
		
	}
	
	


	private Node<String> add(Node<String> root2, String data) {
		if(root2==null)
		{
			return new Node<String>(data);
		}
		else{
		root2.setNext(add(root2.getNext(), data));
		root2.getNext().setback(root2);
		}
		return root2;
		
	 
	}
	
	
	
	public void forward_reverse(){
		
		//System.out.println("Going Forward\n");
		Node<String> temp=root;
		Node<String> reverse=null;
		
		do{
		
			System.out.print(temp.getData()+" ");
			reverse=temp;
			temp=temp.getNext();
		
		
		}while(temp!=null);
		
		
		temp=reverse;
		//System.out.println("Going reverse ");
		System.out.println();
		while(temp!=null){
			System.out.print(temp.getData()+" ");
			temp=temp.getBack();
		}
		
		
		
		
		
		
	}
	
	
	
	
	public void display(){
		
		display(root);
		
		
	}


	private void display(Node<String> root2) {


		if(root2!=null){
			
			System.out.print(root2.getData()+" ");
			display(root2.getNext());
		}
			
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		DoublyLinkedList dlist=new DoublyLinkedList();
	
		dlist.add("C");
		dlist.add("h");
		dlist.add("i");
		dlist.add("c");
		dlist.add("o");
		
		
		dlist.display();
		
		dlist.forward_reverse();
		
	}
	
	
	
	
	
	
	
}
