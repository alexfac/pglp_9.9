package uvsq21603110.Forme;

public class Carre extends Forme {

  Point HG;
  double side;

  public Carre(String name, Point HG, double side) {
    super(name);
    this.HG = HG;
    this.side = side;
  }

  @Override
  public void move(double x, double y) {
    this.HG.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Carre(Point haut gauche = ("
            + this.HG.getX()
            + ","
            + this.HG.getY()
            + ")"
            + ", côté = "
            + this.side
            + ")");
  }
}
