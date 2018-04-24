/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "PinsController", urlPatterns = {"/pins"})
public class PinsController extends HttpServlet {  
    @EJB
    TrackRepository trackRepo;
    
    public static class BoardResponse {
        public Long id;
        public String title;
        public boolean isPrivate;
        
        public BoardResponse(Board board) {
            id = board.getId();
            title = board.getTitle();
            isPrivate = board.isIsPrivate();
        }
    }
    
       public static class TrackResponse {
           public Long id;
           public String title;
           public String artworkUrl;
           public String description;
           public List<BoardResponse> boards = new ArrayList<BoardResponse>();
           
           public TrackResponse(Track track) {
               id = track.getId();
               title = track.getTitle();
               artworkUrl = track.getArtworkUrl();
               description = track.getDescription();
               for(Board board : track.getBoards()) {
                   boards.add(new BoardResponse(board));
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
        
        User user = (User)(request.getSession().getAttribute("user"));
        
        List<Track> pinnedTracks = trackRepo.findPinned(user);
                
        List<TrackResponse> trackResponse = new ArrayList<TrackResponse>();
        for(Track track : pinnedTracks) {
            trackResponse.add(new TrackResponse(track));
        }
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tracks", trackResponse);
        
        String json = new Gson().toJson(result);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        
        
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
