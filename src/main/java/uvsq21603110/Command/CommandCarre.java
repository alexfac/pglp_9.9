package uvsq21603110.Command;

import uvsq21603110.Forme.Carre;
import uvsq21603110.Forme.Point;
import uvsq21603110.Forme.groupeForme;

public class CommandCarre extends CommandGroupe {

  private String name;
  private Point hg;
  private double side;

  public CommandCarre(groupeForme gf, String name, Point hg, double side) {
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
