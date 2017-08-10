package pro4;

import java.util.LinkedList;
/**
 * An iterator for BinaryTree
 * @author Julian Itwaru
 * @version 1.0
 */
public class TreeIterator<T extends Comparable<? super T>> implements java.util.Iterator<T> {
	 /**
	   * The collection traversed by this iterator
	   */
	  private BinarySearchTreeBasis<T> tree;
	  /**
	   * The current location of this iterator
	   */
	  private TreeNode<T> currentNode;
	  /**
	   * An ordered list of nodes traversed by this iterator. 
	   * Empty queue indicates no traversal type currently selected or 
	   * end of current traversal has been reached
	   */
	  private LinkedList <TreeNode<T>> queue;

	  /**
	   * Constructs an iterator over a binary tree. 
	   * @param tree A reference to a binary tree
	   */
	  public TreeIterator(BinarySearchTreeBasis<T> tree) {
		  this.tree = tree;
		  this.currentNode = null;
		  this.queue = new LinkedList<TreeNode<T>>();
	  }

	  /**
	   * Returns true if the iteration has more elements. 
	   * (In other words, returns true if next() would return an element rather than throwing an exception.)
	   * @return A boolean value specifying if there is an element to be returned
	   */
	  public boolean hasNext() {
	    return !queue.isEmpty();
	  }

	  /**
	   * Returns the next element in the iteration.
	   * @return the next element in the iteration
	   * @throws NoSuchElementException if the iteration has no more elements
	   */
	  public T next() throws java.util.NoSuchElementException {
	      this.currentNode = queue.remove();
	      return this.currentNode.getData();
	  }

	  /**
	   * Removes from the underlying binary tree the last element returned by this iterator (optional operation). 
	   * It can be called only once per call to next method.
	   */
	  public void remove() throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	  }

	  /**
	   * Sets the traversal type to be preorder.
	   */
	  public void setPreorder() {
		  this.queue.clear();
	      preorder(this.tree.root);
	  }

	  /**
	   * Sets the traversal type to be inorder.
	   */
	  public void setInorder() {
		  this.queue.clear();
	      inorder(this.tree.root);
	  }

	  /**
	   * Sets the traversal type to be postorder.
	   */
	  public void setPostorder() {
		  this.queue.clear();
	      postorder(this.tree.root);
	  }

	  /**
	   * Traverses BinaryTree in preorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void preorder(TreeNode<T> treeNode) {
	    if (treeNode != null) {
	    	this.queue.add(treeNode);
	    	preorder(treeNode.getLeftChild());
	    	preorder(treeNode.getRightChild());
	     
	    }
	  }

	  /**
	   * Traverses BinaryTree in inorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void inorder(TreeNode<T> treeNode) {
	    if (treeNode != null) {
	    	inorder(treeNode.getLeftChild());
	    	this.queue.add(treeNode);
	    	inorder(treeNode.getRightChild());
	    }
	  }

	  /**
	   * Traverses BinaryTree in postorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void postorder(TreeNode<T> treeNode) {
	    if (treeNode != null) {
	    	postorder(treeNode.getLeftChild());
	    	postorder(treeNode.getRightChild());
	    	this.queue.add(treeNode);
	    } 
	  } 
	  
	  
}