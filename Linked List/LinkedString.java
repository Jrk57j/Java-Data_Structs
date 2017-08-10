package project2point1;
/**
 * A new LinkedList demonstration 
 * @author Julian itwaru
 * @ver 1.0
 */
import project2point1.ListIndexOutOfBoundsException;

public class LinkedString implements LinkedStringInterface
{

	/**
	 * Creates a reference to a Node of a character.
	 */
	private Node<Character> head;
	/**
	 * Creates a int for count
	 */
	private int count = 0; 
	/**
	 * Creates a default constructor  
	 */
	public LinkedString()
	{
		this.head = null;
		this.count = 0;
	}
	/**
	 * A constructor that feeds in the LinkedString string, and itself.
	 * @param chars A reference to a char.
	 * @throws ListIndexOutOfBoundsException if the index 0.
	 */
	public LinkedString(char[] chars) throws ListIndexOutOfBoundsException
	{
		for(int i = 0; i< chars.length; i++)
		{
			this.add(i, chars[i]);
		}
	}
	/**
	 * A String constructor that is going to be feed in from the char LinkedString constructor 
	 * @param string
	 * @throws ListIndexOutOfBoundsException
	 */
	public LinkedString(String string) throws ListIndexOutOfBoundsException
	{
		 this(string.toCharArray());
	}
	/**
	 * The length of the array size. 
	 */
	public int length()
	 {
		 return this.size();
	 }
	/**
	 * A boolean expression that will tell the user if the LinkedList is empty.
	 */
	 public boolean isEmpty()
	 {
		 return this.length() == 0;
		
	 }
	/**
	 * The size of the LinkedList
	 * @return int A size of the LinkedList.
	 */
	 public int size()
	 {
		 return this.count;
	 }
	
	  /**
	   * Fills the LinkedList
	   * @param index
	   * @param chars
	   * @throws ListIndexOutOfBoundsException
	   */
	   public void add(int index, char chars) throws ListIndexOutOfBoundsException{
		  //Insert a node anywhere in a linked list
		  //Insert at the front
		  //Insert at the back
		  //Insert in the middle
		  
	    if(index >= 0 && index <= this.count ){
		   if(index == 0){ //Insert at the front
			   this.insertAtFront(chars);
		   }else if(index == this.count) {  //Insert at the back
			   this.insertAtBack(chars);
		   }else{
			   this.insertInMiddle(index, chars);
		   }
		  //Insert in the middle
		  }else{
			  throw new ListIndexOutOfBoundsException(" The index is out of bounds. ");
		  }
		 
	  }
	  /**
	   * Inserts an item in the front of the LinkedList
	   * @param item
	   */
	 private void insertAtFront(Character item){
		 if(this.isEmpty()){
			 this.head = new Node<Character>(item, null, null);
		 }else{ // non-empty list
			 Node<Character> newNode = new Node<Character>(item, this.head, null);
			 this.head.setNext(newNode);
			 this.head = newNode;
			 
		 }
		 this.count++;
	 }
	 /**
	  * Inserts an items in the back of the LinkedList
	  * @param item
	  */
	 private void insertAtBack(Character item){
		 if(this.isEmpty()){ // empty list
			 this.insertAtFront(item);
		 }else{ // non-empty list
			 //Travel to the last node, and add the new node.
			 Node<Character> current = this.head;
			 while(current.getNext() != null){//must rely on the node to change  
				 current = current.getNext();
			 }
			 current.setNext(new Node<Character>(item, null, head));
		 }
		 this.count++;
	 }
	 /**
	  * Inserts an item in the middle of the LinkedList, referencing the preceding and next node.
	  * @param index
	  * @param item
	  */
	 private void insertInMiddle(int index, Character item){
		 //go to the node at index
		 Node<Character> current = this.head;
		 int position = 0;
		 while(position < index)
		 {
			 //change the position 
			 current = current.getNext();
			 
		 }
		 Node<Character> nodeBefore = current.getPreceding();//created a local variable for us to not get confused
		 Node<Character> newNode = new Node<Character>(item, current, nodeBefore);//node before could also be get preceding. 
		 //change reference
		 nodeBefore.setNext(newNode);
		 current.setPreceding(newNode);
	 }


	  /**
	   * Gets a character from the LInkedList.
	   * @param index
	   * @return
	   * @throws ListIndexOutOfBoundsException
	   */
	 public Character get(int index) throws ListIndexOutOfBoundsException{
		  
		  if(index >= 0 && index < this.count){
			  int skip = 0;
			  Node <Character> current = this.head;
			  while(skip < index){
				  skip++;
				  current = current.getNext();
			  }
				 
			  return current.getItem();
		  }else{
			  throw new ListIndexOutOfBoundsException("The index is out of bounds.");
		  }
	
	  }
	
	
	/**
	 * 
	 */
	public char charAt(int i) throws ListIndexOutOfBoundsException
	{
		if (i >= 0 && i <= this.length())
		{
			int skip = 0;
			Node<Character> curr = this.head;
			while(skip < i)
			{
				skip++;
				curr = curr.getNext();
			}
			return curr.getItem();
		}	
			else
			{
				throw new ListIndexOutOfBoundsException("something");
			}
			
		}
	
	
	/**
	 * Concatenates two different strings from a LInkedList.
	 */
	public LinkedString concat(LinkedString string) throws ListIndexOutOfBoundsException
	{//newly made Character
		LinkedString concat = new LinkedString();
		concat = this;
		for(int i=0; i < string.length(); i++)
		{
			concat.insertAtBack(string.charAt(i));
		}	
		return concat;
		
	}			
				
		/**
		 * Gets the substring from the LinkedString and pulls the new substring.
		 */
		public LinkedString substring(int start, int end) throws ListIndexOutOfBoundsException
		{
			if(start >= 0 && end <=this.length())
			{
				char[] newString = new char[end - start];
				for(int i = 0; i < newString.length; i++)
				{
					newString [i] = this.charAt(i + start);
					
				}
				LinkedString nString = new LinkedString(newString);
				return nString;
				
			}else{
				throw new ListIndexOutOfBoundsException("Index Out Of Bounds");
			}
		}
	
}
	


	
	
	
	
	
	