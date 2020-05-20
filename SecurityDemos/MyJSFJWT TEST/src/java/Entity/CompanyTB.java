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
@Table(name = "CompanyTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyTB.findAll", query = "SELECT c FROM CompanyTB c"),
    @NamedQuery(name = "CompanyTB.findByCompanyId", query = "SELECT c FROM CompanyTB c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "CompanyTB.findByCompanyName", query = "SELECT c FROM CompanyTB c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CompanyTB.findByContactNo1", query = "SELECT c FROM CompanyTB c WHERE c.contactNo1 = :contactNo1"),
    @NamedQuery(name = "CompanyTB.findByContactNo2", query = "SELECT c FROM CompanyTB c WHERE c.contactNo2 = :contactNo2"),
    @NamedQuery(name = "CompanyTB.findByEmailId", query = "SELECT c FROM CompanyTB c WHERE c.emailId = :emailId"),
    @NamedQuery(name = "CompanyTB.findByIsActive", query = "SELECT c FROM CompanyTB c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CompanyTB.findByIsDelete", query = "SELECT c FROM CompanyTB c WHERE c.isDelete = :isDelete"),
    @NamedQuery(name = "CompanyTB.findByAddedOn", query = "SELECT c FROM CompanyTB c WHERE c.addedOn = :addedOn"),
    @NamedQuery(name = "CompanyTB.findByModifiedOn", query = "SELECT c FROM CompanyTB c WHERE c.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "CompanyTB.findByEnteredTerminal", query = "SELECT c FROM CompanyTB c WHERE c.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "CompanyTB.findByUpdatedTerminal", query = "SELECT c FROM CompanyTB c WHERE c.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "CompanyTB.findByTimeStamp", query = "SELECT c FROM CompanyTB c WHERE c.timeStamp = :timeStamp")})
public class CompanyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompanyId")
    private Integer companyId;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "ContactNo1")
    private String contactNo1;
    @Column(name = "ContactNo2")
    private String contactNo2;
    @Column(name = "EmailId")
    private String emailId;
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
    @Column(name = "TimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @OneToMany(mappedBy = "companyId")
    private Collection<AddressTB> addressTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<PolicyTB> policyTBCollection;

    public CompanyTB() {
    }

    public CompanyTB(Integer companyId) {
        this.companyId = companyId;
    }

    public CompanyTB(Integer companyId, String companyName, String contactNo1, boolean isActive, boolean isDelete) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.contactNo1 = contactNo1;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @XmlTransient
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    @XmlTransient
    public Collection<PolicyTB> getPolicyTBCollection() {
        return policyTBCollection;
    }

    public void setPolicyTBCollection(Collection<PolicyTB> policyTBCollection) {
        this.policyTBCollection = policyTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyTB)) {
            return false;
        }
        CompanyTB other = (CompanyTB) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CompanyTB[ companyId=" + companyId + " ]";
    }
    
}
