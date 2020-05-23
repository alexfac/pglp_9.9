package uvsq.command;

import java.util.ArrayList;
import uvsq.forme.Forme;
import uvsq.forme.Groupeforme;

public class CommandDeleteForme implements Command {

  private String name;
  private Groupeforme gf;

  public CommandDeleteForme(Groupeforme gf, String name) {
    this.gf = gf;
    this.name = name;
  }

  @Override
  public void execute() {
    ArrayList<Forme> listforme = this.gf.getListforme();
    for (int i = 0; i < listforme.size(); i++) {
      if (listforme.get(i).getName().matches(name)) {
        listforme.remove(i);
      } else if(i == listforme.size()-1) {
        System.out.println("La forme n'existe pas");
      }
    }
  }
}
