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
@Table(name = "MaritalStatusTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaritalStatusTB.findAll", query = "SELECT m FROM MaritalStatusTB m"),
    @NamedQuery(name = "MaritalStatusTB.findByMaritalStatusId", query = "SELECT m FROM MaritalStatusTB m WHERE m.maritalStatusId = :maritalStatusId"),
    @NamedQuery(name = "MaritalStatusTB.findByMaritalStatus", query = "SELECT m FROM MaritalStatusTB m WHERE m.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "MaritalStatusTB.findByIsActive", query = "SELECT m FROM MaritalStatusTB m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaritalStatusTB.findByIsDelete", query = "SELECT m FROM MaritalStatusTB m WHERE m.isDelete = :isDelete"),
    @NamedQuery(name = "MaritalStatusTB.findByAddedOn", query = "SELECT m FROM MaritalStatusTB m WHERE m.addedOn = :addedOn"),
    @NamedQuery(name = "MaritalStatusTB.findByModifiedOn", query = "SELECT m FROM MaritalStatusTB m WHERE m.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "MaritalStatusTB.findByEnteredTerminal", query = "SELECT m FROM MaritalStatusTB m WHERE m.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "MaritalStatusTB.findByUpdatedTerminal", query = "SELECT m FROM MaritalStatusTB m WHERE m.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "MaritalStatusTB.findByTimestamp", query = "SELECT m FROM MaritalStatusTB m WHERE m.timestamp = :timestamp")})
public class MaritalStatusTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaritalStatusId")
    private Integer maritalStatusId;
    @Basic(optional = false)
    @Column(name = "MaritalStatus")
    private String maritalStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maritalStatusId")
    private Collection<InsuredTB> insuredTBCollection;

    public MaritalStatusTB() {
    }

    public MaritalStatusTB(Integer maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public MaritalStatusTB(Integer maritalStatusId, String maritalStatus, boolean isActive, boolean isDelete, Date timestamp) {
        this.maritalStatusId = maritalStatusId;
        this.maritalStatus = maritalStatus;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(Integer maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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
        hash += (maritalStatusId != null ? maritalStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaritalStatusTB)) {
            return false;
        }
        MaritalStatusTB other = (MaritalStatusTB) object;
        if ((this.maritalStatusId == null && other.maritalStatusId != null) || (this.maritalStatusId != null && !this.maritalStatusId.equals(other.maritalStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.MaritalStatusTB[ maritalStatusId=" + maritalStatusId + " ]";
    }
    
}
