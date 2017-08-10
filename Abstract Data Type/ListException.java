package project1;
/**
 * 
 * @author Julian Itwaru
 * @ver 1.0
 *
 * A runtime exception is applied if the bag is full. 
 */
public class ListException extends RuntimeException 
{
	public ListException(String me)
	{
		super(me);
	}

}
