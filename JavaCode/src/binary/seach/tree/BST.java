package binary.seach.tree;

import queue.SimpleQueue;
import node.Node;

public class BST<E extends Comparable<E>> {
	
	private Node<E> root;
	
	
	public BST(){
		
		root=null;
	}
	
	
	public void add(E data){
		
		root=add(root,data);
	}


	private Node<E> add(Node<E> root2, E data) {
		
		if(root2==null){
			return new Node(data);
		}
		else{
			
			int cmp =data.compareTo(root2.getData());
			if(cmp<0){
				root2.setLeft(add(root2.getLeft(),data));
			}else if(cmp>0){
				root2.setRight(add(root2.getRight(),data));
			}else{
				// If the data is dupicate
				//do nothing
			}
			
			
			return root2;
			
		}
		
	}
	
	
	
	
	public void inOrder(){
		
		
		inOrder(root);
		
		
	}


	private void inOrder(Node<E> root2) {


		if(root2!=null){
			
			//Go left
			//Print
			// Go right
			inOrder(root2.getLeft());
			System.out.print(root2.getData()+" ");
			inOrder(root2.getRight());
				
		}
		
		
	}
	
	
	
	public void preOrder(){
		
		preOrder(root);
	}
	
	
	
	private void preOrder(Node<E> root2) {
		
		//Print 
		//Go left
		//Go right
		
		if(root2!=null){
			System.out.print(root2.getData()+" ");
			preOrder(root2.getLeft());
			preOrder(root2.getRight());
		}
		
		
	}
	
	
	
	public void BFStreeTraversal(){
		
		
		SimpleQueue<Node<E>> queue=new SimpleQueue<>();
		
		// Enqueue the root in Q;
		queue.enqueue(root);
		
		while(!queue.isEmpty()){
			
			Node<E> temp=queue.dequeue();
			//Now print the value of the root element
			System.out.print(temp.getData()+" ");
			//Now enqueue left and right child of this root
			
			if(temp.getLeft()!=null)
				queue.enqueue(temp.getLeft());
			if(temp.getRight()!=null)
				queue.enqueue(temp.getRight());
			
		}
	
		
		
		
		
		
		
	}
	
	
	
	
	public void postOrder(){
		postOrder(root);
	}


	private void postOrder(Node<E> root2) {

		// Go left
		//Go right
		//Print
		
		if(root2!=null){
			
			postOrder(root2.getLeft());
			postOrder(root2.getRight());
			System.out.print(root2.getData()+" ");
			
		}
		
	}


	public static void main(String[] args) {
		
		/*BST<String> bstobj=new BST<>();
		
		
		bstobj.add("Chico");
		bstobj.add("Yuba");
		bstobj.add("San Francisco");
		bstobj.add("Los Angles");
		
		
		System.out.println("In Order Tree Traversal");
		bstobj.inOrder();
		System.out.println("\nPre Order Tree Treversal");
		bstobj.preOrder();
		System.out.println("\nPost order Tree Travesal");
		bstobj.postOrder();
		
		
		System.out.println("\n Breadth First Tree Traversal ");
		bstobj.BFStreeTraversal();*/
		
		
		
BST<Integer> bstobj2=new BST<>();
		
		
		bstobj2.add(35);
		bstobj2.add(11);
		bstobj2.add(38);
		bstobj2.add(45);
		bstobj2.add(20);
		bstobj2.add(15);
		bstobj2.add(1);
		bstobj2.add(44);
		
		System.out.println("In Order Tree Traversal");
		bstobj2.inOrder();
		System.out.println("\nPre Order Tree Treversal");
		bstobj2.preOrder();
		System.out.println("\nPost order Tree Travesal");
		bstobj2.postOrder();
		
		
		System.out.println("\n Breadth First Tree Traversal ");
		bstobj2.BFStreeTraversal();
		
		
		
	}
	
	
	
	
	

}
