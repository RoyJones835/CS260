package edu.bluecc.CS260.trees;

public class TreeTester {

  public static void main(String[] args) {
    LinkedAVLTreeTest();
  }

  public static void LinkedAVLTreeTest() {
    LinkedAVLTree<Integer> t = new LinkedAVLTree<Integer>();
    t.add(14);
    t.print();
    t.add(22);
    t.print();
    t.add(92);
    t.print();
    t.add(63);
    t.print();
    t.add(3);
    t.print();
    t.add(2);
    t.print();
    t.add(4);
    t.print();
    t.add(15);
    t.print();
    t.add(17);
    t.print();
  }

  public static void TestArrayBST() {
    ArrayBST t = new ArrayBST();
    t.add(14);
    System.out.println(t); // testing toString
    t.add(22);
    System.out.println(t);
    t.add(92);
    System.out.println(t);
    t.add(63);
    System.out.println(t);
    t.add(3);
    System.out.println(t);
    t.add(2);
    System.out.println(t);
    t.add(4);
    System.out.println(t);
    t.add(15);
    System.out.println(t);
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
    System.out.println(tree.remove(2));// True
    tree.print();
//    System.out.println(tree.remove(22));// True
//    tree.print();
    // System.out.println(tree);


    //    tree.printReverse();
  }
}
