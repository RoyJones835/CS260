package edu.bluecc.CS260.trees;

public class ExpressionTree {

  private String[] a = new String[1000];
  private int end = -1;

  public static void main(String[] args) {
    ExpressionTree tree = new ExpressionTree();
    tree.add("*");
    tree.add("÷");
    tree.add("-");
    tree.add("+");
    tree.add("4");
    tree.add("6");
    tree.add("1");
    tree.add("5");
    tree.add("*");
    for (int i = 0; i < 8; i++)
      tree.add(null);
    tree.add("3");
    tree.add("2");

    // ( ( 5 + ( 3 * 2 ) ) ÷ 4 ) * ( 6 - 1 )
    tree.LVR();
    System.out.println();
    tree.VLR();
    System.out.println();
    tree.LRV();
    System.out.println();
  }

  /**
   * Add the next value in the expression tree
   * Elements must be added "breadth-first". Missing values must be added with a "null" value
   * @param value - the value to add (operator or operand)
   */
  public void add(String value) {
    a[++end] = value;
  }

  /**
   * Show the expression in "infix" notation
   */
  public void LVR() {
    LVR(0);
  }

  /**
   * This is the recursive LVR traversal method showing the expression in "infix" notation
   * Each movement "down" in the tree to a non-digit node will print a "("; each step up prints a ")"
   * @param index - the "current" index of the traversal
   */
  private void LVR(int index) {
    if (a[index] == null) return;

    if (a[2*index+1] != null) {
      if (a[2*index+1].matches("\\d+")) {
        System.out.print(a[2 * index + 1] + " ");
      } else {
        System.out.print("( ");
        LVR(2 * index + 1); // L
      }
    }

    System.out.print(a[index] + " "); // V

    if (a[2*index+2] != null) {
      if (a[2*index+2].matches("\\d+")) {
        System.out.print(a[2 * index + 2] + " ");
      } else {
        System.out.print("( ");
        LVR(2 * index + 2); // R
      }
    }

    if (index != 0)
      System.out.print(") ");
  }

  /**
   * Show the expression in "prefix" notation
   */
  public void VLR() {
    VLR(0);
  }

  /**
   * This is the recursive VLR traversal method showing the expression in "prefix" notation
   * Each movement "down" in the tree to a non-digit node will print a "("; each step up prints a ")"
   * @param index - the "current" index of the traversal
   */
  private void VLR(int index) {
    if (a[index] == null) return;

    System.out.print(a[index] + " "); // V

    if (a[2*index+1] != null) {
      if (a[2*index+1].matches("\\d+")) {
        System.out.print(a[2 * index + 1] + " ");
      } else {
        System.out.print("( ");
        VLR(2 * index + 1); // L
      }
    }

    if (a[2*index+2] != null) {
      if (a[2*index+2].matches("\\d+")) {
        System.out.print(a[2 * index + 2] + " ");
      } else {
        System.out.print("( ");
        VLR(2 * index + 2); // R
      }
    }

    if (index != 0)
      System.out.print(") ");
  }

  /**
   * Show the expression in "postfix" notation
   */
  public void LRV() {
    LRV(0);
  }

  /**
   * This is the recursive LVR traversal method showing the expression in "infix" notation
   * Each movement "down" in the tree to a non-digit node will print a "("; each step up prints a ")"
   * @param index - the "current" index of the traversal
   */
  private void LRV(int index) {
    if (a[index] == null) return;

    if (a[2*index+1] != null) {
      if (a[2*index+1].matches("\\d+")) {
        System.out.print(a[2 * index + 1] + " ");
      } else {
        System.out.print("( ");
        LRV(2 * index + 1); // L
      }
    }

    if (a[2*index+2] != null) {
      if (a[2*index+2].matches("\\d+")) {
        System.out.print(a[2 * index + 2] + " ");
      } else {
        System.out.print("( ");
        LRV(2 * index + 2); // R
      }
    }

    System.out.print(a[index] + " "); // V

    if (index != 0)
      System.out.print(") ");
  }

}
