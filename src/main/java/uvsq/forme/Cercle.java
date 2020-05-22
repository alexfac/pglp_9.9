package uvsq.forme;

public class Cercle extends Forme {

  Point centre;
  double rayon;

  public Point getCentre() {
    return centre;
  }

  public Double getRayon() {
    return rayon;
  }

  /**
   * COnstructeur cercle.
   * @param name nom
   * @param centre centre
   * @param rayon rayon
   */
  public Cercle(String name, Point centre, double rayon) {
    super(name);
    this.centre = centre;
    this.rayon = rayon;
  }

  @Override
  public void move(double x, double y) {
    this.centre.addPoint(x, y);
  }

  @Override
  public void show() {
    System.out.println(
        "Cercle(centre = ("
            + this.centre.getX()
            + ","
            + this.centre.getY()
            + ")"
            + ", rayon = "
            + this.rayon
            + ")");
  }
}
