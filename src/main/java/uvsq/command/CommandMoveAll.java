package uvsq.command;

import uvsq.forme.Groupeforme;

public class CommandMoveAll implements Command {

  private Groupeforme gf;
  private double px;
  private double py;

  /**
   * Constructeur commande move.
   * @param gf groupe forme
   * @param x point x
   * @param y point y
   */
  public CommandMoveAll(Groupeforme gf, double x, double y) {
    this.gf = gf;
    this.px = x;
    this.py = y;
  }

  @Override
  public void execute() {
    this.gf.move(px, py);
  }
}
