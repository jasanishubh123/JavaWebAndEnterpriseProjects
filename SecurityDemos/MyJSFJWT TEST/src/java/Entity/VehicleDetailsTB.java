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
@Table(name = "VehicleDetailsTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleDetailsTB.findAll", query = "SELECT v FROM VehicleDetailsTB v"),
    @NamedQuery(name = "VehicleDetailsTB.findByVehicleDetailsId", query = "SELECT v FROM VehicleDetailsTB v WHERE v.vehicleDetailsId = :vehicleDetailsId"),
    @NamedQuery(name = "VehicleDetailsTB.findByRegisterNo", query = "SELECT v FROM VehicleDetailsTB v WHERE v.registerNo = :registerNo"),
    @NamedQuery(name = "VehicleDetailsTB.findByEngineNo", query = "SELECT v FROM VehicleDetailsTB v WHERE v.engineNo = :engineNo"),
    @NamedQuery(name = "VehicleDetailsTB.findByChasisNo", query = "SELECT v FROM VehicleDetailsTB v WHERE v.chasisNo = :chasisNo"),
    @NamedQuery(name = "VehicleDetailsTB.findByPermit", query = "SELECT v FROM VehicleDetailsTB v WHERE v.permit = :permit"),
    @NamedQuery(name = "VehicleDetailsTB.findByRegiPlace", query = "SELECT v FROM VehicleDetailsTB v WHERE v.regiPlace = :regiPlace"),
    @NamedQuery(name = "VehicleDetailsTB.findByUnleadenweight", query = "SELECT v FROM VehicleDetailsTB v WHERE v.unleadenweight = :unleadenweight"),
    @NamedQuery(name = "VehicleDetailsTB.findByRoadTax", query = "SELECT v FROM VehicleDetailsTB v WHERE v.roadTax = :roadTax"),
    @NamedQuery(name = "VehicleDetailsTB.findByRDTaxToDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.rDTaxToDate = :rDTaxToDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByRDTaxFromDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.rDTaxFromDate = :rDTaxFromDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByStatePermitNo", query = "SELECT v FROM VehicleDetailsTB v WHERE v.statePermitNo = :statePermitNo"),
    @NamedQuery(name = "VehicleDetailsTB.findByStatePermitExpiryDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.statePermitExpiryDate = :statePermitExpiryDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByNationalpermitNo", query = "SELECT v FROM VehicleDetailsTB v WHERE v.nationalpermitNo = :nationalpermitNo"),
    @NamedQuery(name = "VehicleDetailsTB.findByNationalPermitExpiryDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.nationalPermitExpiryDate = :nationalPermitExpiryDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByRegistrationDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.registrationDate = :registrationDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByFitnessExpiryDate", query = "SELECT v FROM VehicleDetailsTB v WHERE v.fitnessExpiryDate = :fitnessExpiryDate"),
    @NamedQuery(name = "VehicleDetailsTB.findByIsActive", query = "SELECT v FROM VehicleDetailsTB v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VehicleDetailsTB.findByIsDelete", query = "SELECT v FROM VehicleDetailsTB v WHERE v.isDelete = :isDelete"),
    @NamedQuery(name = "VehicleDetailsTB.findByAddedOn", query = "SELECT v FROM VehicleDetailsTB v WHERE v.addedOn = :addedOn"),
    @NamedQuery(name = "VehicleDetailsTB.findByModifiedOn", query = "SELECT v FROM VehicleDetailsTB v WHERE v.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "VehicleDetailsTB.findByEnteredTerminal", query = "SELECT v FROM VehicleDetailsTB v WHERE v.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "VehicleDetailsTB.findByUpdatedTerminal", query = "SELECT v FROM VehicleDetailsTB v WHERE v.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "VehicleDetailsTB.findByTimeStamp", query = "SELECT v FROM VehicleDetailsTB v WHERE v.timeStamp = :timeStamp")})
public class VehicleDetailsTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VehicleDetailsId")
    private Integer vehicleDetailsId;
    @Basic(optional = false)
    @Column(name = "RegisterNo")
    private String registerNo;
    @Basic(optional = false)
    @Column(name = "EngineNo")
    private String engineNo;
    @Basic(optional = false)
    @Column(name = "ChasisNo")
    private String chasisNo;
    @Basic(optional = false)
    @Column(name = "Permit")
    private String permit;
    @Basic(optional = false)
    @Column(name = "Regi_Place")
    private String regiPlace;
    @Basic(optional = false)
    @Column(name = "Unleadenweight")
    private String unleadenweight;
    @Basic(optional = false)
    @Column(name = "RoadTax")
    private String roadTax;
    @Basic(optional = false)
    @Column(name = "RDTaxToDate")
    @Temporal(TemporalType.DATE)
    private Date rDTaxToDate;
    @Basic(optional = false)
    @Column(name = "RDTaxFromDate")
    @Temporal(TemporalType.DATE)
    private Date rDTaxFromDate;
    @Basic(optional = false)
    @Column(name = "StatePermitNo")
    private String statePermitNo;
    @Basic(optional = false)
    @Column(name = "StatePermitExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date statePermitExpiryDate;
    @Basic(optional = false)
    @Column(name = "NationalpermitNo")
    private String nationalpermitNo;
    @Basic(optional = false)
    @Column(name = "NationalPermitExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date nationalPermitExpiryDate;
    @Basic(optional = false)
    @Column(name = "RegistrationDate")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Basic(optional = false)
    @Column(name = "FitnessExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date fitnessExpiryDate;
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
    @JoinColumn(name = "FuelTypeId", referencedColumnName = "FuelTypeId")
    @ManyToOne(optional = false)
    private FuelTypeTB fuelTypeId;
    @JoinColumn(name = "PolicySubTypeId", referencedColumnName = "PolicySubTypeId")
    @ManyToOne(optional = false)
    private PolicySubTypeTB policySubTypeId;
    @JoinColumn(name = "TransactionOfPolicyId", referencedColumnName = "TransactionOfPolicyId")
    @ManyToOne(optional = false)
    private TransactionOfPolicyTB transactionOfPolicyId;
    @JoinColumn(name = "Vehicle_IDVDetailsId", referencedColumnName = "Vehicle_IDVDetailsId")
    @ManyToOne(optional = false)
    private VehicleIDVDetailsTB vehicleIDVDetailsId;
    @JoinColumn(name = "VehicleColorId", referencedColumnName = "VehicleColorId")
    @ManyToOne(optional = false)
    private VehicleColorTB vehicleColorId;

    public VehicleDetailsTB() {
    }

    public VehicleDetailsTB(Integer vehicleDetailsId) {
        this.vehicleDetailsId = vehicleDetailsId;
    }

    public VehicleDetailsTB(Integer vehicleDetailsId, String registerNo, String engineNo, String chasisNo, String permit, String regiPlace, String unleadenweight, String roadTax, Date rDTaxToDate, Date rDTaxFromDate, String statePermitNo, Date statePermitExpiryDate, String nationalpermitNo, Date nationalPermitExpiryDate, Date registrationDate, Date fitnessExpiryDate, boolean isActive, boolean isDelete) {
        this.vehicleDetailsId = vehicleDetailsId;
        this.registerNo = registerNo;
        this.engineNo = engineNo;
        this.chasisNo = chasisNo;
        this.permit = permit;
        this.regiPlace = regiPlace;
        this.unleadenweight = unleadenweight;
        this.roadTax = roadTax;
        this.rDTaxToDate = rDTaxToDate;
        this.rDTaxFromDate = rDTaxFromDate;
        this.statePermitNo = statePermitNo;
        this.statePermitExpiryDate = statePermitExpiryDate;
        this.nationalpermitNo = nationalpermitNo;
        this.nationalPermitExpiryDate = nationalPermitExpiryDate;
        this.registrationDate = registrationDate;
        this.fitnessExpiryDate = fitnessExpiryDate;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getVehicleDetailsId() {
        return vehicleDetailsId;
    }

    public void setVehicleDetailsId(Integer vehicleDetailsId) {
        this.vehicleDetailsId = vehicleDetailsId;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getChasisNo() {
        return chasisNo;
    }

    public void setChasisNo(String chasisNo) {
        this.chasisNo = chasisNo;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getRegiPlace() {
        return regiPlace;
    }

    public void setRegiPlace(String regiPlace) {
        this.regiPlace = regiPlace;
    }

    public String getUnleadenweight() {
        return unleadenweight;
    }

    public void setUnleadenweight(String unleadenweight) {
        this.unleadenweight = unleadenweight;
    }

    public String getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(String roadTax) {
        this.roadTax = roadTax;
    }

    public Date getRDTaxToDate() {
        return rDTaxToDate;
    }

    public void setRDTaxToDate(Date rDTaxToDate) {
        this.rDTaxToDate = rDTaxToDate;
    }

    public Date getRDTaxFromDate() {
        return rDTaxFromDate;
    }

    public void setRDTaxFromDate(Date rDTaxFromDate) {
        this.rDTaxFromDate = rDTaxFromDate;
    }

    public String getStatePermitNo() {
        return statePermitNo;
    }

    public void setStatePermitNo(String statePermitNo) {
        this.statePermitNo = statePermitNo;
    }

    public Date getStatePermitExpiryDate() {
        return statePermitExpiryDate;
    }

    public void setStatePermitExpiryDate(Date statePermitExpiryDate) {
        this.statePermitExpiryDate = statePermitExpiryDate;
    }

    public String getNationalpermitNo() {
        return nationalpermitNo;
    }

    public void setNationalpermitNo(String nationalpermitNo) {
        this.nationalpermitNo = nationalpermitNo;
    }

    public Date getNationalPermitExpiryDate() {
        return nationalPermitExpiryDate;
    }

    public void setNationalPermitExpiryDate(Date nationalPermitExpiryDate) {
        this.nationalPermitExpiryDate = nationalPermitExpiryDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getFitnessExpiryDate() {
        return fitnessExpiryDate;
    }

    public void setFitnessExpiryDate(Date fitnessExpiryDate) {
        this.fitnessExpiryDate = fitnessExpiryDate;
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

    public FuelTypeTB getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(FuelTypeTB fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public PolicySubTypeTB getPolicySubTypeId() {
        return policySubTypeId;
    }

    public void setPolicySubTypeId(PolicySubTypeTB policySubTypeId) {
        this.policySubTypeId = policySubTypeId;
    }

    public TransactionOfPolicyTB getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(TransactionOfPolicyTB transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    public VehicleIDVDetailsTB getVehicleIDVDetailsId() {
        return vehicleIDVDetailsId;
    }

    public void setVehicleIDVDetailsId(VehicleIDVDetailsTB vehicleIDVDetailsId) {
        this.vehicleIDVDetailsId = vehicleIDVDetailsId;
    }

    public VehicleColorTB getVehicleColorId() {
        return vehicleColorId;
    }

    public void setVehicleColorId(VehicleColorTB vehicleColorId) {
        this.vehicleColorId = vehicleColorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleDetailsId != null ? vehicleDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleDetailsTB)) {
            return false;
        }
        VehicleDetailsTB other = (VehicleDetailsTB) object;
        if ((this.vehicleDetailsId == null && other.vehicleDetailsId != null) || (this.vehicleDetailsId != null && !this.vehicleDetailsId.equals(other.vehicleDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.VehicleDetailsTB[ vehicleDetailsId=" + vehicleDetailsId + " ]";
    }
    
}
