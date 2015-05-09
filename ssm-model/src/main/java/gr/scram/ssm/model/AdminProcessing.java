/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Sets;

/**
 * @author Bonobo
 * 
 */
@Entity
@NamedQuery(name = "AdminProcessing.findAll", query = " select a from AdminProcessing a")
public class AdminProcessing extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminProcessing() {
		super();
	}

	@OneToOne(optional=false, mappedBy="adminProcessing")
	private LegalEntity legalEntity;

	
	@Column
	private String permitRecall;
	
	@Column
	@Temporal(value = TemporalType.DATE)
	private Date permitDate;
	
	@Column
	private String sealInstallation;
	
	@Column
	@Temporal(value = TemporalType.DATE)
	private Date sealDate;
	@Column
	private String recallGov;
	@Column
	private String sealGov;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="adminProcessing")
	private Set<Appeal> appeals = Sets.newHashSet();

	/**
	 * @return the permitRecall
	 */
	public String getPermitRecall() {
		return permitRecall;
	}

	/**
	 * @return the permitDate
	 */
	public Date getPermitDate() {
		return permitDate;
	}

	/**
	 * @return the sealInstallation
	 */
	public String getSealInstallation() {
		return sealInstallation;
	}

	/**
	 * @return the sealDate
	 */
	public Date getSealDate() {
		return sealDate;
	}

	/**
	 * @return the recallGov
	 */
	public String getRecallGov() {
		return recallGov;
	}

	/**
	 * @return the sealGov
	 */
	public String getSealGov() {
		return sealGov;
	}

	/**
	 * @param permitRecall
	 *            the permitRecall to set
	 */
	public void setPermitRecall(String permitRecall) {
		this.permitRecall = permitRecall;
	}

	/**
	 * @param permitDate
	 *            the permitDate to set
	 */
	public void setPermitDate(Date permitDate) {
		this.permitDate = permitDate;
	}

	/**
	 * @param sealInstallation
	 *            the sealInstallation to set
	 */
	public void setSealInstallation(String sealInstallation) {
		this.sealInstallation = sealInstallation;
	}

	/**
	 * @param sealDate
	 *            the sealDate to set
	 */
	public void setSealDate(Date sealDate) {
		this.sealDate = sealDate;
	}

	/**
	 * @param recallGov
	 *            the recallGov to set
	 */
	public void setRecallGov(String recallGov) {
		this.recallGov = recallGov;
	}

	/**
	 * @param sealGov
	 *            the sealGov to set
	 */
	public void setSealGov(String sealGov) {
		this.sealGov = sealGov;
	}

	/**
	 * @return the appeals
	 */
	public Set<Appeal> getAppeals() {
		return appeals;
	}

	/**
	 * @param appeals
	 *            the appeals to set
	 */
	public void setAppeals(Set<Appeal> appeals) {
		this.appeals = appeals;
	}


	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}
}
