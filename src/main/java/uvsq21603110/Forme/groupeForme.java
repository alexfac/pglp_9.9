package uvsq21603110.Forme;

import java.util.ArrayList;

public class groupeForme extends Forme {
  public ArrayList<Forme> getListforme() {
    return listforme;
  }

  private ArrayList<Forme> listforme;

  public groupeForme(String name) {
    super(name);
    listforme = new ArrayList<>();
  }

  public boolean checkname(String name) {
    for (Forme f : this.listforme) {
      if (name.matches(f.getName())) {
        System.out.println(" Ce nom est deja utilise");
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  public void addForme(Forme forme) {
    if (!checkname(forme.getName())) this.listforme.add(forme);
  }

  public void move(double x, double y) {
    for (Forme forme : this.listforme) {
      forme.move(x, y);
    }
  }

  public void show() {
    for (Forme forme : this.listforme) {
      forme.show();
    }
  }
}
