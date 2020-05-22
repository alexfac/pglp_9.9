package uvsq.command;

import uvsq.forme.Groupeforme;
import uvsq.forme.Point;
import uvsq.forme.Rectangle;

public class CommandRectangle extends CommandGroupe {

  private String name;
  private Point point;
  private double longueur;
  private double largeur;

  /**
   * Constructeur commande rectangle.
   * @param groupeForme groupeforme
   * @param name nom
   * @param point point haut gauche
   * @param longueur longueur
   * @param largeur largeur
   */
  public CommandRectangle(
          Groupeforme groupeForme, String name, Point point, double longueur, double largeur) {
    super(groupeForme);
    this.name = name;
    this.point = point;
    this.longueur = longueur;
    this.largeur = largeur;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Rectangle(name, point, longueur, largeur));
  }
}
