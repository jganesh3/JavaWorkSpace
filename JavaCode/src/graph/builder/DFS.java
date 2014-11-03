package graph.builder;

import java.util.Iterator;
import java.util.TreeSet;

/*
 DFS class will use to apply DFS algorithm on Graph
*/
class DFS {
	

	public static void DFS(Graph G){
		
		//Initialize each vertex in the graph i.e. set color = white parent =null;
		
		Iterator<Vertex> it= G.iterator();
		Vertex temp;
		while(it.hasNext()){
			temp=it.next();
			temp.setColor(0); // set color back to zero
			temp.setDistance(0); // set distance to zero
			temp.setParent(null); // set parent to null
			
			
		}
		
		
		//re set the iterator
		it=G.iterator();
		while(it.hasNext()){
			temp=it.next();
			if(temp.getColor()==0){
				dfs_visit(G, temp);
			}
		}
		
		
		
		
		
		
		
	}
	
	
	private static void dfs_visit(Graph G,Vertex u){

		
		// set the color to gray
		u.setColor(1);
		Vertex v=null;
		TreeSet<Vertex> adjlist =G.getAdjVertex(u);
		Iterator<Vertex> adjlistIt=adjlist.iterator();
		
		while(adjlistIt.hasNext()){
			 
			v=adjlistIt.next();
			if(v.getColor()==0){
				
				//set the parent of the node
				v.setParent(u);
				
				// recursively check all adj node of this vertex 'v' 
				
				dfs_visit(G, v);
			}
		}
		
		//set the color of the node as black
		u.setColor(2);
		
		
		
		System.out.println(u);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
