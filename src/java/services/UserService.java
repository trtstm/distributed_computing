/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import models.Board;
import models.Track;
import models.User;
import repositories.BoardRepository;
import repositories.TrackRepository;
import repositories.UserRepository;
        
/**
 *
 * @author timo
 */
@Stateless
public class UserService {
    @EJB
    UserRepository userRepo;
    
    @EJB
    BoardRepository boardRepo;
    
    @EJB
    TrackRepository trackRepo;
    
    public void addBoard(User user, Board board) {
        user.addBoard(board);
        board.setUser(user);
        boardRepo.add(board);
        userRepo.save(user);
        //boardRepo.save(board);
    }
    
    public void followBoard(User user, Board board) {
        user.addFollowedBoard(board);
        board.addFollower(user);
        userRepo.save(user);
    }
    
    public void addTrack(User user, Track track) {
        user.addTrack(track);
        track.setUser(user);
        trackRepo.addTrack(track);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
