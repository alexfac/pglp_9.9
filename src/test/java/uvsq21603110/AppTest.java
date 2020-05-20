package uvsq21603110;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import uvsq21603110.DAO.DAOGroupe;
import uvsq21603110.DAO.DAOJdbc;
import uvsq21603110.Forme.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** Unit test for simple App. */
public class AppTest {

  public static Connection connexion = null;
  public static Statement statement = null;

  @BeforeClass
  public static void initDAOJdbc() {

    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connexion = DriverManager.getConnection("jdbc:derby:Test;create=true");
      statement = connexion.createStatement();

      String Table = "CREATE TABLE Groupe(nom varchar(30))";
      statement.execute(Table);
      Table = "CREATE TABLE intoGroupe(nom varchar(50), nomforme varchar(50), forme varchar(30))";
      statement.execute(Table);
      Table =
              "CREATE TABLE  Carre(nom varchar(50), hautgauchex double, hautgauchey double, cote double)";
      statement.execute(Table);
      Table =
              "CREATE TABLE  Triangle(nom varchar(50), ax double, ay double, dx double, dy double, cx double, cy double)";
      statement.execute(Table);
      Table =
              "CREATE TABLE  Cercle(nom varchar(50), centrex double, centrey double, rayon double)";
      statement.execute(Table);
      Table =
              "CREATE TABLE  Rectangle(nom varchar(50), hautgauchex double, hautgauchey double, longueur double, largeur double)";
      statement.execute(Table);
      connexion.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      try {
        connexion.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
  @Test

  public void testFindGroupeDAoJdbcGroupe(){

    DAOJdbc daogroupe = new DAOGroupe();
    Carre c = new Carre("c",new Point(1,1),1);
    Carre c1 = new Carre("c1",new Point(1,1),1);
    Cercle d = new Cercle("c",new Point(1,1),1);
    Rectangle r= new Rectangle("r", new Point(10,10), 10, 5);
    Triangle t = new Triangle("t", new Point(10,10), new Point(5,5), new Point(3,2));
    groupeForme g = new groupeForme("1");
    g.addForme(c);
    g.addForme(c1);
    g.addForme(d);
    g.addForme(r);
    g.addForme(t);
    daogroupe.create(g);
    groupeForme g1 = (groupeForme) daogroupe.find("1");
    assertEquals(g1.getListforme().size() , g.getListforme().size());
    for (int i = 0; i < g.getListforme().size(); i++)
      g.getListforme().get(i).show();
  }
}
