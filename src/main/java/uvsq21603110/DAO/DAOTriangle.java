package uvsq21603110.DAO;

import uvsq21603110.Forme.Point;
import uvsq21603110.Forme.Triangle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOTriangle extends DAOJdbc<Triangle> {
  @Override
  public Triangle create(Triangle obj) {
    this.open();
    try {
      PreparedStatement insertTriangle =
          this.connect.prepareStatement(
              "INSERT INTO Carre(nom, 1x, 1y, 2x, 2y, 3x, 3y) VALUES(?,?,?,?,?,?,?)");
      insertTriangle.setString(1, obj.getName());
      insertTriangle.setObject(2, obj.getP1().getX());
      insertTriangle.setObject(3, obj.getP1().getY());
      insertTriangle.setObject(4, obj.getP2().getX());
      insertTriangle.setObject(5, obj.getP2().getY());
      insertTriangle.setObject(6, obj.getP3().getX());
      insertTriangle.setObject(7, obj.getP3().getY());

      insertTriangle.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return null;
  }

  @Override
  public Triangle find(String name) {
    this.open();
    Triangle t = null;
    try {
      PreparedStatement selectCarre =
          this.connect.prepareStatement("SELECT * FROM Carre WHERE nom = ?");
      selectCarre.setString(1, name);
      selectCarre.execute();
      ResultSet Res = selectCarre.executeQuery();
      if (Res.next()) {
        t =
            new Triangle(
                name,
                new Point(Res.getDouble("1x"), Res.getDouble("1y")),
                new Point(Res.getDouble("2x"), Res.getDouble("2y")),
                new Point(Res.getDouble("3x"), Res.getDouble("3y")));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return t;
  }

  @Override
  public Triangle update(Triangle obj) {
    return null;
  }

  @Override
  public void delete(String name) {
    this.open();
    try {
      PreparedStatement deleteTriangle =
          this.connect.prepareStatement("DELETE FROM Triangle WHERE nom = ?");
      deleteTriangle.setString(1, name);
      deleteTriangle.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.close();
  }
}