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
import models.Board;
import models.Category;
import models.Podcast;
import models.Track;
import models.User;
import models.UserLogin;
        
@Stateless
public class BoardRepository {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;
    
    public Board getById(long id) {
            try {
                Object rawBoard = this.entityManager.createNamedQuery("Board.findById")
                        .setParameter("id", id)
                        .getSingleResult();
                if(rawBoard instanceof Board) {
                    Board t = (Board)rawBoard;
                    return t;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
       
    public List<Board> getAll() {
       return this.entityManager.createNamedQuery("Board.findAll")
                .getResultList();
    }
    
    public void save(Board board) {
        entityManager.merge(board);
    }
    
    public void add(Board board) {
        entityManager.persist(board);
    }
}
