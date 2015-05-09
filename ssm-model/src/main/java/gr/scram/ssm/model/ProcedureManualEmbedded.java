package gr.scram.ssm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProcedureManualEmbedded implements Serializable {
	public ProcedureManualEmbedded() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String landUsage;
	private Boolean landUsageCheck;
	
	private String autopsyTopographic;
	private Boolean autopsyTopographicCheck;
	
	private String signDeclaration;
	private Boolean signDeclarationCheck;
	
	private String suitability;
	private Boolean suitabilityCheck;
	
	private String landUsageReceipt;
	private Boolean landUsageReceiptCheck;
	
	private String studies;
	private Boolean studiesCheck;
	
	private String suitabilityApplication;
	private Boolean suitabilityApplicationCheck;
	
	private String suitabilityAutopsy;
	private Boolean suitabilityAutopsyCheck;
	
	private String suitabilityDecision;
	private Boolean suitabilityDecisionCheck;
	
	private String circulationDeposit;
	private Boolean circulationDepositCheck;
	
	private String circulationAutopsy;
	private Boolean circulationAutopsyCheck;
	
	private String circulationDecision;
	private Boolean circulationDecisionCheck;
	
	private String circulation2Deposit;
	private Boolean circulation2DepositCheck;
	
	private String circulation2Decision;
	private Boolean circulation2DecisionCheck;
	
	private String establishLicence;
	private Boolean establishLicenceCheck;
	
	private String establishLicenceDeposit;
	private Boolean establishLicenceDepositCheck;
	
	private String mpeDecision;
	private Boolean mpeDecisionCheck;
	
	private String mpeDeposit;
	private Boolean mpeDepositCheck;
	
	private String tax;
	private Boolean taxCheck;

	/**
	 * @return the landUsage
	 */
	public String getLandUsage() {
		return landUsage;
	}

	/**
	 * @param landUsage
	 *            the landUsage to set
	 */
	public void setLandUsage(String landUsage) {
		this.landUsage = landUsage;
	}

	/**
	 * @return the landUsageCheck
	 */
	public Boolean getLandUsageCheck() {
		return landUsageCheck;
	}

	/**
	 * @param landUsageCheck
	 *            the landUsageCheck to set
	 */
	public void setLandUsageCheck(Boolean landUsageCheck) {
		this.landUsageCheck = landUsageCheck;
	}

	/**
	 * @return the autopsyTopographic
	 */
	public String getAutopsyTopographic() {
		return autopsyTopographic;
	}

	/**
	 * @param autopsyTopographic
	 *            the autopsyTopographic to set
	 */
	public void setAutopsyTopographic(String autopsyTopographic) {
		this.autopsyTopographic = autopsyTopographic;
	}

	/**
	 * @return the autopsyTopographicCheck
	 */
	public Boolean getAutopsyTopographicCheck() {
		return autopsyTopographicCheck;
	}

	/**
	 * @param autopsyTopographicCheck
	 *            the autopsyTopographicCheck to set
	 */
	public void setAutopsyTopographicCheck(Boolean autopsyTopographicCheck) {
		this.autopsyTopographicCheck = autopsyTopographicCheck;
	}

	/**
	 * @return the signDeclaration
	 */
	public String getSignDeclaration() {
		return signDeclaration;
	}

	/**
	 * @param signDeclaration
	 *            the signDeclaration to set
	 */
	public void setSignDeclaration(String signDeclaration) {
		this.signDeclaration = signDeclaration;
	}

	/**
	 * @return the signDeclarationCheck
	 */
	public Boolean getSignDeclarationCheck() {
		return signDeclarationCheck;
	}

	/**
	 * @param signDeclarationCheck
	 *            the signDeclarationCheck to set
	 */
	public void setSignDeclarationCheck(Boolean signDeclarationCheck) {
		this.signDeclarationCheck = signDeclarationCheck;
	}

	/**
	 * @return the suitability
	 */
	public String getSuitability() {
		return suitability;
	}

	/**
	 * @param suitability
	 *            the suitability to set
	 */
	public void setSuitability(String suitability) {
		this.suitability = suitability;
	}

	/**
	 * @return the suitabilityCheck
	 */
	public Boolean getSuitabilityCheck() {
		return suitabilityCheck;
	}

	/**
	 * @return the suitabilityApplication
	 */
	public String getSuitabilityApplication() {
		return suitabilityApplication;
	}

	/**
	 * @param suitabilityApplication the suitabilityApplication to set
	 */
	public void setSuitabilityApplication(String suitabilityApplication) {
		this.suitabilityApplication = suitabilityApplication;
	}

	/**
	 * @return the suitabilityApplicationCheck
	 */
	public Boolean getSuitabilityApplicationCheck() {
		return suitabilityApplicationCheck;
	}

	/**
	 * @param suitabilityApplicationCheck the suitabilityApplicationCheck to set
	 */
	public void setSuitabilityApplicationCheck(Boolean suitabilityApplicationCheck) {
		this.suitabilityApplicationCheck = suitabilityApplicationCheck;
	}

	/**
	 * @return the circulationDeposit
	 */
	public String getCirculationDeposit() {
		return circulationDeposit;
	}

	/**
	 * @param circulationDeposit the circulationDeposit to set
	 */
	public void setCirculationDeposit(String circulationDeposit) {
		this.circulationDeposit = circulationDeposit;
	}

	/**
	 * @return the circulationDepositCheck
	 */
	public Boolean getCirculationDepositCheck() {
		return circulationDepositCheck;
	}

	/**
	 * @param circulationDepositCheck the circulationDepositCheck to set
	 */
	public void setCirculationDepositCheck(Boolean circulationDepositCheck) {
		this.circulationDepositCheck = circulationDepositCheck;
	}

	/**
	 * @param suitabilityCheck
	 *            the suitabilityCheck to set
	 */
	public void setSuitabilityCheck(Boolean suitabilityCheck) {
		this.suitabilityCheck = suitabilityCheck;
	}

	/**
	 * @return the landUsageReceipt
	 */
	public String getLandUsageReceipt() {
		return landUsageReceipt;
	}

	/**
	 * @param landUsageReceipt
	 *            the landUsageReceipt to set
	 */
	public void setLandUsageReceipt(String landUsageReceipt) {
		this.landUsageReceipt = landUsageReceipt;
	}

	/**
	 * @return the landUsageReceiptCheck
	 */
	public Boolean getLandUsageReceiptCheck() {
		return landUsageReceiptCheck;
	}

	/**
	 * @return the mpeDeposit
	 */
	public String getMpeDeposit() {
		return mpeDeposit;
	}

	/**
	 * @param mpeDeposit the mpeDeposit to set
	 */
	public void setMpeDeposit(String mpeDeposit) {
		this.mpeDeposit = mpeDeposit;
	}

	/**
	 * @return the mpeDepositCheck
	 */
	public Boolean getMpeDepositCheck() {
		return mpeDepositCheck;
	}

	/**
	 * @param mpeDepositCheck the mpeDepositCheck to set
	 */
	public void setMpeDepositCheck(Boolean mpeDepositCheck) {
		this.mpeDepositCheck = mpeDepositCheck;
	}

	/**
	 * @param landUsageReceiptCheck
	 *            the landUsageReceiptCheck to set
	 */
	public void setLandUsageReceiptCheck(Boolean landUsageReceiptCheck) {
		this.landUsageReceiptCheck = landUsageReceiptCheck;
	}

	/**
	 * @return the studies
	 */
	public String getStudies() {
		return studies;
	}

	/**
	 * @return the mpeDecisionCheck
	 */
	public Boolean getMpeDecisionCheck() {
		return mpeDecisionCheck;
	}

	/**
	 * @param mpeDecisionCheck the mpeDecisionCheck to set
	 */
	public void setMpeDecisionCheck(Boolean mpeDecisionCheck) {
		this.mpeDecisionCheck = mpeDecisionCheck;
	}

	/**
	 * @param studies
	 *            the studies to set
	 */
	public void setStudies(String studies) {
		this.studies = studies;
	}

	/**
	 * @return the studiesCheck
	 */
	public Boolean getStudiesCheck() {
		return studiesCheck;
	}

	/**
	 * @param studiesCheck
	 *            the studiesCheck to set
	 */
	public void setStudiesCheck(Boolean studiesCheck) {
		this.studiesCheck = studiesCheck;
	}

	/**
	 * @return the circulationAutopsy
	 */
	public String getCirculationAutopsy() {
		return circulationAutopsy;
	}

	/**
	 * @param circulationAutopsy the circulationAutopsy to set
	 */
	public void setCirculationAutopsy(String circulationAutopsy) {
		this.circulationAutopsy = circulationAutopsy;
	}

	/**
	 * @return the circulationAutopsyCheck
	 */
	public Boolean getCirculationAutopsyCheck() {
		return circulationAutopsyCheck;
	}

	/**
	 * @param circulationAutopsyCheck the circulationAutopsyCheck to set
	 */
	public void setCirculationAutopsyCheck(Boolean circulationAutopsyCheck) {
		this.circulationAutopsyCheck = circulationAutopsyCheck;
	}

	/**
	 * @return the suitabilityAutopsy
	 */
	public String getSuitabilityAutopsy() {
		return suitabilityAutopsy;
	}

	/**
	 * @param suitabilityAutopsy
	 *            the suitabilityAutopsy to set
	 */
	public void setSuitabilityAutopsy(String suitabilityAutopsy) {
		this.suitabilityAutopsy = suitabilityAutopsy;
	}

	/**
	 * @return the suitabilityAutopsyCheck
	 */
	public Boolean getSuitabilityAutopsyCheck() {
		return suitabilityAutopsyCheck;
	}

	/**
	 * @param suitabilityAutopsyCheck
	 *            the suitabilityAutopsyCheck to set
	 */
	public void setSuitabilityAutopsyCheck(Boolean suitabilityAutopsyCheck) {
		this.suitabilityAutopsyCheck = suitabilityAutopsyCheck;
	}

	/**
	 * @return the suitabilityDecision
	 */
	public String getSuitabilityDecision() {
		return suitabilityDecision;
	}

	/**
	 * @param suitabilityDecision
	 *            the suitabilityDecision to set
	 */
	public void setSuitabilityDecision(String suitabilityDecision) {
		this.suitabilityDecision = suitabilityDecision;
	}

	/**
	 * @return the suitabilityDecisionCheck
	 */
	public Boolean getSuitabilityDecisionCheck() {
		return suitabilityDecisionCheck;
	}

	/**
	 * @param suitabilityDecisionCheck
	 *            the suitabilityDecisionCheck to set
	 */
	public void setSuitabilityDecisionCheck(Boolean suitabilityDecisionCheck) {
		this.suitabilityDecisionCheck = suitabilityDecisionCheck;
	}

	/**
	 * @return the circulationDecision
	 */
	public String getCirculationDecision() {
		return circulationDecision;
	}

	/**
	 * @param circulationDecision
	 *            the circulationDecision to set
	 */
	public void setCirculationDecision(String circulationDecision) {
		this.circulationDecision = circulationDecision;
	}

	/**
	 * @return the circulationDecisionCheck
	 */
	public Boolean getCirculationDecisionCheck() {
		return circulationDecisionCheck;
	}

	/**
	 * @param circulationDecisionCheck
	 *            the circulationDecisionCheck to set
	 */
	public void setCirculationDecisionCheck(Boolean circulationDecisionCheck) {
		this.circulationDecisionCheck = circulationDecisionCheck;
	}

	/**
	 * @return the establishLicence
	 */
	public String getEstablishLicence() {
		return establishLicence;
	}

	/**
	 * @param establishLicence
	 *            the establishLicence to set
	 */
	public void setEstablishLicence(String establishLicence) {
		this.establishLicence = establishLicence;
	}

	/**
	 * @return the establishLicenceCheck
	 */
	public Boolean getEstablishLicenceCheck() {
		return establishLicenceCheck;
	}

	/**
	 * @param establishLicenceCheck
	 *            the establishLicenceCheck to set
	 */
	public void setEstablishLicenceCheck(Boolean establishLicenceCheck) {
		this.establishLicenceCheck = establishLicenceCheck;
	}

	/**
	 * @return the circulation2Deposit
	 */
	public String getCirculation2Deposit() {
		return circulation2Deposit;
	}

	/**
	 * @param circulation2Deposit the circulation2Deposit to set
	 */
	public void setCirculation2Deposit(String circulation2Deposit) {
		this.circulation2Deposit = circulation2Deposit;
	}

	/**
	 * @return the circulation2DepositCheck
	 */
	public Boolean getCirculation2DepositCheck() {
		return circulation2DepositCheck;
	}

	/**
	 * @param circulation2DepositCheck the circulation2DepositCheck to set
	 */
	public void setCirculation2DepositCheck(Boolean circulation2DepositCheck) {
		this.circulation2DepositCheck = circulation2DepositCheck;
	}

	/**
	 * @return the circulation2Decision
	 */
	public String getCirculation2Decision() {
		return circulation2Decision;
	}

	/**
	 * @param circulation2Decision the circulation2Decision to set
	 */
	public void setCirculation2Decision(String circulation2Decision) {
		this.circulation2Decision = circulation2Decision;
	}

	/**
	 * @return the circulation2DecisionCheck
	 */
	public Boolean getCirculation2DecisionCheck() {
		return circulation2DecisionCheck;
	}

	/**
	 * @param circulation2DecisionCheck the circulation2DecisionCheck to set
	 */
	public void setCirculation2DecisionCheck(Boolean circulation2DecisionCheck) {
		this.circulation2DecisionCheck = circulation2DecisionCheck;
	}

	/**
	 * @return the mpeDecision
	 */
	public String getMpeDecision() {
		return mpeDecision;
	}

	/**
	 * @param mpeDecision the mpeDecision to set
	 */
	public void setMpeDecision(String mpeDecision) {
		this.mpeDecision = mpeDecision;
	}

	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * @return the taxCheck
	 */
	public Boolean getTaxCheck() {
		return taxCheck;
	}

	/**
	 * @param taxCheck the taxCheck to set
	 */
	public void setTaxCheck(Boolean taxCheck) {
		this.taxCheck = taxCheck;
	}

	/**
	 * @return the establishLicenceDeposit
	 */
	public String getEstablishLicenceDeposit() {
		return establishLicenceDeposit;
	}

	/**
	 * @param establishLicenceDeposit the establishLicenceDeposit to set
	 */
	public void setEstablishLicenceDeposit(String establishLicenceDeposit) {
		this.establishLicenceDeposit = establishLicenceDeposit;
	}

	/**
	 * @return the establishLicenceDepositCheck
	 */
	public Boolean getEstablishLicenceDepositCheck() {
		return establishLicenceDepositCheck;
	}

	/**
	 * @param establishLicenceDepositCheck the establishLicenceDepositCheck to set
	 */
	public void setEstablishLicenceDepositCheck(
			Boolean establishLicenceDepositCheck) {
		this.establishLicenceDepositCheck = establishLicenceDepositCheck;
	}

}
