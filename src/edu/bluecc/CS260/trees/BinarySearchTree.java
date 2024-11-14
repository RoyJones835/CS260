package edu.bluecc.CS260.trees;

/**
 * An interface for the operations available on a Binary Search Tree (BST)
 * A BST is a binary tree where each node is less than all the nodes in its right subtree
 * and greater than all the nodes in its left subtree.
 *
 * @param <E> the type of elements held in this tree
 * @author Greg Schulberg*
 */
public interface BinarySearchTree<E> {

  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   * @param value - The value to add
   * @return true if the value was added, false otherwise
   */
  public boolean add(E value);

  /**
   * Remove a value from this tree
   * @param value The value to remove
   * @return true if the value was removed, false otherwise
   */
  public boolean remove(E value);

  /**
   * Returns true if this tree contains the specified element.
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  public boolean contains(E value);

  /**
   * Returns true if this tree contains no values
   * @return true if this tree contains no values
   */
  public boolean isEmpty();

}