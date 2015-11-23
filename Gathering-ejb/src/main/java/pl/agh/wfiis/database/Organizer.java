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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "ORGANIZER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizer.findAll", query = "SELECT o FROM Organizer o"),
    @NamedQuery(name = "Organizer.findByOrganizerid", query = "SELECT o FROM Organizer o WHERE o.organizerid = :organizerid"),
    @NamedQuery(name = "Organizer.findByCompanyname", query = "SELECT o FROM Organizer o WHERE o.companyname = :companyname"),
    @NamedQuery(name = "Organizer.findByCompanyidentificationnumber", query = "SELECT o FROM Organizer o WHERE o.companyidentificationnumber = :companyidentificationnumber"),
    @NamedQuery(name = "Organizer.findByRepresentativename", query = "SELECT o FROM Organizer o WHERE o.representativename = :representativename"),
    @NamedQuery(name = "Organizer.findByRepresentativesurname", query = "SELECT o FROM Organizer o WHERE o.representativesurname = :representativesurname"),
    @NamedQuery(name = "Organizer.findByEmail", query = "SELECT o FROM Organizer o WHERE o.email = :email"),
    @NamedQuery(name = "Organizer.findByPhonenumber", query = "SELECT o FROM Organizer o WHERE o.phonenumber = :phonenumber"),
    @NamedQuery(name = "Organizer.findByAccountnumber", query = "SELECT o FROM Organizer o WHERE o.accountnumber = :accountnumber")})
public class Organizer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORGANIZERID")
    private Integer organizerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPANYIDENTIFICATIONNUMBER")
    private int companyidentificationnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REPRESENTATIVENAME")
    private String representativename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REPRESENTATIVESURNAME")
    private String representativesurname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONENUMBER")
    private int phonenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNTNUMBER")
    private int accountnumber;

    public Organizer() {
    }

    public Organizer(Integer organizerid) {
        this.organizerid = organizerid;
    }

    public Organizer(Integer organizerid, String companyname, int companyidentificationnumber, String representativename, String representativesurname, String email, int phonenumber, int accountnumber) {
        this.organizerid = organizerid;
        this.companyname = companyname;
        this.companyidentificationnumber = companyidentificationnumber;
        this.representativename = representativename;
        this.representativesurname = representativesurname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.accountnumber = accountnumber;
    }

    public Integer getOrganizerid() {
        return organizerid;
    }

    public void setOrganizerid(Integer organizerid) {
        this.organizerid = organizerid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getCompanyidentificationnumber() {
        return companyidentificationnumber;
    }

    public void setCompanyidentificationnumber(int companyidentificationnumber) {
        this.companyidentificationnumber = companyidentificationnumber;
    }

    public String getRepresentativename() {
        return representativename;
    }

    public void setRepresentativename(String representativename) {
        this.representativename = representativename;
    }

    public String getRepresentativesurname() {
        return representativesurname;
    }

    public void setRepresentativesurname(String representativesurname) {
        this.representativesurname = representativesurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizerid != null ? organizerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizer)) {
            return false;
        }
        Organizer other = (Organizer) object;
        if ((this.organizerid == null && other.organizerid != null) || (this.organizerid != null && !this.organizerid.equals(other.organizerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.agh.wfiis.database.Organizer[ organizerid=" + organizerid + " ]";
    }
    
}
