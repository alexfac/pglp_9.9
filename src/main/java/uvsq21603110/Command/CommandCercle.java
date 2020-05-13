package uvsq21603110.Command;

import uvsq21603110.Forme.Cercle;
import uvsq21603110.Forme.Point;
import uvsq21603110.Forme.groupeForme;

public class CommandCercle extends CommandGroupe {

  private String name;
  private Point hg;
  private double rayon;

  public CommandCercle(groupeForme gf, String name, Point hg, double rayon) {
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
