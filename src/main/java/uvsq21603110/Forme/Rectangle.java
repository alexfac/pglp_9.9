package uvsq21603110.Forme;

public class Rectangle extends Forme {

  String name;
  Point P;
  double length;
  double width;

  public Rectangle(String name, Point HG, double length, double width) {
    this.name = name;
    this.P = HG;
    this.length = length;
    this.width = width;
  }

  @Override
  public void move(double x, double y) {
    this.P.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Rectangle(Point haut gauche = ("
            + this.P.getX()
            + ","
            + this.P.getY()
            + ")"
            + ", longueur = "
            + this.length
            + ", largeur = "
            + this.width
            + ")");
  }
}
