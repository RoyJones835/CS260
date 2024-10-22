package edu.bluecc.CS260.stack;

import java.util.Scanner;

public class ExpressionTester {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Welcome to expression checker 3000");
    System.out.println(isValid("(123 ){(hello)}")); // true
    System.out.println(isValid("(123 ){(hello)")); // false

    run();
  }


  public static void run() {
    String line = scanner.nextLine();
  }

  public static boolean isValid(String s){
    return false;
  }
}
