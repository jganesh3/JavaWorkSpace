package graph.builder;

/*
	@Author Ganesh Joshi
	Client program which will build graph by reading the file and perform other operations such as
	DFS/BFS/Topological Sort on it
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeSet;

public class GraphClient {
	
	
	public static void main(String[] args) {
		
		FileReader fin;
		Graph G;
		
		
		try {
			
			Hashtable<String, Vertex> vertices=new Hashtable<>();
			Vertex x,y;
			
			fin=new FileReader("Vertex.txt");
			G=new Graph();
			BufferedReader buffer=new BufferedReader(fin);
			String line;
			//Read each line in the file and create new Vertex Objects, Add them to the Graph
			while((line=buffer.readLine())!=null){
				
				String[] lineArray = line.split("\\s");
				
				//Check if the HashTable already contains the vertex
				//if present pass the same object to the graph
				//else create new Vertes pass to the graph and ad to hash table.
				
				if(!vertices.containsKey(lineArray[0]))
					vertices.put(lineArray[0], new Vertex(lineArray[0]));
				if(!vertices.containsKey(lineArray[1]))
					vertices.put(lineArray[1], new Vertex(lineArray[1]));
				
				G.add(vertices.get(lineArray[0]),vertices.get(lineArray[1]));
				
				
			}
			
			//close the files
			buffer.close();
			fin.close();
			
			
			
			
			/*System.out.println("Running BFS on the graph");
			BFS.BFS(G, vertices.get("141"));

			//System.out.println("Shortest path to La is "+QueryGraph.getShortestPath(G, vertices.get("la")));
			
			System.out.println();
			System.out.println("Running DFS on the graph");
			DFS.DFS(G);
			
			System.out.println();
			DAGfinder dg=new DAGfinder();
			System.out.println("Checking if the graph is Directed Acyclic Graph : "+dg.isDAG(G));
			dg.displayCycle();
				
			
			
			System.out.println();
			TopologicalSort sort=new TopologicalSort();
			Stack<Vertex> tpsort=sort.topologicalsort(G);
			while(tpsort!=null && !tpsort.isEmpty())
				System.out.print(tpsort.pop().getData()+" ");*/
			
			
			StronglyConnectedComponents strong=new StronglyConnectedComponents();
			HashMap<Integer, TreeSet<Vertex>>tree=strong.findStrongComponents(G);
			System.out.println("Printing Strongly connected components"+tree);
	
			
			
			
			vertices=null;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	

}
