import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ColorableGraph class
 * @author Caroline
 *
 */
public class ColorableGraph {
	
	private File file;//file to get vertex numbers and edges from
	private int numVert;//total number of vertices existing in the graph
	private Scanner scan;//scanner to read file from
	private VertexObj[] graph;//array of VertexObj (vertices) that creates a graph
	private int[] errorSpot;//intended to use for backtracking and inserting vertices of the cycle with odd numbers
	
	/**
	 * takes a file as an input
	 * @param f
	 */
	public ColorableGraph(File f){
		file = f;
		try {
			scan = new Scanner(file);//scanner to iterate through the file
			if(scan.hasNextInt()){
				numVert = scan.nextInt();//grabs first number in the file which is the total number of vertices in the graph
			}
			graph = new VertexObj[numVert];
			errorSpot = new int[numVert];
			for(int i=0; i<graph.length; i++){//initializing graph with unique vertex id
				graph[i] = new VertexObj(i+1, numVert);
			}
			while(scan.hasNextInt()){//reading edges from the file and setting the edge between the "from" and "to" vertices
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph[from-1].setEdge(to);
			}
			
		} catch (FileNotFoundException e) {//throws exception if the file is not found
			e.printStackTrace();
		}
	}
	
	/**
	 * uses breadth first search in order to see if this graph is 2-colorable
	 * @return
	 */
	public boolean colorable(){
		LinkedListQueue queue = new LinkedListQueue();//queue for breadth first search
		queue.enqueue(graph[0]);//enqueues the starting point (1)
		String currColor = "red";
		LinkedListQueue backtrack = new LinkedListQueue();//intended to use to backtrack and print out cycle but couldn't
		while(!queue.isEmpty()){
			VertexObj u = (VertexObj) queue.peek();
			if(graph[u.getId()-1].getColor().equals("white")){
				graph[u.getId()-1].setColor(currColor);//sets the starting point to the color "red"
			}
			currColor = u.getColor();//changes current color to whatever the color of current vertex is
			if(graph[u.getId()-1].getDone() == true) {//checks if this vertex has been visited already
				queue.dequeue();
				continue;
			}
			int[] adj = u.getEdge();//gets the adjacency list of the current vertex
			for(int i=0; i<adj.length; i++){//loop to check every vertex in the adjacency list
				if(adj[i]!=0){//ignore 0 because that means the adjacency list is null at that point
					if(graph[adj[i]-1].getDone() == true) continue;//if this adjacent vertex has been checked already, move to next one
					String diffColor;
					if(currColor.equals("red"))//changes "diffColor" according to the current "currColor"
						diffColor = "blue";
					else
						diffColor = "red";
					if (graph[adj[i]-1].getColor().equals("white")){//if the adjacent vertex hasn't been colored yet, color it with "diffColor"
						graph[adj[i]-1].setColor(diffColor);
						queue.enqueue(graph[adj[i]-1]);//enqueue to the queue
					}
					else{
						if(graph[adj[i]-1].getColor().equals(currColor)){//if the adjacent vertex already has a color which is the same as the color of current vertex
							System.out.println("No");//print out no to indicate this is not a 2-colorable graph
							System.out.println(adj[i]);//print the adjacent vertex
							System.out.println(u.getId());//print the current vertex
							return false;
						}
					}
					
				}
			}
			graph[u.getId()-1].setDone();//set done so that this vertex has been visited
			queue.dequeue();//dequeue this vertex from the queue
	
			
		}
		System.out.println("yes");//if false is not returned during this method, the graph is 2-colorable
		for(int i=0; i<graph.length; i++){
			System.out.println(graph[i].getId() + graph[i].getColor());//print out all the vertex numbers and colors
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Type in file path:");//ask for file path
		Scanner s = new Scanner(System.in);//scanner receives file path
		File file = new File(s.nextLine());//turns the file path into actual file
		ColorableGraph cgraph = new ColorableGraph(file);//make ColorableGraph object with the file received
		cgraph.colorable();//run colorable method to check if it is colorable
	}

}
