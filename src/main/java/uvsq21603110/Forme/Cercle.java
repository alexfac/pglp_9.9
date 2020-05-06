package uvsq21603110.Forme;

public class Cercle extends Forme {

  String name;
  Point centre;
  double rayon;

  public Cercle(String name, Point centre, double rayon) {
    this.name = name;
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
