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
import models.Board;
import models.Podcast;
import models.User;
import models.UserLogin;
import models.Track;
import repositories.TrackRepository;
import repositories.UserRepository;
import services.BoardService;
import services.LoginService;
import services.PodcastService;
import services.RegistrationService;
import services.UserService;

@WebServlet(name = "InstallController", urlPatterns = {"/install"})
public class InstallController extends HttpServlet {
    @EJB
    LoginService ls;
    
    @EJB
    UserRepository userRepo;
    
    @EJB
    UserService userService;
    
    @EJB
    BoardService boardService;
    
    @EJB
    TrackRepository trackRepo;
    
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
        
        addUsers();
    }

    private void addUsers() {
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
        
        addHouseOfCards(admin);
        addRandom2(admin);
        
        for(int i = 0; i < 50; i++) {
            User user = new User();
            user.setCountry("Belgium");
            user.setEmail("admin" + Integer.toString(i) + "@admin.admin");
            user.setFirstName("John" +  Integer.toString(i));
            user.setGender((i % 2 == 0) ? User.Gender.MALE : User.Gender.FEMALE);
            //user.setHasCategories(true);
            //user.setIsAdmin(true);
            user.setLastName("Doe" + Integer.toString(i));
            user.setPassword("password");
            user.setUsername("User" + Integer.toString(i));
            
            userRepo.addUser(user);
            
            if(i == 10) {
                addTracksGot(user);
                userService.followBoard(admin, user.getBoards().get(0));
            } else if(i == 20) {
                addOrangeTracks(user);
                userService.followBoard(admin, user.getBoards().get(0));
                userService.followBoard(user, admin.getBoards().get(0));
            } else if(i == 30) {
                addRandom(user);
                userService.followBoard(user, admin.getBoards().get(0));
            }
        }
    }
    
    private void addRandom2(User user) {
        Track track1 = new Track();
        track1.setTitle("Voices Film & TV Podcast: Chapter 10 • Our Top Ten Films & TV Series Of 2015(Part 1)");
        track1.setDescription("These are the Podcasts from Voicesfilm.com.↵A celebration of all things Film & Television");
        track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000189327283-nlxojc-large.jpg");
        track1.setDuration(3013140);
        track1.setExternalId(new Long(288504081));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/288504081");
        userService.addTrack(user, track1);
        
        Track track2 = new Track();
        track2.setTitle("Vulture TV Podcast Ep 6: Mad Men, the Beginning of the End");
        track2.setDescription("New York TV critic Matt Zoller Seitz, Vulture TV columnist Margaret Lyons, and Vulture TV editor Gazelle Emami discuss last night’s Mad Men premiere. NYMag music critic Lindsay Zoladz talks about the music in Mad Men. Plus, Vulture’s West Coast Editor Joe Adalian talks with AMC’s president Charlie Collier about the Mad Men roll out.");
        track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000112442874-yo4jbo-large.jpg");
        track2.setDuration(3002038);
        track2.setExternalId(new Long(199427585));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/199427585");
        userService.addTrack(user, track2);
        
        Track track3 = new Track();
        track3.setTitle("The Vulture TV Podcast: Mad Men & the Three F’s - Future, Forecast and Friggin’ Glen is Back");
        track3.setDescription("New York TV critic Matt Zoller Seitz, Vulture TV columnist Margaret Lyons, and Vulture TV editor Gazelle Emami dig into the most recent episode of Mad Men, “The Forecast.”");
        track3.setArtworkUrl("https://i1.sndcdn.com/artworks-000114090807-uociaf-large.jpg");
        track3.setDuration(2692588);
        track3.setExternalId(new Long(201802839));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/201802839");
        userService.addTrack(user, track3);
        
        Track track4 = new Track();
        track4.setTitle("Doctor Who Podcast - Last Christmas");
        track4.setDescription("Our review of Last Christmas.  Mark gets angry at the finger clicking incident from the finale again and Daniel creates a Dream Crab/Memory Worm hybrid completely by accident.");
        track4.setArtworkUrl("https://i1.sndcdn.com/artworks-000101932380-5420xl-large.jpg");
        track4.setDuration(1715620);
        track4.setExternalId(new Long(183996193));
        track4.setStreamUrl("https://api.soundcloud.com/tracks/183996193");
        userService.addTrack(user, track4);
        
        Track track5 = new Track();
        track5.setTitle("Episode 1: An Unearthly Child");
        track5.setDescription("We launch our new Doctor Who podcast, Lonely Gods. In this first episode Kate and David discuss the Doctor's first ever adventure: An Unearthly Child. Does the 60s Who stand up to the test of time?");
        track5.setArtworkUrl("https://i1.sndcdn.com/artworks-000169365348-1c59ti-large.jpg");
        track5.setDuration(3214668);
        track5.setExternalId(new Long(271314672));
        track5.setStreamUrl("https://api.soundcloud.com/tracks/271314672");
        userService.addTrack(user, track5);
        
        //userRepo.save(user);
    }
    
    private void addHouseOfCards(User user) {
        Board board = new Board();
        board.setTitle("House Of Cards");
        board.setIsPrivate(false);
        userService.addBoard(user, board);
        
        Track track1 = new Track();
        track1.setTitle("Film Geeks Podcast 18-06-17 House of Cards + Rakka + Nobody Speak + Daddy + Indu Sarkar");
        track1.setDescription("Anir, Abhishek and Arindam review House of Cards Season 5 and Rakka. Also trailer reviews for Nobody Speak, Indu Sarkar, Daddy and we discuss Fox's movie deal with Boom Studio.");
        track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000230821542-tjdal1-large.jpg");
        track1.setDuration(3828029);
        track1.setExternalId(new Long(330348891));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/330348891");
        userService.addTrack(user, track1);
        
        Track track2 = new Track();
        track2.setTitle("Joygasm Podcast Ep. 63: Overwatch League, Soul Calibur 6, Tomb Raider, House Of Cards, & More!");
        track2.setDescription("Happy St. Patrick's Day!  We have SO MUCH to share a pint over: Overwatch League news, Narcos getting its own video game, Microsoft's E3 press conference date announced, a special guest joining the ranks of Soul Calibur 6, a new Tomb Raider game coming out this year, John Williams saying farewell to Star Wars, Black Panther's continued box office success, the final season of House Of Cards, AMC hosting a Marvel movie marathon & tons more...");
        track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000324494628-wvbnfe-large.jpg");
        track2.setDuration(3574669);
        track2.setExternalId(new Long(419802860));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/419802860");
        userService.addTrack(user, track2);
        
        Track track3 = new Track();
        track3.setTitle("Podcast ESMAC N° 79 - House of Cards (4ta Temporada)");
        track3.setDescription("¿No sabes qué series ver? El podcast “El Stream Mató al Cable” te ayuda a decidir, comentando las series más importantes de la nueva Edad Dorada de la TV (y el Stream).↵↵House of Cards sigue siendo la carta fuerte de Netflix en los Emmy con sus tres nominaciones. En esta edición de El Stream Mató al Cable comentamos todo acerca de la cuarta temporada de esta serie en la que vemos como la ficción no logró superar a la realidad de las elecciones americanas.");
        track3.setArtworkUrl("https://i1.sndcdn.com/artworks-000171442346-8ztmks-large.jpg");
        track3.setDuration(2615729);
        track3.setExternalId(new Long(273664581));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/273664581");
        userService.addTrack(user, track3);
        
        Track track4 = new Track();
        track4.setTitle("Bonus Episode - House of Cards");
        track4.setDescription("Damn you Netflix.... Damn you!!!  Just when I thought there was nothing good to watch on TV, you go and throw a huge curve ball and release the whole season in one shot!!  Now how the hell can anyone go to work??  Serious, anyone... I need an excuse!!");
        track4.setArtworkUrl("https://i1.sndcdn.com/artworks-000149639597-15u5vy-large.jpg");
        track4.setDuration(295811);
        track4.setExternalId(new Long(250185548));
        track4.setStreamUrl("https://api.soundcloud.com/tracks/250185548");
        userService.addTrack(user, track4);
        
        //userRepo.save(user);
        
        boardService.addTrack(board, track1);
        boardService.addTrack(board, track2);
        boardService.addTrack(board, track3);
        boardService.addTrack(board, track4);
    }
    
    private void addTracksGot(User user) {
        Board board = new Board();
        board.setTitle("Game of thrones");
        board.setIsPrivate(false);
        userService.addBoard(user, board);
        
        Track track1 = new Track();
        track1.setTitle("Season 6 Finale: Boom Goes The High Sparrow");
        track1.setDescription("Charlie, Clem and Trent break down all of what might be the greatest episode of television in the history of television.  From Cersei officially clutching the belt of Baddest Bitch, to Tommen calling it quits, to Jon Snow wearing the unofficial crown of the North, to the Tower of Joy's ultimate reveal, to Khaleesi FINALLY heading West, to Lyanna Mormont locking up the season MVP in only three episodes.  Oh yeah, and Arya straight up Scott Tenorman'd Walder Frey.  What a goddamn episode.");
        track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000169114022-4xuce5-large.jpg");
        track1.setDuration(2813625);
        track1.setExternalId(new Long(270949310));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/271018327");
        userService.addTrack(user, track1);
        
        Track track2 = new Track();
        track2.setTitle("Game Of Thrones Season Finale Preview with Jason Whitlock");
        track2.setDescription("Jason Whitlock of Fox Sports joins Charlie Wisco and KFC of Barstool New York to talk about the Game of Thrones season finale and recapping season 6.");
        //track2.setArtworkUrl("");
        track2.setDuration(2646948);
        track2.setExternalId(new Long(270949310));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/270949310");
        userService.addTrack(user, track2);

        Track track3 = new Track();
        track3.setTitle("Bastard Bowl Recap");
        track3.setDescription("Charlie, Clem, and Rear Admiral discuss all the happenings in the epic Bastard Bowl, as well as a pleasantly unexpected trip to Mereen.");
        track3.setArtworkUrl("https://i1.sndcdn.com/artworks-000168336366-3fiww6-large.jpg");
        track3.setDuration(3093945);
        track3.setExternalId(new Long(270109179));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/270109179");
        userService.addTrack(user, track3);
        
        
        Track track4 = new Track();
        track4.setTitle("De Instapaflevering - Waarom Game of Thrones wél iets voor jou is");
        track4.setDescription("Kijk jij Game of Thrones?\" ↵\"Nee, niks voor mij, met al die zombies en draken\"↵Een veelgehoord argument in de kijk-jij-GoT discussie. Begrijpelijk aangezien de eerste scène van de serie bolstaat van de ijszombies en dode meisjes met blauwe ogen. Daarom zijn wij er voor je om je door deze scène heen te loodsen en te overtuigen om tóch door te kijken! Laat deze podcast aflevering horen aan die ene vriend of vriendin van je die nog twijfelt of Game of Thrones echt het kijken waard is.");
        track4.setArtworkUrl("https://i1.sndcdn.com/artworks-000298307100-pq6h8l-large.jpg");
        track4.setDuration(1466023);
        track4.setExternalId(new Long(395471322));
        track4.setStreamUrl("https://api.soundcloud.com/tracks/395471322");
        userService.addTrack(user, track4);
        
        Track track5 = new Track();
        track5.setTitle("1e09 - We Waren Ned Zo Lekker Bezig");
        track5.setDescription("Hebben jullie mee gekeken? We zijn opnieuw begonnen bij seizoen één van dit geweldige verhaal. Lysa Arryn komt zo uit Little Britain, de eervolle Ned Stark had een andere serie uit moeten kiezen om 'eervol' in te wezen, en wat kunnen we leren van een oude blinde man?");
        track5.setArtworkUrl("https://i1.sndcdn.com/artworks-000310943355-pm2emy-large.jpg");
        track5.setDuration(5045683);
        track5.setExternalId(new Long(408533214));
        track5.setStreamUrl("https://api.soundcloud.com/tracks/408533214");
        userService.addTrack(user, track5);
        
        //userRepo.save(user);
        
        boardService.addTrack(board, track1);
        boardService.addTrack(board, track2);
        boardService.addTrack(board, track3);
        boardService.addTrack(board, track4);
        boardService.addTrack(board, track5);
    }
    
    private void addOrangeTracks(User user) {
        Board board = new Board();
        board.setTitle("Orange is the new black");
        board.setIsPrivate(false);
        userService.addBoard(user, board);
        
        Track track1 = new Track();
        track1.setTitle("Orange is the New Black | Season 4 Episodes 5, 6, 7 Recap Podcast");
        track1.setDescription("07/11/16 - Jessica Liese and Taylor Cotter are back to explore more of the world of Litchfield as they break down everything that happened in \"Orange Is The New Black,\" Season 4, episodes 5, 6 and 7.");
        //track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000169114022-4xuce5-large.jpg");
        track1.setDuration(5264192);
        track1.setExternalId(new Long(273259460));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/273259460");
        userService.addTrack(user, track1);
        
        Track track2 = new Track();
        track2.setTitle("Podcast Cinescalero Volumen XXI: Orange is the New Black (cuarta temporada)");
        track2.setDescription("");
        track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000169038809-8fkjgb-large.jpg");
        track2.setDuration(3676347);
        track2.setExternalId(new Long(270919709));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/270919709");
        userService.addTrack(user, track2);

        Track track3 = new Track();
        track3.setTitle("Podcast Cinescalero Volumen VI: Sobre Orange Is the New Black");
        track3.setDescription("Charlie, Clem, and Rear Admiral discuss all the happenings in the epic Bastard Bowl, as well as a pleasantly unexpected trip to Mereen.");
        track3.setArtworkUrl("https://i1.sndcdn.com/artworks-000082296247-qadlon-large.jpg");
        track3.setDuration(2480898);
        track3.setExternalId(new Long(154238224));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/154238224");
        userService.addTrack(user, track3);
        
        
        Track track4 = new Track();
        track4.setTitle("Orange is the New Black | Season 4 Episodes 5, 6, 7 Recap Podcast");
        track4.setDescription("07/11/16 - Jessica Liese and Taylor Cotter are back to explore more of the world of Litchfield as they break down everything that happened in \"Orange Is The New Black,\" Season 4, episodes 5, 6 and 7.");
        //track4.setArtworkUrl("https://i1.sndcdn.com/artworks-000298307100-pq6h8l-large.jpg");
        track4.setDuration(5264192);
        track4.setExternalId(new Long(273259460));
        track4.setStreamUrl("https://api.soundcloud.com/tracks/273259460");
        userService.addTrack(user, track4);
        
        Track track5 = new Track();
        track5.setTitle("Podcast ESMAC N° 45 - Orange is the New Black 3ra Temporada");
        track5.setDescription("¿No sabes qué series ver? El podcast “El Stream Mató al Cable” te ayuda a decidir, comentando las series más importantes de la nueva Edad Dorada de la TV (y el Stream).↵↵Orange is the New Black fue la primera serie genuinamente buena de Netflix y en este podcast sobre la 3ra Temporada comentamos por qué sigue demostrando por qué es una serie como ninguna otra.");
        track5.setArtworkUrl("https://i1.sndcdn.com/artworks-000138909979-0x93cb-large.jpg");
        track5.setDuration(4363615);
        track5.setExternalId(new Long(236722246));
        track5.setStreamUrl("https://api.soundcloud.com/tracks/236722246");
        userService.addTrack(user, track5);
        
        //userRepo.save(user);
        
        boardService.addTrack(board, track1);
        boardService.addTrack(board, track2);
        boardService.addTrack(board, track3);
        boardService.addTrack(board, track4);
        boardService.addTrack(board, track5);
    }
    
    private void addRandom(User user) {
       
        Track track1 = new Track();
        track1.setTitle("Seinfeld: The Comeback | Episode 147 Recap Podcast");
        track1.setDescription("02/18/17 - Rob Cesternino and Akiva Wienerkur continue their journey to watch every Seinfeld episode as they discuss Season 8, Episode 13, \"The Comeback.\"");
        //track1.setArtworkUrl("https://i1.sndcdn.com/artworks-000169114022-4xuce5-large.jpg");
        track1.setDuration(5810908);
        track1.setExternalId(new Long(308469864));
        track1.setStreamUrl("https://api.soundcloud.com/tracks/308469864");
        userService.addTrack(user, track1);
        
        Track track2 = new Track();
        track2.setTitle("Walking Dead Season 7, Episode 10 Recap | New Best Friends");
        track2.setDescription("02/19/17 - Rob Cesternino and Alex Kidwell recap the Season 7, Episode 10 of The Walking Dead , \"New Best Friends\"");
        //track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000169038809-8fkjgb-large.jpg");
        track2.setDuration(3556356);
        track2.setExternalId(new Long(308618130));
        track2.setStreamUrl("https://api.soundcloud.com/tracks/308618130");
        userService.addTrack(user, track2);

        Track track3 = new Track();
        track3.setTitle("Walking Dead Season 1 Rewatch, Episode 6: TS-19");
        track3.setDescription("02/09/17 - Rob Cesternino and Josh Wigler finish their rewatch of the first season of The Walking Dead with this look back at the finale of Season 1 of The Walking Dead, \"TS-19\"");
        //track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000169038809-8fkjgb-large.jpg");
        track3.setDuration(4099779);
        track3.setExternalId(new Long(307007809));
        track3.setStreamUrl("https://api.soundcloud.com/tracks/307007809");
        userService.addTrack(user, track3);
        
        Track track4 = new Track();
        track4.setTitle("24 Legacy: Series Premiere Recap Podcast");
        track4.setDescription("02/07/17 - Rob Cesternino and Josh Wigler recap the series premiere of \"24 Legacy\"");
        //track2.setArtworkUrl("https://i1.sndcdn.com/artworks-000169038809-8fkjgb-large.jpg");
        track4.setDuration(2686840);
        track4.setExternalId(new Long(306349497));
        track4.setStreamUrl("https://api.soundcloud.com/tracks/306349497");
        userService.addTrack(user, track4);
        
        //userRepo.save(user);

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
