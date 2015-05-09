package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Συνεργείο.
 * 
 * @author bonobo
 * 
 */
@Entity
@NamedQuery(name = "CarStation.findAll", query = " select a from CarStation a")
public class CarStation extends AbstractJPAEntity {

	/**
	 * @author asvesdi
	 *
	 */
	public enum CarStationSystem {
		SYSTEM1,SYSTEM2
	}

	/**
	 * @author asvesdi
	 *
	 */
	public enum CarStationFloorConnection {
		CONN1, CONN2
	}

	/**
	 * 
	 * @author asvesdi
	 * 
	 */
	public enum CarStationSize {
		SIZE1, SIZE2
	}

	/**
	 * @author asvesdi
	 * 
	 */
	public enum CarStationType {
		TYPE1, TYPE2
	}

	/**
	 * 
	 */

	@OneToOne(mappedBy = "carStation", optional = false)
	private LegalEntity legalEntity;
	
	private Double usefulArea;
	
	private Integer parkingPositions;
	
	private Integer floorsOver;
	
	private Integer floorsUnder;
	
	private Boolean pumps;
	
	private Boolean laundry;
	
	private Boolean lubrication;
	
	private String comments;

	private static final long serialVersionUID = 1L;

	public CarStation() {
		super();
	}

	@Enumerated(EnumType.STRING)
	private CarStationType type;
	
	@Enumerated(EnumType.STRING)
	private CarStationSize size;
	
	@Enumerated(EnumType.STRING)
	private CarStationFloorConnection floor;
	
	@Enumerated(EnumType.STRING)
	private CarStationSystem system;

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
	 * @return the type
	 */
	public CarStationType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(CarStationType type) {
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public CarStationSize getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(CarStationSize size) {
		this.size = size;
	}

	/**
	 * @return the usefulArea
	 */
	public Double getUsefulArea() {
		return usefulArea;
	}

	/**
	 * @param usefulArea the usefulArea to set
	 */
	public void setUsefulArea(Double usefulArea) {
		this.usefulArea = usefulArea;
	}

	/**
	 * @return the parkingPositions
	 */
	public Integer getParkingPositions() {
		return parkingPositions;
	}

	/**
	 * @param parkingPositions the parkingPositions to set
	 */
	public void setParkingPositions(Integer parkingPositions) {
		this.parkingPositions = parkingPositions;
	}

	/**
	 * @return the floorsOver
	 */
	public Integer getFloorsOver() {
		return floorsOver;
	}

	/**
	 * @param floorsOver the floorsOver to set
	 */
	public void setFloorsOver(Integer floorsOver) {
		this.floorsOver = floorsOver;
	}

	/**
	 * @return the floorsUnder
	 */
	public Integer getFloorsUnder() {
		return floorsUnder;
	}

	/**
	 * @param floorsUnder the floorsUnder to set
	 */
	public void setFloorsUnder(Integer floorsUnder) {
		this.floorsUnder = floorsUnder;
	}

	/**
	 * @return the pumps
	 */
	public Boolean getPumps() {
		return pumps;
	}

	/**
	 * @param pumps the pumps to set
	 */
	public void setPumps(Boolean pumps) {
		this.pumps = pumps;
	}

	/**
	 * @return the laundry
	 */
	public Boolean getLaundry() {
		return laundry;
	}

	/**
	 * @param laundry the laundry to set
	 */
	public void setLaundry(Boolean laundry) {
		this.laundry = laundry;
	}

	/**
	 * @return the lubrication
	 */
	public Boolean getLubrication() {
		return lubrication;
	}

	/**
	 * @param lubrication the lubrication to set
	 */
	public void setLubrication(Boolean lubrication) {
		this.lubrication = lubrication;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the floor
	 */
	public CarStationFloorConnection getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(CarStationFloorConnection floor) {
		this.floor = floor;
	}

	/**
	 * @return the system
	 */
	public CarStationSystem getSystem() {
		return system;
	}

	/**
	 * @param system the system to set
	 */
	public void setSystem(CarStationSystem system) {
		this.system = system;
	}
}
