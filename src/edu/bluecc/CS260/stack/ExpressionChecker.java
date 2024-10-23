package edu.bluecc.CS260.stack;

import java.util.Scanner;

public class ExpressionChecker {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Welcome to expression checker 3000");
    System.out.println(isValid("(123 ){(hello)}")); // true
    System.out.println(isValid("(123 ){(hello)")); // false

    run();
  }


  public static void run() {
    System.out.print("enter an expression or type 'cancel' ");
    String line = scanner.nextLine();
    while(!line.equals("cancel")) {
      if (isValid(line))
        System.out.printf("\"%s\" is a valid expression\n", line);
      else
        System.out.printf("\"%s\" is invalid\n", line);
      System.out.print("enter an expression or type 'cancel' ");
      line = scanner.nextLine();
    }
  }

  public static boolean isValid(String s){
    Stack<Character> stack = new LinkedStack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      }
      else if (c == ')') {
        if (stack.isEmpty() || stack.pop() != '(')
          return false;
      }
      else if (c == ']') {
        if (stack.isEmpty() || stack.pop() != '[')
          return false;
      }
      else if (c == '}') {
        if (stack.isEmpty() || stack.pop() != '{')
          return false;
      }
    }

    return stack.isEmpty();
  }


}
