/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
    @NamedQuery(name = "Board.findById", query = "SELECT p FROM Board p WHERE p.id = :id"),
    @NamedQuery(name = "Board.findAll", query = "SELECT p FROM Board p"),
})

/**
 *
 * @author timo
 */
@Entity
@Table(name = "boards")
public class Board implements Serializable {
    public static class BoardExcl implements ExclusionStrategy {

        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {

            return (f.getDeclaringClass() == User.class && f.getName().equals("boards"));
        }

    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
      
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @Column(name = "private")
    private boolean isPrivate;
    
    
    @ManyToOne()
    @NotNull
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToMany(mappedBy = "followedBoards")
    private List<User> followers = new ArrayList<User>();
    
    @ManyToMany
    @JoinTable(
      name="BOARD_TRACKS",
      joinColumns=@JoinColumn(name="board_id", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="track_id", referencedColumnName="id"))
    private List<Track> tracks = new ArrayList<Track>();
    
    public List<Track> getTracks() {
        return tracks;
    }
    
    public void addTrack(Track track) {
        track.addBoard(this);
        tracks.add(track);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getFollowers() {
        return followers;
    }
    
    public void addFollower(User user) {
        this.followers.add(user);
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
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
        if (!(object instanceof Board)) {
            return false;
        }
        Board other = (Board) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Podcast[ id=" + id + " ]";
    }
    
}
