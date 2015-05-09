package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.FireProcessingData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.FireProcessing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FireProcessingDataBean extends GenericDataBean<FireProcessing, Long>
		implements FireProcessingData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public FireProcessing findByLegalId(final Long legaId) {
		return (FireProcessing) getEntityManager()
				.createQuery(
						" select p from FireProcessing p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}
}
