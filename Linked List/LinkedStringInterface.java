package project2point1;
/**
 * An interface to LinkedString. 
 * @author Julian Itwaru
 * @ver 1.0
 */
import project2point1.LinkedString;
import project2point1.ListIndexOutOfBoundsException;

public interface LinkedStringInterface
{
	/**
	 * A integer value of the LinkedList length.
	 * @return an Integer value of the List. 
	 */
	public int length();
	/**
	 * 
	 * @param i
	 * @return
	 * @throws ListIndexOutOfBoundsException if the index if full or 0.
	 */
	public char charAt(int i) throws ListIndexOutOfBoundsException;
	/**
	 * 
	 * @param string A new string.
	 * @return A string of the new LinkedList
	 * @throws ListIndexOutOfBoundsException if the index is 0 or full.
	 */
	public LinkedString concat(LinkedString string) throws ListIndexOutOfBoundsException;
	/**
	 * Adds an item to the list at position index.
	 * @param index The position of this added item
	 * @param item A reference to this added item
	 * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
	 */
	public LinkedString substring(int start, int end) throws ListIndexOutOfBoundsException;
	/**
	 * Determines if the list is empty.
	 * @return an boolean value if the list is full or empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the length of a list.
	 * @return an integer that tells the length of the list.
	 */
	public int size();
	
	
	
	
}
