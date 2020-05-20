/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author snehal
 */
@Entity
@Table(name = "User_GroupCredentialTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroupCredentialTB.findAll", query = "SELECT u FROM UserGroupCredentialTB u"),
    @NamedQuery(name = "UserGroupCredentialTB.findByUserGroupCredentialId", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.userGroupCredentialId = :userGroupCredentialId"),
    @NamedQuery(name = "UserGroupCredentialTB.findByGroupId", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.groupId = :groupId"),
    @NamedQuery(name = "UserGroupCredentialTB.findByUserId", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserGroupCredentialTB.findByIsActive", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "UserGroupCredentialTB.findByIsDelete", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.isDelete = :isDelete"),
    @NamedQuery(name = "UserGroupCredentialTB.findByAddedOn", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.addedOn = :addedOn"),
    @NamedQuery(name = "UserGroupCredentialTB.findByModifiedOn", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "UserGroupCredentialTB.findByEnteredTerminal", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "UserGroupCredentialTB.findByUpdatedTerminal", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "UserGroupCredentialTB.findByTimestamp", query = "SELECT u FROM UserGroupCredentialTB u WHERE u.timestamp = :timestamp")})
public class UserGroupCredentialTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "User_GroupCredentialId")
    private Integer userGroupCredentialId;
    @Basic(optional = false)
    @Column(name = "GroupId")
    private int groupId;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;
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

    public UserGroupCredentialTB() {
    }

    public UserGroupCredentialTB(Integer userGroupCredentialId) {
        this.userGroupCredentialId = userGroupCredentialId;
    }

    public UserGroupCredentialTB(Integer userGroupCredentialId, int groupId, int userId, boolean isActive, boolean isDelete, Date timestamp) {
        this.userGroupCredentialId = userGroupCredentialId;
        this.groupId = groupId;
        this.userId = userId;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getUserGroupCredentialId() {
        return userGroupCredentialId;
    }

    public void setUserGroupCredentialId(Integer userGroupCredentialId) {
        this.userGroupCredentialId = userGroupCredentialId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupCredentialId != null ? userGroupCredentialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupCredentialTB)) {
            return false;
        }
        UserGroupCredentialTB other = (UserGroupCredentialTB) object;
        if ((this.userGroupCredentialId == null && other.userGroupCredentialId != null) || (this.userGroupCredentialId != null && !this.userGroupCredentialId.equals(other.userGroupCredentialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserGroupCredentialTB[ userGroupCredentialId=" + userGroupCredentialId + " ]";
    }
    
}
