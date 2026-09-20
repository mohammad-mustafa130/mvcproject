/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.ac.iul.mvcproject.Dao;
import java.sql.*;

/**
 *
 * @author mohammad-mustafa
 */
public class MyDao {
    String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
    String username = "mustafa";
    String password = "admin";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection doConnect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
    public PreparedStatement getStatement(Connection con, String query) throws SQLException {
        return con.prepareStatement(query);
    }
    public ResultSet getData(PreparedStatement ps) throws SQLException {
        return ps.executeQuery();
    }
    public int storeData(PreparedStatement ps) throws SQLException {
        return ps.executeUpdate();
    }
}
