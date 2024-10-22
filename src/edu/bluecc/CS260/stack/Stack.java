package edu.bluecc.CS260.stack;

public interface Stack<E> {

  /**
     * Pushes a value onto the top of this stack
     * @param value - the value to be pushed onto the stack
     * @return the value
     * @throws IllegalArgumentException if the value is null
     */
  public E push(E value);

  /**
     * Pops a value off the stack
     * @return the popped value
     * @throws EmptyStackException if the stack is empty
     */
  public E pop();
    
  /**
     * Returns the top value without removing it
     * @return the top value
     * @throws EmptyStackException if the stack is empty
  */
  public E peek();

  /**
     * Tests if this stack is empty
     * @return true if the stack is empty, false otherwise
     */
  public boolean isEmpty();

}