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
@NamedQuery(name = "EnvironmentProcessing.findAll", query = " select a from EnvironmentProcessing a")
public class EnvironmentProcessing extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnvironmentProcessing() {
		super();
	}
	
	@OneToOne(mappedBy = "environmentProcessing", optional=false)
	private LegalEntity legalEntity;
	
	@Column
	private String envApplication;
	@Column
	private String envAutopsy;
	@Column
	private String envApproval;

	/**
	 * @return the envApplication
	 */
	public String getEnvApplication() {
		return envApplication;
	}

	/**
	 * @return the envAutopsy
	 */
	public String getEnvAutopsy() {
		return envAutopsy;
	}

	/**
	 * @return the envApproval
	 */
	public String getEnvApproval() {
		return envApproval;
	}

	/**
	 * @param envApplication the envApplication to set
	 */
	public void setEnvApplication(String envApplication) {
		this.envApplication = envApplication;
	}

	/**
	 * @param envAutopsy the envAutopsy to set
	 */
	public void setEnvAutopsy(String envAutopsy) {
		this.envAutopsy = envAutopsy;
	}

	/**
	 * @param envApproval the envApproval to set
	 */
	public void setEnvApproval(String envApproval) {
		this.envApproval = envApproval;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

}
