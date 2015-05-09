package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.ConnectionProcessingData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.ConnectionProcessing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ConnectionProcessingDataBean extends GenericDataBean<ConnectionProcessing, Long>
		implements ConnectionProcessingData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public ConnectionProcessing findByLegalId(final Long legaId) {
		return (ConnectionProcessing) getEntityManager()
				.createQuery(
						" select p from ConnectionProcessing p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

}
