/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.wfiis.database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventid", query = "SELECT e FROM Event e WHERE e.eventid = :eventid"),
    @NamedQuery(name = "Event.findByTitle", query = "SELECT e FROM Event e WHERE e.title = :title"),
    @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description"),
    @NamedQuery(name = "Event.findByEventdate", query = "SELECT e FROM Event e WHERE e.eventdate = :eventdate"),
    @NamedQuery(name = "Event.findByPlace", query = "SELECT e FROM Event e WHERE e.place = :place"),
    @NamedQuery(name = "Event.findByPicturelink", query = "SELECT e FROM Event e WHERE e.picturelink = :picturelink"),
    @NamedQuery(name = "Event.findByMaxamountofparticipants", query = "SELECT e FROM Event e WHERE e.maxamountofparticipants = :maxamountofparticipants"),
    @NamedQuery(name = "Event.findByPrice", query = "SELECT e FROM Event e WHERE e.price = :price"),
    @NamedQuery(name = "Event.findByCurrency", query = "SELECT e FROM Event e WHERE e.currency = :currency"),
    @NamedQuery(name = "Event.findByMinimalage", query = "SELECT e FROM Event e WHERE e.minimalage = :minimalage"),
    @NamedQuery(name = "Event.findByMaximalage", query = "SELECT e FROM Event e WHERE e.maximalage = :maximalage")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENTID")
    private Integer eventid;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 1024)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EVENTDATE")
    @Temporal(TemporalType.DATE)
    private Date eventdate;
    @Size(max = 255)
    @Column(name = "PLACE")
    private String place;
    @Size(max = 255)
    @Column(name = "PICTURELINK")
    private String picturelink;
    @Column(name = "MAXAMOUNTOFPARTICIPANTS")
    private Integer maxamountofparticipants;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Size(max = 3)
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "MINIMALAGE")
    private Integer minimalage;
    @Column(name = "MAXIMALAGE")
    private Integer maximalage;
    @JoinColumn(name = "ORGANIZER", referencedColumnName = "ORGANIZERID")
    @ManyToOne(optional = false)
    private Organizer organizer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<EventsToCathegory> eventsToCathegoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<ParticipantToEvent> participantToEventCollection;

    public Event() {
    }

    public Event(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    public Integer getMaxamountofparticipants() {
        return maxamountofparticipants;
    }

    public void setMaxamountofparticipants(Integer maxamountofparticipants) {
        this.maxamountofparticipants = maxamountofparticipants;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMinimalage() {
        return minimalage;
    }

    public void setMinimalage(Integer minimalage) {
        this.minimalage = minimalage;
    }

    public Integer getMaximalage() {
        return maximalage;
    }

    public void setMaximalage(Integer maximalage) {
        this.maximalage = maximalage;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @XmlTransient
    public Collection<EventsToCathegory> getEventsToCathegoryCollection() {
        return eventsToCathegoryCollection;
    }

    public void setEventsToCathegoryCollection(Collection<EventsToCathegory> eventsToCathegoryCollection) {
        this.eventsToCathegoryCollection = eventsToCathegoryCollection;
    }

    @XmlTransient
    public Collection<ParticipantToEvent> getParticipantToEventCollection() {
        return participantToEventCollection;
    }

    public void setParticipantToEventCollection(Collection<ParticipantToEvent> participantToEventCollection) {
        this.participantToEventCollection = participantToEventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.Event[ eventid=" + eventid + " ]";
    }
    
}
