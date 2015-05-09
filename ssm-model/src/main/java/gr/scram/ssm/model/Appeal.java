/**
 * 
 */
package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Bonobo
 * 
 */
@Entity
public class Appeal extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Appeal() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "LAWYER_ID")
	private Person lawyer;

	@ManyToOne
	@JoinColumn(name = "ADM_ID", nullable = false)
	private AdminProcessing adminProcessing;

	@Column
	private String prefects;

	@Column
	private String stateCouncil;

	@Column
	private String comments;

	/**
	 * @return the prefects
	 */
	public String getPrefects() {
		return prefects;
	}

	/**
	 * @return the stateCouncil
	 */
	public String getStateCouncil() {
		return stateCouncil;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param prefects
	 *            the prefects to set
	 */
	public void setPrefects(String prefects) {
		this.prefects = prefects;
	}

	/**
	 * @param stateCouncil
	 *            the stateCouncil to set
	 */
	public void setStateCouncil(String stateCouncil) {
		this.stateCouncil = stateCouncil;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the lawyer
	 */
	public Person getLawyer() {
		return lawyer;
	}

	/**
	 * @param lawyer
	 *            the lawyer to set
	 */
	public void setLawyer(Person lawyer) {
		this.lawyer = lawyer;
	}

	/**
	 * @return the adminProcessing
	 */
	public AdminProcessing getAdminProcessing() {
		return adminProcessing;
	}

	/**
	 * @param adminProcessing the adminProcessing to set
	 */
	public void setAdminProcessing(AdminProcessing adminProcessing) {
		this.adminProcessing = adminProcessing;
	}

}
