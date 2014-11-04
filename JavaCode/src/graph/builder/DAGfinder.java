package graph.builder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

/*

 DAG finder class is implemented to find if the given graph is directed acyclic graph or not

*/
public class DAGfinder {

private Stack<Vertex> stack;  // This stack will maintains the vertices present in the cycle

private LinkedList<Vertex> onStack; // This list will maintains all the current vertices which are present on stack

public DAGfinder(){
	stack=null;
	onStack=new  LinkedList<Vertex>();
	
}


public boolean isDAG(Graph G){
	
	//for all the vertex of the Graph G
	Vertex temp;
	Iterator<Vertex> it=G.iterator();
	
	//Initialize the graph for processing
	while(it.hasNext()){
		temp=it.next();
		temp.setColor(0);
		temp.setParent(null);
	}
	
	it=G.iterator();
	while(it.hasNext()){
	temp=it.next();
	//if the vertex if not visited, call dfs visit
	if(temp.getColor()==0){
		DFS_VISIT(G,temp);
		
		
	}
	}
	
	
	
	if(stack==null)
		return false;
	else
		return true;
	
	
	
}


public void displayCycle(){
	//Printing all the vertices which forms cycle
		while(!stack.isEmpty())
			System.out.print(stack.pop().getData()+" ");
		
}


private void DFS_VISIT(Graph g, Vertex u) {
	
	// Add the vertex in the onStack list
	onStack.add(u);
	
	//Mark it as Visited Vertex
	u.setColor(1);
	
	//get all the adj vertices of this Vertex 
	TreeSet<Vertex> adjlist=g.getAdjVertex(u);
	Iterator<Vertex> iterator=adjlist.iterator();
	
	
	while(iterator.hasNext()){
		
		Vertex v=iterator.next();
	
		//If the cycle is present simply returns
		//Now check if the vertex is visited or not,if not call DFS_VISIT
		//else check if that vertex is already on the Stack , this means cycle present, add the Vertex on stack
		if(hasCycle()) return;
		else if(v.getColor()==0){
			v.setParent(u);
			DFS_VISIT(g, v);
		}else if(onStack.contains(v)){
			v.setParent(u);
			stack=new Stack<>();
			Vertex x=v;
			while(x!=u){
				//add the vertex on stack and c
				stack.add(x);
				x=x.getParent();
			}
			stack.add(x);
			stack.add(u.getParent());
		}
		
		
	}
	
	// set color of the Vertex to black i.e. 2 and remove the vertex from the stack.
	u.setColor(2);
	onStack.remove(u);
	
	
	
}


private boolean hasCycle() {
	// TODO Auto-generated method stub
	return stack!=null;
}


}
