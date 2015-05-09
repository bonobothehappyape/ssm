package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author bonobo
 *
 */
@Entity
@NamedQuery(name = "Ministry.findAll", query = " select a from Ministry a")
public class Ministry extends AbstractJPAEntity {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Ministry() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
