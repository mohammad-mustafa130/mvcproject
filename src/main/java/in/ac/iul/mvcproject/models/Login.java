/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.ac.iul.mvcproject.models;

import in.ac.iul.mvcproject.Dao.MyDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author mohammad-mustafa
 */
public class Login implements Model {
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        System.out.println("Email: " + email);
        System.out.println("Password: " + pass);
        
        try {
            MyDao md = new MyDao();
            Connection con = md.doConnect();
            
            String query = "CALL emailInfo('"+email+"')";
            PreparedStatement ps = md.getStatement(con, query);
            
            ResultSet rs = md.getData(ps);
      
            if(rs.next()) {
                String password = rs.getString("password");
                if(password.equals(pass)) return "afterLogin";
                else return "incorrectPass";
            } else {
                return "userNotExist";
            }
        } catch(Exception e ) {
            e.printStackTrace();
        }
        return "login";
    }
}
