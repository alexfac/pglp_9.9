package uvsq21603110.Command;

import java.util.Scanner;
import uvsq21603110.Forme.*;
import uvsq21603110.Forme.Point;

public class DrawingTui {

  private Scanner scan;
  private groupeForme groupeForme;

  public DrawingTui(String name) {
    this.groupeForme = new groupeForme(name);
    this.scan = new Scanner(System.in);
  }

  public void setGroupeForme(groupeForme groupeForme) {
    this.groupeForme = groupeForme;
  }

  public Command nextCommand() {
    Command command = null;
    String in = this.scan.nextLine();
    try {
      in = in.replace(" ", "");
      if (in.contains("=")) {
        try {
          String[] createforme = in.split("=");
          String name = createforme[0];
          String forme = createforme[1].substring(0, createforme[1].indexOf('('));
          if (name.matches("") || name.matches(" ")) {
            System.out.println("pas de nom pour la forme");
          } else {
            if (forme.matches("carre")) {
              String[] carre = in.split(",");
              double x = Double.parseDouble(carre[0].substring(carre[0].lastIndexOf('(') + 1));
              double y = Double.parseDouble(carre[1].substring(0, carre[1].indexOf(')')));
              double side = Double.parseDouble(carre[1].substring(0, carre[2].length() - 1));
              command = new CommandCarre(this.groupeForme, name, new Point(x, y), side);
            } else if (forme.matches("cercle")) {
              String[] cercle = in.split(",");
              double x = Double.parseDouble(cercle[0].substring(cercle[0].lastIndexOf('(') + 1));
              double y = Double.parseDouble(cercle[1].substring(0, cercle[1].indexOf(')')));
              double rayon = Double.parseDouble(cercle[1].substring(0, cercle[2].length() - 1));
              command = new CommandCercle(this.groupeForme, name, new Point(x, y), rayon);
            } else if (forme.matches("rectangle")) {
              String[] rectangle = in.split(",");
              double x =
                  Double.parseDouble(rectangle[0].substring(rectangle[0].lastIndexOf('(') + 1));
              double y = Double.parseDouble(rectangle[1].substring(0, rectangle[1].indexOf(')')));
              double longueur = Double.parseDouble(rectangle[2]);
              double largeur =
                  Double.parseDouble(rectangle[3].substring(0, rectangle[3].indexOf(')')));
              command =
                  new CommandRectangle(this.groupeForme, name, new Point(x, y), longueur, largeur);
            } else if (forme.matches("triangle")) {
              try {
                String[] triangle = in.split(",");
                double x =
                    Double.parseDouble(triangle[0].substring(triangle[0].lastIndexOf('(') + 1));
                double y = Double.parseDouble(triangle[1].substring(0, triangle[1].indexOf(')')));
                double x1 =
                    Double.parseDouble(triangle[2].substring(triangle[2].lastIndexOf('(') + 1));
                double y1 = Double.parseDouble(triangle[3].substring(0, triangle[3].indexOf(')')));
                double x2 =
                    Double.parseDouble(triangle[4].substring(triangle[4].lastIndexOf('(') + 1));
                double y2 = Double.parseDouble(triangle[5].substring(0, triangle[5].indexOf(')')));
                command =
                    new CommandTriangle(
                        this.groupeForme,
                        name,
                        new Point(x, y),
                        new Point(x1, y1),
                        new Point(x2, y2));
              } catch (Exception e) {
                System.out.println(
                    "Commande invalide, verifier qu'il n'y ait pas d'espaces "
                        + "ou de parametres manquants");
              }
            }
          }
        } catch (Exception e) {
          System.out.println(
              "Commande invalide, verifier qu'il n'y ait pas d'espaces ou de parametres manquants");
        }
      } else if (in.contains("move")) {
        if (in.contains("all")) {
          try {
            double x =
                Double.parseDouble(in.substring(in.lastIndexOf("(") + 1, in.lastIndexOf(',')));
            double y =
                Double.parseDouble(in.substring(in.lastIndexOf(",") + 1, in.lastIndexOf(')')));
            command = new CommandMove(this.groupeForme, x, y);
          } catch (Exception e) {
            System.out.println("Commande invalide");
          }
        } else {
          try {
            String nForme = in.substring(in.indexOf("(") + 1, in.lastIndexOf(",("));
            double x =
                Double.parseDouble(in.substring(in.lastIndexOf("(") + 1, in.lastIndexOf(',')));
            double y =
                Double.parseDouble(in.substring(in.lastIndexOf(",") + 1, in.lastIndexOf("))")));
            for (Forme forme : this.groupeForme.getListforme()) {
              if (forme.getName().contains(nForme)) {
                command = new CommandMove(forme, x, y);
              }
            }
          } catch (Exception e) {
            System.out.println("Commande invalide");
          }
        } // c=carre((0,0),0) t=triangle((0,0),(0,0),(0,0)) ce=cercle((0,0),0)
        // r=rectangle((0,0),10,10)
      } else if (in.contains("delete")) {
        String nameForme = in.substring(in.lastIndexOf("(") + 1, in.lastIndexOf(")"));
        command = new CommandDeleteForme(this.groupeForme, nameForme);
      } else if (in.contains("quit")) {
        command = new Commandquit();
      } else if (in.contains("save")) {
        command = new CommandSave(this.groupeForme);
      } else if (in.contains("load")) {
        String name = in.substring(in.indexOf("(") + 1, in.lastIndexOf(")"));
        command = new CommandLoad(name, this);
      } else {
        System.out.println("Verifiez votre commande");
      }
    } catch (NumberFormatException e) {
      System.out.println("Verifiez votre commande");
    }
    return command;
  }

  public void show() {
    System.out.println("Nom du Dessin : " + this.groupeForme.getName());
    for (Forme forme : this.groupeForme.getListforme()) {
      forme.show();
    }
  }
}
