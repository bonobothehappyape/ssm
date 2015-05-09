package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.CarStationData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.CarStation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarStationDataBean extends GenericDataBean<CarStation, Long>
		implements CarStationData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	@Override
	public CarStation findByLegalId(final Long legaId) {
		return (CarStation) getEntityManager()
				.createQuery(
						" select p from CarStation p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}
}
