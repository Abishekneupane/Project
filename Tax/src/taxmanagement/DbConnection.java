package taxmanagement;
//making database connection for all the classes in package .
import java.sql.*;

public class DbConnection {

  private static Connection con;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://127.0.0.1:3306/Taxman";
      String username = "root";
      String password = "123456";
      con = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return con;
  }
}
