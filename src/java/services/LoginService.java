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
        
/**
 *
 * @author timo
 */
@Stateless
public class LoginService {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;

    
    
    public User login(String email, String password) {
            try {
                Object rawUser = this.entityManager.createNamedQuery("User.findByEmailAndPassword")
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getSingleResult();
                if(rawUser instanceof User) {
                    User u = (User)rawUser;
                    logLogin(u);
                    return u;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
    
    public List<UserLogin> getLogins(User user) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -14);
        Date twoWeeksAgo = cal.getTime();

       return this.entityManager.createNamedQuery("UserLogin.selectSinceDate")
                .setParameter("user", user)
                .setParameter("datetime", twoWeeksAgo)
                .getResultList();
    }
    
    private void logLogin(User u) {
        UserLogin ul = new UserLogin();
        ul.setUser(u);
        ul.setDatetime(new Date());
        
        entityManager.persist(ul);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
