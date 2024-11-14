package edu.bluecc.CS260.trees;

public class WaterBottle implements Comparable<WaterBottle>{

  private final int capacity;
  private int level;
  private final String color;

  public WaterBottle(int capacity,String color) {
    this.capacity = capacity;
    this.color = color;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getLevel() {
    return level;
  }

  public String getColor() {
    return color;
  }

  public void addLiquid(int amount) {
    level = Math.min(level+amount,capacity);
  }

  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * @param wb a WaterBottle Instance
   * @returns a negative Integer, 0, or a positive integer, based on their capacity
   */
  @Override
  public int compareTo(WaterBottle wb) {
    return capacity - wb.capacity;
  }
}
