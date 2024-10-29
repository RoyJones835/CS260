package edu.bluecc.CS260.queue;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

  private Node<E> front;
  private Node<E> back;

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayQueue<>();
    queue.clear();
    queue.add(1);
    queue.add(2);
    queue.add(27);
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.isEmpty());
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
    Node<E> node = new Node<>(value);
    if (isEmpty())
      front = node;
    else
      back.setNext(node);
    back = node;
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

    E value = front.getValue();
    front = front.getNext();
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
    return front.getValue();
  }

  /**
   * Returns true if this list contains no elements.
   *
   * @return true if this list contains no elements
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public boolean isEmpty() {
    return front == null;
  }

  /**
   * Clear the queue
   */
  @Override
  public void clear() {
    front = null;
    back = null;
  }
}
