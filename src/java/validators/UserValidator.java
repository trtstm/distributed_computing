/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import repositories.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletRequest;
import models.User;
import models.User.Gender;
import utils.ErrorMap;
        
@Stateful
@SessionScoped
public class UserValidator {  
    @EJB
    private UserRepository userRepo;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public ErrorMap getErrors() {
        return errors;
    }
            
    private String email;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    private String country;
    private Gender gender;
    private ErrorMap errors;
    
    
    
    public void validate(HttpServletRequest request) {
        errors = new ErrorMap();
        
        String email = request.getParameter("email");
        if(email == null || email.length() < 5 || !email.contains("@")) {
            errors.addError("email", "Invalid email.");
        } else if(userRepo.getByEmail(email) != null) {
            errors.addError("email", "Email is already taken.");
        }
        this.email = email;
        
        String password = request.getParameter("password");
        if(password.length() < 5) {
            errors.addError("password", "Password should contain atleast 5 characters.");
        }
        this.password = password;
        
        String username = request.getParameter("username");
        if(username.length() < 5) {
            errors.addError("username", "Username should contain atleast 5 characters.");
        } else if(userRepo.getByUsername(username) != null) {
            errors.addError("username", "Username is already taken.");
        }
        this.username = username;
        
        
        String firstName = request.getParameter("first_name");
        if(firstName.length() < 2) {
            errors.addError("first_name", "First name should contain atleast 2 characters.");
        }
        this.firstName = firstName;
        
        String lastName = request.getParameter("last_name");
        if(lastName.length() < 2) {
            errors.addError("last_name", "Last name should contain atleast 2 characters.");
        }
        this.lastName = lastName;
        
        String country = request.getParameter("country");
        if(country.length() > 0) {
            this.country = country;
        }
        
        String gender = request.getParameter("gender");
        if(gender == null) {
            errors.addError("gender", "Please select a gender.");
        } else if(gender.equals("M")) {
            this.gender = Gender.MALE;
        } else if(gender.equals("F")) {
            this.gender = Gender.FEMALE;
        } else {
            errors.addError("gender", "Please select a gender.");
        }
        
    }
}
