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
@Table(name = "Vehicle_IDVDetailsTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleIDVDetailsTB.findAll", query = "SELECT v FROM VehicleIDVDetailsTB v"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByVehicleIDVDetailsId", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.vehicleIDVDetailsId = :vehicleIDVDetailsId"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findBySeatingCapacity", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.seatingCapacity = :seatingCapacity"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByCcGvw", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.ccGvw = :ccGvw"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByIdv", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.idv = :idv"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTrailerIDV", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.trailerIDV = :trailerIDV"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByElectronicAcce", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.electronicAcce = :electronicAcce"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByCNGFualKits", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.cNGFualKits = :cNGFualKits"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByMFGYear", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.mFGYear = :mFGYear"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByVehicleBasicRate", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.vehicleBasicRate = :vehicleBasicRate"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByBasicOfVehicle", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.basicOfVehicle = :basicOfVehicle"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByGvw", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.gvw = :gvw"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByBasicPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.basicPrem = :basicPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByImt23", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.imt23 = :imt23"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByImt47", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.imt47 = :imt47"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByImt48", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.imt48 = :imt48"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByBasicODPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.basicODPrem = :basicODPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByNcb", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.ncb = :ncb"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByDiscOnODPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.discOnODPrem = :discOnODPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByLoading", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.loading = :loading"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTotalBasicPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.totalBasicPrem = :totalBasicPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByAddOnCover", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.addOnCover = :addOnCover"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByOtherPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.otherPrem = :otherPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByNetODPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.netODPrem = :netODPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTPPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.tPPrem = :tPPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTrailerTPPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.trailerTPPrem = :trailerTPPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByPAOwnerDriver", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.pAOwnerDriver = :pAOwnerDriver"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByPAbUNPass", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.pAbUNPass = :pAbUNPass"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByLLToPaidDriverEndt", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.lLToPaidDriverEndt = :lLToPaidDriverEndt"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByCoolie", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.coolie = :coolie"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByRestrictedTPPD", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.restrictedTPPD = :restrictedTPPD"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTotalLibialityPrem", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.totalLibialityPrem = :totalLibialityPrem"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByGeoExt", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.geoExt = :geoExt"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByAddOnChoice", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.addOnChoice = :addOnChoice"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByIsActive", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByIsDelete", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.isDelete = :isDelete"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByAddedOn", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.addedOn = :addedOn"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByModifiedOn", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByEnteredTerminal", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByUpdatedTerminal", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "VehicleIDVDetailsTB.findByTimeStamp", query = "SELECT v FROM VehicleIDVDetailsTB v WHERE v.timeStamp = :timeStamp")})
public class VehicleIDVDetailsTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Vehicle_IDVDetailsId")
    private Integer vehicleIDVDetailsId;
    @Basic(optional = false)
    @Column(name = "SeatingCapacity")
    private int seatingCapacity;
    @Basic(optional = false)
    @Column(name = "CC_GVW")
    private String ccGvw;
    @Basic(optional = false)
    @Column(name = "IDV")
    private String idv;
    @Basic(optional = false)
    @Column(name = "TrailerIDV")
    private String trailerIDV;
    @Basic(optional = false)
    @Column(name = "ElectronicAcce")
    private String electronicAcce;
    @Basic(optional = false)
    @Column(name = "CNG_FualKits")
    private String cNGFualKits;
    @Basic(optional = false)
    @Column(name = "MFGYear")
    private int mFGYear;
    @Basic(optional = false)
    @Column(name = "VehicleBasicRate")
    private String vehicleBasicRate;
    @Basic(optional = false)
    @Column(name = "BasicOfVehicle")
    private String basicOfVehicle;
    @Basic(optional = false)
    @Column(name = "GVW")
    private int gvw;
    @Basic(optional = false)
    @Column(name = "BasicPrem")
    private String basicPrem;
    @Basic(optional = false)
    @Column(name = "IMT23")
    private String imt23;
    @Basic(optional = false)
    @Column(name = "IMT47")
    private String imt47;
    @Basic(optional = false)
    @Column(name = "IMT48")
    private String imt48;
    @Basic(optional = false)
    @Column(name = "BasicODPrem")
    private String basicODPrem;
    @Basic(optional = false)
    @Column(name = "NCB")
    private String ncb;
    @Basic(optional = false)
    @Column(name = "Disc_OnODPrem")
    private String discOnODPrem;
    @Basic(optional = false)
    @Column(name = "Loading")
    private String loading;
    @Basic(optional = false)
    @Column(name = "TotalBasicPrem")
    private String totalBasicPrem;
    @Basic(optional = false)
    @Column(name = "AddOnCover")
    private String addOnCover;
    @Basic(optional = false)
    @Column(name = "OtherPrem")
    private String otherPrem;
    @Basic(optional = false)
    @Column(name = "NetODPrem")
    private String netODPrem;
    @Basic(optional = false)
    @Column(name = "TPPrem")
    private String tPPrem;
    @Basic(optional = false)
    @Column(name = "TrailerTPPrem")
    private String trailerTPPrem;
    @Basic(optional = false)
    @Column(name = "PAOwnerDriver")
    private String pAOwnerDriver;
    @Basic(optional = false)
    @Column(name = "PAbUNPass")
    private String pAbUNPass;
    @Basic(optional = false)
    @Column(name = "LLToPaidDriverEndt")
    private String lLToPaidDriverEndt;
    @Basic(optional = false)
    @Column(name = "Coolie")
    private String coolie;
    @Basic(optional = false)
    @Column(name = "RestrictedTPPD")
    private String restrictedTPPD;
    @Basic(optional = false)
    @Column(name = "TotalLibialityPrem")
    private String totalLibialityPrem;
    @Basic(optional = false)
    @Column(name = "GeoExt")
    private String geoExt;
    @Basic(optional = false)
    @Column(name = "Add_OnChoice")
    private String addOnChoice;
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
    @JoinColumn(name = "ModelOfVehicleId", referencedColumnName = "ModelOfVehicleId")
    @ManyToOne(optional = false)
    private ModelOfVehicleTB modelOfVehicleId;
    @JoinColumn(name = "TransactionOfPolicyId", referencedColumnName = "TransactionOfPolicyId")
    @ManyToOne(optional = false)
    private TransactionOfPolicyTB transactionOfPolicyId;
    @JoinColumn(name = "ZoneOfIDVId", referencedColumnName = "ZoneOfIDV_VehicleId")
    @ManyToOne(optional = false)
    private ZoneOfIDVVehicleTB zoneOfIDVId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleIDVDetailsId")
    private Collection<VehicleDetailsTB> vehicleDetailsTBCollection;

    public VehicleIDVDetailsTB() {
    }

    public VehicleIDVDetailsTB(Integer vehicleIDVDetailsId) {
        this.vehicleIDVDetailsId = vehicleIDVDetailsId;
    }

    public VehicleIDVDetailsTB(Integer vehicleIDVDetailsId, int seatingCapacity, String ccGvw, String idv, String trailerIDV, String electronicAcce, String cNGFualKits, int mFGYear, String vehicleBasicRate, String basicOfVehicle, int gvw, String basicPrem, String imt23, String imt47, String imt48, String basicODPrem, String ncb, String discOnODPrem, String loading, String totalBasicPrem, String addOnCover, String otherPrem, String netODPrem, String tPPrem, String trailerTPPrem, String pAOwnerDriver, String pAbUNPass, String lLToPaidDriverEndt, String coolie, String restrictedTPPD, String totalLibialityPrem, String geoExt, String addOnChoice, boolean isActive, boolean isDelete) {
        this.vehicleIDVDetailsId = vehicleIDVDetailsId;
        this.seatingCapacity = seatingCapacity;
        this.ccGvw = ccGvw;
        this.idv = idv;
        this.trailerIDV = trailerIDV;
        this.electronicAcce = electronicAcce;
        this.cNGFualKits = cNGFualKits;
        this.mFGYear = mFGYear;
        this.vehicleBasicRate = vehicleBasicRate;
        this.basicOfVehicle = basicOfVehicle;
        this.gvw = gvw;
        this.basicPrem = basicPrem;
        this.imt23 = imt23;
        this.imt47 = imt47;
        this.imt48 = imt48;
        this.basicODPrem = basicODPrem;
        this.ncb = ncb;
        this.discOnODPrem = discOnODPrem;
        this.loading = loading;
        this.totalBasicPrem = totalBasicPrem;
        this.addOnCover = addOnCover;
        this.otherPrem = otherPrem;
        this.netODPrem = netODPrem;
        this.tPPrem = tPPrem;
        this.trailerTPPrem = trailerTPPrem;
        this.pAOwnerDriver = pAOwnerDriver;
        this.pAbUNPass = pAbUNPass;
        this.lLToPaidDriverEndt = lLToPaidDriverEndt;
        this.coolie = coolie;
        this.restrictedTPPD = restrictedTPPD;
        this.totalLibialityPrem = totalLibialityPrem;
        this.geoExt = geoExt;
        this.addOnChoice = addOnChoice;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getVehicleIDVDetailsId() {
        return vehicleIDVDetailsId;
    }

    public void setVehicleIDVDetailsId(Integer vehicleIDVDetailsId) {
        this.vehicleIDVDetailsId = vehicleIDVDetailsId;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getCcGvw() {
        return ccGvw;
    }

    public void setCcGvw(String ccGvw) {
        this.ccGvw = ccGvw;
    }

    public String getIdv() {
        return idv;
    }

    public void setIdv(String idv) {
        this.idv = idv;
    }

    public String getTrailerIDV() {
        return trailerIDV;
    }

    public void setTrailerIDV(String trailerIDV) {
        this.trailerIDV = trailerIDV;
    }

    public String getElectronicAcce() {
        return electronicAcce;
    }

    public void setElectronicAcce(String electronicAcce) {
        this.electronicAcce = electronicAcce;
    }

    public String getCNGFualKits() {
        return cNGFualKits;
    }

    public void setCNGFualKits(String cNGFualKits) {
        this.cNGFualKits = cNGFualKits;
    }

    public int getMFGYear() {
        return mFGYear;
    }

    public void setMFGYear(int mFGYear) {
        this.mFGYear = mFGYear;
    }

    public String getVehicleBasicRate() {
        return vehicleBasicRate;
    }

    public void setVehicleBasicRate(String vehicleBasicRate) {
        this.vehicleBasicRate = vehicleBasicRate;
    }

    public String getBasicOfVehicle() {
        return basicOfVehicle;
    }

    public void setBasicOfVehicle(String basicOfVehicle) {
        this.basicOfVehicle = basicOfVehicle;
    }

    public int getGvw() {
        return gvw;
    }

    public void setGvw(int gvw) {
        this.gvw = gvw;
    }

    public String getBasicPrem() {
        return basicPrem;
    }

    public void setBasicPrem(String basicPrem) {
        this.basicPrem = basicPrem;
    }

    public String getImt23() {
        return imt23;
    }

    public void setImt23(String imt23) {
        this.imt23 = imt23;
    }

    public String getImt47() {
        return imt47;
    }

    public void setImt47(String imt47) {
        this.imt47 = imt47;
    }

    public String getImt48() {
        return imt48;
    }

    public void setImt48(String imt48) {
        this.imt48 = imt48;
    }

    public String getBasicODPrem() {
        return basicODPrem;
    }

    public void setBasicODPrem(String basicODPrem) {
        this.basicODPrem = basicODPrem;
    }

    public String getNcb() {
        return ncb;
    }

    public void setNcb(String ncb) {
        this.ncb = ncb;
    }

    public String getDiscOnODPrem() {
        return discOnODPrem;
    }

    public void setDiscOnODPrem(String discOnODPrem) {
        this.discOnODPrem = discOnODPrem;
    }

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public String getTotalBasicPrem() {
        return totalBasicPrem;
    }

    public void setTotalBasicPrem(String totalBasicPrem) {
        this.totalBasicPrem = totalBasicPrem;
    }

    public String getAddOnCover() {
        return addOnCover;
    }

    public void setAddOnCover(String addOnCover) {
        this.addOnCover = addOnCover;
    }

    public String getOtherPrem() {
        return otherPrem;
    }

    public void setOtherPrem(String otherPrem) {
        this.otherPrem = otherPrem;
    }

    public String getNetODPrem() {
        return netODPrem;
    }

    public void setNetODPrem(String netODPrem) {
        this.netODPrem = netODPrem;
    }

    public String getTPPrem() {
        return tPPrem;
    }

    public void setTPPrem(String tPPrem) {
        this.tPPrem = tPPrem;
    }

    public String getTrailerTPPrem() {
        return trailerTPPrem;
    }

    public void setTrailerTPPrem(String trailerTPPrem) {
        this.trailerTPPrem = trailerTPPrem;
    }

    public String getPAOwnerDriver() {
        return pAOwnerDriver;
    }

    public void setPAOwnerDriver(String pAOwnerDriver) {
        this.pAOwnerDriver = pAOwnerDriver;
    }

    public String getPAbUNPass() {
        return pAbUNPass;
    }

    public void setPAbUNPass(String pAbUNPass) {
        this.pAbUNPass = pAbUNPass;
    }

    public String getLLToPaidDriverEndt() {
        return lLToPaidDriverEndt;
    }

    public void setLLToPaidDriverEndt(String lLToPaidDriverEndt) {
        this.lLToPaidDriverEndt = lLToPaidDriverEndt;
    }

    public String getCoolie() {
        return coolie;
    }

    public void setCoolie(String coolie) {
        this.coolie = coolie;
    }

    public String getRestrictedTPPD() {
        return restrictedTPPD;
    }

    public void setRestrictedTPPD(String restrictedTPPD) {
        this.restrictedTPPD = restrictedTPPD;
    }

    public String getTotalLibialityPrem() {
        return totalLibialityPrem;
    }

    public void setTotalLibialityPrem(String totalLibialityPrem) {
        this.totalLibialityPrem = totalLibialityPrem;
    }

    public String getGeoExt() {
        return geoExt;
    }

    public void setGeoExt(String geoExt) {
        this.geoExt = geoExt;
    }

    public String getAddOnChoice() {
        return addOnChoice;
    }

    public void setAddOnChoice(String addOnChoice) {
        this.addOnChoice = addOnChoice;
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

    public ModelOfVehicleTB getModelOfVehicleId() {
        return modelOfVehicleId;
    }

    public void setModelOfVehicleId(ModelOfVehicleTB modelOfVehicleId) {
        this.modelOfVehicleId = modelOfVehicleId;
    }

    public TransactionOfPolicyTB getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(TransactionOfPolicyTB transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    public ZoneOfIDVVehicleTB getZoneOfIDVId() {
        return zoneOfIDVId;
    }

    public void setZoneOfIDVId(ZoneOfIDVVehicleTB zoneOfIDVId) {
        this.zoneOfIDVId = zoneOfIDVId;
    }

    @XmlTransient
    public Collection<VehicleDetailsTB> getVehicleDetailsTBCollection() {
        return vehicleDetailsTBCollection;
    }

    public void setVehicleDetailsTBCollection(Collection<VehicleDetailsTB> vehicleDetailsTBCollection) {
        this.vehicleDetailsTBCollection = vehicleDetailsTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleIDVDetailsId != null ? vehicleIDVDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleIDVDetailsTB)) {
            return false;
        }
        VehicleIDVDetailsTB other = (VehicleIDVDetailsTB) object;
        if ((this.vehicleIDVDetailsId == null && other.vehicleIDVDetailsId != null) || (this.vehicleIDVDetailsId != null && !this.vehicleIDVDetailsId.equals(other.vehicleIDVDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.VehicleIDVDetailsTB[ vehicleIDVDetailsId=" + vehicleIDVDetailsId + " ]";
    }
    
}
