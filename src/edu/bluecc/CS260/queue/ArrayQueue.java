package edu.bluecc.CS260.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

  private E[] a = (E[])(new Object[1000]);
  private int back = -1;

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayQueue<>();
    queue.clear();
    queue.add(1);
    queue.add(2);
    queue.add(27);
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
  }

  /**
   * Adds an element to the queue. Return false
   * if the element cannot be added.
   *
   * @param value - the value to add
   * @return - true if the element was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    if(back > 0.8*a.length) {
      E[] b = (E[])(new Object[(int)(1.5 * a.length)]);
      for (int i=0; i <= back; i++) {
        b[i]=a[i];
      }
      a=b;
    }
    a[++back] = value;
    return true;
  }

  /**
   * Removes a value from the front of the queue
   *
   * @return - the removed value
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException();
    E value = a[0];
    for (int i = 1; i <= back; i++) {
      a[i-1] = a[i];
    }
    back--;
    return value;
  }

  /**
   * Returns the value at the front of the queue
   * without removing it
   *
   * @return - the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public E peek() {
    if (isEmpty())
      throw new NoSuchElementException();
    return a[0];
  }

  /**
   * Returns true if this list contains no elements.
   *
   * @return true if this list contains no elements
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public boolean isEmpty() {
    return back == -1;
  }

  /**
   * Clear the queue
   */
  @Override
  public void clear() {
    a = (E[])(new Object[1000]);
    back = -1;
  }
}
