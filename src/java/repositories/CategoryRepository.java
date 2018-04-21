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
import models.User;
import models.UserLogin;
        
@Stateless
public class CategoryRepository {  
    @PersistenceContext(unitName = "pinterestPU")
    private EntityManager entityManager;
    
    public Category getById(long id) {
            try {
                Object rawCategory = this.entityManager.createNamedQuery("Category.findById")
                        .setParameter("id", id)
                        .getSingleResult();
                if(rawCategory instanceof Category) {
                    Category c = (Category)rawCategory;
                    return c;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
    
    
    public Category getByName(String name) {
            try {
                Object rawCategory = this.entityManager.createNamedQuery("User.findByName")
                        .setParameter("name", name)
                        .getSingleResult();
                if(rawCategory instanceof Category) {
                    Category c = (Category)rawCategory;
                    return c;
                }
            } catch(NoResultException e) {
                return null;
            }
            
            return null;
    }
       
    public void save(Category category) {
        entityManager.merge(category);
    }
    
    public void addCategory(Category category) {
        entityManager.persist(category);
    }
    
    public void deleteCategory(Category category) {
        entityManager.remove(category);
    }
}
