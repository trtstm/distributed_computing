/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import models.User;
import models.UserLogin;
        
@Stateless
public class UserRepository {   
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;
    
    public User getById(long id) {
            try {
                Object rawUser = this.entityManager.createNamedQuery("User.findById")
                        .setParameter("id", id)
                        .getSingleResult();
                if(rawUser instanceof User) {
                    User u = (User)rawUser;
                    return u;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
    
    
    public User getByEmail(String email) {
            try {
                Object rawUser = this.entityManager.createNamedQuery("User.findByEmail")
                        .setParameter("email", email)
                        .getSingleResult();
                if(rawUser instanceof User) {
                    User u = (User)rawUser;
                    return u;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
    
    
    public User getByUsername(String username) {
            try {
                Object rawUser = this.entityManager.createNamedQuery("User.findByUsername")
                        .setParameter("username", username)
                        .getSingleResult();
                if(rawUser instanceof User) {
                    User u = (User)rawUser;
                    return u;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
    
    public User getByEmailAndPassword(String email, String password) {
        try {
            Object rawUser = this.entityManager.createNamedQuery("User.findByEmailAndPassword")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            if(rawUser instanceof User) {
                User u = (User)rawUser;
                return u;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
    
    public List<UserLogin> getLoginHistory(User user, Date since) {
       return this.entityManager.createNamedQuery("UserLogin.selectSinceDate")
                .setParameter("user", user)
                .setParameter("datetime", since)
                .getResultList();
    }
    
    public void save(User user) {
        entityManager.merge(user);
    }
    
    public void addUser(User user) {
        entityManager.persist(user);
    }
    
    public void addUserLogin(UserLogin ul) {
        entityManager.persist(ul);
    }
}
