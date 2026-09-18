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
public class Login implements Model {
    @Override
    public String businessLogic(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }
}
