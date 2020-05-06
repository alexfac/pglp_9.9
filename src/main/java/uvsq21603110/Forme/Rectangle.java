package uvsq21603110.Forme;

import uvsq21603110.Forme.Forme;
import uvsq21603110.Forme.Point;

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
    this.P.x += x;
    this.P.y += y;
  }

  @Override
  public void show() {
    System.out.println(
        "Rectangle(Point haut gauche = ("
            + this.P.getX()
            + ","
            + this.P.getY()
            + ")"
            + ", longeur = "
            + this.length
            + ", largeur = "
            + this.width
            + ")");
  }
}
