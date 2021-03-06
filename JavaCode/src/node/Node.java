package node;

public class Node<E>{
	
	private E data;
	private Node<E> next;
	private Node<E> back;
	
	// Tree node data
	private Node<E> left;
	private Node<E> right;
	private Node<E> parent;
	

	//default constructor
	public Node(){
		this.next=null;
	}
	// Constructor
	public Node(E x){
		this.data=x;
		this.next=null;
		this.back=null;
		this.left=null;
		this.right=null;
		this.parent=null;
		
	}
	
	
	
	public Node<E> getLeft() {
		return left;
	}
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	public Node<E> getRight() {
		return right;
	}
	public void setRight(Node<E> right) {
		this.right = right;
	}
	public Node<E> getParent() {
		return parent;
	}
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}
	public E getData(){
		return this.data;
		
	}
	
	
	public Node<E> getNext(){
		return this.next;
	}
	
	public Node<E> getBack(){
		return this.back;
	}
	
	public void setback(Node<E> x){
		this.back=x;
	}
	
	public void setNext(Node<E> y){
		this.next=y;
	}
	
	
	
	
	

	

}
