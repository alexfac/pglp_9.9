package uvsq.command;

import uvsq.dao.DaoFactory;

public class CommandLoad implements Command {

  private String name;
  private DrawingTui dt;

  public CommandLoad(String name, DrawingTui dt) {
    this.name = name;
    this.dt = dt;
  }

  @Override
  public void execute() {
    try {
      this.dt.setGroupeForme(DaoFactory.getDaoGroupe().find(this.name));
    } catch (Exception e) {
      System.out.println("le dessin n'existe pas");
    }
  }
}
