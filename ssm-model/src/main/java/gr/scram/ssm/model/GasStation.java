package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 * Πρατήριο Υγρών Καυσίμων.
 * @author Bonobo
 */
@Entity
@NamedQuery(name = "GasStation.findAll", query = " select a from GasStation a")
public class GasStation extends AbstractJPAEntity {
	
	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "gasStation", optional=false)
	private LegalEntity legalEntity;
	
	private String unleadeGas;

	private String superGas;
	
	private String lpg;

	private String unleadedSuperPlusGas;

	private String dieselVehicle;

	private String dieselHeating;

	private Integer gasTankTotal;

	private Integer dieselTotal;

	private String comments;
	
	@Embedded
	private CertifiedPumpsInfo certifiedPumps = new CertifiedPumpsInfo();

	/**
	 * @return the unleadeGas
	 */
	public String getUnleadeGas() {
		return unleadeGas;
	}

	/**
	 * @return the superGas
	 */
	public String getSuperGas() {
		return superGas;
	}

	/**
	 * @return the unleadedSuperPlusGas
	 */
	public String getUnleadedSuperPlusGas() {
		return unleadedSuperPlusGas;
	}

	/**
	 * @return the dieselVehicle
	 */
	public String getDieselVehicle() {
		return dieselVehicle;
	}

	/**
	 * @return the dieselHeating
	 */
	public String getDieselHeating() {
		return dieselHeating;
	}

	/**
	 * @return the gasTankTotal
	 */
	public Integer getGasTankTotal() {
		return gasTankTotal;
	}

	/**
	 * @return the dieselTotal
	 */
	public Integer getDieselTotal() {
		return dieselTotal;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param unleadeGas
	 *            the unleadeGas to set
	 */
	public void setUnleadeGas(String unleadeGas) {
		this.unleadeGas = unleadeGas;
	}

	/**
	 * @param superGas
	 *            the superGas to set
	 */
	public void setSuperGas(String superGas) {
		this.superGas = superGas;
	}

	/**
	 * @param unleadedSuperPlusGas
	 *            the unleadedSuperPlusGas to set
	 */
	public void setUnleadedSuperPlusGas(String unleadedSuperPlusGas) {
		this.unleadedSuperPlusGas = unleadedSuperPlusGas;
	}

	/**
	 * @param dieselVehicle
	 *            the dieselVehicle to set
	 */
	public void setDieselVehicle(String dieselVehicle) {
		this.dieselVehicle = dieselVehicle;
	}

	/**
	 * @param dieselHeating
	 *            the dieselHeating to set
	 */
	public void setDieselHeating(String dieselHeating) {
		this.dieselHeating = dieselHeating;
	}

	/**
	 * @param gasTankTotal
	 *            the gasTankTotal to set
	 */
	public void setGasTankTotal(Integer gasTankTotal) {
		this.gasTankTotal = gasTankTotal;
	}

	/**
	 * @param dieselTotal
	 *            the dieselTotal to set
	 */
	public void setDieselTotal(Integer dieselTotal) {
		this.dieselTotal = dieselTotal;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Constructor.
	 */
	public GasStation() {
		super();
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

	/**
	 * @return the certifiedPumps
	 */
	public CertifiedPumpsInfo getCertifiedPumps() {
		return certifiedPumps;
	}

	/**
	 * @param certifiedPumps the certifiedPumps to set
	 */
	public void setCertifiedPumps(CertifiedPumpsInfo certifiedPumps) {
		this.certifiedPumps = certifiedPumps;
	}

	/**
	 * @return the lpg
	 */
	public String getLpg() {
		return lpg;
	}

	/**
	 * @param lpg the lpg to set
	 */
	public void setLpg(String lpg) {
		this.lpg = lpg;
	}

}
