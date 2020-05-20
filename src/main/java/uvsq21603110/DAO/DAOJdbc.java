package uvsq21603110.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOJdbc<T> {

  Connection connect = null;

  public abstract T create(T obj);

  public abstract T find(String name);

  public abstract T update(T obj);

  public abstract void delete(String name);

  public void open() {
    String url = "jdbc:derby:Test;create=false";
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connect = DriverManager.getConnection(url);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void close() {
    try {
      connect.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
