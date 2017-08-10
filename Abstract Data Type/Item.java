package project1;
/**
 * A refernce to an item. 
 * @author Julian
 * @ver 1.0
 */
public class Item 
{
	//A String that represents an item
	private String name;
	
	/**
	 * Creates a default item.
	 */
	public Item()
	{
		name = null;
	}
	
	/**
	 * A String literal of an item. 
	 * @param item
	 */
	public Item(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns a name for the object. 
	 * @return String A reference to the object's name. 
	 */
	public String getItem()
	{
		return this.name;
	}
	/**
	 * Changes the name of the item. 
	 * @param item Changes the name of the item that is being added to the bag. 
	 */
	public void setItem(String item)
	{
		this.name = item;
	}
	
	/**
	 * A string that is the name of item. 
	 */
	public String toString()
	{
		return this.name;
		
	}
	
	/**
	 * A boolean that determines if one object is equal to another object. 
	 */
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Item))
		{
			return false;
		}
		
		Item other = (Item)obj;
		return this.name.equalsIgnoreCase(name);
	}

	
	
}
