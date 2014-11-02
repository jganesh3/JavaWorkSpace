package graph.builder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

 class Graph {
	
	private HashMap<Vertex, TreeSet<Vertex>> adjlist;
	
	
	
	
	public Graph(){
		adjlist=new HashMap<>();
	}
	
	public void add(Vertex x,Vertex y){
		
		//Check if the Vertex is present,if not add new Vertex in adjlist
		if(!isVertexPresent(x)) adjlist.put(x, new TreeSet<Vertex>());
		if(!isVertexPresent(y)) adjlist.put(y, new TreeSet<Vertex>());
		
		//check if Vertex are already present in Adj List
		if(!isAdj(x,y)) adjlist.get(x).add(y);
		
		
		
		
	}
	
	
	
	
	
	public TreeSet<Vertex> getAdjVertex(Vertex s){
		return adjlist.get(s);
	}
	
	
	public Iterator<Vertex> iterator(){
		return this.adjlist.keySet().iterator();
	}
	
	
	
	private boolean isAdj(Vertex x, Vertex y) {
		
		return adjlist.get(x).contains(y);
		
	}



	@Override
	public String toString() {
		return "Graph [adjlist=" + adjlist + "]";
	}

	private boolean isVertexPresent(Vertex x){
		return adjlist.containsKey(x);
	}
	
	
	
	
	
	
	
	
	

}
