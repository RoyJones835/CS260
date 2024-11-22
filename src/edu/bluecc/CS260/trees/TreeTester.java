package edu.bluecc.CS260.trees;

public class TreeTester {

  public static void main(String[] args) {
    TestLinkedBST();
  }

  public static void AVLTest() {
    AVL<Integer> t = new AVL<Integer>();
  }
  private static void TestGenericLinkedBST() {
    GenericLinkedBST<String> tree = new GenericLinkedBST<>();
    tree.add("dakjlf");

    GenericLinkedBST<Integer> tree2 = new GenericLinkedBST<>();
    tree2.add(3);

    GenericLinkedBST<Double> tree3 = new GenericLinkedBST<>();
    tree3.add(12d);
    tree3.add(12.2343);

    GenericLinkedBST<WaterBottle> tree4 = new GenericLinkedBST<>();
    tree4.add(new WaterBottle(1000,"purple"));
    tree4.add(new WaterBottle(10,"grey"));
  }


  private static void TestLinkedBST() {
    System.out.println("----Adding values----");
    LinkedIntegerBST tree = new LinkedIntegerBST();
    System.out.println(tree.add(14)); // True
    System.out.println(tree.add(22)); // True
    System.out.println(tree.add(92));
    System.out.println(tree.add(63));
    System.out.println(tree.add(3));
    System.out.println(tree.add(2));
    System.out.println(tree.add(4));
    System.out.println(tree.add(15));

//    System.out.println("----Adding duplicates----");
//    System.out.println(tree.add(14)); // False
//    System.out.println(tree.add(22)); // False
//
//    System.out.println("----Checking contains----");
//    System.out.println(tree.contains(14)); //True
//    System.out.println(tree.contains(-13)); //False
//    System.out.println(tree.contains(0)); // False
//    tree.print();
    System.out.println("----Removing values----");
//    System.out.println(tree.remove(52)); // false
//    tree.print();
    System.out.println(tree.remove(3)); // True
    tree.print();
//    System.out.println(tree.remove(14));// True
//    tree.print();
//    System.out.println(tree.remove(92));// True
//    tree.print();
    System.out.println(tree.remove(2));// True ToDO fix this
    tree.print();
//    System.out.println(tree.remove(22));// True
//    tree.print();
    // System.out.println(tree);


    //    tree.printReverse();
  }
}
