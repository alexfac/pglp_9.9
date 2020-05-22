package uvsq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import uvsq.command.Command;
import uvsq.command.DrawingTui;

public class DrawingApp {

  public static Connection connexion = null;
  public static Statement statement = null;

  /**
   * Initialise la bd.
   */
  public static void initDaoJdbc() {

    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connexion = DriverManager.getConnection("jdbc:derby:Test;create=true");
      statement = connexion.createStatement();
      /*
            String delete = "DROP TABLE Groupe";
            statement.execute(delete);
            delete = "DROP TABLE intoGroupe";
            statement.execute(delete);
            delete = "DROP TABLE Carre";
            statement.execute(delete);
            delete = "DROP TABLE Cercle";
            statement.execute(delete);
            delete = "DROP TABLE Triangle";
            statement.execute(delete);
            delete = "DROP TABLE Rectangle";
            statement.execute(delete);
      */

      String table = "CREATE TABLE Groupe(nom varchar(30))";
      statement.execute(table);
      table = "CREATE TABLE intoGroupe(nom varchar(50), nomforme varchar(50), forme varchar(30))";
      statement.execute(table);
      table =
          "CREATE TABLE  Carre(nom varchar(50), "
              + "hautgauchex double, hautgauchey double, cote double)";
      statement.execute(table);
      table =
          "CREATE TABLE  Triangle(nom varchar(50), "
              + "ax double, ay double, dx double, dy double, cx double, cy double)";
      statement.execute(table);
      table =
          "CREATE TABLE  Cercle(nom varchar(50), "
              + "centrex double, centrey double, rayon double)";
      statement.execute(table);
      table =
          "CREATE TABLE  Rectangle(nom varchar(50), "
              + "hautgauchex double, hautgauchey double, longueur double, largeur double)";
      statement.execute(table);
      connexion.close();
    } catch (ClassNotFoundException | SQLException e) {
      // e.printStackTrace();
      try {
        connexion.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * Execute le programme.
   */
  public void run() {
    initDaoJdbc();
    System.out.println("Entrez le nom de votre dessin : ");
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    DrawingTui dt = new DrawingTui(name);
    Command command;
    System.out.println("EXEMPLE DE COMMANDE ");
    System.out.println(
        " c=carre((0,0),0) \n"
            + " t=triangle((0,0),(0,0),(0,0))\n "
            + "ce=cercle((0,0),0)\n "
            + "r=rectangle((0,0),10,10)");
    System.out.println(" delete(nomForme)");
    System.out.println(" move(nomForme,(1,1))");
    System.out.println(" moveall(1,1)");
    System.out.println(" save");
    System.out.println(" load(nomDessin)");
    System.out.println(" quit");
    System.out.println("---------------------------------------------------");
    while (true) {
      command = dt.nextCommand();
      try {
        command.execute();
        dt.show();
      } catch (Exception e) {
        // System.out.println("Commande invalide");
      }
    }
  }

  public static void main(String[] args) {
    DrawingApp d = new DrawingApp();
    d.run();
  }
}
