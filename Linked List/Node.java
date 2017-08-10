package project2point1;
/**
 * A new node that uses the deferred type to create a new node for the LinkedList.
 * @author Julian Itwaru
 * @ver 1.0
 */
public class Node<E> {
	/**
	 * The data of this node
	 */
	private E item;
	/**
	 * The link to next node
	 */
	protected Node<E> next;
	
	/*
	 * A link to the preceding node of the head
	 */
	private Node<E> preceding;
	

	/**
	 * Constructs a default node.
	 */
	public Node(){
		this(null, null, null);
	}  
	/**
	 * Constructs a node with an item and link to a null node.
	 * @param item A reference to this data of this node
	 */
	public Node(E item) {
		this(item, null, null);
	}  
	/**
	 * Constructs a node with an item and a link to next node.
	 * @param item A reference to this data of this node
	 */
	public Node(E item, Node<E> next, Node<E> preceding) {
		this.item = item;
		this.next = next;
		this.preceding = preceding;
    }
	/**
	 * Returns the value of this node.
	 * @return the item of this node
	 */
	public E getItem() {
		return this.item;
	}
	/**
	 * Changes the item of this node.
	 * @param item the item to set
	 */
	public void setItem(E item) {
		this.item = item;
	}
	/**
	 * Returns the reference to the next node. 
	 * @return A reference to the next node
	 */
	public Node<E> getNext() {
		return this.next;
	}
	/**
	 * Changes the next node of this node.
	 * @param next A reference to the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	/**
	 * Returns the reference to the preceding node.
	 * @return A reference to the preceding node
	 */
	public Node<E> getPreceding() {
		return this.preceding;
	}
	/**
	 * Changes the reference to the preceding node.
	 * @param preceding A reference to the preceding node to set
	 */
	public void setPreceding(Node<E> preceding) {
		this.preceding = preceding;
	}  
}  

