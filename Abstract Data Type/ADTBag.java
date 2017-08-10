package project1;

import java.util.Random;



/**
 * This program will allow a user to add any type of singular data into a "virtual" bag. It will be able to tell you if the 
 * bag is full, empty, remove at random and be able to do other stuff. magical things like cook bacon for you
 * @author Julian Itwaru
 * @version 1.0
 */


public class ADTBag implements ADTBagInterface
{
		/**
		 * Array of random objects.
		 */
		private Object[] items;
		
		/*
		 * item count for the list
		 */
		
		private int count;
		
		/**
		 * size of the array
		 */
		private final int MAXIMUM_SIZE = 15;
		
		/**
		 * Constructs an empty list
		 */
		public ADTBag()
		{
			this.items = new Object[MAXIMUM_SIZE];
			this.count = 0;
		}
		
		/**
		 * Returns if the "list" is empty.
		 * @return A boolean value true or false if the bag is empty(true) or has object(false)
		 */
		public boolean isEmpty()
		{
			if(count == 0)
			{
				return true;
			}else return false;	
		}
		
		public boolean isFull()
		{
			if(count == MAXIMUM_SIZE)
			{
				return true;
			}else return false;
		}
		
		/**
		 * Returns how many objects are in the bag.
		 * @return int An interger reference to the size of the bag. 
		 */
		public int size()
		{
			return this.count;
		}
		
		
		/**
		 * 
		 * A reference to an Item that is being added to the bag. 
		 * 
		 * @param item A reference to the item that is being added to the bag. 
		 * @throws ListException if the bag is full. 
		 */
		public  void insertItem(Object items) throws ListException
		{
			
			if(isFull())
			{
				throw new ListException("List is full");
			}
			else if(this.count <= MAXIMUM_SIZE)
			{
				this.items[this.count] =  items;
				 this.count++;
			}
		}
		
		
			/**
			 * Empty the bag of all items
			 */
			public void makeEmpty()
			{
				this.items = new Object[MAXIMUM_SIZE];
				this.count = 0;
			}
			/**
			 * Reoves the last item from the bag. 
			 * @throws ListException If the bag is empty. 
			 */
			
			public void removeLast() throws ListException
			{
				if(this.isEmpty())
				{
					throw new ListException("Bag is empty");
					
					
				}
				else if(this.count > 0 && this.count < MAXIMUM_SIZE)
				{
					this.items[this.count -1] = null;
					this.count--;
				}
				
				else if(this.count == MAXIMUM_SIZE)
				{
					this.items[MAXIMUM_SIZE - 1] = null;
					this.count--;
				}
				
				
				
			}
				
			/**
			 * Removes an item at random. 
			 */
			public void removeRandom() throws ArrayIndexOutOfBoundsException
			{
				if(this.isEmpty())
				{
					throw new ArrayIndexOutOfBoundsException("This list is empty");
				}
				else if(this.count == 1)
				{
					this.count--;
				}
				else
				{
					Random rand = new Random();
					int j = rand.nextInt(this.count);
					while(j < this.count)
					{
						items[j - 1] = items[j];
						j++;
						
					}
					this.count--;
				}
			}
			
			/**
			 * Returns the object(s) that are in the bag. 
			 */
			public Object get(int index) throws ArrayIndexOutOfBoundsException
			{
				  //must scan through the list
				  //must find item
				
				if(index >= 0 && index < this.items.length)
				{
					
					return this.items[index];
				}//throw an exception if the list does not contain this object. 
					else
					{
						throw new ArrayIndexOutOfBoundsException("No item found");
					}
				}			
}