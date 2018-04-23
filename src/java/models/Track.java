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
    @NamedQuery(name = "Track.findById", query = "SELECT p FROM Track p WHERE p.id = :id"),
    @NamedQuery(name = "Track.findAll", query = "SELECT p FROM Track p"),
    @NamedQuery(name = "Track.findByExternalId", query = "SELECT p FROM Track p WHERE p.externalId = :id"),    
})

/**
 *
 * @author timo
 */
@Entity
@Table(name = "tracks")
public class Track implements Serializable {
    public static class TrackExcl implements ExclusionStrategy {

        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {

            return (f.getDeclaringClass() == User.class && f.getName().equals("tracks"));
        }

    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "external_id")
    private Long externalId;
   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = true)
    @Size(min = 1, max = 128)
    @Column(name = "artwork_url")
    private String artworkUrl;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private Integer duration;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "stream_url")
    private String streamUrl;

    @Basic(optional = true)
    @NotNull
    @Column(name = "description", columnDefinition="clob")
    private String description;

    //@ManyToOne(fetch=FetchType.LAZY)
    //@NotNull
    //@JoinColumn(name="podcast_id")
    //private Podcast podcast;
    
    @ManyToOne()
    @NotNull
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToMany(mappedBy = "tracks")
    private List<Board> boards = new ArrayList<Board>();

    public List<Board> getBoards() {
        return boards;
    }
    
    public void addBoard(Board board) {
        boards.add(board);
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Podcast getPodcast() {
        //return podcast;
        return null;
    }

    public void setPodcast(Podcast podcast) {
        //this.podcast = podcast;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
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
