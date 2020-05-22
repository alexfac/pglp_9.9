package uvsq.command;

import uvsq.forme.Groupeforme;
import uvsq.forme.Point;
import uvsq.forme.Triangle;

public class CommandTriangle extends CommandGroupe {

  private String name;
  private Point point;
  private Point point1;
  private Point point2;

  /**
   * Constructeur commande triangle.
   * @param groupeForme groupeforme
   * @param name nom
   * @param point point en haut
   * @param point1 point a gauche
   * @param point2 point a droite
   */
  public CommandTriangle(
          Groupeforme groupeForme, String name, Point point, Point point1, Point point2) {
    super(groupeForme);
    this.name = name;
    this.point = point;
    this.point1 = point1;
    this.point2 = point2;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Triangle(name, point, point1, point2));
  }
}
