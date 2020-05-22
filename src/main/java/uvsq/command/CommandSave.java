package uvsq.command;

import uvsq.dao.DaoFactory;
import uvsq.forme.Groupeforme;

public class CommandSave implements Command {

  private Groupeforme gf;

  public CommandSave(Groupeforme gf) {
    this.gf = gf;
  }

  @Override
  public void execute() {
    DaoFactory.getDaoGroupe().create(this.gf);
  }
}
