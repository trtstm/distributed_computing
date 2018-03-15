/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import models.User;
        
/**
 *
 * @author timo
 */
@Stateless
public class RegistrationService {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;

    
    
    public void registerUser(User user) {
        entityManager.persist(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
