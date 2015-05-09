package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PassengerVehicleInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String airCompressor;
	
	private Integer airCompressorNo;

	private String electricLift2Weel;
	
	private Integer electricLift2WeelNo;
	
	private String electricLift4Wheel;
	
	private Integer electricLift4WheelNo;
	
	private String tunnel;
	
	private Integer tunnelNo;
	
	private String selfServicePosition;
	
	private Integer selfServicePositionNo;

	public PassengerVehicleInfo() {
		super();
	}

	/**
	 * @return the airCompressor
	 */
	public String getAirCompressor() {
		return airCompressor;
	}

	/**
	 * @return the airCompressorNo
	 */
	public Integer getAirCompressorNo() {
		return airCompressorNo;
	}

	/**
	 * @return the electricLift2Weel
	 */
	public String getElectricLift2Weel() {
		return electricLift2Weel;
	}

	/**
	 * @return the electricLift2WeelNo
	 */
	public Integer getElectricLift2WeelNo() {
		return electricLift2WeelNo;
	}

	/**
	 * @return the electricLift4Wheel
	 */
	public String getElectricLift4Wheel() {
		return electricLift4Wheel;
	}

	/**
	 * @return the electricLift4WheelNo
	 */
	public Integer getElectricLift4WheelNo() {
		return electricLift4WheelNo;
	}

	/**
	 * @return the tunnel
	 */
	public String getTunnel() {
		return tunnel;
	}

	/**
	 * @return the tunnelNo
	 */
	public Integer getTunnelNo() {
		return tunnelNo;
	}

	/**
	 * @return the selfServicePosition
	 */
	public String getSelfServicePosition() {
		return selfServicePosition;
	}

	/**
	 * @return the selfServicePositionNo
	 */
	public Integer getSelfServicePositionNo() {
		return selfServicePositionNo;
	}

	/**
	 * @param airCompressor the airCompressor to set
	 */
	public void setAirCompressor(String airCompressor) {
		this.airCompressor = airCompressor;
	}

	/**
	 * @param airCompressorNo the airCompressorNo to set
	 */
	public void setAirCompressorNo(Integer airCompressorNo) {
		this.airCompressorNo = airCompressorNo;
	}

	/**
	 * @param electricLift2Weel the electricLift2Weel to set
	 */
	public void setElectricLift2Weel(String electricLift2Weel) {
		this.electricLift2Weel = electricLift2Weel;
	}

	/**
	 * @param electricLift2WeelNo the electricLift2WeelNo to set
	 */
	public void setElectricLift2WeelNo(Integer electricLift2WeelNo) {
		this.electricLift2WeelNo = electricLift2WeelNo;
	}

	/**
	 * @param electricLift4Wheel the electricLift4Wheel to set
	 */
	public void setElectricLift4Wheel(String electricLift4Wheel) {
		this.electricLift4Wheel = electricLift4Wheel;
	}

	/**
	 * @param electricLift4WheelNo the electricLift4WheelNo to set
	 */
	public void setElectricLift4WheelNo(Integer electricLift4WheelNo) {
		this.electricLift4WheelNo = electricLift4WheelNo;
	}

	/**
	 * @param tunnel the tunnel to set
	 */
	public void setTunnel(String tunnel) {
		this.tunnel = tunnel;
	}

	/**
	 * @param tunnelNo the tunnelNo to set
	 */
	public void setTunnelNo(Integer tunnelNo) {
		this.tunnelNo = tunnelNo;
	}

	/**
	 * @param selfServicePosition the selfServicePosition to set
	 */
	public void setSelfServicePosition(String selfServicePosition) {
		this.selfServicePosition = selfServicePosition;
	}

	/**
	 * @param selfServicePositionNo the selfServicePositionNo to set
	 */
	public void setSelfServicePositionNo(Integer selfServicePositionNo) {
		this.selfServicePositionNo = selfServicePositionNo;
	}

}