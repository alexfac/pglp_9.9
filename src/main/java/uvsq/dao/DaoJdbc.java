package uvsq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoJdbc<T> {

  Connection connect = null;

  public abstract T create(T obj);

  public abstract T find(String name);

  public abstract T update(T obj);

  public abstract void delete(String name);

  /**
   * ouvre la connection.
   */
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

  /**
   * ferme la connection.
   */
  public void close() {
    try {
      connect.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
