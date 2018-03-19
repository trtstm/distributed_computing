/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import models.UserLogin;
import repositories.UserRepository;
import services.LoginService;
import services.RegistrationService;
import utils.ErrorMap;
import validators.UserValidator;

/**
 *
 * @author timo
 */
@WebServlet(name = "SettingsController", urlPatterns = {"/settings"})
public class SettingsController extends HttpServlet {  
    @EJB
    UserValidator userValidator;
    
    @EJB
    UserRepository userRepo;
    
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
                
        User user = (User)request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/settings.jsp").forward(request, response);
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
        User u = (User)(request.getSession().getAttribute("user"));

        userValidator.validate(request);
        ErrorMap errors = userValidator.getErrors();
        // We do not validate email because I can't be set anyway.
        errors.removeErrors("email");
        // Only validate username if we changed it.
        if(userValidator.getUsername().equals(u.getUsername())) {
            errors.removeErrors("username");
        }
        

        if(errors.hasErrors()) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/settings.jsp").forward(request, response);
            return;
        }
        
        u.setCountry(userValidator.getCountry());
        u.setFirstName(userValidator.getFirstName());
        u.setLastName(userValidator.getLastName());
        u.setGender(userValidator.getGender());
        u.setUsername(userValidator.getUsername());
        u.setPassword(userValidator.getPassword());
        
        userRepo.save(u);
        
        //HttpSession session = request.getSession();
        //session.setAttribute("user_id", u.getId());
        
        request.setAttribute("success", "Settings updated!");
        request.getRequestDispatcher("/settings.jsp").forward(request, response);
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
