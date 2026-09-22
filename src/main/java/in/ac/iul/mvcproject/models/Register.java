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
public class Register implements Model {
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
            
            String uidQuery = "CALL uidInfo()";
            PreparedStatement ps = md.getStatement(con, uidQuery);
            ResultSet rs = md.getData(ps);
            if(rs.next()) uid = rs.getInt("uid")+1;
            else uid = 1;
            
            String userQuery = "CALL userInfo('"+uid+"', '"+fname+"', '"+lname+"', '"+dob+"', '"+gender+"')";
            PreparedStatement ps1 = md.getStatement(con, userQuery);
            md.storeData(ps1);
            
            String loginQuery = "CALL loginInfo('"+email+"', '"+password+"', '"+status+"', '"+uid+"')";
            PreparedStatement ps2 = md.getStatement(con, loginQuery);
            md.storeData(ps2);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "register";
    }
    
}
