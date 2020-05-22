package uvsq.forme;

public class Rectangle extends Forme {

  Point hg;
  double length;
  double width;

  public Point getP() {
    return hg;
  }

  public double getWidth() {
    return width;
  }

  public double getLength() {
    return length;
  }

  /**
   * Constructeur rectangle.
   * @param name nome
   * @param hg point haut gauche
   * @param length longueur
   * @param width largeur
   */
  public Rectangle(String name, Point hg, double length, double width) {
    super(name);
    this.hg = hg;
    this.length = length;
    this.width = width;
  }

  @Override
  public void move(double x, double y) {
    this.hg.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Rectangle(Point haut gauche = ("
            + this.hg.getX()
            + ","
            + this.hg.getY()
            + ")"
            + ", longueur = "
            + this.length
            + ", largeur = "
            + this.width
            + ")");
  }
}
