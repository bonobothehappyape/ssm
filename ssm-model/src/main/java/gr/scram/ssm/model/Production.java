/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author bonobo
 * 
 */
@Entity
@NamedQuery(name = "Production.findAll", query = " select a from Production a")
public class Production extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Production() {
		super();
	}
	
	@OneToOne(mappedBy = "production", optional=false)
	private LegalEntity legalEntity;

	@Column
	private String assignment;
	@Column
	private Date autopsyDeadline;
	@Column
	private Date autopsyExec;
	@ManyToOne
	private Person designDesigner;
	@Column
	private String designCharge;
	@Column
	private Date designDeadline;
	@Column
	private Date designExec;
	@Column
	private Person techTechnician;
	@Column
	private String techCharge;
	@Column
	private Date techDeadline;
	@Column
	private Date techExec;
	@Column
	private Person secretariatTechnician;
	@Column
	private String secretariatCharge;
	@Column
	private Date secretariatDeadline;
	@Column
	private Date secretariatExec;

	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}
	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	/**
	 * @return the autopsyDeadline
	 */
	public Date getAutopsyDeadline() {
		return autopsyDeadline;
	}
	/**
	 * @param autopsyDeadline the autopsyDeadline to set
	 */
	public void setAutopsyDeadline(Date autopsyDeadline) {
		this.autopsyDeadline = autopsyDeadline;
	}
	/**
	 * @return the autopsyExec
	 */
	public Date getAutopsyExec() {
		return autopsyExec;
	}
	/**
	 * @param autopsyExec the autopsyExec to set
	 */
	public void setAutopsyExec(Date autopsyExec) {
		this.autopsyExec = autopsyExec;
	}
	/**
	 * @return the designDesigner
	 */
	public Person getDesignDesigner() {
		return designDesigner;
	}
	/**
	 * @param designDesigner the designDesigner to set
	 */
	public void setDesignDesigner(Person designDesigner) {
		this.designDesigner = designDesigner;
	}
	/**
	 * @return the designCharge
	 */
	public String getDesignCharge() {
		return designCharge;
	}
	/**
	 * @param designCharge the designCharge to set
	 */
	public void setDesignCharge(String designCharge) {
		this.designCharge = designCharge;
	}
	/**
	 * @return the designDeadline
	 */
	public Date getDesignDeadline() {
		return designDeadline;
	}
	/**
	 * @param designDeadline the designDeadline to set
	 */
	public void setDesignDeadline(Date designDeadline) {
		this.designDeadline = designDeadline;
	}
	/**
	 * @return the designExec
	 */
	public Date getDesignExec() {
		return designExec;
	}
	/**
	 * @param designExec the designExec to set
	 */
	public void setDesignExec(Date designExec) {
		this.designExec = designExec;
	}
	/**
	 * @return the techTechnician
	 */
	public Person getTechTechnician() {
		return techTechnician;
	}
	/**
	 * @param techTechnician the techTechnician to set
	 */
	public void setTechTechnician(Person techTechnician) {
		this.techTechnician = techTechnician;
	}
	/**
	 * @return the techCharge
	 */
	public String getTechCharge() {
		return techCharge;
	}
	/**
	 * @param techCharge the techCharge to set
	 */
	public void setTechCharge(String techCharge) {
		this.techCharge = techCharge;
	}
	/**
	 * @return the techDeadline
	 */
	public Date getTechDeadline() {
		return techDeadline;
	}
	/**
	 * @param techDeadline the techDeadline to set
	 */
	public void setTechDeadline(Date techDeadline) {
		this.techDeadline = techDeadline;
	}
	/**
	 * @return the techExec
	 */
	public Date getTechExec() {
		return techExec;
	}
	/**
	 * @param techExec the techExec to set
	 */
	public void setTechExec(Date techExec) {
		this.techExec = techExec;
	}
	/**
	 * @return the secretariatTechnician
	 */
	public Person getSecretariatTechnician() {
		return secretariatTechnician;
	}
	/**
	 * @param secretariatTechnician the secretariatTechnician to set
	 */
	public void setSecretariatTechnician(Person secretariatTechnician) {
		this.secretariatTechnician = secretariatTechnician;
	}
	/**
	 * @return the secretariatCharge
	 */
	public String getSecretariatCharge() {
		return secretariatCharge;
	}
	/**
	 * @param secretariatCharge the secretariatCharge to set
	 */
	public void setSecretariatCharge(String secretariatCharge) {
		this.secretariatCharge = secretariatCharge;
	}
	/**
	 * @return the secretariatDeadline
	 */
	public Date getSecretariatDeadline() {
		return secretariatDeadline;
	}
	/**
	 * @param secretariatDeadline the secretariatDeadline to set
	 */
	public void setSecretariatDeadline(Date secretariatDeadline) {
		this.secretariatDeadline = secretariatDeadline;
	}
	/**
	 * @return the secretariatExec
	 */
	public Date getSecretariatExec() {
		return secretariatExec;
	}
	/**
	 * @param secretariatExec the secretariatExec to set
	 */
	public void setSecretariatExec(Date secretariatExec) {
		this.secretariatExec = secretariatExec;
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
