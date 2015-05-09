package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable 
public class Contact implements Serializable  {
	
	public Contact() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 55)
	private String email;
	
	@Column(length = 25)
	private String tel1;
	
	@Column(length = 25)
	private String tel2;
	
	@Column(length = 25)
	private String fax;
	
	@Column(length = 125)
	private String url;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
