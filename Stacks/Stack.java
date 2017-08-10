package project3;

import java.util.ArrayList;

/**
 * @author Julian
 * @version 1.0
 */
public class Stack<E> implements StackInterface<E> {

	
          private ArrayList<E> list;

          /**
           * Constructs an empty stack
           */
          public Stack() 
          {
                  this.list = new ArrayList<E>();
          }

          /**
      	 * Returns the number of objects in this stack
      	 */
          public int getSize() 
          {
                  return this.list.size();
          }

          /**
           *
           */
          public void popAll() 
          {
                  this.list.clear();
          }

          /**
          * Removes the top of this stack.
          * @return The item that was most recently added to this stack
          * @throws StackException Throws StackException if the stack is empty.
          */
          public E pop() 
          {
                  return this.list.remove(this.list.size() - 1);
          }

         /**
          *
          * Adds an item to the top of this stack.
          * @param newItem The item to be added to the stack
          * @throws StackException Some implementations may throw StackException when newItem cannot 
          * be placed on the stack.
          */
          public void push(E item) 
          {
                  this.list.add(item);
          }

          /**
      	 * Retrieves a reference the top element of the stack.
      	 * @return The item that was added most recently
      	 * @throws StackException Throws StackException if the stack is empty.
      	 */
          public E peek() 
          {
                  return this.list.get(this.list.size() - 1);
          }

        /**
         * Determines whether the stack is empty.
         * @return A boolean value specifying if this stack is empty
         */
          public boolean isEmpty() 
          {
                  return this.list.isEmpty();
          }

  }

