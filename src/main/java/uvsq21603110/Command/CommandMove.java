package uvsq21603110.Command;

import uvsq21603110.Forme.Forme;

public class CommandMove implements Command {

  private double x;
  private double y;
  private Forme forme;

  public CommandMove(Forme forme, double x, double y) {
    this.forme = forme;
    this.x = x;
    this.y = y;
  }

  @Override
  public void execute() {
    this.forme.move(x, y);
  }
}
