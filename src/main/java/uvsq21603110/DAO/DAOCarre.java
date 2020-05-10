package uvsq21603110.DAO;

import uvsq21603110.Forme.Carre;
import uvsq21603110.Forme.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCarre extends DAOJdbc<Carre> {
  @Override
  public Carre create(Carre obj) {
    this.open();
    try {
      PreparedStatement insertCarre =
          this.connect.prepareStatement(
              "INSERT INTO Carre(nom, hautgauchex, hautgauchey, cote) VALUES(?,?,?,?)");
      insertCarre.setString(1, obj.getName());
      insertCarre.setObject(2, obj.getHG().getX());
      insertCarre.setObject(3, obj.getHG().getY());
      insertCarre.setDouble(4, obj.getSide());
      insertCarre.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return null;
  }

  @Override
  public Carre find(String name) {
    this.open();
    Carre c = null;
    try {
      PreparedStatement selectCarre =
          this.connect.prepareStatement("SELECT * FROM Carre WHERE nom = ?");
      selectCarre.setString(1, name);
      selectCarre.execute();
      ResultSet Res = selectCarre.executeQuery();
      if (Res.next()) {
        c =
            new Carre(
                name,
                new Point(Res.getDouble("hautgauchex"), Res.getDouble("hautgauchey")),
                Res.getDouble("cote"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return c;
  }

  @Override
  public Carre update(Carre obj) {
    return null;
  }

  @Override
  public void delete(String name) {
    this.open();
    try {
      PreparedStatement deleteCarre =
          this.connect.prepareStatement("DELETE FROM Carre WHERE nom = ?");
      deleteCarre.setString(1, name);
      deleteCarre.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.close();
  }
}
