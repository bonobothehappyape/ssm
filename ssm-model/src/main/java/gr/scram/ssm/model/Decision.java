package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author bonobo
 * 
 */
@Entity
@NamedQuery(name = "Decision.findAll", query = " select a from Decision a")
public class Decision extends AbstractJPAEntity {

	@OneToOne(mappedBy = "decision", optional = false)
	private LegalEntity legalEntity;

	@ManyToOne
	@JoinColumn(name = "MIN_ID", nullable = true, updatable = true)
	private Ministry ministry;

	private static final long serialVersionUID = 1L;

	private String envelopeNumber;

	private String workPermission;

	private String lastApprovedPlans;

	private String newEnvelopeNumber;

	private String newSuitability;

	private String newEstablishLicense;

	private String newWorkPermission;

	private String electricCerticifate;

	private String fireStudyApproval;

	private String fireStudyModification;

	private String fireStudyCertificate;

	private Date fireRenewal;

	private Boolean fireUpdate;

	private String envMPE;

	private Date envRenewal;

	private Boolean envUpdate;

	public Decision() {
		super();
	}

	/**
	 * @return the envelopeNumber
	 */
	public String getEnvelopeNumber() {
		return envelopeNumber;
	}

	/**
	 * @param envelopeNumber
	 *            the envelopeNumber to set
	 */
	public void setEnvelopeNumber(String envelopeNumber) {
		this.envelopeNumber = envelopeNumber;
	}

	/**
	 * @return the workPermission
	 */
	public String getWorkPermission() {
		return workPermission;
	}

	/**
	 * @param workPermission
	 *            the workPermission to set
	 */
	public void setWorkPermission(String workPermission) {
		this.workPermission = workPermission;
	}

	/**
	 * @return the lastApprovedPlans
	 */
	public String getLastApprovedPlans() {
		return lastApprovedPlans;
	}

	/**
	 * @param lastApprovedPlans
	 *            the lastApprovedPlans to set
	 */
	public void setLastApprovedPlans(String lastApprovedPlans) {
		this.lastApprovedPlans = lastApprovedPlans;
	}

	/**
	 * @return the newEnvelopeNumber
	 */
	public String getNewEnvelopeNumber() {
		return newEnvelopeNumber;
	}

	/**
	 * @param newEnvelopeNumber
	 *            the newEnvelopeNumber to set
	 */
	public void setNewEnvelopeNumber(String newEnvelopeNumber) {
		this.newEnvelopeNumber = newEnvelopeNumber;
	}

	/**
	 * @return the newSuitability
	 */
	public String getNewSuitability() {
		return newSuitability;
	}

	/**
	 * @param newSuitability
	 *            the newSuitability to set
	 */
	public void setNewSuitability(String newSuitability) {
		this.newSuitability = newSuitability;
	}

	/**
	 * @return the newEstablishLicense
	 */
	public String getNewEstablishLicense() {
		return newEstablishLicense;
	}

	/**
	 * @return the ministry
	 */
	public Ministry getMinistry() {
		return ministry;
	}

	/**
	 * @param ministry the ministry to set
	 */
	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}

	/**
	 * @return the legalEntity
	 */
	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	/**
	 * @param legalEntity
	 *            the legalEntity to set
	 */
	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	/**
	 * @param newEstablishLicense
	 *            the newEstablishLicense to set
	 */
	public void setNewEstablishLicense(String newEstablishLicense) {
		this.newEstablishLicense = newEstablishLicense;
	}

	/**
	 * @return the newWorkPermission
	 */
	public String getNewWorkPermission() {
		return newWorkPermission;
	}

	/**
	 * @param newWorkPermission
	 *            the newWorkPermission to set
	 */
	public void setNewWorkPermission(String newWorkPermission) {
		this.newWorkPermission = newWorkPermission;
	}

	/**
	 * @return the electricCerticifate
	 */
	public String getElectricCerticifate() {
		return electricCerticifate;
	}

	/**
	 * @param electricCerticifate
	 *            the electricCerticifate to set
	 */
	public void setElectricCerticifate(String electricCerticifate) {
		this.electricCerticifate = electricCerticifate;
	}

	/**
	 * @return the fireStudyApproval
	 */
	public String getFireStudyApproval() {
		return fireStudyApproval;
	}

	/**
	 * @param fireStudyApproval
	 *            the fireStudyApproval to set
	 */
	public void setFireStudyApproval(String fireStudyApproval) {
		this.fireStudyApproval = fireStudyApproval;
	}

	/**
	 * @return the fireStudyModification
	 */
	public String getFireStudyModification() {
		return fireStudyModification;
	}

	/**
	 * @param fireStudyModification
	 *            the fireStudyModification to set
	 */
	public void setFireStudyModification(String fireStudyModification) {
		this.fireStudyModification = fireStudyModification;
	}

	/**
	 * @return the fireStudyCertificate
	 */
	public String getFireStudyCertificate() {
		return fireStudyCertificate;
	}

	/**
	 * @param fireStudyCertificate
	 *            the fireStudyCertificate to set
	 */
	public void setFireStudyCertificate(String fireStudyCertificate) {
		this.fireStudyCertificate = fireStudyCertificate;
	}

	/**
	 * @return the fireRenewal
	 */
	public Date getFireRenewal() {
		return fireRenewal;
	}

	/**
	 * @param fireRenewal
	 *            the fireRenewal to set
	 */
	public void setFireRenewal(Date fireRenewal) {
		this.fireRenewal = fireRenewal;
	}

	/**
	 * @return the fireUpdate
	 */
	public Boolean getFireUpdate() {
		return fireUpdate;
	}

	/**
	 * @param fireUpdate
	 *            the fireUpdate to set
	 */
	public void setFireUpdate(Boolean fireUpdate) {
		this.fireUpdate = fireUpdate;
	}

	/**
	 * @return the envMPE
	 */
	public String getEnvMPE() {
		return envMPE;
	}

	/**
	 * @param envMPE
	 *            the envMPE to set
	 */
	public void setEnvMPE(String envMPE) {
		this.envMPE = envMPE;
	}

	/**
	 * @return the envRenewal
	 */
	public Date getEnvRenewal() {
		return envRenewal;
	}

	/**
	 * @param envRenewal
	 *            the envRenewal to set
	 */
	public void setEnvRenewal(Date envRenewal) {
		this.envRenewal = envRenewal;
	}

	/**
	 * @return the envUpdate
	 */
	public Boolean getEnvUpdate() {
		return envUpdate;
	}

	/**
	 * @param envUpdate
	 *            the envUpdate to set
	 */
	public void setEnvUpdate(Boolean envUpdate) {
		this.envUpdate = envUpdate;
	}

}
