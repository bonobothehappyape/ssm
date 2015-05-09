package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Address implements Serializable {

	public Address() {
		super();
	}

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length = 155)
	private String addressStreet;
	
	@Column(length = 10)
	private String addressNo;
	
	@Column(length = 10)
	private String poCode;
	
	@ManyToOne
	private Municipality municipality;

	/**
	 * @return the addressStreet
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * @param addressStreet
	 *            the addressStreet to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * @return the addressNo
	 */
	public String getAddressNo() {
		return addressNo;
	}

	/**
	 * @param addressNo
	 *            the addressNo to set
	 */
	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	/**
	 * @return the poCode
	 */
	public String getPoCode() {
		return poCode;
	}

	/**
	 * @param poCode
	 *            the poCode to set
	 */
	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}

	/**
	 * @return the municipality
	 */
	public Municipality getMunicipality() {
		return municipality;
	}

	/**
	 * @param municipality
	 *            the municipality to set
	 */
	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressNo == null) ? 0 : addressNo.hashCode());
		result = prime * result
				+ ((addressStreet == null) ? 0 : addressStreet.hashCode());
		result = prime * result
				+ ((municipality == null) ? 0 : municipality.hashCode());
		result = prime * result + ((poCode == null) ? 0 : poCode.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressNo == null) {
			if (other.addressNo != null)
				return false;
		} else if (!addressNo.equals(other.addressNo))
			return false;
		if (addressStreet == null) {
			if (other.addressStreet != null)
				return false;
		} else if (!addressStreet.equals(other.addressStreet))
			return false;
		if (municipality == null) {
			if (other.municipality != null)
				return false;
		} else if (!municipality.equals(other.municipality))
			return false;
		if (poCode == null) {
			if (other.poCode != null)
				return false;
		} else if (!poCode.equals(other.poCode))
			return false;
		return true;
	}
}
