package edu.bluecc.CS260.trees;

public class Node<E> {

  private Node<E> left;
  private Node<E> right;
  private Node<E> parent;
  private final E value;
  private int height = 0;

  public Node(E value) {
    this.value = value;
  }

  public Node(E value, Node<E> parent) {
    this.value = value;
    this.parent = parent;
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

  public void updateHeight() {
    height = Math.max(height(left),height(right))+1;
  }

  private static <E> int height (Node<E> node) {
    return node == null ? -1 : node.height;
  }

  public int balanceFactor() {
    return height(right) - height(left);
  }

  // tostring method that displays the value, height and balance factor
  @Override
  public String toString() {
    return String.format("%s:%d|%d", value.toString(), height, balanceFactor());
  }
}
