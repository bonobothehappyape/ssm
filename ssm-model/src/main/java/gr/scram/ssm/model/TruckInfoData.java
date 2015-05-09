package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TruckInfoData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wheelWashers;
	
	private Integer wheelWashersNo;
	
	private String hydraulicLift;
	
	private Integer hydraulicLiftNo;

	private String automaticLaundrie;
	
	private Integer automaticLaundrieNo;
	
	public TruckInfoData() {
		super();
	}

	/**
	 * @return the wheelWashers
	 */
	public String getWheelWashers() {
		return wheelWashers;
	}

	/**
	 * @return the wheelWashersNo
	 */
	public Integer getWheelWashersNo() {
		return wheelWashersNo;
	}

	/**
	 * @return the hydraulicLift
	 */
	public String getHydraulicLift() {
		return hydraulicLift;
	}

	/**
	 * @return the hydraulicLiftNo
	 */
	public Integer getHydraulicLiftNo() {
		return hydraulicLiftNo;
	}

	/**
	 * @return the automaticLaundrie
	 */
	public String getAutomaticLaundrie() {
		return automaticLaundrie;
	}

	/**
	 * @return the automaticLaundrieNo
	 */
	public Integer getAutomaticLaundrieNo() {
		return automaticLaundrieNo;
	}

	/**
	 * @param wheelWashers the wheelWashers to set
	 */
	public void setWheelWashers(String wheelWashers) {
		this.wheelWashers = wheelWashers;
	}

	/**
	 * @param wheelWashersNo the wheelWashersNo to set
	 */
	public void setWheelWashersNo(Integer wheelWashersNo) {
		this.wheelWashersNo = wheelWashersNo;
	}

	/**
	 * @param hydraulicLift the hydraulicLift to set
	 */
	public void setHydraulicLift(String hydraulicLift) {
		this.hydraulicLift = hydraulicLift;
	}

	/**
	 * @param hydraulicLiftNo the hydraulicLiftNo to set
	 */
	public void setHydraulicLiftNo(Integer hydraulicLiftNo) {
		this.hydraulicLiftNo = hydraulicLiftNo;
	}

	/**
	 * @param automaticLaundrie the automaticLaundrie to set
	 */
	public void setAutomaticLaundrie(String automaticLaundrie) {
		this.automaticLaundrie = automaticLaundrie;
	}

	/**
	 * @param automaticLaundrieNo the automaticLaundrieNo to set
	 */
	public void setAutomaticLaundrieNo(Integer automaticLaundrieNo) {
		this.automaticLaundrieNo = automaticLaundrieNo;
	}

}