package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CertifiedPumpsInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CertifiedPumpsInfo() {
		super();
	}

	private String single;
	
	private Integer singleNo; 

	private String simpleTwin;
	
	private Integer simpleTwinNo;

	private String simpleTriplet;
	
	private Integer simpleTripletNo;

	private String doubleTwin;
	
	private Integer doubleTwinNo;

	private String doubleTriplet;
	
	private Integer doubleTripletNo;

	private Boolean hasCarLubrication;
	
	private String carLubricationComments;

	private Boolean hasCarLaundry;

	private String carLaundryComments;

	/**
	 * @return the single
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * @return the singleNo
	 */
	public Integer getSingleNo() {
		return singleNo;
	}

	/**
	 * @return the simpleTwin
	 */
	public String getSimpleTwin() {
		return simpleTwin;
	}

	/**
	 * @return the simpleTwinNo
	 */
	public Integer getSimpleTwinNo() {
		return simpleTwinNo;
	}

	/**
	 * @return the simpleTriplet
	 */
	public String getSimpleTriplet() {
		return simpleTriplet;
	}

	/**
	 * @return the simpleTripletNo
	 */
	public Integer getSimpleTripletNo() {
		return simpleTripletNo;
	}

	/**
	 * @return the doubleTwin
	 */
	public String getDoubleTwin() {
		return doubleTwin;
	}

	/**
	 * @return the doubleTwinNo
	 */
	public Integer getDoubleTwinNo() {
		return doubleTwinNo;
	}

	/**
	 * @return the doubleTriplet
	 */
	public String getDoubleTriplet() {
		return doubleTriplet;
	}

	/**
	 * @return the doubleTripletNo
	 */
	public Integer getDoubleTripletNo() {
		return doubleTripletNo;
	}

	/**
	 * @return the hasCarLubrication
	 */
	public Boolean getHasCarLubrication() {
		return hasCarLubrication;
	}

	/**
	 * @return the carLubricationComments
	 */
	public String getCarLubricationComments() {
		return carLubricationComments;
	}

	/**
	 * @return the hasCarLaundry
	 */
	public Boolean getHasCarLaundry() {
		return hasCarLaundry;
	}

	/**
	 * @return the carLaundryComments
	 */
	public String getCarLaundryComments() {
		return carLaundryComments;
	}

	/**
	 * @param single the single to set
	 */
	public void setSingle(String single) {
		this.single = single;
	}

	/**
	 * @param singleNo the singleNo to set
	 */
	public void setSingleNo(Integer singleNo) {
		this.singleNo = singleNo;
	}

	/**
	 * @param simpleTwin the simpleTwin to set
	 */
	public void setSimpleTwin(String simpleTwin) {
		this.simpleTwin = simpleTwin;
	}

	/**
	 * @param simpleTwinNo the simpleTwinNo to set
	 */
	public void setSimpleTwinNo(Integer simpleTwinNo) {
		this.simpleTwinNo = simpleTwinNo;
	}

	/**
	 * @param simpleTriplet the simpleTriplet to set
	 */
	public void setSimpleTriplet(String simpleTriplet) {
		this.simpleTriplet = simpleTriplet;
	}

	/**
	 * @param simpleTripletNo the simpleTripletNo to set
	 */
	public void setSimpleTripletNo(Integer simpleTripletNo) {
		this.simpleTripletNo = simpleTripletNo;
	}

	/**
	 * @param doubleTwin the doubleTwin to set
	 */
	public void setDoubleTwin(String doubleTwin) {
		this.doubleTwin = doubleTwin;
	}

	/**
	 * @param doubleTwinNo the doubleTwinNo to set
	 */
	public void setDoubleTwinNo(Integer doubleTwinNo) {
		this.doubleTwinNo = doubleTwinNo;
	}

	/**
	 * @param doubleTriplet the doubleTriplet to set
	 */
	public void setDoubleTriplet(String doubleTriplet) {
		this.doubleTriplet = doubleTriplet;
	}

	/**
	 * @param doubleTripletNo the doubleTripletNo to set
	 */
	public void setDoubleTripletNo(Integer doubleTripletNo) {
		this.doubleTripletNo = doubleTripletNo;
	}

	/**
	 * @param hasCarLubrication the hasCarLubrication to set
	 */
	public void setHasCarLubrication(Boolean hasCarLubrication) {
		this.hasCarLubrication = hasCarLubrication;
	}

	/**
	 * @param carLubricationComments the carLubricationComments to set
	 */
	public void setCarLubricationComments(String carLubricationComments) {
		this.carLubricationComments = carLubricationComments;
	}

	/**
	 * @param hasCarLaundry the hasCarLaundry to set
	 */
	public void setHasCarLaundry(Boolean hasCarLaundry) {
		this.hasCarLaundry = hasCarLaundry;
	}

	/**
	 * @param carLaundryComments the carLaundryComments to set
	 */
	public void setCarLaundryComments(String carLaundryComments) {
		this.carLaundryComments = carLaundryComments;
	}

	
}
