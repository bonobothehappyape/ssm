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
@NamedQuery(name = "ConnectionProcessing.findAll", query = " select a from ConnectionProcessing a")
public class ConnectionProcessing extends AbstractJPAEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "connectionProcessing", optional=false)
	private LegalEntity legalEntity;
	
	@Column
	private String preApprovalApplication;
	@Column
	private String preApprovalAutopsy;
	@Column
	private String preApprovalDecision;
	@Column
	private String approvalApplication;
	@Column
	private String approvalDecision;
	@Column
	private String consensusApplication;
	@Column
	private String consensusAutopsy;
	@Column
	private String decision;
	@Column
	private String townshipApplication;
	@Column
	private String townshipDecision;
	@Column
	private String approvalApplication2;
	@Column
	private String approvalAutopsy2;
	@Column
	private String approvalDecision2;
	@Column
	private String consensusApplication2;
	@Column
	private String consensusAutopsy2;
	@Column
	private String decision2;
	/**
	 * 
	 */
	public ConnectionProcessing() {
		super();
	}
	/**
	 * @return the preApprovalApplication
	 */
	public String getPreApprovalApplication() {
		return preApprovalApplication;
	}
	/**
	 * @return the preApprovalAutopsy
	 */
	public String getPreApprovalAutopsy() {
		return preApprovalAutopsy;
	}
	/**
	 * @return the preApprovalDecision
	 */
	public String getPreApprovalDecision() {
		return preApprovalDecision;
	}
	/**
	 * @return the approvalApplication
	 */
	public String getApprovalApplication() {
		return approvalApplication;
	}
	/**
	 * @return the approvalDecision
	 */
	public String getApprovalDecision() {
		return approvalDecision;
	}
	/**
	 * @return the consensusApplication
	 */
	public String getConsensusApplication() {
		return consensusApplication;
	}
	/**
	 * @return the consensusAutopsy
	 */
	public String getConsensusAutopsy() {
		return consensusAutopsy;
	}
	/**
	 * @return the decision
	 */
	public String getDecision() {
		return decision;
	}
	/**
	 * @return the townshipApplication
	 */
	public String getTownshipApplication() {
		return townshipApplication;
	}
	/**
	 * @return the townshipDecision
	 */
	public String getTownshipDecision() {
		return townshipDecision;
	}
	/**
	 * @return the approvalApplication2
	 */
	public String getApprovalApplication2() {
		return approvalApplication2;
	}
	/**
	 * @return the approvalAutopsy2
	 */
	public String getApprovalAutopsy2() {
		return approvalAutopsy2;
	}
	/**
	 * @return the approvalDecision2
	 */
	public String getApprovalDecision2() {
		return approvalDecision2;
	}
	/**
	 * @param preApprovalApplication the preApprovalApplication to set
	 */
	public void setPreApprovalApplication(String preApprovalApplication) {
		this.preApprovalApplication = preApprovalApplication;
	}
	/**
	 * @param preApprovalAutopsy the preApprovalAutopsy to set
	 */
	public void setPreApprovalAutopsy(String preApprovalAutopsy) {
		this.preApprovalAutopsy = preApprovalAutopsy;
	}
	public LegalEntity getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}
	/**
	 * @param preApprovalDecision the preApprovalDecision to set
	 */
	public void setPreApprovalDecision(String preApprovalDecision) {
		this.preApprovalDecision = preApprovalDecision;
	}
	/**
	 * @param approvalApplication the approvalApplication to set
	 */
	public void setApprovalApplication(String approvalApplication) {
		this.approvalApplication = approvalApplication;
	}
	/**
	 * @param approvalDecision the approvalDecision to set
	 */
	public void setApprovalDecision(String approvalDecision) {
		this.approvalDecision = approvalDecision;
	}
	/**
	 * @param consensusApplication the consensusApplication to set
	 */
	public void setConsensusApplication(String consensusApplication) {
		this.consensusApplication = consensusApplication;
	}
	/**
	 * @param consensusAutopsy the consensusAutopsy to set
	 */
	public void setConsensusAutopsy(String consensusAutopsy) {
		this.consensusAutopsy = consensusAutopsy;
	}
	/**
	 * @param decision the decision to set
	 */
	public void setDecision(String decision) {
		this.decision = decision;
	}
	/**
	 * @param townshipApplication the townshipApplication to set
	 */
	public void setTownshipApplication(String townshipApplication) {
		this.townshipApplication = townshipApplication;
	}
	/**
	 * @param townshipDecision the townshipDecision to set
	 */
	public void setTownshipDecision(String townshipDecision) {
		this.townshipDecision = townshipDecision;
	}
	/**
	 * @param approvalApplication2 the approvalApplication2 to set
	 */
	public void setApprovalApplication2(String approvalApplication2) {
		this.approvalApplication2 = approvalApplication2;
	}
	/**
	 * @param approvalAutopsy2 the approvalAutopsy2 to set
	 */
	public void setApprovalAutopsy2(String approvalAutopsy2) {
		this.approvalAutopsy2 = approvalAutopsy2;
	}
	/**
	 * @param approvalDecision2 the approvalDecision2 to set
	 */
	public void setApprovalDecision2(String approvalDecision2) {
		this.approvalDecision2 = approvalDecision2;
	}
	public String getConsensusApplication2() {
		return consensusApplication2;
	}
	public void setConsensusApplication2(String consensusApplication2) {
		this.consensusApplication2 = consensusApplication2;
	}
	public String getConsensusAutopsy2() {
		return consensusAutopsy2;
	}
	public void setConsensusAutopsy2(String consensusAutopsy2) {
		this.consensusAutopsy2 = consensusAutopsy2;
	}
	public String getDecision2() {
		return decision2;
	}
	public void setDecision2(String decision2) {
		this.decision2 = decision2;
	}
}
