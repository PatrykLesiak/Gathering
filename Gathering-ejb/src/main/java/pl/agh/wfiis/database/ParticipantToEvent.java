/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.wfiis.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "PARTICIPANT_TO_EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipantToEvent.findAll", query = "SELECT p FROM ParticipantToEvent p"),
    @NamedQuery(name = "ParticipantToEvent.findById", query = "SELECT p FROM ParticipantToEvent p WHERE p.id = :id")})
public class ParticipantToEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "PARTICIPANT", referencedColumnName = "PARTICIPANTID")
    @ManyToOne(optional = false)
    private Participant participant;
    @JoinColumn(name = "EVENT", referencedColumnName = "EVENTID")
    @ManyToOne(optional = false)
    private Event event;

    public ParticipantToEvent() {
    }

    public ParticipantToEvent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
        if (!(object instanceof ParticipantToEvent)) {
            return false;
        }
        ParticipantToEvent other = (ParticipantToEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.ParticipantToEvent[ id=" + id + " ]";
    }
    
}
