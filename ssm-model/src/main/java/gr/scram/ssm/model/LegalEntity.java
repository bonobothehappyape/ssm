package gr.scram.ssm.model;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Bonobo
 * 
 */
@Entity
@NamedQuery(name = "LegalEntity.findAll", query = " select a from LegalEntity a")
public class LegalEntity extends AbstractJPAEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 155)
	private String name;

	@Column(length = 155)
	private String position;

	@Embedded
	private Address addressInfo = new Address();

	@Embedded
	private Contact contactInfo = new Contact();

	@ManyToOne
	@JoinColumn(name = "CHARGE_ID")
	private Person personInCharge;

	@ManyToOne
	@JoinColumn(name = "COMMUN_ID")
	private Person personToCommunicate;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "FIRE_ID", unique = true, nullable = false, updatable = false)
	private FireProcessing fireProcessing = new FireProcessing();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADM_ID", unique = true, nullable = false, updatable = false)
	private AdminProcessing adminProcessing = new AdminProcessing();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONN_ID", unique = true, nullable = false, updatable = false)
	private ConnectionProcessing connectionProcessing = new ConnectionProcessing();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "ENV_ID", unique = true, nullable = false, updatable = false)
	private EnvironmentProcessing environmentProcessing = new EnvironmentProcessing();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "MINSTR_ID", unique = true, nullable = false, updatable = false)
	private MinistryProcessing ministryProcessing = new MinistryProcessing();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "GARAGE_ID", unique = true, nullable = false, updatable = false)
	private Garage garage = new Garage();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "GAS_ID", unique = true, nullable = false, updatable = false)
	private GasStation gasStation = new GasStation();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "CAR_WASH_ID", unique = true, nullable = false, updatable = false)
	private CarWash carWash = new CarWash();

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROD_ID", unique = true, nullable = false, updatable = false)
	private Production production = new Production();
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "DECS_ID", unique = true, nullable = false, updatable = false)
	private Decision decision = new Decision();
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "CARST_ID", unique = true, nullable = false, updatable = false)
	private CarStation carStation = new CarStation();
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "LPG_ID", unique = true, nullable = false, updatable = false)
	private LPGStation lpgStation = new LPGStation();
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROC_IN_ID", unique = true, nullable = false, updatable = false)
	private ProcedureManualIn procedureManualIn = new ProcedureManualIn();
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROC_OUT_ID", unique = true, nullable = false, updatable = false)
	private ProcedureManualOut procedureManualOut = new ProcedureManualOut();

	/**
	 * 
	 */
	public LegalEntity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(Address addressInfo) {
		this.addressInfo = addressInfo;
	}

	public Contact getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Contact contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Person getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(Person personInCharge) {
		this.personInCharge = personInCharge;
	}

	/**
	 * @return the personToCommunicate
	 */
	public Person getPersonToCommunicate() {
		return personToCommunicate;
	}

	/**
	 * @param personToCommunicate
	 *            the personToCommunicate to set
	 */
	public void setPersonToCommunicate(Person personToCommunicate) {
		this.personToCommunicate = personToCommunicate;
	}

	/**
	 * @return the fireProcessing
	 */
	public FireProcessing getFireProcessing() {
		return fireProcessing;
	}

	/**
	 * @param fireProcessing
	 *            the fireProcessing to set
	 */
	public void setFireProcessing(FireProcessing fireProcessing) {
		this.fireProcessing = fireProcessing;
	}

	/**
	 * @return the adminProcessing
	 */
	public AdminProcessing getAdminProcessing() {
		return adminProcessing;
	}

	/**
	 * @param adminProcessing
	 *            the adminProcessing to set
	 */
	public void setAdminProcessing(AdminProcessing adminProcessing) {
		this.adminProcessing = adminProcessing;
	}

	/**
	 * @return the connectionProcessing
	 */
	public ConnectionProcessing getConnectionProcessing() {
		return connectionProcessing;
	}

	/**
	 * @param connectionProcessing
	 *            the connectionProcessing to set
	 */
	public void setConnectionProcessing(
			ConnectionProcessing connectionProcessing) {
		this.connectionProcessing = connectionProcessing;
	}

	/**
	 * @return the environmentProcessing
	 */
	public EnvironmentProcessing getEnvironmentProcessing() {
		return environmentProcessing;
	}

	/**
	 * @param environmentProcessing
	 *            the environmentProcessing to set
	 */
	public void setEnvironmentProcessing(
			EnvironmentProcessing environmentProcessing) {
		this.environmentProcessing = environmentProcessing;
	}

	/**
	 * @return the ministryProcessing
	 */
	public MinistryProcessing getMinistryProcessing() {
		return ministryProcessing;
	}

	/**
	 * @param ministryProcessing
	 *            the ministryProcessing to set
	 */
	public void setMinistryProcessing(MinistryProcessing ministryProcessing) {
		this.ministryProcessing = ministryProcessing;
	}

	/**
	 * @return the garage
	 */
	public Garage getGarage() {
		return garage;
	}

	/**
	 * @param garage
	 *            the garage to set
	 */
	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	/**
	 * @return the gasStation
	 */
	public GasStation getGasStation() {
		return gasStation;
	}

	/**
	 * @param gasStation
	 *            the gasStation to set
	 */
	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}

	/**
	 * @return the carWash
	 */
	public CarWash getCarWash() {
		return carWash;
	}

	/**
	 * @param carWash
	 *            the carWash to set
	 */
	public void setCarWash(CarWash carWash) {
		this.carWash = carWash;
	}

	/**
	 * @return the carStation
	 */
	public CarStation getCarStation() {
		return carStation;
	}

	/**
	 * @param carStation the carStation to set
	 */
	public void setCarStation(CarStation carStation) {
		this.carStation = carStation;
	}

	/**
	 * @return the decision
	 */
	public Decision getDecision() {
		return decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	/**
	 * @return the production
	 */
	public Production getProduction() {
		return production;
	}

	/**
	 * @param production
	 *            the production to set
	 */
	public void setProduction(Production production) {
		this.production = production;
	}

	/**
	 * @return the lpgStation
	 */
	public LPGStation getLpgStation() {
		return lpgStation;
	}

	/**
	 * @param lpgStation the lpgStation to set
	 */
	public void setLpgStation(LPGStation lpgStation) {
		this.lpgStation = lpgStation;
	}

	/**
	 * @return the procedureManualIn
	 */
	public ProcedureManualIn getProcedureManualIn() {
		return procedureManualIn;
	}

	/**
	 * @param procedureManualIn the procedureManualIn to set
	 */
	public void setProcedureManualIn(ProcedureManualIn procedureManualIn) {
		this.procedureManualIn = procedureManualIn;
	}

	/**
	 * @return the procedureManualOut
	 */
	public ProcedureManualOut getProcedureManualOut() {
		return procedureManualOut;
	}

	/**
	 * @param procedureManualOut the procedureManualOut to set
	 */
	public void setProcedureManualOut(ProcedureManualOut procedureManualOut) {
		this.procedureManualOut = procedureManualOut;
	}

}
