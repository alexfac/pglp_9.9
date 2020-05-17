package uvsq21603110.Command;

import uvsq21603110.Forme.groupeForme;

public abstract class CommandGroupe implements Command {

  protected groupeForme gf;

  public CommandGroupe(groupeForme gf) {
    this.gf = gf;
  }
}
