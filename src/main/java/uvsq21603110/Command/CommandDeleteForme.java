package uvsq21603110.Command;

import uvsq21603110.Forme.Forme;
import uvsq21603110.Forme.groupeForme;

import java.util.ArrayList;

public class CommandDeleteForme implements Command {

  private String name;
  private groupeForme gf;

  public CommandDeleteForme(groupeForme gf, String name) {
    this.gf = gf;
    this.name = name;
  }

  @Override
  public void execute() {
    ArrayList<Forme> listforme = this.gf.getListforme();
    for (int i = 0; i < listforme.size(); i++) {
      if (listforme.get(i).getName().matches(name)) listforme.remove(i);
      else System.out.println("La forme n'existe pas");
    }
  }
}
