/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import repositories.UserRepository;
import services.RegistrationService;
import utils.ErrorMap;
import validators.UserValidator;

/**
 *
 * @author timo
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @EJB
    private RegistrationService rs;
    
    @EJB
    private UserValidator userValidator;
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)(request.getSession().getAttribute("user"));
        if(!user.isAnonymous()) {
            response.sendRedirect(request.getContextPath() + "/welcome");
            return;
        }
        
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)(request.getSession().getAttribute("user"));
        if(!user.isAnonymous()) {
            response.sendRedirect(request.getContextPath() + "/welcome");
            return;
        }

        userValidator.validate(request);

        if(userValidator.getErrors().hasErrors()) {
            request.setAttribute("errors", userValidator.getErrors());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        
        User u = new User();
        u.setCountry(userValidator.getCountry());
        u.setEmail(userValidator.getEmail());
        u.setFirstName(userValidator.getFirstName());
        u.setLastName(userValidator.getLastName());
        u.setGender(userValidator.getGender());
        u.setUsername(userValidator.getUsername());
        u.setPassword(userValidator.getPassword());
        u.setAnonymous(false);
        
        rs.registerUser(u);
        //HttpSession session = request.getSession();
        //session.setAttribute("user_id", u.getId());
        
        response.sendRedirect(request.getContextPath() + "/login");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
