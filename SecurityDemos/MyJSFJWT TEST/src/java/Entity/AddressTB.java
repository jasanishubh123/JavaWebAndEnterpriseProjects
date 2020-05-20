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
@Table(name = "AddressTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressTB.findAll", query = "SELECT a FROM AddressTB a"),
    @NamedQuery(name = "AddressTB.findByAddressId", query = "SELECT a FROM AddressTB a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "AddressTB.findByAddress", query = "SELECT a FROM AddressTB a WHERE a.address = :address"),
    @NamedQuery(name = "AddressTB.findByHouseNo", query = "SELECT a FROM AddressTB a WHERE a.houseNo = :houseNo"),
    @NamedQuery(name = "AddressTB.findByIsActive", query = "SELECT a FROM AddressTB a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AddressTB.findByIsDelete", query = "SELECT a FROM AddressTB a WHERE a.isDelete = :isDelete"),
    @NamedQuery(name = "AddressTB.findByAddedOn", query = "SELECT a FROM AddressTB a WHERE a.addedOn = :addedOn"),
    @NamedQuery(name = "AddressTB.findByModifiedOn", query = "SELECT a FROM AddressTB a WHERE a.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "AddressTB.findByEnteredTerminal", query = "SELECT a FROM AddressTB a WHERE a.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "AddressTB.findByUpdatedTerminal", query = "SELECT a FROM AddressTB a WHERE a.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "AddressTB.findByTimeStamp", query = "SELECT a FROM AddressTB a WHERE a.timeStamp = :timeStamp")})
public class AddressTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressId")
    private Integer addressId;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "HouseNo")
    private String houseNo;
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
    @JoinColumn(name = "AddressTypeId", referencedColumnName = "AddressTypeId")
    @ManyToOne(optional = false)
    private AddressTypeTB addressTypeId;
    @JoinColumn(name = "AgentId", referencedColumnName = "AgentId")
    @ManyToOne
    private AgentTB agentId;
    @JoinColumn(name = "AreaId", referencedColumnName = "AreaId")
    @ManyToOne(optional = false)
    private AreaTB areaId;
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    @ManyToOne
    private CompanyTB companyId;
    @JoinColumn(name = "InsuredId", referencedColumnName = "InsuredId")
    @ManyToOne
    private InsuredTB insuredId;

    public AddressTB() {
    }

    public AddressTB(Integer addressId) {
        this.addressId = addressId;
    }

    public AddressTB(Integer addressId, String address, String houseNo, boolean isActive, boolean isDelete) {
        this.addressId = addressId;
        this.address = address;
        this.houseNo = houseNo;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
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

    public AddressTypeTB getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(AddressTypeTB addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public AgentTB getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentTB agentId) {
        this.agentId = agentId;
    }

    public AreaTB getAreaId() {
        return areaId;
    }

    public void setAreaId(AreaTB areaId) {
        this.areaId = areaId;
    }

    public CompanyTB getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyTB companyId) {
        this.companyId = companyId;
    }

    public InsuredTB getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(InsuredTB insuredId) {
        this.insuredId = insuredId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressTB)) {
            return false;
        }
        AddressTB other = (AddressTB) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AddressTB[ addressId=" + addressId + " ]";
    }
    
}
