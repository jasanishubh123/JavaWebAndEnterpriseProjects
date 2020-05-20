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
@Table(name = "GroupTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupTB.findAll", query = "SELECT g FROM GroupTB g"),
    @NamedQuery(name = "GroupTB.findByGroupId", query = "SELECT g FROM GroupTB g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupTB.findByGroupName", query = "SELECT g FROM GroupTB g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "GroupTB.findByIsActive", query = "SELECT g FROM GroupTB g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GroupTB.findByIsDelete", query = "SELECT g FROM GroupTB g WHERE g.isDelete = :isDelete"),
    @NamedQuery(name = "GroupTB.findByAddedOn", query = "SELECT g FROM GroupTB g WHERE g.addedOn = :addedOn"),
    @NamedQuery(name = "GroupTB.findByModifiedOn", query = "SELECT g FROM GroupTB g WHERE g.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "GroupTB.findByEnteredTerminal", query = "SELECT g FROM GroupTB g WHERE g.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "GroupTB.findByUpdatedTerminal", query = "SELECT g FROM GroupTB g WHERE g.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "GroupTB.findByTimestamp", query = "SELECT g FROM GroupTB g WHERE g.timestamp = :timestamp")})
public class GroupTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GroupId")
    private Integer groupId;
    @Basic(optional = false)
    @Column(name = "GroupName")
    private String groupName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<UserTB> userTBCollection;

    public GroupTB() {
    }

    public GroupTB(Integer groupId) {
        this.groupId = groupId;
    }

    public GroupTB(Integer groupId, String groupName, boolean isActive, boolean isDelete, Date timestamp) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTB)) {
            return false;
        }
        GroupTB other = (GroupTB) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.GroupTB[ groupId=" + groupId + " ]";
    }
    
}
