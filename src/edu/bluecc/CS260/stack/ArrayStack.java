package edu.bluecc.CS260.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

  private E[] a = (E[])(new Object[1000]);
  private int top = -1;

  public static void main(String[] args) {
    Stack<Integer> stack = new ArrayStack<Integer>();
    System.out.println(stack.push(1));
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
    System.out.println(stack.peek());
  }

  /**
   * Pushes a value onto the top of this stack
   *
   * @param value - the value to be pushed onto the stack
   * @return the value
   * @throws IllegalArgumentException if the value is null
   */
  @Override
  public E push(E value) {
    if (value == null)
      throw new IllegalArgumentException("cannot push a null value");

    // resize the array if needed
    if(top > 0.8*a.length) {
      E[] b = (E[])(new Object[(int)(1.5 * a.length)]);
      for (int i=0; i <= top; i++) {
        b[i]=a[i];
      }
      a=b;
    }
    a[++top] = value;
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
    if (isEmpty())
      throw new EmptyStackException();
    return a[top--];
  }

  /**
   * Returns the top value without removing it
   *
   * @return the top value
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public E peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return a[top];
  }

  /**
   * Tests if this stack is empty
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return top == -1;
  }
}
