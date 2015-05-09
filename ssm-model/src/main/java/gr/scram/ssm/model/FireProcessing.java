/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Bonobo
 *
 */
@Entity
@NamedQuery(name = "FireProcessing.findAll", query = " select a from FireProcessing a")
public class FireProcessing extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public FireProcessing() {
		super();
	}
	
	@OneToOne(mappedBy = "fireProcessing" , optional=false)
	private LegalEntity legalEntity;
	
	@Column
	private String studyApplication;
	@Column
	private String studyDecision;
	@Column
	private String studyChangeApplication;
	@Column
	private String certificateApplication;
	@Column
	private String certificateGrant;

	@ManyToOne
    @JoinColumn(name="STUD_ID", nullable=true, updatable=true)
	private Person studyPerson;
	
	@Column
	private Person autopsy;
	
	@ManyToOne
    @JoinColumn(name="AUT_ID", nullable=true, updatable=true)
	private Person autopsyPerson;

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public String getStudyApplication() {
		return studyApplication;
	}

	public String getStudyDecision() {
		return studyDecision;
	}

	public String getStudyChangeApplication() {
		return studyChangeApplication;
	}

	public String getCertificateApplication() {
		return certificateApplication;
	}

	public String getCertificateGrant() {
		return certificateGrant;
	}

	public Person getStudyPerson() {
		return studyPerson;
	}

	public Person getAutopsy() {
		return autopsy;
	}

	public Person getAutopsyPerson() {
		return autopsyPerson;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public void setStudyApplication(String studyApplication) {
		this.studyApplication = studyApplication;
	}

	public void setStudyDecision(String studyDecision) {
		this.studyDecision = studyDecision;
	}

	public void setStudyChangeApplication(String studyChangeApplication) {
		this.studyChangeApplication = studyChangeApplication;
	}

	public void setCertificateApplication(String certificateApplication) {
		this.certificateApplication = certificateApplication;
	}

	public void setCertificateGrant(String certificateGrant) {
		this.certificateGrant = certificateGrant;
	}

	public void setStudyPerson(Person studyPerson) {
		this.studyPerson = studyPerson;
	}

	public void setAutopsy(Person autopsy) {
		this.autopsy = autopsy;
	}

	public void setAutopsyPerson(Person autopsyPerson) {
		this.autopsyPerson = autopsyPerson;
	}

	
	
}
