package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.CarWashData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.CarWash;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarWashDataBean extends GenericDataBean<CarWash, Long>
		implements CarWashData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	@Override
	public CarWash findByLegalId(final Long legaId) {
		return (CarWash) getEntityManager()
				.createQuery(
						" select p from CarWash p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}
}
