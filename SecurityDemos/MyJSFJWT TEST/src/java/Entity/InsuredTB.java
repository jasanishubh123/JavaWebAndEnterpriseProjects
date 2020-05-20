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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "InsuredTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuredTB.findAll", query = "SELECT i FROM InsuredTB i"),
    @NamedQuery(name = "InsuredTB.findByInsuredId", query = "SELECT i FROM InsuredTB i WHERE i.insuredId = :insuredId"),
    @NamedQuery(name = "InsuredTB.findByFullName", query = "SELECT i FROM InsuredTB i WHERE i.fullName = :fullName"),
    @NamedQuery(name = "InsuredTB.findByGroupHeadName", query = "SELECT i FROM InsuredTB i WHERE i.groupHeadName = :groupHeadName"),
    @NamedQuery(name = "InsuredTB.findByFatherSpouseName", query = "SELECT i FROM InsuredTB i WHERE i.fatherSpouseName = :fatherSpouseName"),
    @NamedQuery(name = "InsuredTB.findByMaidenName", query = "SELECT i FROM InsuredTB i WHERE i.maidenName = :maidenName"),
    @NamedQuery(name = "InsuredTB.findByPlaceOfBirth", query = "SELECT i FROM InsuredTB i WHERE i.placeOfBirth = :placeOfBirth"),
    @NamedQuery(name = "InsuredTB.findByDob", query = "SELECT i FROM InsuredTB i WHERE i.dob = :dob"),
    @NamedQuery(name = "InsuredTB.findByAge", query = "SELECT i FROM InsuredTB i WHERE i.age = :age"),
    @NamedQuery(name = "InsuredTB.findByAnniversaryDate", query = "SELECT i FROM InsuredTB i WHERE i.anniversaryDate = :anniversaryDate"),
    @NamedQuery(name = "InsuredTB.findByContactNo1", query = "SELECT i FROM InsuredTB i WHERE i.contactNo1 = :contactNo1"),
    @NamedQuery(name = "InsuredTB.findByContactNo2", query = "SELECT i FROM InsuredTB i WHERE i.contactNo2 = :contactNo2"),
    @NamedQuery(name = "InsuredTB.findByEmailId", query = "SELECT i FROM InsuredTB i WHERE i.emailId = :emailId"),
    @NamedQuery(name = "InsuredTB.findByNationality", query = "SELECT i FROM InsuredTB i WHERE i.nationality = :nationality"),
    @NamedQuery(name = "InsuredTB.findByGSTNo", query = "SELECT i FROM InsuredTB i WHERE i.gSTNo = :gSTNo"),
    @NamedQuery(name = "InsuredTB.findByAadharNo", query = "SELECT i FROM InsuredTB i WHERE i.aadharNo = :aadharNo"),
    @NamedQuery(name = "InsuredTB.findByPANNo", query = "SELECT i FROM InsuredTB i WHERE i.pANNo = :pANNo"),
    @NamedQuery(name = "InsuredTB.findByAgeProof", query = "SELECT i FROM InsuredTB i WHERE i.ageProof = :ageProof"),
    @NamedQuery(name = "InsuredTB.findByIsActive", query = "SELECT i FROM InsuredTB i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InsuredTB.findByIsDelete", query = "SELECT i FROM InsuredTB i WHERE i.isDelete = :isDelete"),
    @NamedQuery(name = "InsuredTB.findByAddedOn", query = "SELECT i FROM InsuredTB i WHERE i.addedOn = :addedOn"),
    @NamedQuery(name = "InsuredTB.findByModifiedOn", query = "SELECT i FROM InsuredTB i WHERE i.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "InsuredTB.findByEnteredTerminal", query = "SELECT i FROM InsuredTB i WHERE i.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "InsuredTB.findByUpdatedTerminal", query = "SELECT i FROM InsuredTB i WHERE i.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "InsuredTB.findByTimeStamp", query = "SELECT i FROM InsuredTB i WHERE i.timeStamp = :timeStamp")})
public class InsuredTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InsuredId")
    private Integer insuredId;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "GroupHeadName")
    private String groupHeadName;
    @Basic(optional = false)
    @Column(name = "Father_SpouseName")
    private String fatherSpouseName;
    @Basic(optional = false)
    @Column(name = "MaidenName")
    private String maidenName;
    @Basic(optional = false)
    @Column(name = "PlaceOfBirth")
    private String placeOfBirth;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @Column(name = "AnniversaryDate")
    @Temporal(TemporalType.DATE)
    private Date anniversaryDate;
    @Basic(optional = false)
    @Column(name = "ContactNo1")
    private String contactNo1;
    @Column(name = "ContactNo2")
    private String contactNo2;
    @Column(name = "EmailId")
    private String emailId;
    @Column(name = "Nationality")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "GSTNo")
    private String gSTNo;
    @Basic(optional = false)
    @Column(name = "AadharNo")
    private int aadharNo;
    @Basic(optional = false)
    @Column(name = "PANNo")
    private String pANNo;
    @Basic(optional = false)
    @Column(name = "AgeProof")
    private String ageProof;
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
    @OneToMany(mappedBy = "insureddId")
    private Collection<UserTB> userTBCollection;
    @OneToMany(mappedBy = "insuredId")
    private Collection<AddressTB> addressTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuredId")
    private Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuredId")
    private Collection<OccupationDetailsOfInsuredTB> occupationDetailsOfInsuredTBCollection;
    @JoinColumn(name = "EducationQualificationId", referencedColumnName = "EducationQualificationId")
    @ManyToOne(optional = false)
    private EducationQualificationTB educationQualificationId;
    @JoinColumn(name = "GenderId", referencedColumnName = "GenderId")
    @ManyToOne(optional = false)
    private GenderTB genderId;
    @JoinColumn(name = "MaritalStatusId", referencedColumnName = "MaritalStatusId")
    @ManyToOne(optional = false)
    private MaritalStatusTB maritalStatusId;

    public InsuredTB() {
    }

    public InsuredTB(Integer insuredId) {
        this.insuredId = insuredId;
    }

    public InsuredTB(Integer insuredId, String fullName, String groupHeadName, String fatherSpouseName, String maidenName, String placeOfBirth, Date dob, int age, Date anniversaryDate, String contactNo1, String gSTNo, int aadharNo, String pANNo, String ageProof, boolean isActive, boolean isDelete) {
        this.insuredId = insuredId;
        this.fullName = fullName;
        this.groupHeadName = groupHeadName;
        this.fatherSpouseName = fatherSpouseName;
        this.maidenName = maidenName;
        this.placeOfBirth = placeOfBirth;
        this.dob = dob;
        this.age = age;
        this.anniversaryDate = anniversaryDate;
        this.contactNo1 = contactNo1;
        this.gSTNo = gSTNo;
        this.aadharNo = aadharNo;
        this.pANNo = pANNo;
        this.ageProof = ageProof;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Integer insuredId) {
        this.insuredId = insuredId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupHeadName() {
        return groupHeadName;
    }

    public void setGroupHeadName(String groupHeadName) {
        this.groupHeadName = groupHeadName;
    }

    public String getFatherSpouseName() {
        return fatherSpouseName;
    }

    public void setFatherSpouseName(String fatherSpouseName) {
        this.fatherSpouseName = fatherSpouseName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(Date anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGSTNo() {
        return gSTNo;
    }

    public void setGSTNo(String gSTNo) {
        this.gSTNo = gSTNo;
    }

    public int getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(int aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPANNo() {
        return pANNo;
    }

    public void setPANNo(String pANNo) {
        this.pANNo = pANNo;
    }

    public String getAgeProof() {
        return ageProof;
    }

    public void setAgeProof(String ageProof) {
        this.ageProof = ageProof;
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
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    @XmlTransient
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    @XmlTransient
    public Collection<TransactionOfPolicyTB> getTransactionOfPolicyTBCollection() {
        return transactionOfPolicyTBCollection;
    }

    public void setTransactionOfPolicyTBCollection(Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection) {
        this.transactionOfPolicyTBCollection = transactionOfPolicyTBCollection;
    }

    @XmlTransient
    public Collection<OccupationDetailsOfInsuredTB> getOccupationDetailsOfInsuredTBCollection() {
        return occupationDetailsOfInsuredTBCollection;
    }

    public void setOccupationDetailsOfInsuredTBCollection(Collection<OccupationDetailsOfInsuredTB> occupationDetailsOfInsuredTBCollection) {
        this.occupationDetailsOfInsuredTBCollection = occupationDetailsOfInsuredTBCollection;
    }

    public EducationQualificationTB getEducationQualificationId() {
        return educationQualificationId;
    }

    public void setEducationQualificationId(EducationQualificationTB educationQualificationId) {
        this.educationQualificationId = educationQualificationId;
    }

    public GenderTB getGenderId() {
        return genderId;
    }

    public void setGenderId(GenderTB genderId) {
        this.genderId = genderId;
    }

    public MaritalStatusTB getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(MaritalStatusTB maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insuredId != null ? insuredId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuredTB)) {
            return false;
        }
        InsuredTB other = (InsuredTB) object;
        if ((this.insuredId == null && other.insuredId != null) || (this.insuredId != null && !this.insuredId.equals(other.insuredId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InsuredTB[ insuredId=" + insuredId + " ]";
    }
    
}
