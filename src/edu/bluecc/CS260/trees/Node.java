package edu.bluecc.CS260.trees;

public class Node<E> {

  private Node<E> left;
  private Node<E> right;
  private Node<E> parent;
  private final E value;

  public Node(E value) {
    this.value = value;
  }

  public Node<E> getLeft() {
    return left;
  }

  public void setLeft(Node<E> left) {
    this.left = left;
  }

  public Node<E> getRight() {
    return right;
  }

  public void setRight(Node<E> right) {
    this.right = right;
  }

  public Node<E> getParent() {
    return parent;
  }

  public void setParent(Node<E> parent) {
    this.parent = parent;
  }

  public E getValue() {
    return value;
  }
}
