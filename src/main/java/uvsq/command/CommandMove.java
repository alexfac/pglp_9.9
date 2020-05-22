package uvsq.command;

import uvsq.forme.Forme;

public class CommandMove implements Command {

  private double px;
  private double py;
  private Forme forme;

  /**
   * Constructeur commande move.
   * @param forme forme a deplacer
   * @param x point x
   * @param y point y
   */
  public CommandMove(Forme forme, double x, double y) {
    this.forme = forme;
    this.px = x;
    this.py = y;
  }

  @Override
  public void execute() {
    this.forme.move(px, py);
  }
}
