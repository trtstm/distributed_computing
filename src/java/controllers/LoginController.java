/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import services.LoginService;
import services.RegistrationService;
import utils.ErrorMap;

/**
 *
 * @author timo
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {   
    @EJB
    private LoginService ls;
    
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
        
        request.setAttribute("page", "login");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        user = ls.login(email, password);
        if(user == null) {
            ErrorMap errors = new ErrorMap();
            errors.addError("login", "Username/password do not match.");
            request.setAttribute("errors", errors);
            request.setAttribute("page", "login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        request.getSession().setAttribute("user_id", user.getId());
        response.sendRedirect(request.getContextPath() + "/welcome");     
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
