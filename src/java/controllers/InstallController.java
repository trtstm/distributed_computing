/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import models.User;
import models.UserLogin;
import models.Track;
import repositories.UserRepository;
import services.LoginService;
import services.PodcastService;
import services.RegistrationService;

@WebServlet(name = "InstallController", urlPatterns = {"/install"})
public class InstallController extends HttpServlet {
    @EJB
    LoginService ls;
    
    @EJB
    UserRepository userRepo;
    
    @EJB
    PodcastService podcastService;
    
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
        User admin = new User();
        admin.setCountry("Belgium");
        admin.setEmail("admin@admin.admin");
        admin.setFirstName("Admin");
        admin.setGender(User.Gender.MALE);
        admin.setHasCategories(true);
        admin.setIsAdmin(true);
        admin.setLastName("Admin");
        admin.setPassword("admin");
        admin.setUsername("admin");
        userRepo.addUser(admin);
        
        Podcast p = new Podcast();
        p.setTitle("The Post Game of Thrones Podcast");
        p.setDescription("");
        p.setExternalId(new Long(223947935));
        p.setArtworkUrl("https://i1.sndcdn.com/avatars-000221919404-ujme8y-large.jpg");
        
        Track track1 = new Track();
        track1.setTitle("Season 6 Finale: Boom Goes The High Sparrow");
        track1.setDescription("Charlie, Clem and Trent break down all of what might be the greatest episode of television in the history of television.  From Cersei officially clutching the belt of Baddest Bitch, to Tommen calling it quits, to Jon Snow wearing the unofficial crown of the North, to the Tower of Joy's ultimate reveal, to Khaleesi FINALLY heading West, to Lyanna Mormont locking up the season MVP in only three episodes.  Oh yeah, and Arya straight up Scott Tenorman'd Walder Frey.  What a goddamn episode.");
        track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000169114022-4xuce5-large.jpg");
        track1.setDuration(2813625);
        track1.setExternalId(new Long(270949310));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/271018327/stream");
        
        Track track2 = new Track();
        track2.setTitle("Game Of Thrones Season Finale Preview with Jason Whitlock");
        track2.setDescription("Jason Whitlock of Fox Sports joins Charlie Wisco and KFC of Barstool New York to talk about the Game of Thrones season finale and recapping season 6.");
        //track2.setArtworkUrl("");
        track2.setDuration(2646948);
        track2.setExternalId(new Long(270949310));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/270949310/stream");

        Track track3 = new Track();
        track3.setTitle("Bastard Bowl Recap");
        track3.setDescription("Charlie, Clem, and Rear Admiral discuss all the happenings in the epic Bastard Bowl, as well as a pleasantly unexpected trip to Mereen.");
        track3.setArtworkUrl("https://i1.sndcdn.com/artworks-000168336366-3fiww6-large.jpg");
        track3.setDuration(3093945);
        track3.setExternalId(new Long(270109179));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/270109179/stream");
        
        List<Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        p.setTracks(tracks);
        
        podcastService.addPodcast(p);
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
