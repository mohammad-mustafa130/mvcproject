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
public class EmailVerifier implements Model{
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response) {
        
        String resdata;
        String email = request.getParameter("email");
        System.out.println(email);
            
        try { 
            
            MyDao md = new MyDao();
            Connection con = md.doConnect();
            
            String query = "SELECT email FROM login_table2 WHERE email=?";
            
            PreparedStatement ps = md.getStatement(con, query);
            ps.setString(1, email);
            
            ResultSet rs = md.getData(ps);
           
            if(rs.next()) {
               resdata = "{\"exist\":\"true\"}";
            } else {
               resdata = "{\"exist\":\"false\"}";
            }
            response.getWriter().write(resdata);
        } catch(Exception e ) {
            e.printStackTrace();
        }
        return null;
    }
}
