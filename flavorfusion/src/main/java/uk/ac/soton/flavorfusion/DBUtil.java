package uk.ac.soton.flavorfusion;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
  private static final String DB_URL = "jdbc:h2:./db/"; // 数据库路径，"./data"是你的数据文件夹
  private static final String USER = "sa";
  private static final String PASS = "";

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(DB_URL, USER, PASS);
  }
}
