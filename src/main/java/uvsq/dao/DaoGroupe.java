package uvsq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uvsq.forme.Carre;
import uvsq.forme.Cercle;
import uvsq.forme.Forme;
import uvsq.forme.Groupeforme;
import uvsq.forme.Rectangle;
import uvsq.forme.Triangle;

public class DaoGroupe extends DaoJdbc<Groupeforme> {
  @Override
  public Groupeforme create(Groupeforme obj) {
    this.open();
    try {
      PreparedStatement insertGroupe =
          this.connect.prepareStatement("INSERT INTO Groupe(nom) VALUES (?)");
      PreparedStatement insertIntoGroupe =
          this.connect.prepareStatement(
              "INSERT INTO intoGroupe(nom, nomforme, forme) VALUES (?,?,?)");
      insertGroupe.setString(1, obj.getName());
      insertGroupe.execute();

      ArrayList<Forme> listforme = obj.getListforme();
      for (Forme forme : listforme) {
        if (forme instanceof Carre) {
          DaoJdbc dao = new DaoCarre();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "carre");
          insertIntoGroupe.execute();
        } else if (forme instanceof Cercle) {
          DaoJdbc dao = new DaoCercle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "cercle");
          insertIntoGroupe.execute();
        } else if (forme instanceof Rectangle) {
          DaoJdbc dao = new DaoRectangle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "rectangle");
          insertIntoGroupe.execute();
        } else if (forme instanceof Triangle) {
          DaoJdbc dao = new DaoTriangle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "triangle");
          insertIntoGroupe.execute();
        }
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    System.out.println("Sauvegarde effectue");
    this.close();
    return obj;
  }

  @Override
  public Groupeforme find(String name) {
    this.open();
    Groupeforme gf = null;
    try {
      PreparedStatement selectGroupe =
          this.connect.prepareStatement("SELECT * FROM Groupe WHERE nom = ?");
      PreparedStatement selectIntoGroupe =
          this.connect.prepareStatement("SELECT * FROM intoGroupe WHERE nom = ? ");
      selectGroupe.setString(1, name);
      selectIntoGroupe.setString(1, name);
      ResultSet res = selectGroupe.executeQuery();
      ResultSet res1 = selectIntoGroupe.executeQuery();
      if (res.next()) {
        gf = new Groupeforme(name);
        while (res1.next()) {
          if (res1.getString("forme").contains("carre")) {
            DaoJdbc dao = new DaoCarre();
            gf.addForme((Carre) dao.find(res1.getString("nomforme")));
          } else if (res1.getString("forme").contains("cercle")) {
            DaoJdbc dao = new DaoCercle();
            gf.addForme((Cercle) dao.find(res1.getString("nomforme")));
          } else if (res1.getString("forme").contains("rectangle")) {
            DaoJdbc dao = new DaoRectangle();
            gf.addForme((Rectangle) dao.find(res1.getString("nomforme")));
          } else if (res1.getString("forme").contains("triangle")) {
            DaoJdbc dao = new DaoTriangle();
            gf.addForme((Triangle) dao.find(res1.getString("nomforme")));
          }
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return gf;
  }

  @Override
  public Groupeforme update(Groupeforme obj) {
    return null;
  }

  @Override
  public void delete(String name) {
    this.open();
    try {
      PreparedStatement deleteGroupe =
          this.connect.prepareStatement("DELETE FROM Groupe WHERE nom = ?");
      deleteGroupe.setString(1, name);
      deleteGroupe.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.close();
  }
}
