
/**
 * VertexObj class that has information about one vertex of the graph
 * @author Caroline
 *
 */
public class VertexObj {
	private int vertId; //number that the vertex is associated with
	private int numVert;//number of vertices in total in the graph
	private int[] edgeArr;//int array that contains the number of vertices this vertex has edge to
	private boolean done;//boolean to check if this vertex has been visited already
	private String color;//color of this vertex (white, red, blue)
	
	public VertexObj(int id, int numV){
		vertId = id;
		numVert = numV;
		edgeArr = new int[numVert];
		done = false;
		color = "white";
	}
	
	/**
	 * returns vertex ID
	 * @return
	 */
	public int getId(){
		return vertId;
	}
	
	/**
	 * receives a number of vertex that this vertex has an edge to
	 * and adds it to the array of vertices(edgeArr) that this vertex has an edge to
	 * @param e
	 */
	public void setEdge(int e){
		for(int i=0; i<edgeArr.length; i++){
			if(edgeArr[i] == 0){
				edgeArr[i] = e;
				break;
			}
			else{
				continue;
			}
		}
	}
	
	/**
	 * returns the edgeArr
	 * @return
	 */
	public int[] getEdge(){
		return edgeArr;
	}
	
	/**
	 * changes done variable to true to indicate that this vertex has been visited 
	 * and all of its adjacent vertices has been checked
	 */
	public void setDone(){
		done = true;
	}
	
	/**
	 * returns done boolean
	 * @return
	 */
	public boolean getDone(){
		return done;
	}
	
	/**
	 * sets the color of this vertex to another color
	 * @param c
	 */
	public void setColor(String c){
		color = c;
	}
	
	/**
	 * returns the color of this vertex
	 * @return
	 */
	public String getColor(){
		return color;
	}
}
