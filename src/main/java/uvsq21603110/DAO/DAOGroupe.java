package uvsq21603110.DAO;

import uvsq21603110.Forme.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOGroupe extends DAOJdbc<groupeForme> {
  @Override
  public groupeForme create(groupeForme obj) {
    this.open();
    try{
      PreparedStatement insertGroupe = this.connect.prepareStatement("INSERT INTO Groupe(nom) VALUES (?)");
      PreparedStatement insertIntoGroupe = this.connect.prepareStatement("INSERT INTO intoGroupe(nom, nomforme, forme) VALUES (?,?,?)");
      insertGroupe.setString(1,obj.getName());
      insertGroupe.execute();

      ArrayList<Forme> listforme = obj.getListforme();
      for (Forme forme : listforme){
        if (forme instanceof Carre){
          DAOJdbc dao = new DAOCarre();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "carre");
          insertIntoGroupe.execute();
        } else if (forme instanceof Cercle) {
          DAOJdbc dao = new DAOCercle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "cercle");
          insertIntoGroupe.execute();
        } else if (forme instanceof Rectangle) {
          DAOJdbc dao = new DAOCercle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3, "rectangle");
          insertIntoGroupe.execute();
        } else if (forme instanceof Triangle) {
          DAOJdbc dao = new DAOCercle();
          dao.create(forme);
          insertIntoGroupe.setString(1, obj.getName());
          insertIntoGroupe.setString(2, forme.getName());
          insertIntoGroupe.setString(3,"triangle");
          insertIntoGroupe.execute();
        }
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.close();
    return obj;
  }

  @Override
  public groupeForme find(String name) {
    this.open();
    groupeForme gf = null;
    try{
      PreparedStatement selectGroupe = this.connect.prepareStatement("SELECT * FROM Groupe WHERE nom = ?");
      PreparedStatement selectIntoGroupe = this.connect.prepareStatement("INSERT INTO intoGroupe(nom, nomforme, forme) VALUES (?,?,?)");
      selectGroupe.setString(1, name);
      selectIntoGroupe.setString(1,name);
      ResultSet res = selectGroupe.executeQuery();
      ResultSet res1 = selectIntoGroupe.executeQuery();
      if (res.next()) {
        gf = new groupeForme(name);
        while(res1.next()){
          if (res1.getString("forme") == "carre") {
            DAOJdbc dao = new DAOCarre();
            gf.addForme((Carre) dao.find(res1.getString("nom")));
          } else if (res1.getString("forme") == "cercle") {
            DAOJdbc dao = new DAOCercle();
            gf.addForme((Cercle) dao.find(res1.getString("nom")));
          } else if (res1.getString("forme") == "rectangle") {
            DAOJdbc dao = new DAORectangle();
            gf.addForme((Rectangle) dao.find(res1.getString("nom")));
          } else if (res1.getString("forme") == "triangle") {
            DAOJdbc dao = new DAOCarre();
            gf.addForme((Triangle) dao.find(res1.getString("nom")));
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
  public groupeForme update(groupeForme obj) {
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
