/**
 * Queue data structure implemented with linked list
 * @author Caroline
 *
 */
public class LinkedListQueue {

	/**
	 * Node that will make linked list when connected together
	 * @author Caroline
	 *
	 * @param <T>This node will take any type of objects
	 */
	private static class Node<T>{
		private T data;
		private Node next;
		
		public Node(T n){
			data = n;
		}
	}
	
	private Node head;
	private Node tail;
	
	/**
	 * checks if the queue is empty (head is empty)
	 * @return
	 */
	public boolean isEmpty(){
		if(head == null) return true;
		else return false;
	}
	
	/**
	 * adds a node with data to the end of the queue
	 * @param data
	 */
	public <T>void enqueue(T data){
		Node<T> n = new Node(data);
		if(isEmpty()){
			n.next = head;
			head = n;
			tail = n;
		}else{
			tail.next = n;
			tail = n;
			tail.next = null;
		}
	}
	
	/**
	 * removes the first node in the queue
	 */
	public void dequeue(){
		if(head.next == null){
			tail = null;
			head = null;
		}else{
			head = head.next;
		}
	}
	
	/**
	 * returns the data of the first node in the queue
	 * @return
	 */
	public <T>Object peek(){
		return head.data;
	}
	
}
