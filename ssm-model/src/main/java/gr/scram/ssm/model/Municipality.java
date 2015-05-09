package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Municipality.findAll", query = " select a from Municipality a")
public class Municipality extends AbstractJPAEntity {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@Column
	private String code;
	
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
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
