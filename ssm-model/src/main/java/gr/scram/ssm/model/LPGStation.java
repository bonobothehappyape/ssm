package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Συνεργείο.
 * 
 * @author bonobo
 * 
 */
@Entity
@NamedQuery(name = "LPGStation.findAll", query = " select a from LPGStation a")
public class LPGStation extends AbstractJPAEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@OneToOne(mappedBy = "lpgStation", optional = false)
	private LegalEntity legalEntity;
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
