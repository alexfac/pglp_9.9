package uvsq.command;

import uvsq.forme.Cercle;
import uvsq.forme.Groupeforme;
import uvsq.forme.Point;

public class CommandCercle extends CommandGroupe {

  private String name;
  private Point hg;
  private double rayon;

  /**
   * Constructeur commande cercle.
   * @param gf groupeforme
   * @param name nom cercle
   * @param hg point haut gauche
   * @param rayon rayon du cercle
   */
  public CommandCercle(Groupeforme gf, String name, Point hg, double rayon) {
    super(gf);
    this.name = name;
    this.hg = hg;
    this.rayon = rayon;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Cercle(name, hg, rayon));
  }
}
