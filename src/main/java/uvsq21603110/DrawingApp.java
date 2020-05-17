package uvsq21603110;

import uvsq21603110.Command.Command;
import uvsq21603110.Command.DrawingTui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DrawingApp {

    public static Connection connexion = null;
    public static Statement statement = null;
    public static void initDAOJdbc() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connexion = DriverManager.getConnection("jdbc:derby:test;create=false");
            statement = connexion.createStatement();

            String Table = "CREATE TABLE Groupe(nom varchar(30))";
            statement.execute(Table);
            Table = "CREATE TABLE intoGroupe(nom varchar(50), nomforme varchar(50), forme varchar(30))";
            statement.execute(Table);
            Table = "CREATE TABLE  Carre(nom varchar(50), hautgauchex double(7,2), hautgauchey double(7,2), cote double(7,2)))";
            statement.execute(Table);
            Table = "CREATE TABLE  Triangle(nom varchar(50), 1x double(7,2), 1y double(7,2), 2x double(7,2), 2y double(7,2), 3x double(7,2), 3y double(7,2))";
            statement.execute(Table);
            Table = "CREATE TABLE  Cercle(nom varchar(50), centrex double(7,2), centrey double(7,2), rayon double(7,2))";
            statement.execute(Table);
            Table = "CREATE TABLE  Rectangle(nom varchar(50), hautgauchex double(7,2), hautgauchey double(7,2), longueur double(7,2), largeur double(7,2))";
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
    
    public void run() {
        System.out.println("Entrez le nom de votre dessin : ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        DrawingTui dt = new DrawingTui(name);
        Command command;
        System.out.println("EXEMPLE DE COMMANDE ");
        System.out.println(" c=carre((0,0),0) \n" +
                " t=triangle((0,0),(0,0),(0,0))\n " +
                "ce=cercle((0,0),0)\n " +
                "r=rectangle((0,0),10,10)");
        System.out.println(" delete(nomForme)");
        System.out.println(" move(nomForme,(1,1))");
        System.out.println(" moveall(1,1)");
        System.out.println(" quit");
        System.out.println("---------------------------------------------------");
        while (true){
            command = dt.nextCommand();
            try{
                command.execute();
                dt.show();
            } catch (Exception e){
                //System.out.println("Commande invalide");
            }
        }
    }
}
