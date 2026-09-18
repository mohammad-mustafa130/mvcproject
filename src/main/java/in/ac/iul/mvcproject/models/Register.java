/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.ac.iul.mvcproject.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammad-mustafa
 */
public class Register implements Model{
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String date = request.getParameter("date");
        String gender = request.getParameter("gender");
        System.out.print(email);
        System.out.println(pass);
        System.out.println(fname);
        System.out.println(lname);
        System.out.println(date);
        System.out.println(gender);
        return "register";
    }
    
}
