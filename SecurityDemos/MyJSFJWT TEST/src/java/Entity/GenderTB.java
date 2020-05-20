/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snehal
 */
@Entity
@Table(name = "GenderTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenderTB.findAll", query = "SELECT g FROM GenderTB g"),
    @NamedQuery(name = "GenderTB.findByGenderId", query = "SELECT g FROM GenderTB g WHERE g.genderId = :genderId"),
    @NamedQuery(name = "GenderTB.findByGender", query = "SELECT g FROM GenderTB g WHERE g.gender = :gender"),
    @NamedQuery(name = "GenderTB.findByIsActive", query = "SELECT g FROM GenderTB g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GenderTB.findByIsDelete", query = "SELECT g FROM GenderTB g WHERE g.isDelete = :isDelete"),
    @NamedQuery(name = "GenderTB.findByAddedOn", query = "SELECT g FROM GenderTB g WHERE g.addedOn = :addedOn"),
    @NamedQuery(name = "GenderTB.findByModifiedOn", query = "SELECT g FROM GenderTB g WHERE g.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "GenderTB.findByEnteredTerminal", query = "SELECT g FROM GenderTB g WHERE g.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "GenderTB.findByUpdatedTerminal", query = "SELECT g FROM GenderTB g WHERE g.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "GenderTB.findByTimestamp", query = "SELECT g FROM GenderTB g WHERE g.timestamp = :timestamp")})
public class GenderTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GenderId")
    private Integer genderId;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "IsDelete")
    private boolean isDelete;
    @Column(name = "AddedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;
    @Column(name = "ModifiedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "EnteredTerminal")
    private String enteredTerminal;
    @Column(name = "UpdatedTerminal")
    private String updatedTerminal;
    @Basic(optional = false)
    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId")
    private Collection<InsuredTB> insuredTBCollection;

    public GenderTB() {
    }

    public GenderTB(Integer genderId) {
        this.genderId = genderId;
    }

    public GenderTB(Integer genderId, String gender, boolean isActive, boolean isDelete, Date timestamp) {
        this.genderId = genderId;
        this.gender = gender;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getEnteredTerminal() {
        return enteredTerminal;
    }

    public void setEnteredTerminal(String enteredTerminal) {
        this.enteredTerminal = enteredTerminal;
    }

    public String getUpdatedTerminal() {
        return updatedTerminal;
    }

    public void setUpdatedTerminal(String updatedTerminal) {
        this.updatedTerminal = updatedTerminal;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @XmlTransient
    public Collection<InsuredTB> getInsuredTBCollection() {
        return insuredTBCollection;
    }

    public void setInsuredTBCollection(Collection<InsuredTB> insuredTBCollection) {
        this.insuredTBCollection = insuredTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenderTB)) {
            return false;
        }
        GenderTB other = (GenderTB) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.GenderTB[ genderId=" + genderId + " ]";
    }
    
}
