package uvsq.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uvsq.forme.Point;
import uvsq.forme.Rectangle;

public class DaoRectangle extends DaoJdbc<Rectangle> {
  @Override
  public Rectangle create(Rectangle obj) {
    this.open();
    try {
      PreparedStatement insertRectangle =
          this.connect.prepareStatement(
              "INSERT INTO Rectangle(nom, hautgauchex, "
                  + "hautgauchey, longueur, largeur) VALUES(?,?,?,?,?)");
      insertRectangle.setString(1, obj.getName());
      insertRectangle.setObject(2, obj.getP().getX());
      insertRectangle.setObject(3, obj.getP().getY());
      insertRectangle.setDouble(4, obj.getLength());
      insertRectangle.setDouble(5, obj.getWidth());
      insertRectangle.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return null;
  }

  @Override
  public Rectangle find(String name) {
    this.open();
    Rectangle r = null;
    try {
      PreparedStatement selectRectangle =
          this.connect.prepareStatement("SELECT * FROM Rectangle WHERE nom = ?");
      selectRectangle.setString(1, name);
      selectRectangle.execute();
      ResultSet res = selectRectangle.executeQuery();
      if (res.next()) {
        Point p = new Point(res.getDouble("hautgauchex"), res.getDouble("hautgauchey"));
        r = new Rectangle(name, p, res.getDouble("longueur"), res.getDouble("largeur"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.close();
    return r;
  }

  @Override
  public Rectangle update(Rectangle obj) {
    return null;
  }

  @Override
  public void delete(String name) {
    this.open();
    try {
      PreparedStatement deleteRectangle =
          this.connect.prepareStatement("DELETE FROM Rectangle WHERE nom = ?");
      deleteRectangle.setString(1, name);
      deleteRectangle.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.close();
  }
}
