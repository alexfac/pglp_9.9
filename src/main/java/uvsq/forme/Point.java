package uvsq.forme;

public class Point {

  double px;
  double py;

  public Point(double x, double y) {
    this.px = x;
    this.py = y;
  }

  public void addPoint(double x, double y) {
    this.px += x;
    this.py += y;
  }

  public double getX() {
    return px;
  }

  public double getY() {
    return py;
  }
}
