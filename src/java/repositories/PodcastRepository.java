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
import models.Category;
import models.Podcast;
import models.User;
import models.UserLogin;
        
@Stateless
public class PodcastRepository {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;
    
    public Podcast getById(long id) {
            try {
                Object rawPodcast = this.entityManager.createNamedQuery("Podcast.findById")
                        .setParameter("id", id)
                        .getSingleResult();
                if(rawPodcast instanceof Podcast) {
                    Podcast p = (Podcast)rawPodcast;
                    return p;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
   
    public Podcast getByExternalId(long id) {
        try {
            Object rawPodcast = this.entityManager.createNamedQuery("Podcast.findByExternalId")
                    .setParameter("id", id)
                    .getSingleResult();
            if(rawPodcast instanceof Podcast) {
                Podcast p = (Podcast)rawPodcast;
                return p;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
    
    public List<Podcast> getAll() {
       return this.entityManager.createNamedQuery("Podcast.findAll")
                .getResultList();
    }
           
    public void save(Podcast podcast) {
        entityManager.merge(podcast);
    }
    
    public void addPodcast(Podcast podcast) {
        entityManager.persist(podcast);
    }
    
    public void deletePodcast(Podcast podcast) {
        entityManager.remove(podcast);
    }
}
