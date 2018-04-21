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
import models.Podcast;
import models.User;
import repositories.PodcastRepository;
import repositories.UserRepository;
        
/**
 *
 * @author timo
 */
@Stateless
public class PodcastService {
    @EJB
    PodcastRepository podcastRepo;
   
    public void addPodcast(Podcast podcast) {
        if(podcastRepo.getByExternalId(podcast.getExternalId()) != null) {
            // An existing podcast, just update it.
            podcastRepo.save(podcast);
            return;
        }
        
        podcastRepo.addPodcast(podcast);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
