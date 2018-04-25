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
import repositories.BoardRepository;
import repositories.TrackRepository;
import services.BoardService;
import services.LoginService;
import services.RegistrationService;
import services.UserService;

/**
 *
 * @author timo
 */
@WebServlet(name = "BoardController", urlPatterns = {"/boards"})
public class BoardController extends HttpServlet {   
    @EJB
    UserService userService;
    
    @EJB
    BoardRepository boardRepo;
    
    @EJB
    TrackRepository trackRepo;
    
    @EJB
    BoardService boardService;
    
    public static class BoardResponse {
        public Long id;
        public String title;
        public boolean isPrivate;
        public List<TrackResponse> tracks;
        
        public BoardResponse(Board board) {
            id = board.getId();
            title = board.getTitle();
            isPrivate = board.isIsPrivate();
            tracks = new ArrayList<TrackResponse>();
            for(Track track : board.getTracks()) {
                tracks.add(new TrackResponse(track));
            }
            
            user = new BoardResponse.UserResponse(board.getUser());
        }
        
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
            
            public TrackResponse(Track track) {
                id = track.getId();
                title = track.getTitle();
            }
        }
        
        public UserResponse user;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User)(request.getSession().getAttribute("user"));

        List<BoardResponse> userBoards = new ArrayList<BoardResponse>();
        List<BoardResponse> followedBoards = new ArrayList<BoardResponse>();
        for(Board board : user.getBoards()) {
            userBoards.add(new BoardResponse(board));
        }
        for(Board board : user.getFollowedBoards()) {
            followedBoards.add(new BoardResponse(board));
        }
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("mine")) {
            String json = new Gson().toJson(userBoards);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        }
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("followed")) {
            String json = new Gson().toJson(followedBoards);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        }
        
        
        HashMap<String, List<BoardResponse>> result = new HashMap<String, List<BoardResponse>>();
        result.put("userBoards", userBoards);
        result.put("followedBoards", followedBoards);
        
        String json = new Gson().toJson(result);
        request.setAttribute("boards", json);
        
        request.getRequestDispatcher("/boards.jsp").forward(request, response);
  
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User)(request.getSession().getAttribute("user"));

        String action = request.getParameter("action");
        if(action.equals("create")) {           
            String title = request.getParameter("title");
            boolean isPrivate = Boolean.parseBoolean(request.getParameter("isPrivate"));
            Board board = new Board();
            board.setTitle(title);
            board.setIsPrivate(isPrivate);
            userService.addBoard(user, board);
            
            BoardResponse boardResponse = new BoardResponse(board);
                    
            String json = new Gson().toJson(boardResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        } else if(action.equals("pin")) {
            Long boardId = Long.parseLong(request.getParameter("board"));
            Long trackId = Long.parseLong(request.getParameter("track"));
            
            Board board = boardRepo.getById(boardId);
            Track track = trackRepo.getById(trackId);
            
            if(!board.getUser().getId().equals(user.getId())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            
            boardService.addTrack(board, track);
            
            BoardResponse boardResponse = new BoardResponse(board);
            
            String json = new Gson().toJson(boardResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        } else if(action.equals("unpin")) {
            Long boardId = Long.parseLong(request.getParameter("board"));
            Long trackId = Long.parseLong(request.getParameter("track"));
            
            Board board = boardRepo.getById(boardId);
            Track track = trackRepo.getById(trackId);
            
            if(!board.getUser().getId().equals(user.getId())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            
            boardService.removeTrack(board, track);
            
            BoardResponse boardResponse = new BoardResponse(board);
            
            String json = new Gson().toJson(boardResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        } else if(action.equals("follow")) {
            Long boardId = Long.parseLong(request.getParameter("board"));
            
            Board board = boardRepo.getById(boardId);
                       
            userService.followBoard(user, board);
            return;
        } else if(action.equals("unfollow")) {
            Long boardId = Long.parseLong(request.getParameter("board"));
            
            Board board = boardRepo.getById(boardId);
            
            userService.unfollowBoard(user, board);
            return;
        }
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
