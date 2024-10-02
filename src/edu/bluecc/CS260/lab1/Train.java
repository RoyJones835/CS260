package edu.bluecc.CS260.lab1;

import java.util.Scanner;

public class Train {

  private TrainCar start;
  private TrainCar end;
  private int numCars;


  public Train(TrainCar start) {
    this.start = start;
    this.end = start;
    numCars = 1;
  }

  public void addCar(TrainCar car) {
    end.setNextCar(car);
    end = car;
    numCars++;
  }

  public void show() {
    TrainCar car = start;
    while (car != null) {
      System.out.print(car);
      car = car.getNextCar();
      if (car != null)
        System.out.print(" -- ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    TrainCar start = new TrainCar(1,"Engine");
    Train train = new Train(start);

    System.out.println("Do you want to add a train car?");
    String response = scanner.nextLine();
    int counter = 2;
    while (response.equalsIgnoreCase("yes")) {
      System.out.print("what is the cargo of this car? ");
      String cargo = scanner.nextLine();
      train.addCar(new TrainCar(counter,cargo));
      counter++;

      System.out.print("Do you want to add another train car? ");
      response = scanner.nextLine();
    }

    System.out.println("Train buildination is complete. Your train:\n");

    train.show();
    scanner.close();
  }
}