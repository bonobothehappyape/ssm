/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Bonobo
 *
 */
@Entity
@NamedQuery(name = "ProcedureManualIn.findAll", query = " select a from ProcedureManualIn a")
@Table
public class ProcedureManualIn extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "procedureManualIn", optional=false)
	private LegalEntity legalEntity;

	/**
	 * 
	 */
	public ProcedureManualIn() {
		super();
	}
	
	@Embedded
	private ProcedureManualEmbedded procedureManualEmbedded = new ProcedureManualEmbedded();
	
	private String sidewalk;
	
	private Boolean sidewalkCheck;
	
	private String fireCertificate;
	
	private Boolean fireCertificateCheck;
	
	private String sidewalkReceipt;
	
	private Boolean sidewalkReceiptCheck;

	/**
	 * @return the sidewalk
	 */
	public String getSidewalk() {
		return sidewalk;
	}

	/**
	 * @return the sidewalkCheck
	 */
	public Boolean getSidewalkCheck() {
		return sidewalkCheck;
	}

	/**
	 * @return the sidewalkReceipt
	 */
	public String getSidewalkReceipt() {
		return sidewalkReceipt;
	}

	/**
	 * @return the sidewalkReceiptCheck
	 */
	public Boolean getSidewalkReceiptCheck() {
		return sidewalkReceiptCheck;
	}

	/**
	 * @param sidewalk the sidewalk to set
	 */
	public void setSidewalk(String sidewalk) {
		this.sidewalk = sidewalk;
	}

	/**
	 * @param sidewalkCheck the sidewalkCheck to set
	 */
	public void setSidewalkCheck(Boolean sidewalkCheck) {
		this.sidewalkCheck = sidewalkCheck;
	}

	/**
	 * @param sidewalkReceipt the sidewalkReceipt to set
	 */
	public void setSidewalkReceipt(String sidewalkReceipt) {
		this.sidewalkReceipt = sidewalkReceipt;
	}

	/**
	 * @param sidewalkReceiptCheck the sidewalkReceiptCheck to set
	 */
	public void setSidewalkReceiptCheck(Boolean sidewalkReceiptCheck) {
		this.sidewalkReceiptCheck = sidewalkReceiptCheck;
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

	/**
	 * @return the procedureManualEmbedded
	 */
	public ProcedureManualEmbedded getProcedureManualEmbedded() {
		return procedureManualEmbedded;
	}

	/**
	 * @param procedureManualEmbedded the procedureManualEmbedded to set
	 */
	public void setProcedureManualEmbedded(
			ProcedureManualEmbedded procedureManualEmbedded) {
		this.procedureManualEmbedded = procedureManualEmbedded;
	}

	/**
	 * @return the fireCertificate
	 */
	public String getFireCertificate() {
		return fireCertificate;
	}

	/**
	 * @param fireCertificate the fireCertificate to set
	 */
	public void setFireCertificate(String fireCertificate) {
		this.fireCertificate = fireCertificate;
	}

	/**
	 * @return the fireCertificateCheck
	 */
	public Boolean getFireCertificateCheck() {
		return fireCertificateCheck;
	}

	/**
	 * @param fireCertificateCheck the fireCertificateCheck to set
	 */
	public void setFireCertificateCheck(Boolean fireCertificateCheck) {
		this.fireCertificateCheck = fireCertificateCheck;
	}
	
}
