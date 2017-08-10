package pro4;

/**
 * A Tree exception that is thrown whenever the binaryTree is empty
 * @author Julian Itwaru
 * @version 1.0
 */
public class TreeException extends RuntimeException 
{
	/**
	   * Construct an exception object with a message.
	   * @param E A reference to an exception message
	   */
	  public TreeException(String ex) 
	  {
	    super(ex);
	  }
}