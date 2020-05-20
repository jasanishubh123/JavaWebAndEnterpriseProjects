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
@Table(name = "StateTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateTB.findAll", query = "SELECT s FROM StateTB s"),
    @NamedQuery(name = "StateTB.findByStateId", query = "SELECT s FROM StateTB s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "StateTB.findByState", query = "SELECT s FROM StateTB s WHERE s.state = :state"),
    @NamedQuery(name = "StateTB.findByIsActive", query = "SELECT s FROM StateTB s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "StateTB.findByIsDelete", query = "SELECT s FROM StateTB s WHERE s.isDelete = :isDelete"),
    @NamedQuery(name = "StateTB.findByAddedOn", query = "SELECT s FROM StateTB s WHERE s.addedOn = :addedOn"),
    @NamedQuery(name = "StateTB.findByModifiedOn", query = "SELECT s FROM StateTB s WHERE s.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "StateTB.findByEnteredTerminal", query = "SELECT s FROM StateTB s WHERE s.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "StateTB.findByUpdatedTerminal", query = "SELECT s FROM StateTB s WHERE s.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "StateTB.findByTimestamp", query = "SELECT s FROM StateTB s WHERE s.timestamp = :timestamp")})
public class StateTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StateId")
    private Integer stateId;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<CityTB> cityTBCollection;

    public StateTB() {
    }

    public StateTB(Integer stateId) {
        this.stateId = stateId;
    }

    public StateTB(Integer stateId, String state, boolean isActive, boolean isDelete, Date timestamp) {
        this.stateId = stateId;
        this.state = state;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    public Collection<CityTB> getCityTBCollection() {
        return cityTBCollection;
    }

    public void setCityTBCollection(Collection<CityTB> cityTBCollection) {
        this.cityTBCollection = cityTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateTB)) {
            return false;
        }
        StateTB other = (StateTB) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StateTB[ stateId=" + stateId + " ]";
    }
    
}
