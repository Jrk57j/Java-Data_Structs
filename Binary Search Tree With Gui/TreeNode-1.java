package pro4;
/**
 * Represents a node from a BinaryTree
 * @author Julian Itwaru
 * @version 1.0
 */
public class TreeNode<T extends Comparable<? super T>> implements Comparable<TreeNode<T>> {
	/**
	 * The data portion of this node
	 */
	private T data;
	/**
	 * The reference to left child of this node
	 */
	private TreeNode<T> leftChild;
	
	/**
	 * The TreeNode<T> to right child of this node
	 */
	private TreeNode<T> rightChild;
	
	/**
	 * Constructs an empty node.
	 * @param data A reference to the item of this node
	 */
	public TreeNode(T data) {
		this(data, null, null);
	}
	
	/**
	 * Constructs a node with an item and two descendant nodes. 
	 * @param data A reference to the data of this node
	 * @param leftChild Index to the left child of this node
	 * @param rightChild Index to the right child of this node.
	 */
	public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	/**
	 * Returns the data of this node.
	 * @return A reference to the data of this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Changes the data of this node.
	 * @param data The data of this node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Returns the left child of this node.
	 * @return A reference to the left child of this node
	 */
	public TreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Changes the left child of this node.
	 * @param leftChild A reference to the left child of this node
	 */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Returns the right child of this node. 
	 * @return A reference to the right child of this node
	 */
	public TreeNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Changes the right child of this node. 
	 * @param rightChild A reference to the right child of this node
	 */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	/**
	 * A compareTo method used in the BinaryTree search method
	 */
	public int compareTo(TreeNode<T> Node) {
		if(this.data.compareTo(Node.data) > 0) {
			return 1;
		}
		else if(this.data.compareTo(Node.data) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}