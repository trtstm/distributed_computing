/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
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
import models.Podcast;
import models.Track;
import models.User;
import models.UserLogin;
import services.LoginService;
import services.RecommendationService;
import services.RegistrationService;

/**
 *
 * @author timo
 */
@WebServlet(name = "RecommendationController", urlPatterns = {"/recommendations"})
public class RecommendationController extends HttpServlet {
        public static class UserResponse {
           public String username;
           public Long id;

           public UserResponse(User user) {
               id = user.getId();
               username = user.getUsername();
           }
       }

       public static class TrackResponse {
           public Long id;
           public String title;
           public UserResponse user;
           public String artworkUrl;
           public String description;

           public TrackResponse(Track track) {
               id = track.getId();
               title = track.getTitle();
               user = new UserResponse(track.getUser());
               artworkUrl = track.getArtworkUrl();
               description = track.getDescription();
           }
       }
    
    @EJB
    RecommendationService recommendationService;

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

        User user = (User) (request.getSession().getAttribute("user"));
        List<Track> recommendations = recommendationService.calculateRecommendedTracks(user);

        List<TrackResponse> trackResponse = new ArrayList<TrackResponse>();
        for(Track track : recommendations) {
            trackResponse.add(new TrackResponse(track));
        }
        String json = new Gson().toJson(trackResponse);
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
