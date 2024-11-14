package edu.bluecc.CS260.trees;

public class LinkedIntegerBST implements BinarySearchTree<Integer> {

  private Node<Integer> root;


  /**
   * Add a value to this tree following the BST algorithm
   * Values to the right of a node are greater than the node value
   * Values to the left of a node are less than the node value
   *
   * @param value - The value to add
   * @return true if the value was added, false otherwise
   */
  @Override
  public boolean add(Integer value) {
    if (root == null) {
      root = new Node<Integer>(value);
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
  public boolean add(Integer value, Node<Integer> node) {
    if (value.equals(node.getValue()))
      return false;
    else if (value < node.getValue()) {
      if (node.getLeft() == null) {
        Node<Integer> n = new Node<>(value);
        n.setParent(node);
        node.setLeft(n);
        return true;
      }
      return add(value,node.getLeft()); //go left
    } else {
      if (node.getRight() == null) {
        Node<Integer> n = new Node<>(value);
        n.setParent(node);
        node.setRight(n);
        return true;
      }
      return add(value,node.getRight()); //go right
    }

  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   * @return true if the value was removed, false otherwise
   */
  @Override
  public boolean remove(Integer value) {
    Node<Integer> node = find(value,root);
    if (node == null)
      return false; // value not found
    if (node.getRight() == null && node.getLeft() == null) {
      replace (node,null); // Leaf node detected
      return true;
    }
    else if (node.getRight() != null && node.getLeft() == null) {
      replace(node,node.getRight());
      return true;
    }
    else if (node.getRight() == null && node.getLeft() != null) {
      replace(node,node.getLeft());
      return true;
    } else {
      Node<Integer> min = min(node.getRight());
      min.setLeft(node.getLeft());
      node.setLeft(null);
      replace(node,node.getRight());
      return true;
    }
  }

  private void replace(Node<Integer> n1, Node<Integer> n2) {
    if (n1.getParent() == null) {
      // n1 is the root node
      root = n2;
      n2.setParent(null);
      return;
    }
    Node<Integer> parent = n1.getParent();
    if (n1 == parent.getRight())
      parent.setRight(n2);
    else
      parent.setLeft(n2);

    if (n2 != null)
      n2.setParent(parent);
  }

  /**
   *
   * @return the minimum value node of the subtree. this node will always be found by repeatably going left
   */
  private Node<Integer> min(Node<Integer> node) {
    if (node == null)
      throw new IllegalArgumentException("cannot find the minimum of a null pointer");
    if (node.getLeft() == null)
      return node;
    else
      return min(node.getLeft());
  }

  /**
   * Returns true if this tree contains the specified element.
   *
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  @Override
  public boolean contains(Integer value) {
    return find(value,root) != null;
  }

  /** returns the node that contains the value in the tree, or null if not found
   * recursively searches the tree using the rules of BST
   *
   * @param value the value to search for in the tree
   * @param node Where this method is in the tree
   * @return the node that contains the value
   */
  private Node<Integer> find(Integer value, Node<Integer> node) {
    if (node == null)
      return null;
    if (value.equals(node.getValue()))
      return node;
    if (value < node.getValue())
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
  }

  /**
   * Recursive method that prints the Tree using LVR Traversal
   */
  public void print(Node<Integer> node) {
    if (node.getLeft() != null) {
      print(node.getLeft()); //go left
    }

    System.out.printf("%s ",node.getValue()); //visit

    if (node.getRight() != null) {
      print(node.getRight()); //go right
    }
  }


}
