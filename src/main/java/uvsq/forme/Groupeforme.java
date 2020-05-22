package uvsq.forme;

import java.util.ArrayList;

public class Groupeforme extends Forme {
  public ArrayList<Forme> getListforme() {
    return listforme;
  }

  private ArrayList<Forme> listforme;

  public Groupeforme(String name) {
    super(name);
    listforme = new ArrayList<>();
  }

  /**
   * Verifie si le nom existe.
   * @param name nom forme
   * @return vrai si existe faux sinon
   */
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

  /**
   * Ajoute une forme.
   * @param forme forme
   */
  public void addForme(Forme forme) {
    if (!checkname(forme.getName())) {
      this.listforme.add(forme);
    }
  }

  /**
   * Bouge la forme.
   * @param x point x
   * @param y point y
   */
  public void move(double x, double y) {
    for (Forme forme : this.listforme) {
      forme.move(x, y);
    }
  }

  /**
   * Affiche toutes les formes.
   */
  public void show() {
    for (Forme forme : this.listforme) {
      forme.show();
    }
  }
}
