package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.EnvironmentProcessingData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.EnvironmentProcessing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnvironmentProcessingDataBean extends GenericDataBean<EnvironmentProcessing, Long>
		implements EnvironmentProcessingData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public EnvironmentProcessing findByLegalId(final Long legaId) {
		return (EnvironmentProcessing) getEntityManager()
				.createQuery(
						" select p from EnvironmentProcessing p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

}
