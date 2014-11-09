package graph.builder;

import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

/*
 * @Author Ganesh Joshi
 * 
  This class implements topological sort.

  To do a topological sort, given graph must be a DAC(Directed acyclic Graph)

  We can check if the graph is directed acyclic or not by running the Depth first Search algorithm with slight modification

  - Run DFS algo
  - Keep all the visiting Vertex in List (Linked list or ArrayList) (in DFS_VISIT)
  - recursively call DFS_VISIT with the adj vertices.
  - If we found a vertex which is already present in List, we found the back edge else continue.
  - return to calling function 
  - if the list is empty no back edge is present, Hence it is DAC graph
  - else it is not a DAC

TOPOLOGICAL-SORT.G
1 call DFS.G to compute finishing times :f for each vertex 
2 as each vertex is finished, insert it onto the stack
3 return the stack

 */
class TopologicalSort {

	private Stack<Vertex> stack;

	public TopologicalSort(){
		stack=new Stack<Vertex>();
	}



	public Stack<Vertex> topologicalsort(Graph G){

		Vertex temp;
		Iterator<Vertex> it=G.iterator();

		//Initialize the graph for processing
		while(it.hasNext()){
			temp=it.next();
			temp.setColor(0);
			temp.setParent(null);
		}


		//Step 2 :- check if the Given graph is a DAC
		DAGfinder dg=new DAGfinder();
		boolean flag=dg.isDAG(G);
		
		// Re initialize the Graph 
		it=G.iterator();
		while(it.hasNext()){
			temp=it.next();
			temp.setColor(0);
			temp.setParent(null);
		}

		
		//destroy DAGfinder object
		dg=null;
		if(flag){

			// For all the vertices of the Graph
			it=G.iterator();

			while(it.hasNext()){
				temp=it.next();
				if(temp.getColor() == 0){

					//Call DFS_VISIT

					DFS_VISIT(G,temp);


				}


			}
			return this.stack;
		}else{
			return null;
		}

	}



	private void DFS_VISIT(Graph g, Vertex u) {

		//Set the vertex color to gray i.e. marking it as visited.
		u.setColor(1);

		// Get all the adj vertices of the u

		TreeSet<Vertex> adjlist=g.getAdjVertex(u);
		Iterator<Vertex> iterator=adjlist.iterator();

		Vertex v;
		while(iterator.hasNext()){
			v=iterator.next();

			//Check if the this vertex is already visited or not
			if(v.getColor()==0){

				//Set the color of the Vertex to Grey and call DFS_VISIT recursively.
				v.setColor(1);
				v.setParent(u);
				DFS_VISIT(g, v);

			}

			

		}

		u.setColor(3);
		stack.push(u);

	}



}
