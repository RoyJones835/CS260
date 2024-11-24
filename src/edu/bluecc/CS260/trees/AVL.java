package edu.bluecc.CS260.trees;

public class AVL<E extends Comparable<E>> implements BinarySearchTree<E> {

  private Node<E> root;


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
    if (root == null) {
      root = new Node<E>(value);
      return true;
    }
    return add(value,root);
  }

  /**
   * Recursive add method that follows the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value - The value to add
   * @param node - Where this method is in the tree
   * @return true if the value was added, false otherwise
   */
  public boolean add(E value, Node<E> node) {
    if (value.equals(node.getValue()))
      return false;

    boolean added;
    if (value.compareTo(node.getValue()) < 0) {
      if (node.getLeft() == null) {
        Node<E> n = new Node<>(value);
        n.setParent(node);
        node.setLeft(n);
        added = true;
      } else added = add(value,node.getLeft()); //go left
    } else {
      if (node.getRight() == null) {
        Node<E> n = new Node<>(value);
        n.setParent(node);
        node.setRight(n);
        added = true;
      } else added = add(value,node.getRight()); //go right
    }
    // at this point, added is set

    node.updateHeight();
    if(Math.abs(node.balanceFactor()) > 1) {
      System.out.println("unbalanced node!!!");
      balance(node);
    }

    return added;
  }

  private void balance(Node<E> node) {

    if (node.balanceFactor() == 2) {
      if (node.getRight().balanceFactor() >= 0) {
        // RR
        rotateLeft(node.getRight(), node); // this line
      } else {
        // RL
        Node<E> a = node.getRight();
        Node<E> b = a.getLeft();
        rotateRight(b,a);
        rotateLeft(b,node);
      }
    } else {
      if (node.getLeft().balanceFactor() <= 0) {
        // LL
        rotateRight(node.getLeft(), node);
      } else {
        // LR
        Node<E> a = node.getLeft();
        Node<E> b = a.getRight();
        rotateLeft(b,a);
        rotateRight(b,node);
      }
    }
  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   * @return true if the value was removed, false otherwise
   */
  @Override
  public boolean remove(E value) {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  private void replace(Node<E> n1, Node<E> n2) {
    Node<E> parent = n1.getParent();
    if (n2 != null)
      n2.setParent(parent);
    if (n1.getParent() == null) {
      // n1 is the root node
      root = n2;
      return;
    }
    if (n1 == parent.getRight())
      parent.setRight(n2);
    else
      parent.setLeft(n2);
  }

  /**
   * Returns true if this tree contains the specified element.
   *
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  @Override
  public boolean contains(E value) {
    return find(value,root) != null;
  }

  /** returns the node that contains the value in the tree, or null if not found
   * recursively searches the tree using the rules of BST
   *
   * @param value the value to search for in the tree
   * @param node Where this method is in the tree
   * @return the node that contains the value
   */
  private Node<E> find(E value, Node<E> node) {
    if (node == null)
      return null;
    if (value.equals(node.getValue()))
      return node;
    if (value.compareTo(node.getValue()) < 0)
      return find(value,node.getLeft());
    else
      return find(value,node.getRight());
  }

  /**
   * Returns true if this tree contains no values
   *
   * @return true if this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Prints the Tree using LVR Traversal, starting at the root
   */
  public void print() {
    if (root != null)
      print(root);
    System.out.println();
  }

  /**
   * Recursive method that prints the Tree using LVR Traversal
   */
  public void print(Node<E> node) {
    if (node.getLeft() != null) {
      print(node.getLeft()); //go left
    }

    System.out.printf("%s ",node.toString()); //visit

    if (node.getRight() != null) {
      print(node.getRight()); //go right
    }
  }

  // NOTE: swapped argument order, updated height after rotation
  private void rotateLeft(Node<E> node2, Node<E> node1) {
    // TODO fix rotate left and right
    node1.setRight(node2.getLeft());
    if(node1.getRight() != null)
      node1.getRight().setParent(node1);
    node2.setLeft(node1);
    replace(node1,node2);
    node1.setParent(node2);

    node1.updateHeight();
    node2.updateHeight();
  }

  private void rotateRight(Node<E> node2, Node<E> node1) {
    node1.setLeft(node2.getRight());
    if(node1.getLeft() != null)
      node1.getLeft().setParent(node1);
    node2.setRight(node1);
    replace(node1,node2);
    node1.setParent(node2);

    node1.updateHeight();
    node2.updateHeight();
  }


}
