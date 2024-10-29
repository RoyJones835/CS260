package edu.bluecc.CS260.queue;

import java.util.NoSuchElementException;

public interface Queue<E> {

  /**
   * Adds an element to the queue. Return false
   * if the element cannot be added.
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  public boolean add(E value);

  /**
   * Removes a value from the front of the queue
   * @return - the removed value
   * @throws NoSuchElementException if the queue is empty
   */
  public E remove();

  /**
   * Returns the value at the front of the queue
   * without removing it
   * @return - the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  public E peek();

  /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements
   * @throws NoSuchElementException if the queue is empty    
  */
  public boolean isEmpty();

  /**
   * Clear the queue
   */
  public void clear();

}