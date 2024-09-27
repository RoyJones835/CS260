package edu.bluecc.CS260.javareminder;


public class Point3D {
  public static void main(String[] args) {
    Point3D point1 = createRandom(-10,10);
    Point3D point2 = createRandom(-10,10);
    System.out.printf("The distance between %s and %s is %.4f units",point1,point2,point1.distanceTo(point2));
  }

  /* This is just a method that returns a random number in the specified range, a to b.
  */
  public static double randomNumber(int a, int b) {
    return Math.random()*(b-a)+a;
  }

  public static Point3D createRandom(int a, int b) {
    if (b<a) {
      throw new IllegalArgumentException("The maximum value cannot be less than the minimum value");
    }
    return new Point3D(randomNumber(a,b), randomNumber(a,b), randomNumber(a,b));
  }

  private double x;
  private double y;
  private double z;

  public Point3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /** Calculate the 3D distance between this point and the given Point3D **/
  public double distanceTo(Point3D point) {
    return Math.sqrt(Math.pow(point.x - x,2)+Math.pow(point.y - y,2)+Math.pow(point.y - y,2));
  }

  public String toString() {
    return String.format("(%.4f, %.4f, %.4f)", x, y, z);
  }

}
