package uvsq21603110.Command;

import uvsq21603110.Forme.Point;
import uvsq21603110.Forme.Rectangle;
import uvsq21603110.Forme.groupeForme;

public class CommandRectangle extends CommandGroupe {

  private String name;
  private Point point;
  private double longueur;
  private double largeur;

  public CommandRectangle(groupeForme groupeForme, String name, Point point, double longueur, double largeur) {
    super(groupeForme);
    this.name = name;
    this.point = point;
    this.longueur = longueur;
    this.largeur = largeur;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Rectangle(name,point,longueur,largeur));
  }
}
