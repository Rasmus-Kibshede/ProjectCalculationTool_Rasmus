package projectCalculationTool.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
  private static String user;
  private static String password;
  private static String url;
  private static Connection connection = null;

  public static Connection getConnection(){
    if(connection != null){
      return connection;
    }
    user = System.getenv(user);
    password = System.getenv(password);
    url = System.getenv(url);

    try{
      connection = DriverManager.getConnection(user, password, url);
    }catch (SQLException e){
      e.printStackTrace(); // MAKE OWN EXCEPTION????
    }

    return connection;
  }
}
