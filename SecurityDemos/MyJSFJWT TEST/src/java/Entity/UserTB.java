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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "UserTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTB.findAll", query = "SELECT u FROM UserTB u"),
    @NamedQuery(name = "UserTB.findByUserId", query = "SELECT u FROM UserTB u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserTB.findByUserName", query = "SELECT u FROM UserTB u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserTB.findByPassword", query = "SELECT u FROM UserTB u WHERE u.password = :password"),
    @NamedQuery(name = "UserTB.findByEmailId", query = "SELECT u FROM UserTB u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserTB.findByContactNo", query = "SELECT u FROM UserTB u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "UserTB.findByIsActive", query = "SELECT u FROM UserTB u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "UserTB.findByIsDelete", query = "SELECT u FROM UserTB u WHERE u.isDelete = :isDelete"),
    @NamedQuery(name = "UserTB.findByAddedOn", query = "SELECT u FROM UserTB u WHERE u.addedOn = :addedOn"),
    @NamedQuery(name = "UserTB.findByModifiedOn", query = "SELECT u FROM UserTB u WHERE u.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "UserTB.findByEnteredTerminal", query = "SELECT u FROM UserTB u WHERE u.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "UserTB.findByUpdatedTerminal", query = "SELECT u FROM UserTB u WHERE u.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "UserTB.findByTimestamp", query = "SELECT u FROM UserTB u WHERE u.timestamp = :timestamp")})
public class UserTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "EmailId")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "ContactNo")
    private String contactNo;
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
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne
    private AdminTB adminId;
    @JoinColumn(name = "AgentId", referencedColumnName = "AgentId")
    @ManyToOne
    private AgentTB agentId;
    @JoinColumn(name = "GroupId", referencedColumnName = "GroupId")
    @ManyToOne(optional = false)
    private GroupTB groupId;
    @JoinColumn(name = "InsureddId", referencedColumnName = "InsuredId")
    @ManyToOne
    private InsuredTB insureddId;
    @JoinColumn(name = "StaffId", referencedColumnName = "StaffId")
    @ManyToOne
    private StaffTB staffId;

    public UserTB() {
    }

    public UserTB(Integer userId) {
        this.userId = userId;
    }

    public UserTB(Integer userId, String userName, String password, String emailId, String contactNo, boolean isActive, boolean isDelete, Date timestamp) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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

    public AdminTB getAdminId() {
        return adminId;
    }

    public void setAdminId(AdminTB adminId) {
        this.adminId = adminId;
    }

    public AgentTB getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentTB agentId) {
        this.agentId = agentId;
    }

    public GroupTB getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupTB groupId) {
        this.groupId = groupId;
    }

    public InsuredTB getInsureddId() {
        return insureddId;
    }

    public void setInsureddId(InsuredTB insureddId) {
        this.insureddId = insureddId;
    }

    public StaffTB getStaffId() {
        return staffId;
    }

    public void setStaffId(StaffTB staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTB)) {
            return false;
        }
        UserTB other = (UserTB) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserTB[ userId=" + userId + " ]";
    }
    
}
