package pro4;

/**
 * The BinaryTree base, contains all the operations that the BinaryTree will have.
 * @author Julian Itwaru
 * @version 1.0
 */
public abstract class BinarySearchTreeBasis<T extends Comparable<? super T>>{
	/**
	 * The root of this tree
	 */
	protected TreeNode<T> root;
	
	/**
	 * Creates an empty binary tree.
	 */
	public BinarySearchTreeBasis(){
		this.root = null;
	}
	
	/**
	 * The default constructor for this BinaryTree
	 * @param rootData A reference to the root
	 */
	public BinarySearchTreeBasis(T rootData){
		this.root = new TreeNode<T>(rootData, null, null);
	}
	
	/**
	 * Returns true if the tree is empty, returns false is the tree is not empty.
	 * @return boolean Returns true if empty, returns false if not empty
	 */
	public boolean isEmpty(){
		return this.root == null;
	}
	
	/**
	 * Removes all nodes from the tree.
	 */
	public void makeEmpty(){
		this.root = null;
	}
	
	/**
	 * Returns the root data of this binaryTree basis
	 * @return Returns the 
	 * @throws TreeException Throws an exception if the binaryTree is empty.
	 */
	public T getRootData() throws TreeException{
		if(this.root == null){
			throw new TreeException("Error: Empty tree");
		}
		else{
			return this.root.getData();
		}
	}
	
	/**
	 * Sets the root value of the tree.
	 * @param newData 
	 */
	public abstract void setRootData(T newData);
	
}
