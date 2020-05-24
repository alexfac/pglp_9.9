package uvsq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uvsq.forme.Point;
import uvsq.forme.Triangle;

public class DaoTriangle extends DaoJdbc<Triangle> {
  @Override
  public Triangle create(Triangle obj) {
    this.open();
    try {
      PreparedStatement insertTriangle =
          this.connect.prepareStatement(
              "INSERT INTO Triangle(nom, ax, ay, dx, dy, cx, cy) VALUES(?,?,?,?,?,?,?)");
      insertTriangle.setString(1, obj.getName());
      insertTriangle.setObject(2, obj.getP1().getX());
      insertTriangle.setObject(3, obj.getP1().getY());
      insertTriangle.setObject(4, obj.getP2().getX());
      insertTriangle.setObject(5, obj.getP2().getY());
      insertTriangle.setObject(6, obj.getP3().getX());
      insertTriangle.setObject(7, obj.getP3().getY());

      insertTriangle.executeUpdate();
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
      PreparedStatement selectTriangle =
          this.connect.prepareStatement("SELECT * FROM Triangle WHERE nom = ?");
      selectTriangle.setString(1, name);
      selectTriangle.execute();
      ResultSet res = selectTriangle.executeQuery();
      if (res.next()) {
        t =
            new Triangle(
                name,
                new Point(res.getDouble("ax"), res.getDouble("ay")),
                new Point(res.getDouble("dx"), res.getDouble("dy")),
                new Point(res.getDouble("cx"), res.getDouble("cy")));
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
