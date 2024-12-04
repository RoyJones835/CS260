package edu.bluecc.CS260.mapexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapProgram {

  public static void main(String[] args) {
    Map<Integer, Student> studentMap = readStudents("students.txt");
    System.out.println(studentMap.size());
    showScores(studentMap);
    double average = calculateAverage(studentMap);
    System.out.println("Average score is: " + average);
  }

  private static double calculateAverage(Map<Integer, Student> studentMap) {
    // Your code here. Loop over all keys, getting the student score
    // for each and adding to a variable representing the total
    int total = 0;
    for (int id : studentMap.keySet()) {
      Student student = studentMap.get(id);
      total = total + student.getScore();
    }
    return (double)total / studentMap.size();
  }

  private static void showScores(Map<Integer, Student> studentMap) {
    // Your code here. Loop over each key, showing the student name and score for each entry.
    for (int id : studentMap.keySet()) {
      Student student = studentMap.get(id);
      System.out.printf("%s, score:%d ID:%d\n", student.getName(), student.getScore(), student.getId());
    }
  }



  private static Map<Integer,Student> readStudents(String filename) {
    Map<Integer,Student> map = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    try {
      Scanner s = new Scanner(new File(filename));
      while (s.hasNext()) {
        String line = s.nextLine();
        String[] split = line.split(",");
        int id = Integer.valueOf(split[0]);
        LocalDate date = LocalDate.parse(split[3],formatter);
        Student student = new Student(id, split[1], date);
        student.setScore(Integer.valueOf(split[2]));
        map.put(id, student);
      }
      return map;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


}
