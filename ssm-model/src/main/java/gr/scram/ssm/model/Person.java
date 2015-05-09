package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * 
 * @author Bonobo
 *
 */
@Entity
@NamedQuery(name="Person.findAll", query = " select p from Person p ")
public class Person extends AbstractJPAEntity {


	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;


	public Person() {
		super();
	}

	private String name;
	
	private String surname;
	
	@Embedded
	private Contact contactInfo = new Contact();
	
	@Embedded
	private Address addressInfo = new Address();

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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the contactInfo
	 */
	public Contact getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(Contact contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * @return the addressInfo
	 */
	public Address getAddressInfo() {
		return addressInfo;
	}

	/**
	 * @param addressInfo the addressInfo to set
	 */
	public void setAddressInfo(Address addressInfo) {
		this.addressInfo = addressInfo;
	}
}