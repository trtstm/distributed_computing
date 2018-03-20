/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import models.User;
import models.UserLogin;
import repositories.UserRepository;
        
/**
 *
 * @author timo
 */
@Stateless
public class LoginService {  
    @EJB
    UserRepository userRepo;
    
    
    public User login(String email, String password) {
        User user = userRepo.getByEmailAndPassword(email, password);
        if(user != null) {
            logLogin(user);
        }
        
        return user;
    }
    
    private void logLogin(User u) {
        UserLogin ul = new UserLogin();
        ul.setUser(u);
        ul.setDatetime(new Date());
        
        userRepo.addUserLogin(ul);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
