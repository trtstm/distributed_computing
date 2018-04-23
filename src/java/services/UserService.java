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
import models.User;
import repositories.BoardRepository;
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
    
    public void addBoard(User user, Board board) {
        user.addBoard(board);
        board.setUser(user);
        boardRepo.add(board);
        userRepo.save(user);
        //boardRepo.save(board);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
