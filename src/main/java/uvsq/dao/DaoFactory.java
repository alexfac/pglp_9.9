package uvsq.dao;

import uvsq.forme.Carre;
import uvsq.forme.Cercle;
import uvsq.forme.Groupeforme;
import uvsq.forme.Rectangle;
import uvsq.forme.Triangle;

public class DaoFactory {

  public static DaoJdbc<Carre> getDaoCarre() {
    return new DaoCarre();
  }

  public static DaoJdbc<Cercle> getDaoCercle() {
    return new DaoCercle();
  }

  public static DaoJdbc<Groupeforme> getDaoGroupe() {
    return new DaoGroupe();
  }

  public static DaoJdbc<Rectangle> getDaoRectangle() {
    return new DaoRectangle();
  }

  public static DaoJdbc<Triangle> getDaoTriangle() {
    return new DaoTriangle();
  }
}
