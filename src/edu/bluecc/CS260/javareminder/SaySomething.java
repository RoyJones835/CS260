package edu.bluecc.CS260.javareminder;

public class SaySomething {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(CreateSentence());
    }
  }

  public static String CreateSentence() {
    String[] nouns = {"frogs","broccoli","octopus","beet juice","yams","frisbees","long walks off a short pier","dolphins","public speaking"};
    String[] verbs = {"like", "love", "despise", "crave", "enjoy", "throw", "catch", "run with"};
    int ni = (int)(Math.random() * nouns.length);
    int vi = (int)(Math.random() * verbs.length);
    String sentence = String.format("I %s %s.", verbs[vi], nouns[ni]);
    return sentence;
  }
}
