package project3;

/**
 * @author Julian
 * @version 1.0
 */
public interface StackInterface<E>
    {
        /**
         * @return the size of the stack. 
         */
        public int getSize();
        
        /**
         * @return deletes last item. 
         * @throws StackException 
         */
        public E pop() throws StackException;
        
        /**
         * adds an item into to the stack. 
         * @param item
         */
        public void push(E item)throws StackException;
        
        /**
         * displays the last items added in. 
         * @param item
         */
        public E peek()/* throws StackException*/;
        
        /**
         * checks to see if the stack is empty. 
         * @return
         */
        public boolean isEmpty();
    }