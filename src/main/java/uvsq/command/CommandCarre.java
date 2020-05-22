package uvsq.command;

import uvsq.forme.Carre;
import uvsq.forme.Groupeforme;
import uvsq.forme.Point;

public class CommandCarre extends CommandGroupe {

  private String name;
  private Point hg;
  private double side;

  /**
   * Constructeur commande carre.
   * @param gf groupeforme
   * @param name nom carre
   * @param hg point haut gauche
   * @param side cote carre
   */
  public CommandCarre(Groupeforme gf, String name, Point hg, double side) {
    super(gf);
    this.name = name;
    this.hg = hg;
    this.side = side;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Carre(name, hg, side));
  }
}
