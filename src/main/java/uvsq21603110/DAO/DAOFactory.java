package uvsq21603110.DAO;

import uvsq21603110.Forme.*;

public class DAOFactory {

  public static DAOJdbc<Carre> getDAOCarre() {
    return new DAOCarre();
  }

  public static DAOJdbc<Cercle> getDAOCercle() {
    return new DAOCercle();
  }

  public static DAOJdbc<groupeForme> getDAOGroupe() {
    return new DAOGroupe();
  }

  public static DAOJdbc<Rectangle> getDAORectangle() {
    return new DAORectangle();
  }

  public static DAOJdbc<Triangle> getDAOTriangle() {
    return new DAOTriangle();
  }
}
