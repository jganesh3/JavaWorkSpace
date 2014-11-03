package graph.builder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

class BFS {
	
	
	
	
	public static void BFS(Graph G,Vertex source){
		
		
		LinkedList<Vertex> Q=new LinkedList<>();
		
		//Initialize graph values like color and distance
		
		Iterator<Vertex> it=G.iterator();
		
		while(it.hasNext()){
			
			Vertex temp=it.next();
			temp.setDistance(0);
			temp.setColor(0);
			temp.setParent(null);
		}
		
		
		//Enqueue the source vertex in the Q
		Q.add(source);
		
		
		//Now while Q is non empty dequeue the elements
		while(!Q.isEmpty()){
			
			Vertex s=Q.poll();
			//set the color of the vertex to gray
			s.setColor(1);
			
			//Get all the Adj Vertex of s 
			
			TreeSet<Vertex> adj=G.getAdjVertex(s);
			
			//Get the Iterator and iterator through the adjlist of s
			
			Iterator<Vertex> adjIt=adj.iterator();
			
			while(adjIt.hasNext()){
				
				Vertex u=adjIt.next();
				
				if(u.getColor()==0){
					
					u.setColor(1);
					u.setDistance(s.getDistance()+1);
					
					u.setParent(s);
					
					Q.add(u);
					
					
					
					
					
				}
				
				
			}
			
			
			s.setColor(2);
			System.out.println(s);
			
			
		}
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
	

}
