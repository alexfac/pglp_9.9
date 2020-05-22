package uvsq.forme;

public class Carre extends Forme {

  public Point getHG() {
    return hg;
  }

  public double getSide() {
    return side;
  }

  Point hg;
  double side;

  /**
   * COnstructeur carre.
   * @param name nom
   * @param hg point haut gauche
   * @param side cote du carre
   */
  public Carre(String name, Point hg, double side) {
    super(name);
    this.hg = hg;
    this.side = side;
  }

  @Override
  public void move(double x, double y) {
    this.hg.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Carre(Point haut gauche = ("
            + this.hg.getX()
            + ","
            + this.hg.getY()
            + ")"
            + ", côté = "
            + this.side
            + ")");
  }
}
