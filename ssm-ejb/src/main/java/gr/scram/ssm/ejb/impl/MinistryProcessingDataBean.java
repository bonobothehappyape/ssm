package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.MinistryProcessingData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.MinistryProcessing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MinistryProcessingDataBean extends GenericDataBean<MinistryProcessing, Long>
		implements MinistryProcessingData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public MinistryProcessing findByLegalId(final Long legaId) {
		return (MinistryProcessing) getEntityManager()
				.createQuery(
						" select p from MinistryProcessing p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

}
