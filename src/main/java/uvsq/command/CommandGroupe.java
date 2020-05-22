package uvsq.command;

import uvsq.forme.Groupeforme;

public abstract class CommandGroupe implements Command {

  protected Groupeforme gf;

  public CommandGroupe(Groupeforme gf) {
    this.gf = gf;
  }
}
