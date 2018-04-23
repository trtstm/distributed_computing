/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
    //Some native sql queries to be performed. 
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByEmailAndPassword", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")

})

/**
 *
 * @author timo
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    public enum Gender {
        MALE, FEMALE
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email", unique = true)
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "username", unique = true)
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "first_name")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "last_name")
    private String lastName;
        
    @Basic(optional = true)
    @Size(min = 1, max = 128)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @Column(name = "is_admin")
    private boolean isAdmin = false;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Basic(optional = false)
    @Column(name = "gender")
    private Gender gender;
    
    @Basic(optional = false)
    @Column(name = "has_categories")
    private boolean hasCategories = false;
    
    @OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
    private List<Track> tracks = new ArrayList<Track>();
    
    @OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
    private List<Board> boards = new ArrayList<Board>();
    
    @ManyToMany
    @JoinTable(
      name="BOARD_FOLLOWERS",
      joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="board_id", referencedColumnName="id"))
    private List<Board> followedBoards = new ArrayList<Board>();

    public List<Track> getTracks() {
        return tracks;
    }
    
    public void addTrack(Track track) {
        track.setUser(this);
        tracks.add(track);
    }
    
    public List<Board> getBoards() {
        return boards;
    }
    
    public void addBoard(Board board) {
        boards.add(board);
    }
    
    public List<Board> getFollowedBoards() {
        return followedBoards;
    }
    
    public void addFollowedBoard(Board board) {
        followedBoards.add(board);
    }
    
    public boolean hasCategories() {
        return hasCategories;
    }

    public void setHasCategories(boolean hasCategories) {
        this.hasCategories = hasCategories;
    }
        
    @Transient
    boolean anonymous = false;
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
   
    public boolean isAnonymous() {
        return this.anonymous;
    }
    
    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.User[ id=" + id + " ]";
    }
    
}
