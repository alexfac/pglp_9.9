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
    PreparedStatement insertGroupe = null;
    PreparedStatement insertIntoGroupe = null;
    try {
      insertGroupe =
          this.connect.prepareStatement("INSERT INTO Groupe(nom) VALUES (?)");
      insertIntoGroupe =
          this.connect.prepareStatement(
              "INSERT INTO intoGroupe(nom, nomforme, forme) VALUES (?,?,?)");
      insertGroupe.setString(1, obj.getName());
      insertGroupe.executeUpdate();
      ArrayList<Forme> listforme = obj.getListforme();

      for (Forme forme : listforme) {
        if (forme instanceof Carre) {
          DaoJdbc dao = new DaoCarre();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "carre");
          insertIntoGroupe.executeUpdate();
        } else if (forme instanceof Cercle) {
          DaoJdbc dao = new DaoCercle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "cercle");
          insertIntoGroupe.executeUpdate();
        } else if (forme instanceof Rectangle) {
          DaoJdbc dao = new DaoRectangle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "rectangle");
          insertIntoGroupe.executeUpdate();
        } else if (forme instanceof Triangle) {
          DaoJdbc dao = new DaoTriangle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "triangle");
          insertIntoGroupe.executeUpdate();
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (insertGroupe != null) {
          try {
            insertGroupe.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (insertIntoGroupe != null) {
          try {
            insertIntoGroupe.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println("Sauvegarde effectue");
    this.close();
    return obj;
  }

  @Override
  public Groupeforme find(String name) {
    this.open();
    Groupeforme gf = null;
    PreparedStatement selectGroupe = null;
    PreparedStatement selectIntoGroupe = null;
    try {
      selectGroupe = this.connect.prepareStatement("SELECT * FROM Groupe WHERE nom = ?");
      selectIntoGroupe = this.connect.prepareStatement("SELECT * FROM intoGroupe WHERE nom = ? ");
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
      res.close();
      res1.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (selectGroupe != null) {
          try {
            selectGroupe.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (selectIntoGroupe != null) {
          try {
            selectIntoGroupe.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
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
    PreparedStatement deleteGroupe = null;
    try {
      deleteGroupe =
          this.connect.prepareStatement("DELETE FROM Groupe WHERE nom = ?");
      deleteGroupe.setString(1, name);
      deleteGroupe.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (deleteGroupe != null) {
          try {
            deleteGroupe.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    this.close();
  }
}
