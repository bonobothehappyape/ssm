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
@NamedQuery(name = "ProcedureManualOut.findAll", query = " select a from ProcedureManualOut a")
@Table
public class ProcedureManualOut extends AbstractJPAEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "procedureManualOut", optional=false)
	private LegalEntity legalEntity;
	
	/**
	 * 
	 */
	public ProcedureManualOut() {
		super();
	}
	
	@Embedded
	private ProcedureManualEmbedded procedureManualEmbedded = new ProcedureManualEmbedded();


	/**
	 * @return the procedureManualEmbedded
	 */
	public ProcedureManualEmbedded getProcedureManualEmbedded() {
		return procedureManualEmbedded;
	}

	/**
	 * @param procedureManualEmbedded the procedureManualEmbedded to set
	 */
	public void setProcedureManualEmbedded(ProcedureManualEmbedded procedureManualEmbedded) {
		this.procedureManualEmbedded = procedureManualEmbedded;
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
