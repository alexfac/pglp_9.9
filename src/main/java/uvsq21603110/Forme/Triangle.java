package uvsq21603110.Forme;

public class Triangle extends Forme {

  String name;
  Point P1;
  Point P2;
  Point P3;

  public Triangle(String name, Point P1, Point P2, Point P3) {
    this.name = name;
    this.P1 = P1;
    this.P2 = P2;
    this.P3 = P3;
  }

  @Override
  public void move(double x, double y) {
    this.P1.addPoint(x, y);
    this.P2.addPoint(x, y);
    this.P3.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Triangle(Point 1 = ("
            + this.P1.getX()
            + ","
            + this.P1.getY()
            + "), "
            + "Point 2 = ("
            + this.P2.getX()
            + ","
            + this.P2.getY()
            + "), "
            + "Point 3 = ("
            + this.P3.getX()
            + ","
            + this.P3.getY()
            + ")"
            + ")");
  }
}
