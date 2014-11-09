package graph.builder;
/*
 * @author : Ganesh Joshi
 * API for finding stronlgly connected components in the graph.
 * 
 * Algorithm:
 * Given a digraph G, use DepthFirstOrder to compute the reverse postorder of its reverse, G R
 * Run standard DFS on G, but consider the unmarked vertices in the order just computed instead of the standard numerical order
 * All vertices reached on a call to the recursive dfs() from the constructor are in a strong component (!), so identify them as in CC.
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

class StronglyConnectedComponents {
	
	private Stack<Vertex> stack;
	//HashMap Strong components will give all the strongly connected components
	private HashMap<Integer, TreeSet<Vertex>> strongcomponents;
	
	public StronglyConnectedComponents(){
		stack= new Stack<Vertex>();
		strongcomponents=new HashMap<>();
	}
	
	
	
	public HashMap<Integer, TreeSet<Vertex>> findStrongComponents(Graph G){
	
		//step 1
		int group=0;
		stack=findreversereorder(G);
		Vertex temp=null;
		if(stack==null)
			return null;
		//We got the reverse postorder now pop each vertex and call DFS on it
		while(!stack.isEmpty()){
			
				temp=stack.pop();
				
				if(temp.getColor()==0){
					
					//call DFS again
					DFS_VISIT2(G,temp,group);
					
				}
				
				group++;
			
			
			
			
			
		}
		
		
		
		
		
		return this.strongcomponents;
	}



	private void DFS_VISIT2(Graph g,Vertex u, int group) {
		
	  //set the color of the vertex gey
		
		u.setColor(1);
		
		//Get all the adj vertex 
		
		TreeSet<Vertex> adjlist=g.getAdjVertex(u);
		Iterator<Vertex> it=adjlist.iterator();
		Vertex V;
		while(it.hasNext()){
			
			V=it.next();
			if(V.getColor()==0){
				DFS_VISIT2(g, V, group);
			}
			
			
			
		}
		
		u.setColor(2);
		
		if(strongcomponents.containsKey(group))
			strongcomponents.get(group).add(u);
		else{
			TreeSet<Vertex> t=new TreeSet<>();
			t.add(u);
			strongcomponents.put(group, t);
		}

		
		
		
	}



	private Stack<Vertex> findreversereorder(Graph g) {
		
		Iterator<Vertex> it=g.iterator();
		Vertex u;
		while(it.hasNext()){
			u=it.next();
			if(u.getColor()==0){
				DFS_VISIT(u,g);
			}
			
		}
		
		
		return this.stack;
	}



	private void DFS_VISIT(Vertex u,Graph G) {

		//set the color to grey
		u.setColor(2);
		
		// Get the adjecent vertices for Vertex u
		TreeSet<Vertex> adjV=G.getAdjVertex(u);
		// Get the iterator to traverse the adj. list 
		Iterator<Vertex> i=adjV.iterator();
		Vertex v;
		while(i.hasNext()){
			
			v=i.next();
			
			if(v.getColor()==0){
				
				//Set the parent and call DFS_VIST
				v.setParent(u);
				DFS_VISIT(v, G);
				
			}
			
		}
		
		//set the color of the vertex to black i.e. the vertex is completely visited.
		u.setColor(2);
		stack.add(u);
		
	}
	
	
	
	
	

}
