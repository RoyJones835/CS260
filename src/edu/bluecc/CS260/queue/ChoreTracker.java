package edu.bluecc.CS260.queue;

import java.util.Scanner;

public class ChoreTracker {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    Queue<String> queue = new LinkedQueue<>();
    String input = prompt();

    while (!"q".equalsIgnoreCase(input)) {
      if (input.equalsIgnoreCase("a")) {
        System.out.print("Enter a job: ");
        queue.add(scanner.nextLine());
      }
      else if (input.equalsIgnoreCase("g")) {
        if (queue.isEmpty())
          System.out.println("* No more jobs! *");
        else
          System.out.println(queue.remove());
      }
      else if (input.equalsIgnoreCase("c")) {
        System.out.print("Are you sure (y/n)? ");
        String response = scanner.nextLine();
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
          System.out.print("Are you sure (y/n)? ");
          response = scanner.nextLine();
        }
        if (response.equalsIgnoreCase("y")) {
          queue.clear();
          System.out.println("* Cleared! *");
        }
      }
      else
        System.out.printf("'%s' is invalid\n", input);
      input = prompt();
    }
    System.out.println("Goodbye!");
  }

  /** prompts the user with a question and returns the answer
   *
   * @return returns the answer to the question
   */
  public static String prompt() {
    System.out.print("Would you like to (A)dd a job, (G)et a job, (C)lear the queue, or (Q)uit? ");
    return scanner.nextLine();
  }
}
