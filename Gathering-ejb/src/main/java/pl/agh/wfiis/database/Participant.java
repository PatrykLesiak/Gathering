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
@Table(name = "PARTICIPANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participant.findAll", query = "SELECT p FROM Participant p"),
    @NamedQuery(name = "Participant.findByParticipantid", query = "SELECT p FROM Participant p WHERE p.participantid = :participantid"),
    @NamedQuery(name = "Participant.findByName", query = "SELECT p FROM Participant p WHERE p.name = :name"),
    @NamedQuery(name = "Participant.findBySurname", query = "SELECT p FROM Participant p WHERE p.surname = :surname"),
    @NamedQuery(name = "Participant.findByAge", query = "SELECT p FROM Participant p WHERE p.age = :age"),
    @NamedQuery(name = "Participant.findByEmail", query = "SELECT p FROM Participant p WHERE p.email = :email"),
    @NamedQuery(name = "Participant.findBySex", query = "SELECT p FROM Participant p WHERE p.sex = :sex"),
    @NamedQuery(name = "Participant.findByPassword", query = "SELECT p FROM Participant p WHERE p.password = :password")})
public class Participant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARTICIPANTID")
    private Integer participantid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SURNAME")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE")
    private int age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SEX")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participantId")
    private Collection<UsersGroups> usersGroupsCollection;

    public Participant() {
    }

    public Participant(Integer participantid) {
        this.participantid = participantid;
    }

    public Participant(Integer participantid, String name, String surname, int age, String email, String sex, String password) {
        this.participantid = participantid;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    public Integer getParticipantid() {
        return participantid;
    }

    public void setParticipantid(Integer participantid) {
        this.participantid = participantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<UsersGroups> getUsersGroupsCollection() {
        return usersGroupsCollection;
    }

    public void setUsersGroupsCollection(Collection<UsersGroups> usersGroupsCollection) {
        this.usersGroupsCollection = usersGroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantid != null ? participantid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participant)) {
            return false;
        }
        Participant other = (Participant) object;
        if ((this.participantid == null && other.participantid != null) || (this.participantid != null && !this.participantid.equals(other.participantid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.Participant[ participantid=" + participantid + " ]";
    }
    
}
