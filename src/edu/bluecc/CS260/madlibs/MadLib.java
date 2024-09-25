package edu.bluecc.CS260.madlibs;

import java.util.Scanner;

public class MadLib {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String text = "In the book War of the [1], the main character is an anonymous [2] who records the arrival of [3] in [4]. Needless to say, havoc reigns as the [3] continue to [5] everything in sight until they are killed by the common [6].";
    String[] parts = {"NOUN (PLURAL)", "OCCUPATION", "ANIMAL (PLURAL)", "PLACE", "VERB", "NOUN"};
    MadLib m = new MadLib(text, parts);
    m.play();
  }

  /**
   * Given the array of parts of speech, returns an array of words entered by the user to match each one. The size of the returned array will be the same size as the input array.
   * @param parts
   * @return words
   */
  private static String[] getWords(String[] parts) {
    String[] words = new String[parts.length];

    for (int i = 0; i < parts.length; i++) {
      System.out.printf("Give me a %s: ",parts[i]);
      words[i] = scanner.nextLine();
    }

    return words;
  }

  private void play() {
    System.out.println("----- Welcome to Madlibs CS260 Edition ------");
    String[] words = getWords(parts);
    String story = text;
    for (int i = 0; i < words.length; i++) {
      story = story.replaceAll(String.format("\\[%d\\]",i+1), words[i]);
    }
    System.out.println(story);

  }

  private final String text;
  private final String[] parts;

  public MadLib(String text, String[] parts) {
    this.text = text;
    this.parts = parts;
  }

  public String getText() {
    return text;
  }

  public String[] getParts() {
    return parts;
  }


}
