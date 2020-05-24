package uvsq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uvsq.forme.Cercle;
import uvsq.forme.Point;

public class DaoCercle extends DaoJdbc<Cercle> {
  @Override
  public Cercle create(Cercle obj) {
    this.open();
    PreparedStatement insertCercle = null;
    try {
      insertCercle =
          this.connect.prepareStatement(
              "INSERT INTO Cercle(nom, centrex, centrey, rayon) VALUES(?,?,?,?)");
      insertCercle.setString(1, obj.getName());
      insertCercle.setObject(2, obj.getCentre().getX());
      insertCercle.setObject(3, obj.getCentre().getY());
      insertCercle.setDouble(4, obj.getRayon());
      insertCercle.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (insertCercle != null) {
          try {
            insertCercle.close();
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    this.close();
    return null;
  }

  @Override
  public Cercle find(String name) {
    this.open();
    Cercle c = null;
    PreparedStatement selectCercle = null;
    try {
      selectCercle = this.connect.prepareStatement("SELECT * FROM Cercle WHERE nom = ?");
      selectCercle.setString(1, name);
      selectCercle.execute();
      ResultSet res = selectCercle.executeQuery();
      if (res.next()) {
        c =
            new Cercle(
                name,
                new Point(res.getDouble("centrex"), res.getDouble("centrey")),
                res.getDouble("rayon"));
      }
      res.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (selectCercle != null) {
          try {
            selectCercle.close();
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
  public Cercle update(Cercle obj) {
    return null;
  }

  @Override
  public void delete(String name) {
    this.open();
    PreparedStatement deleteCercle = null;
    try {
      deleteCercle =
          this.connect.prepareStatement("DELETE FROM Cercle WHERE nom = ?");
      deleteCercle.setString(1, name);
      deleteCercle.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (deleteCercle != null) {
          try {
            deleteCercle.close();
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
