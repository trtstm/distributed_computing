/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import models.Board;
import models.Track;
import models.User;
import models.UserLogin;
import repositories.TrackRepository;
import services.LoginService;
import services.RegistrationService;

/**
 *
 * @author timo
 */
@WebServlet(name = "TrackController", urlPatterns = {"/tracks"})
public class TrackController extends HttpServlet {
    @EJB
    TrackRepository trackRepo;
    
    public static class TrackResponse {
        public Long id;
        public String title;
        public UserResponse user;
        public List<Long> boards = new ArrayList<Long>();

        public static class UserResponse {
            public Long id;
            public String username;
            
            public UserResponse(User user) {
                id = user.getId();
                username = user.getUsername();
            }
        }
        
        public TrackResponse(User u, Track track) {
            id = track.getId();
            title = track.getTitle();
            user = new UserResponse(track.getUser());
            for(Board board : u.getBoards()) {
                if(board.getTracks().contains(track)) {
                    boards.add(board.getId());
                }
            }
        }
    }
    
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
        User u = (User)(request.getSession().getAttribute("user"));
        
        String idStr = request.getParameter("id");
        if(idStr == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        try {
            Long id = Long.parseLong(idStr);
            Track track = trackRepo.getById(id);
            if(track == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            
            request.setAttribute("track", track);
            String json = new Gson().toJson(new TrackResponse(u, track));
            request.setAttribute("trackJson", json);
            
            List<BoardController.BoardResponse> boardResponse = new ArrayList<BoardController.BoardResponse>();
            for(Board board : u.getBoards()) {
                boardResponse.add(new BoardController.BoardResponse(board));
            }
            json = new Gson().toJson(boardResponse);
            request.setAttribute("userBoards", json);
        } catch(NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        request.getRequestDispatcher("/track.jsp").forward(request, response);
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
