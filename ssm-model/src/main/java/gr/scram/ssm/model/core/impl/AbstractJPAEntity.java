package gr.scram.ssm.model.core.impl;


import gr.scram.ssm.model.core.Identifiable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class AbstractJPAEntity implements Identifiable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_generator")
	@SequenceGenerator(name="id_sequence_generator", sequenceName="tec_id")
	@Column(name="PK_ID", nullable = false)
	private Long id ;

	public AbstractJPAEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	

}
