package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Συνεργείο.
 * @author bonobo
 *	
 */
@Entity
@NamedQuery(name = "Garage.findAll", query = " select a from Garage a")
public class Garage extends AbstractJPAEntity {

	/**
	 * 
	 */
	
	@OneToOne(mappedBy = "garage", optional=false)
	private LegalEntity legalEntity;
	
	private static final long serialVersionUID = 1L;
	
	private String specialty;
	
	private String machinery;
	
	private Double mainArea;
	
	private Double helpArea;
	
	private Double power;
	
	private String comments;
	
	public Garage() {
		super();
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @return the machinery
	 */
	public String getMachinery() {
		return machinery;
	}

	/**
	 * @return the mainArea
	 */
	public Double getMainArea() {
		return mainArea;
	}

	/**
	 * @return the helpArea
	 */
	public Double getHelpArea() {
		return helpArea;
	}

	/**
	 * @return the power
	 */
	public Double getPower() {
		return power;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * @param machinery the machinery to set
	 */
	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}

	/**
	 * @param mainArea the mainArea to set
	 */
	public void setMainArea(Double mainArea) {
		this.mainArea = mainArea;
	}

	/**
	 * @param helpArea the helpArea to set
	 */
	public void setHelpArea(Double helpArea) {
		this.helpArea = helpArea;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(Double power) {
		this.power = power;
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
}
