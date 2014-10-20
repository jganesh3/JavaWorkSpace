package queue;

import node.Node;

public class SimpleQueue<E> {

	private Node<E> Head;
	private Node<E> Tail;
	
	public boolean isEmpty(){
		return Head==null;
	}
	
	public void enqueue(E data){
		
		if(isEmpty()){
			// Queue is currently empty
			Head=new Node<>(data);
			Tail=Head;
		}
		else{
			//Add new Node to Tail
			Tail.setNext(new Node<>(data));
			Tail=Tail.getNext();
		}
		
	}
	
	
	public E dequeue(){
		if(isEmpty()){
			
			return null;
			
		}else{
			
			E data=Head.getData();
			Head=Head.getNext();
			return data;
		}
	}
	
	
}
