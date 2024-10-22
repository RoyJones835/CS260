package edu.bluecc.CS260.stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

  private Node<E> top = null;

  public static void main(String[] args) {
    Stack<Integer> s = new LinkedStack<Integer>();
    System.out.println(s.push(1));
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    System.out.println(s.peek());
  }
  /**
   * Pushes a value onto the top of this stack
   *
   * @param value - the value to be pushed onto the stack
   * @return the value
   */
  @Override
  public E push(E value) {
    Node<E> node = new Node<>(value);
    node.setNext(top);
    top = node;
    return value;
  }

  /**
   * Pops a value off the stack
   *
   * @return the popped value
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public E pop() {
    if (top == null)
      throw new EmptyStackException();
    E value = top.getValue();
    top = top.getNext();
    return value;
  }

  /**
   * Returns the top value without removing it
   *
   * @return the top value
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public E peek() {
    if (top == null)
      throw new EmptyStackException();
    return top.getValue();
  }

  /**
   * Tests if this stack is empty
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return top == null;
  }
}
