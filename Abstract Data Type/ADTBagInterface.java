package project1;
/**
 * Interface for the ADTBag for the driver.
 * 
 * @author Julian Itwar
 * @ver 1.0
 */
public interface ADTBagInterface 
{
	/**
	 * Determines if the bag is empty.
	 * @return A boolean value that tells if the bag is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Tells the amount of items in the bag.
	 * @return An integer of how many items are in the bag. 
	 */
	public int size();
	
	/**
	 * Determines if the bad is full.
	 * @return A boolean value that tells if the bag is full. 
	 */
	public boolean isFull();
	
	/**
	 * Returns an items.
	 * @param item A reference to the added item. 
	 * @throws ListException if list is full.
	 * @throws ArrayIndexOutOfBoundsException  if items is greater than 0, or is full.
	 */
	public void insertItem(Object item) throws ListException, ArrayIndexOutOfBoundsException;
	
	/**
	 * Removes all items from the bag. 
	 */
	public void makeEmpty();
	
	/**
	 * 
	 * Removes an item from the bag.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void removeLast() throws ArrayIndexOutOfBoundsException;
	
	/**
	 * 
	 * Removes a random item from the bag. 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void removeRandom() throws ArrayIndexOutOfBoundsException;
	
	
	/**
	 * 
	 * @param index
	 * @return An item at index. 
	 * @throws ArrayIndexOutOfBoundsException If there is no item to return. 
	 * @throws ListException If the bag is empty. 
	 */
	public Object get(int index) throws ArrayIndexOutOfBoundsException;
	

	
	
	
	
	
		

}
