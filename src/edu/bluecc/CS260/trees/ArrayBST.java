package edu.bluecc.CS260.trees;

public class ArrayBST implements BinarySearchTree<Integer> {

  private Integer[] a = new Integer[10000];

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
    return add(value,0);
  }

  /**
   * Recursive 'add' method which traverses the BST at the
   * node specified by the given index
   * @param value
   * @param index
   * @return true if the value is added, false otherwise
   */
  private boolean add(Integer value, int index) {
    // resize if needed
    if (index > a.length-1) {
      Integer[] b = new Integer[(2 * index)];
      for (int i=0; i < a.length; i++) {
        b[i]=a[i];
      }
      a=b;
    }

    if (a[index] == null) {
      a[index] = value;
      return true;
    }
    else if (value < a[index])
      return add(value,2*index+1); // Go Left
    else if (value > a[index])
      return add(value,2*index+2); // Go Right
    else
      return false; // duplicate value
  }

  /**
   * Remove a value from this tree
   *
   * @param value The value to remove
   * @return true if the value was removed, false otherwise
   */
  @Override
  public boolean remove(Integer value) {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * Returns true if this tree contains the specified element.
   *
   * @param value value whose presence in this tree is to be tested
   * @return true if this list contains the specified value
   */
  @Override
  public boolean contains(Integer value) {
    return contains(value,0);
  }

  public boolean contains(Integer value, int index) {
    // Check for value not found
    if (a[index] == null)
      return false;

    if (value.equals(a[index]))
      return true;
    else if (value < a[index])
      return contains(value,2*index+1); // Go Left
    else
      return contains(value,2*index+2); // Go Right
  }

  /**
   * Returns true if this tree contains no values
   *
   * @return true if this tree contains no values
   */
  @Override
  public boolean isEmpty() {
    return a[0] == null;
  }

  /**
   * Performs an LVR traversal, printing each node
   */
  public void print() {
    LVR(0);
  }

  private void LVR(int index) {
    if (a[index] == null)
      return;

    LVR(2*index+1);
    System.out.print(a[index] + " ");
    LVR(2*index+2);
  }

  public void printReverse() {
    RVL(0);
  }

  private void RVL(int index) {
    if (a[index] == null)
      return;

    RVL(2*index+2);
    System.out.print(a[index] + " ");
    RVL(2*index+1);
  }

}
