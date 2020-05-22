package uvsq.forme;

public class Triangle extends Forme {

  Point p1;
  Point p2;
  Point p3;

  public Point getP1() {
    return p1;
  }

  public Point getP2() {
    return p2;
  }

  public Point getP3() {
    return p3;
  }

  /**
   * Constructeur triangle.
   * @param name nom
   * @param p1 point haut
   * @param p2 point gauche
   * @param p3 point droite
   */
  public Triangle(String name, Point p1, Point p2, Point p3) {
    super(name);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  @Override
  public void move(double x, double y) {
    this.p1.addPoint(x, y);
    this.p2.addPoint(x, y);
    this.p3.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Triangle(Point 1 = ("
            + this.p1.getX()
            + ","
            + this.p1.getY()
            + "), "
            + "Point 2 = ("
            + this.p2.getX()
            + ","
            + this.p2.getY()
            + "), "
            + "Point 3 = ("
            + this.p3.getX()
            + ","
            + this.p3.getY()
            + ")"
            + ")");
  }
}
