package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.ParkingStationData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.ParkingStation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParkingStationDataBean extends GenericDataBean<ParkingStation, Long>
		implements ParkingStationData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
