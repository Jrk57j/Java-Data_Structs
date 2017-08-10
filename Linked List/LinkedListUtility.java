package project2point1;
/**
 * A utility that test the LInkedlist. S
 * @author Julian Itwaru
 * @ver 1.0
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LinkedListUtility 
{
	public static void startHere() throws ListIndexOutOfBoundsException, FileNotFoundException
	{
		Scanner scan = new Scanner(new File("txt.txt"));
		LinkedString list = new LinkedString();
		LinkedString list2 = new LinkedString(new String("bacon"));
		
		
		list = fillList(list, scan);
		
		displayList(list);
		displayList(list.concat(list2));
		displayList(list.concat(list2).substring(3, 7));
		
		
		
	}

	private static LinkedString fillList(LinkedString list, Scanner scan) throws ListIndexOutOfBoundsException 
	{
		while(scan.hasNext())
		if(scan.hasNextInt())
		{
			char[] chars = new char[15];
			for(int i = 0; i < chars.length; i++)
			{
				chars[i] = (char)scan.nextInt();
			}
			list = new LinkedString(chars);
		}else
		{
			String str;
			str = scan.next();
			list = new LinkedString(str);
		}
		return list;
	}
	
	private static void displayList(LinkedString list) throws ListIndexOutOfBoundsException 
	{
		System.out.println("size of this is " + list.length());
		for(int i = 0; i< list.length(); i++)
		{
			System.out.println(list.charAt(i));
		}		
	}
}
