package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.GarageData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Garage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GarageDataBean extends GenericDataBean<Garage, Long> implements
		GarageData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Garage findByLegalId(Long id) {
		return (Garage) getEntityManager()
				.createQuery(
						" select p from Garage p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", id).getSingleResult();
	}

}
