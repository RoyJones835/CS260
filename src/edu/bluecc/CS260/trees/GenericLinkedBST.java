package edu.bluecc.CS260.trees;

public class GenericLinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

  Node<E> root;
  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value - The value to add
   * @return true if the value was added, false otherwise
   */
  @Override
  public boolean add(E value) {
    return add(value, root);
  }

  private boolean add(E value, Node<E> node) {
    if (value.compareTo(node.getValue())<0) {
      System.out.println("Add it here");
    }
    return false;
  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   * @return true if the value was removed, false otherwise
   */
  @Override
  public boolean remove(E value) {
    return false;
  }

  /**
   * Returns true if this tree contains the specified element.
   *
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  @Override
  public boolean contains(E value) {
    return false;
  }

  /**
   * Returns true if this tree contains no values
   *
   * @return true if this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return false;
  }
}
