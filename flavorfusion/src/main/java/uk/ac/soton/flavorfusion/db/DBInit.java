package uk.ac.soton.flavorfusion.db;
import java.sql.Connection;
import java.sql.Statement;

public class DBInit {
//  public static void initializeDatabase() {
//    try (Connection conn = DBUtil.getConnection();
//        Statement stmt = conn.createStatement()) {
//
//      // 创建Ingredients表
//      stmt.execute("CREATE TABLE IF NOT EXISTS Ingredients (" +
//          "ID INT PRIMARY KEY," +
//          "CommonName VARCHAR(255)," +
//          "Description VARCHAR(255)," +
//          "GlycemicIndex FLOAT," +
//          "CreateDate DATE," +
//          "ModifyDate DATE," +
//          "EshaCode VARCHAR(50)," +
//          "NutrientRefNum INT," +
//          "Product VARCHAR(100)," +
//          "Supplier VARCHAR(100)," +
//          "USDAcode VARCHAR(50)," +
//          "Version VARCHAR(50)" +
//          ");");
//
//      // 创建Categories表
//      stmt.execute("CREATE TABLE IF NOT EXISTS Categories (" +
//          "GroupID INT PRIMARY KEY," +
//          "GroupName VARCHAR(255)," +
//          "IsFolder BOOLEAN" +
//          ");");
//
//      // 创建IngredientCategories表
//      stmt.execute("CREATE TABLE IF NOT EXISTS IngredientCategories (" +
//          "IngredientID INT," +
//          "CategoryID INT," +
//          "FOREIGN KEY (IngredientID) REFERENCES Ingredients(ID)," +
//          "FOREIGN KEY (CategoryID) REFERENCES Categories(GroupID)" +
//          ");");
//
//      // 可以添加更多的初始化代码，比如插入初始数据
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
}

