package graph.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphClient {
	
	
	public static void main(String[] args) {
		
		FileReader fin;
		Graph G;
		
		
		try {
			
			fin=new FileReader("Vertex.txt");
			G=new Graph();
			BufferedReader buffer=new BufferedReader(fin);
			String line;
			//Read each line in the file and create new Vertex Objects, Add them to the Graph
			while((line=buffer.readLine())!=null){
				
				String[] lineArray = line.split("\\s");
				Vertex x=new Vertex(lineArray[0]);
				Vertex y=new Vertex(lineArray[1]);
				
				
				G.add(x, y);
				
				
				
				
			}
			
			buffer.close();
			fin.close();
			
			
			
			
			System.out.println(G);
			BFS.BFS(G, new Vertex("chico"));
			System.out.println(G);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	

}
