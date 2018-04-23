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
import models.Track;
import models.User;
import models.UserLogin;
        
@Stateless
public class TrackRepository {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;
    
    public Track getById(long id) {
            try {
                Object rawTrack = this.entityManager.createNamedQuery("Track.findById")
                        .setParameter("id", id)
                        .getSingleResult();
                if(rawTrack instanceof Track) {
                    Track t = (Track)rawTrack;
                    return t;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
   
    public Track getByExternalId(long id) {
        try {
            Object rawTrack = this.entityManager.createNamedQuery("Track.findByExternalId")
                    .setParameter("id", id)
                    .getSingleResult();
            if(rawTrack instanceof Track) {
                Track t = (Track)rawTrack;
                return t;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
    
    public List<Track> getAll() {
       return this.entityManager.createNamedQuery("Track.findAll")
                .getResultList();
    }
    
    public List<Track> findRecommendations(User user) {
       return this.entityManager.createNamedQuery("Track.findRecommendations")
               .setParameter("u", user)
                .getResultList();
    }
           
    public void save(Track track) {
        entityManager.merge(track);
    }
    
    public void addTrack(Track track) {
        entityManager.persist(track);
    }
    
    public void deleteTrack(Track track) {
        entityManager.remove(track);
    }
}
