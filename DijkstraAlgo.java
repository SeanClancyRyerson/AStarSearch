package dijkstraAlgo;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;



public class DijkstraAlgo{
/* Dijkstra Algorithm
 * 
 *
 */
	public static int computePaths(Node source){
		source.shortestDistance=0;
		//vari to count total number of checked possible paths
		int count = 0;
		//implement a priority queue
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(source);

		while(!queue.isEmpty()){
			Node u = queue.poll();

			/*visit the neighbors, starting from 
			the nearest node(smallest shortestDistance)*/
			
			for(Edge e: u.neighbors){
				count++;
				Node v = e.target;
				int weight = e.weight;

				//relax(u,v,weight)
				int distanceFromU = u.shortestDistance+weight;
				if(distanceFromU<v.shortestDistance){

					/*remove v from queue for updating 
					the shortestDistance value*/
					queue.remove(v);
					v.shortestDistance = distanceFromU;
					v.parent = u;
					queue.add(v);

				}
			}
		}
		return count;
	}

	public static List<Node> getShortestPathTo(Node target){

		//trace path from target to source
		List<Node> path = new ArrayList<Node>();
		for(Node node = target; node!=null; node = node.parent){
			path.add(node);
		}


		//reverse the order such that it will be from source to target
		Collections.reverse(path);

		return path;
	}



	public static void main(String[] args){
		
		/*
		//initialize the graph base on the Romania map
		Node n1 = new Node("Arad");
		Node n2 = new Node("Zerind");
		Node n3 = new Node("Oradea");
		Node n4 = new Node("Sibiu");
		Node n5 = new Node("Fagaras");
		Node n6 = new Node("Rimnicu Vilcea");
		Node n7 = new Node("Pitesti");
		Node n8 = new Node("Timisoara");
		Node n9 = new Node("Lugoj");
		Node n10 = new Node("Mehadia");
		Node n11 = new Node("Drobeta");
		Node n12 = new Node("Craiova");
		Node n13 = new Node("Bucharest");
		Node n14 = new Node("Giurgiu");

		//initialize the edges
		n1.neighbors = new Edge[]{
			new Edge(n2,75),
			new Edge(n4,140),
			new Edge(n8,118)
		};

		n2.neighbors = new Edge[]{
			new Edge(n1,75),
			new Edge(n3,71)
		};

		n3.neighbors = new Edge[]{
			new Edge(n2,71),
			new Edge(n4,151)
		};

		n4.neighbors = new Edge[]{
			new Edge(n1,140),
			new Edge(n5,99),
			new Edge(n3,151),
			new Edge(n6,80),
		};

		n5.neighbors = new Edge[]{
			new Edge(n4,99),
			new Edge(n13,211)
		};

		n6.neighbors = new Edge[]{
			new Edge(n4,80),
			new Edge(n7,97),
			new Edge(n12,146)
		};

		n7.neighbors = new Edge[]{
			new Edge(n6,97),
			new Edge(n13,101),
			new Edge(n12,138)
		};

		n8.neighbors = new Edge[]{
			new Edge(n1,118),
			new Edge(n9,111)
		};

		n9.neighbors = new Edge[]{
			new Edge(n8,111),
			new Edge(n10,70)
		};

		n10.neighbors = new Edge[]{
			new Edge(n9,70),
			new Edge(n11,75)
		};

		n11.neighbors = new Edge[]{
			new Edge(n10,75),
			new Edge(n12,120)
		};

		n12.neighbors = new Edge[]{
			new Edge(n11,120),
			new Edge(n6,146),
			new Edge(n7,138)
		};

		n13.neighbors = new Edge[]{
			new Edge(n7,101),
			new Edge(n14,90),
			new Edge(n5,211)
		};

		n14.neighbors = new Edge[]{
			new Edge(n13,90)
		};
		*/
		
		
    	//england map declaration
		Node n1 = new Node("Newcastle");
		Node n2 = new Node("Whitby");
		Node n3 = new Node("York");
		Node n4 = new Node("Leeds");
		Node n5 = new Node("Liverpool");
		Node n6 = new Node("Manchester");
		Node n7 = new Node("Derby");
		Node n8 = new Node("Leicester");
		Node n9 = new Node("Norwich");
		Node n10 = new Node("London");
		Node n11 = new Node("Cambridge");
		Node n12 = new Node("Dover");
		Node n13 = new Node("Brighton");
		Node n14 = new Node("Southampton");
		Node n15 = new Node("Bristol");
		Node n16 = new Node("Oxford");
		
		//newcastle 
		n1.neighbors = new Edge[]{
				new Edge(n2,75),
				new Edge(n5,174),
				new Edge(n6,145)
			};
		//whitby
		n2.neighbors = new Edge[]{
				new Edge(n1,75),
				new Edge(n3,41)
		};
		//york
		n3.neighbors = new Edge[]{
			new Edge(n2,41),
			new Edge(n4,24)
		};
		//leeds
		n4.neighbors = new Edge[]{
			new Edge(n3,24),
			new Edge(n6,46)
		};
		//liverpool
		n5.neighbors = new Edge[]{
			new Edge(n1,174),
			new Edge(n6,30)
		};
		//manchester
		n6.neighbors = new Edge[]{
			new Edge(n5,30),
			new Edge(n1,145),
			new Edge(n4,46),
			new Edge(n7,80)
		};
		//derby
		n7.neighbors = new Edge[]{
			new Edge(n6,80),
			new Edge(n8,30)
		};
		//leicester
		n8.neighbors = new Edge[]{
			new Edge(n7,30),
			new Edge(n3,112),
			new Edge(n9,116),
			new Edge(n11,72),
			new Edge(n16,74)
		};
		//norwich
		n9.neighbors = new Edge[]{
			new Edge(n8,116),
			new Edge(n11,101)
		};
		//london
		n10.neighbors = new Edge[]{
			new Edge(n16,55),
			new Edge(n11,64),
			new Edge(n12,78),
			new Edge(n13,53)
		};
		//cambridge
		n11.neighbors = new Edge[]{
			new Edge(n8,72),
			new Edge(n9,101),
			new Edge(n10,64)
		};
		//dover
		n12.neighbors = new Edge[]{
			new Edge(n10,78),
			new Edge(n13,79)
		};
		//brighton
		n13.neighbors = new Edge[]{
			new Edge(n10,53),
			new Edge(n12,79),
			new Edge(n14,64)
		};
		//southampton
		n14.neighbors = new Edge[]{
			new Edge(n15,100),
			new Edge(n13,64)
		};
		//bristol
		n15.neighbors = new Edge[]{
				new Edge(n16,72),
    			new Edge(n14,100)
		};
		//oxford
		n16.neighbors = new Edge[]{
				new Edge(n8,74),
    			new Edge(n10,55),
    			new Edge(n15,72)
		};
		

		//compute paths from source node
		int count = computePaths(n9);

		//print shortest paths
		/*
		for(Node n: nodes){
			System.out.println("Distance to " + 
				n + ": " + n.shortestDistance);
    		List<Node> path = getShortestPathTo(n);
    		System.out.println("Path: " + path);
		}*/
		
		//newcastle (start) to brighton (n13)
		List<Node> path = getShortestPathTo(n13);
		System.out.println("Dijkstra Path: " + path);
		System.out.println("Dijkstra count: " + count);

	}


}


//define Node
class Node implements Comparable<Node>{
	
	public final String value;
	public Edge[] neighbors;
	public int shortestDistance = Integer.MAX_VALUE;
	public Node parent;

	public Node(String val){
		value = val;
	}

	public String toString(){
			return value;
	}

	public int compareTo(Node other){
		return Integer.compare(shortestDistance, other.shortestDistance);
	}

}

//define Edge
class Edge{
	public final Node target;
	public final int weight;
	public Edge(Node targetNode, int weightVal){
		target = targetNode;
		weight = weightVal;
	}
}
