/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Bonobo
 * 
 */
@Entity
@NamedQuery(name = "MinistryProcessing.findAll", query = " select a from MinistryProcessing a")
public class MinistryProcessing extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "ministryProcessing", optional=false)
	private LegalEntity legalEntity;
	
	@Column
	private String suitabilityApplication;
	@Column
	private String autopsy;
	@Column
	private String suitabilityAdoption;
	@Column
	private String establishLicenceApplication;
	@Column
	private String establishLicenceDecision;
	@Column
	private String tax;
	@Column
	private String operationApplicationStart;
	@Column
	private String operationDecisionStart;
	@Column
	private String decisionEstablishDecision;
	@Column
	private String blueprintApplication;
	@Column
	private String blueprintDecision;
	@Column
	private String tax2;
	@Column
	private String operationApplicationEnd;
	@Column
	private String operationDecisionEnd;
	@Column
	private String comments;
	
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

	public MinistryProcessing() {
		super();
	}

	/**
	 * @return the suitabilityApplication
	 */
	public String getSuitabilityApplication() {
		return suitabilityApplication;
	}

	/**
	 * @return the autopsy
	 */
	public String getAutopsy() {
		return autopsy;
	}

	/**
	 * @return the suitabilityAdoption
	 */
	public String getSuitabilityAdoption() {
		return suitabilityAdoption;
	}

	/**
	 * @return the establishLicenceApplication
	 */
	public String getEstablishLicenceApplication() {
		return establishLicenceApplication;
	}

	/**
	 * @return the establishLicenceDecision
	 */
	public String getEstablishLicenceDecision() {
		return establishLicenceDecision;
	}

	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}

	
	
	/**
	 * @return the operationApplicationStart
	 */
	public String getOperationApplicationStart() {
		return operationApplicationStart;
	}

	/**
	 * @return the operationDecisionStart
	 */
	public String getOperationDecisionStart() {
		return operationDecisionStart;
	}

	/**
	 * @return the blueprintApplication
	 */
	public String getBlueprintApplication() {
		return blueprintApplication;
	}

	/**
	 * @return the blueprintDecision
	 */
	public String getBlueprintDecision() {
		return blueprintDecision;
	}

	/**
	 * @return the operationApplicationEnd
	 */
	public String getOperationApplicationEnd() {
		return operationApplicationEnd;
	}

	/**
	 * @return the operationDecisionEnd
	 */
	public String getOperationDecisionEnd() {
		return operationDecisionEnd;
	}

	/**
	 * @param suitabilityApplication the suitabilityApplication to set
	 */
	public void setSuitabilityApplication(String suitabilityApplication) {
		this.suitabilityApplication = suitabilityApplication;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	/**
	 * @param autopsy the autopsy to set
	 */
	public void setAutopsy(String autopsy) {
		this.autopsy = autopsy;
	}

	/**
	 * @param suitabilityAdoption the suitabilityAdoption to set
	 */
	public void setSuitabilityAdoption(String suitabilityAdoption) {
		this.suitabilityAdoption = suitabilityAdoption;
	}

	/**
	 * @param establishLicenceApplication the establishLicenceApplication to set
	 */
	public void setEstablishLicenceApplication(String establishLicenceApplication) {
		this.establishLicenceApplication = establishLicenceApplication;
	}

	/**
	 * @param establishLicenceDecision the establishLicenceDecision to set
	 */
	public void setEstablishLicenceDecision(String establishLicenceDecision) {
		this.establishLicenceDecision = establishLicenceDecision;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * @return the decisionEstablishDecision
	 */
	public String getDecisionEstablishDecision() {
		return decisionEstablishDecision;
	}

	/**
	 * @param decisionEstablishDecision the decisionEstablishDecision to set
	 */
	public void setDecisionEstablishDecision(String decisionEstablishDecision) {
		this.decisionEstablishDecision = decisionEstablishDecision;
	}

	/**
	 * @param operationApplicationStart the operationApplicationStart to set
	 */
	public void setOperationApplicationStart(String operationApplicationStart) {
		this.operationApplicationStart = operationApplicationStart;
	}

	/**
	 * @param operationDecisionStart the operationDecisionStart to set
	 */
	public void setOperationDecisionStart(String operationDecisionStart) {
		this.operationDecisionStart = operationDecisionStart;
	}

	/**
	 * @param blueprintApplication the blueprintApplication to set
	 */
	public void setBlueprintApplication(String blueprintApplication) {
		this.blueprintApplication = blueprintApplication;
	}

	/**
	 * @return the tax2
	 */
	public String getTax2() {
		return tax2;
	}

	/**
	 * @param tax2 the tax2 to set
	 */
	public void setTax2(String tax2) {
		this.tax2 = tax2;
	}

	/**
	 * @param blueprintDecision the blueprintDecision to set
	 */
	public void setBlueprintDecision(String blueprintDecision) {
		this.blueprintDecision = blueprintDecision;
	}

	/**
	 * @param operationApplicationEnd the operationApplicationEnd to set
	 */
	public void setOperationApplicationEnd(String operationApplicationEnd) {
		this.operationApplicationEnd = operationApplicationEnd;
	}

	/**
	 * @param operationDecisionEnd the operationDecisionEnd to set
	 */
	public void setOperationDecisionEnd(String operationDecisionEnd) {
		this.operationDecisionEnd = operationDecisionEnd;
	}
}
