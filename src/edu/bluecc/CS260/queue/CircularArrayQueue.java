package edu.bluecc.CS260.queue;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {

  E[] a = (E[])(new Object[1000]);
  int front = 0;
  int back = 0;

  public static void main(String[] args) {
    Queue<Integer> queue = new CircularArrayQueue<>();
    for (int i = 0; i < 10; i++) {
      queue.add(i);
      System.out.println(i+" added");
    }
    System.out.println(queue.remove());
    for (int i = 10; i < 20; i++) {
      queue.add(i);
      System.out.println(i+" added");
    }
    for (int i = 0; i < 20; i++)
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
    if (front == (back+1)%a.length) {
      E[] b = (E[])(new Object[(int)(1.5 * a.length)]);
      for (int i = front, i2 = 0; i != back; i = (i+1)%a.length) {
        b[i2++]=a[i];
      }
      a=b;
    }

    a[back] = value;
    back = (back+1)%a.length;
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

    E val = a[front];
    front = (front+1)%a.length;
    return val;
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
    return a[front];
  }

  /**
   * Returns true if this list contains no elements.
   *
   * @return true if this list contains no elements
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public boolean isEmpty() {
    return front == back;
  }

  /**
   * Clear the queue
   */
  @Override
  public void clear() {
    a = (E[])(new Object[1000]);
    front = 0;
    back = 0;
  }
}
