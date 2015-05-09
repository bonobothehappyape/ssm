/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Bonobo
 * 
 */
@Entity
@NamedQuery(name = "CarWash.findAll", query = " select a from CarWash a")
public class CarWash extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CarWash() {
		super();
	}

	@OneToOne(mappedBy = "carWash", optional = false)
	private LegalEntity legalEntity;

	private String wheelWashersTruck;

	private Integer wheelWashersNoTruck;

	private String hydraulicLiftTruck;

	private Integer hydraulicLiftNoTruck;

	private String automaticLaundrieTruck;

	private Integer automaticLaundrieNoTruck;

	@Embedded
	private PassengerVehicleInfo passengerVehicleData = new PassengerVehicleInfo();

	@Embedded
	private TruckInfoData outdoorInfo = new TruckInfoData();

	/**
	 * @return the legalEntity
	 */
	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	/**
	 * @param legalEntity the legalEntity to set
	 */
	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	/**
	 * @return the wheelWashersTruck
	 */
	public String getWheelWashersTruck() {
		return wheelWashersTruck;
	}

	/**
	 * @param wheelWashersTruck the wheelWashersTruck to set
	 */
	public void setWheelWashersTruck(String wheelWashersTruck) {
		this.wheelWashersTruck = wheelWashersTruck;
	}

	/**
	 * @return the wheelWashersNoTruck
	 */
	public Integer getWheelWashersNoTruck() {
		return wheelWashersNoTruck;
	}

	/**
	 * @param wheelWashersNoTruck the wheelWashersNoTruck to set
	 */
	public void setWheelWashersNoTruck(Integer wheelWashersNoTruck) {
		this.wheelWashersNoTruck = wheelWashersNoTruck;
	}

	/**
	 * @return the hydraulicLiftTruck
	 */
	public String getHydraulicLiftTruck() {
		return hydraulicLiftTruck;
	}

	/**
	 * @param hydraulicLiftTruck the hydraulicLiftTruck to set
	 */
	public void setHydraulicLiftTruck(String hydraulicLiftTruck) {
		this.hydraulicLiftTruck = hydraulicLiftTruck;
	}

	/**
	 * @return the hydraulicLiftNoTruck
	 */
	public Integer getHydraulicLiftNoTruck() {
		return hydraulicLiftNoTruck;
	}

	/**
	 * @param hydraulicLiftNoTruck the hydraulicLiftNoTruck to set
	 */
	public void setHydraulicLiftNoTruck(Integer hydraulicLiftNoTruck) {
		this.hydraulicLiftNoTruck = hydraulicLiftNoTruck;
	}

	/**
	 * @return the automaticLaundrieTruck
	 */
	public String getAutomaticLaundrieTruck() {
		return automaticLaundrieTruck;
	}

	/**
	 * @param automaticLaundrieTruck the automaticLaundrieTruck to set
	 */
	public void setAutomaticLaundrieTruck(String automaticLaundrieTruck) {
		this.automaticLaundrieTruck = automaticLaundrieTruck;
	}

	/**
	 * @return the automaticLaundrieNoTruck
	 */
	public Integer getAutomaticLaundrieNoTruck() {
		return automaticLaundrieNoTruck;
	}

	/**
	 * @param automaticLaundrieNoTruck the automaticLaundrieNoTruck to set
	 */
	public void setAutomaticLaundrieNoTruck(Integer automaticLaundrieNoTruck) {
		this.automaticLaundrieNoTruck = automaticLaundrieNoTruck;
	}

	/**
	 * @return the passengerVehicleData
	 */
	public PassengerVehicleInfo getPassengerVehicleData() {
		return passengerVehicleData;
	}

	/**
	 * @param passengerVehicleData the passengerVehicleData to set
	 */
	public void setPassengerVehicleData(PassengerVehicleInfo passengerVehicleData) {
		this.passengerVehicleData = passengerVehicleData;
	}

	/**
	 * @return the outdoorInfo
	 */
	public TruckInfoData getOutdoorInfo() {
		return outdoorInfo;
	}

	/**
	 * @param outdoorInfo the outdoorInfo to set
	 */
	public void setOutdoorInfo(TruckInfoData outdoorInfo) {
		this.outdoorInfo = outdoorInfo;
	}



}
