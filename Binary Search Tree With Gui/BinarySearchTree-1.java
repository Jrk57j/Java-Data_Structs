package pro4;
import java.util.ArrayList;
/**
 * Represents a BinaryTree with a additional search and insert operator.
 * @author Julian Itwaru
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinarySearchTreeBasis<T> {
	/**
	 * Constructs a BinaryTree
	 */
	public BinarySearchTree(){
		super();
	}
	/**
	 * Creates a node in the binary tree.
	 * @param rootData A reference to the root of this tree
	 */
	public BinarySearchTree(T rootData){
		super(rootData);
	}
	
	
	/**
	 * Constructs a BinaryTree that contains a rootData, a left tree, and a right tree.
	 * @param rootData A reference to the root node
	 * @param leftTree A reference to the left sub tree
	 * @param rightTree A reference to the right sub tree
	 */
	public BinarySearchTree(T rootData, BinarySearchTree<T> leftTree, BinarySearchTree<T> rightTree) {
		  super(rootData);
		  this.attachLeftSubtree(leftTree);
		  this.attachRightSubtree(rightTree);
	}
	
	/**
	 * Constructs a BinaryTree with a root.
	 * @param rootNode A reference to the root node
	 */
	protected BinarySearchTree(TreeNode<T> rootNode) {
	    root = rootNode;
	}  
	
	/**
	 * Sets the root value of this BinaryTree 
	 * @param newData A reference to the value of the node
	 */
	public void setRootData(T newData) {
	    if (root != null) {
	      root.setData(newData);
	    }
	    else {
	       root = new TreeNode<T>(newData, null, null);
	    }
	  }
	
	  /**
	   * Attaches a left child containing new data to the root of a binary tree.
	   * @param newData A reference to the value of the node
	   */
	  public void attachLeft(T newData) {
		     if(!(isEmpty()) && root.getLeftChild() == null){
		    	 root.setLeftChild(new TreeNode<T>(newData, null, null));
		     }
		     else if(isEmpty()){
		    	 throw new TreeException("Error: Cannot attach child to an empty tree!");
		     }
		     else if(root.getLeftChild() != null){
		    	 throw new TreeException("Error: There is already an attached child!");
		     }
	  }
	  
	  /**
	   * Attaches a right child containing new data to the root of a binary tree.
	   * @param newData A reference to the value of this node
	   */
	  public void attachRight(T newData){
		  if(!(isEmpty()) && root.getRightChild() == null){
			  root.setRightChild(new TreeNode<T>(newData, null, null));
		  }
		  else if(isEmpty()){
			  throw new TreeException("Error: Cannot attach child to an empty tree!");
		  }
		  else if(root.getRightChild() != null){
		    	 throw new TreeException("Error: There is already an attached child!");
		     }
		  
	  }
	  
	  /**
	   * Attaches left Tree to the left subtree of the root of a binary tree
	   * @param leftTree A reference to the leftTree of this BinaryTree
	   * @throws TreeException Throws an exception if the BinaryTree is empty
	   */
	  public void attachLeftSubtree(BinarySearchTree<T> leftTree) throws TreeException {
		    if (isEmpty()) {
		      throw new TreeException("Error: Cannot attach a subtree to an empty tree!");
		    }
		    else if (root.getLeftChild() != null) {
		      throw new TreeException("Error: Cannot overwrite left subtree!");
		    }
		    else {
		      root.setLeftChild(leftTree.root);
		      leftTree.makeEmpty();
		    }
	  	   }
	   
	   /**
	    * Attaches right Tree to the right subtree of the root of a binary tree
	    * @param rightTree A reference to the rightTree of this BinaryTree
	    * @throws TreeException Throws an exception if the BinaryTree is empty 
	    */
	   public void attachRightSubtree(BinarySearchTree<T> rightTree) throws TreeException {
			  if (isEmpty()) {
			    throw new TreeException("Error: Cannot attach a subtree to an empty tree!");
			  }
			  else if (root.getRightChild() != null) {
			    throw new TreeException("Error: Cannot overwrite right subtree!");
			  }
			  else {
			       root.setRightChild(rightTree.root);
			       rightTree.makeEmpty();
			  }
	   		 }
	   
	   /**
	    * Detaches the leftSubTree from the BinaryTree
	    * @return A reference to the left tree of this BinaryTree
	    * @throws TreeException Throws an exception if the BinaryTree is empty
	    */
	   public BinarySearchTree<T> detachLeftSubtree() throws TreeException {
		    if (isEmpty()) {
		      throw new TreeException("Error: Cannot detach from and empty empty tree!");
		    }
		    else {
		     BinarySearchTree<T> leftTree = new BinarySearchTree<T>(root.getLeftChild());
		     root.setLeftChild(null);
		     return leftTree;
		    }
		  }
	   
	   /**
	    * Detaches the rightSubTree from the BinaryTree
	    * @return A reference to the left tree of this Binary Tree
	    * @throws TreeException Throws and exception if the BinaryTree is empty
	    */
	   public BinarySearchTree<T> detachRightSubtree() throws TreeException {
		    if (isEmpty()) {
		      throw new TreeException("Error: Cannot detach from an empty tree!");
		    }
		    else {
		       BinarySearchTree<T> rightTree = new BinarySearchTree<T>(root.getRightChild());
		       root.setRightChild(null);
		       return rightTree;
		    }
		  }
	   
	   /**
	    * Searches for a specific value in the binaryTree
	    * @param data A reference to the data 
	    * @param treeNode A reference to the tree node
	    * @return T A reference to T data
	    * @throws TreeException throws an exception if the binaryTree is empty
	    */
	   public boolean search(T data) throws TreeException{
		  TreeNode<T> current = this.root;
		  while(current != null){
			  if(current.getData() == data){
				  return true;
			  }
			  else if(data.compareTo(current.getData())<0){
				  current = current.getLeftChild();
				  
			  }
			  else if(data.compareTo(current.getData())>0){
				  current = current.getRightChild();
				  
			  }
		  }
			return false;	  
			  
		  }
		   
	   /**
	    * Searches the path of the specified value in the binaryTree.
	    * @param data A reference to the data
	    * @param pathHolder
	    * @param node
	    * @return 
	    */
	   public ArrayList<T> searchPath(T data, ArrayList<T> pathHolder ,TreeNode<T> node){
		if(node == null){
			   return pathHolder;
		   }
		   pathHolder.add(node.getData());
		   if(node.getData().compareTo(data) > 0){
			 searchPath(data, pathHolder, node.getLeftChild());
		   }
		   else if(node.getData().compareTo(data) < 0){
			   searchPath(data, pathHolder, node.getRightChild());
		   }
		   else{
			   return pathHolder;
		   }
		   return pathHolder;
	   }
	   
	   /**
	    * Inserts a specific value to the binaryTree
	    * @param data A reference to the data
	    * @param Node A reference to the tree node
	    * @throws TreeException Throws an exception if the BinaryTree is empty
	    */
	   public void insert(T data, BinarySearchTree<T> node) throws TreeException{
		  if(isEmpty()){
			  throw new TreeException("Error: Can't insert a node in an empty tree!");
		  }
		  else if(data.compareTo(node.getRootData()) <= 0 && node.root.getLeftChild() != null){
			  BinarySearchTree<T> LSubTree = new BinarySearchTree<T>(node.root.getLeftChild());
			  insert(data, LSubTree);
		  }
		  else if(data.compareTo(node.getRootData()) > 0 && node.root.getRightChild() != null){
			  BinarySearchTree<T> RSubTree = new BinarySearchTree<T>(node.root.getRightChild());
			  insert(data, RSubTree);
		  }
		  else if(data.compareTo(node.getRootData()) < 0 && node.root.getLeftChild() == null){
			  node.attachLeft(data);  
		  }
		  else{
			  node.attachRight(data);
		  }
	   }
	   
	   
}
