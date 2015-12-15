/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.wfiis.database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "CATHEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cathegory.findAll", query = "SELECT c FROM Cathegory c"),
    @NamedQuery(name = "Cathegory.findByCathegoryid", query = "SELECT c FROM Cathegory c WHERE c.cathegoryid = :cathegoryid"),
    @NamedQuery(name = "Cathegory.findByName", query = "SELECT c FROM Cathegory c WHERE c.name = :name")})
public class Cathegory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATHEGORYID")
    private Integer cathegoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cathegory")
    private Collection<EventsToCathegory> eventsToCathegoryCollection;

    public Cathegory() {
    }

    public Cathegory(Integer cathegoryid) {
        this.cathegoryid = cathegoryid;
    }

    public Cathegory(Integer cathegoryid, String name) {
        this.cathegoryid = cathegoryid;
        this.name = name;
    }

    public Integer getCathegoryid() {
        return cathegoryid;
    }

    public void setCathegoryid(Integer cathegoryid) {
        this.cathegoryid = cathegoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<EventsToCathegory> getEventsToCathegoryCollection() {
        return eventsToCathegoryCollection;
    }

    public void setEventsToCathegoryCollection(Collection<EventsToCathegory> eventsToCathegoryCollection) {
        this.eventsToCathegoryCollection = eventsToCathegoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cathegoryid != null ? cathegoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cathegory)) {
            return false;
        }
        Cathegory other = (Cathegory) object;
        if ((this.cathegoryid == null && other.cathegoryid != null) || (this.cathegoryid != null && !this.cathegoryid.equals(other.cathegoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.Cathegory[ cathegoryid=" + cathegoryid + " ]";
    }
    
}
