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
@Table(name = "OccupationTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OccupationTypeTB.findAll", query = "SELECT o FROM OccupationTypeTB o"),
    @NamedQuery(name = "OccupationTypeTB.findByOccupationTypeId", query = "SELECT o FROM OccupationTypeTB o WHERE o.occupationTypeId = :occupationTypeId"),
    @NamedQuery(name = "OccupationTypeTB.findByOccupation", query = "SELECT o FROM OccupationTypeTB o WHERE o.occupation = :occupation"),
    @NamedQuery(name = "OccupationTypeTB.findByIsActive", query = "SELECT o FROM OccupationTypeTB o WHERE o.isActive = :isActive"),
    @NamedQuery(name = "OccupationTypeTB.findByIsDelete", query = "SELECT o FROM OccupationTypeTB o WHERE o.isDelete = :isDelete"),
    @NamedQuery(name = "OccupationTypeTB.findByAddedOn", query = "SELECT o FROM OccupationTypeTB o WHERE o.addedOn = :addedOn"),
    @NamedQuery(name = "OccupationTypeTB.findByModifiedOn", query = "SELECT o FROM OccupationTypeTB o WHERE o.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "OccupationTypeTB.findByEnteredTerminal", query = "SELECT o FROM OccupationTypeTB o WHERE o.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "OccupationTypeTB.findByUpdatedTerminal", query = "SELECT o FROM OccupationTypeTB o WHERE o.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "OccupationTypeTB.findByTimestamp", query = "SELECT o FROM OccupationTypeTB o WHERE o.timestamp = :timestamp")})
public class OccupationTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OccupationTypeId")
    private Integer occupationTypeId;
    @Basic(optional = false)
    @Column(name = "Occupation")
    private String occupation;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupationTypeId")
    private Collection<OccupationDetailsOfInsuredTB> occupationDetailsOfInsuredTBCollection;

    public OccupationTypeTB() {
    }

    public OccupationTypeTB(Integer occupationTypeId) {
        this.occupationTypeId = occupationTypeId;
    }

    public OccupationTypeTB(Integer occupationTypeId, String occupation, boolean isActive, boolean isDelete, Date timestamp) {
        this.occupationTypeId = occupationTypeId;
        this.occupation = occupation;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getOccupationTypeId() {
        return occupationTypeId;
    }

    public void setOccupationTypeId(Integer occupationTypeId) {
        this.occupationTypeId = occupationTypeId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
    public Collection<OccupationDetailsOfInsuredTB> getOccupationDetailsOfInsuredTBCollection() {
        return occupationDetailsOfInsuredTBCollection;
    }

    public void setOccupationDetailsOfInsuredTBCollection(Collection<OccupationDetailsOfInsuredTB> occupationDetailsOfInsuredTBCollection) {
        this.occupationDetailsOfInsuredTBCollection = occupationDetailsOfInsuredTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationTypeId != null ? occupationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationTypeTB)) {
            return false;
        }
        OccupationTypeTB other = (OccupationTypeTB) object;
        if ((this.occupationTypeId == null && other.occupationTypeId != null) || (this.occupationTypeId != null && !this.occupationTypeId.equals(other.occupationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OccupationTypeTB[ occupationTypeId=" + occupationTypeId + " ]";
    }
    
}
