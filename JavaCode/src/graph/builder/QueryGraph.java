package graph.builder;

import java.util.ArrayList;

/*
This class will be used to Query Graph for Shortest Path from the given source
*/
class QueryGraph {
	
	
	
	//This function will return all the vertices in the shortest path from the source to the destination
	public static  ArrayList<Vertex> getShortestPath(Graph G , Vertex destination){
		
		ArrayList<Vertex> shortestpath =new ArrayList<>();
		
		while(destination!=null){
			shortestpath.add(destination.getParent());
			destination=destination.getParent();
		}
		
		return shortestpath;
		
		
	}
	

}
