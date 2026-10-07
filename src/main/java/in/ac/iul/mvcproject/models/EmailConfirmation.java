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
public class EmailConfirmation implements Model {
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response) {
        
        String uid = request.getParameter("uid");
        System.out.println(uid);
        
        try {
            MyDao md = new MyDao();
            Connection con =  md.doConnect();
            
            String query = "UPDATE login_table2 SET status=1 WHERE uid=?";
            
            PreparedStatement ps = md.getStatement(con, query);
            ps.setString(1, uid);
            
            md.storeData(ps);
            
            response.setContentType("text/html");

            response.getWriter().println("<h2>Email confirmed successfully!</h2>");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
