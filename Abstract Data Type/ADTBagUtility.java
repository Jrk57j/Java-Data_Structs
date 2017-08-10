package project1;
/**
 * @author Julian
 * @ver 10
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * Fills a bag. 
 * 
 * @author Julian
 * @ver 1.0
 */
public class ADTBagUtility 
{
	 /* 
	 * @param args A reference to a string array that can store command-line arguments
	 */
	public static void thisBag() throws ArrayIndexOutOfBoundsException, ListException, FileNotFoundException  {
		
	   //Create a list
		
		ADTBag list = new ADTBag();
		Scanner data = new Scanner(new File("items.txt"));
		
		fillList(list, data);

	   //Display a list
		displayList(list);
		//Removes last item
		list.removeLast();
		displayList(list);
		//removes random item
		list.removeRandom();
		displayList(list);
	}
	/**
	 * 
	 * @param list
	 * @param data
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws ListException
	 */
	private static void fillList(ADTBag list, Scanner data) throws ArrayIndexOutOfBoundsException, ListException
	{
		try{
		while(data.hasNext())
		{
			String item = data.next();
			list.insertItem(new Item(item));
			
		}
		
		/**
		 * This section was to test the try catch to ensure that the program will still run even if the user tries to add to many objects. 
		 */
    	/*list.insertItem("Bacon");
		list.insertItem("ground beef");
		list.insertItem("yogurt");
		list.insertItem("milk");
		list.insertItem("cheese");
		list.insertItem("BMW m5");
		list.insertItem("goku");
		list.insertItem("Grim Reaper");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");
		list.insertItem("Bacon");*/
		}
		
	
       /**
        * If the token passed is not an integer it will catch and throw the error. 	
        */
        catch(ListException ex) 
        {
       	ex.printStackTrace();
       	System.out.println("List is Full");
        }
		
	
		finally
		{
			
		}
	}	
	
		
	/**
	 * 
	 * @param list Displays the list.
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws ListException
	 */
	private static void displayList(ADTBag list) throws ArrayIndexOutOfBoundsException, ListException
	{
		System.out.println("The size of this list is " + list.size());
		   for(int i = 0; i < list.size(); i++){
			   System.out.println(list.get(i));
		   }
		   System.out.println();
		 
		   
	 
	 
	 
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

				

