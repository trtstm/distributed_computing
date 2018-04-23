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
import models.Podcast;
import models.Track;
import models.User;
import models.UserLogin;
import repositories.PodcastRepository;
import repositories.TrackRepository;
import repositories.UserRepository;
        
/**
 *
 * @author timo
 */
@Stateless
public class RecommendationService {  
    @EJB
    PodcastRepository podcastRepo;
    
    @EJB
    TrackRepository trackRepo;
    
    public List<Podcast> calculateRecommendations(User user) {
        return podcastRepo.getAll();
    }
    
    public List<Track> calculateRecommendedTracks(User user) {
        return trackRepo.findRecommendations(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
