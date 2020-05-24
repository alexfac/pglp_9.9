package uvsq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uvsq.forme.Carre;
import uvsq.forme.Point;

public class DaoCarre extends DaoJdbc<Carre> {
  @Override
  public Carre create(Carre obj) {
    this.open();
    PreparedStatement insertCarre = null;
    try {
      insertCarre =
          this.connect.prepareStatement(
              "INSERT INTO Carre(nom, hautgauchex, hautgauchey, cote) VALUES(?,?,?,?)");
      insertCarre.setString(1, obj.getName());
      insertCarre.setObject(2, obj.getHG().getX());
      insertCarre.setObject(3, obj.getHG().getY());
      insertCarre.setDouble(4, obj.getSide());
      insertCarre.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (insertCarre != null) {
          try {
            insertCarre.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    this.close();
    return obj;
  }

  @Override
  public Carre find(String name) {
    this.open();
    Carre c = null;
    PreparedStatement selectCarre = null;
    try {
      selectCarre =
          this.connect.prepareStatement("SELECT * FROM Carre WHERE nom = ?");
      selectCarre.setString(1, name);
      selectCarre.execute();
      ResultSet res = selectCarre.executeQuery();
      if (res.next()) {
        c =
            new Carre(
                name,
                new Point(res.getDouble("hautgauchex"), res.getDouble("hautgauchey")),
                res.getDouble("cote"));
      }
      res.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (selectCarre != null) {
          try {
            selectCarre.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
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
    PreparedStatement deleteCarre = null;
    try {
      deleteCarre = this.connect.prepareStatement("DELETE FROM Carre WHERE nom = ?");
      deleteCarre.setString(1, name);
      deleteCarre.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (deleteCarre != null) {
          try {
            deleteCarre.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      this.close();
    }
  }
}
