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
@Table(name = "ORGANIZERS_GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizersGroups.findAll", query = "SELECT o FROM OrganizersGroups o"),
    @NamedQuery(name = "OrganizersGroups.findById", query = "SELECT o FROM OrganizersGroups o WHERE o.id = :id")})
public class OrganizersGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ORGANIZER_ID", referencedColumnName = "ORGANIZERID")
    @ManyToOne(optional = false)
    private Organizer organizerId;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    @ManyToOne(optional = false)
    private Groups groupId;

    public OrganizersGroups() {
    }

    public OrganizersGroups(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organizer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Organizer organizerId) {
        this.organizerId = organizerId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof OrganizersGroups)) {
            return false;
        }
        OrganizersGroups other = (OrganizersGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.OrganizersGroups[ id=" + id + " ]";
    }
    
}
