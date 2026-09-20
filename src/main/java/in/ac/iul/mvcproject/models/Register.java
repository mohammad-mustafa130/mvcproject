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
public class Register implements Model{
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
        System.out.println("DOB: " + dob);
        System.out.println("Gender: " + gender);
        
        try {
            int uid;
            int status = 0;
            MyDao md = new MyDao();
            Connection con = md.doConnect();
            
            String query = "SELECT uid FROM user_table2 ORDER BY uid DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) uid = rs.getInt("uid")+1;
            else uid = 1;
            
            String query1 = "INSERT INTO user_table2(uid, first_name, last_name, dob, gender) VALUES(?,?,?,?,?)";
            
            PreparedStatement ps1 = md.getStatement(con, query1);
            ps1.setInt(1, uid);
            ps1.setString(2, fname);
            ps1.setString(3, lname);
            ps1.setString(4, dob);
            ps1.setString(5, gender);
            
            md.storeData(ps1);
            
            String query2 = "INSERT INTO login_table2(email, password, status, uid) VALUES(?,?,?,?)";
            
            PreparedStatement ps2 = md.getStatement(con, query2);
            ps2.setString(1, email);
            ps2.setString(2, password);
            ps2.setInt(3, status);
            ps2.setInt(4, uid);
            
            md.storeData(ps2);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "register";
    }
    
}
