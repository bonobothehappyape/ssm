package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.AdminProcessingData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.AdminProcessing;
import gr.scram.ssm.model.LegalEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminProcessingDataBean extends
		GenericDataBean<AdminProcessing, Long> implements AdminProcessingData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public AdminProcessing findByLegalId(final Long legaId) {
		return (AdminProcessing) getEntityManager()
				.createQuery(
						" select p from AdminProcessing p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

	@Override
	public AdminProcessing findByLegalId(final LegalEntity le) {

		return (AdminProcessing) getEntityManager()
				.createQuery(
						" select p from AdminProcessing p where p.legalEntity =:legalId ")
				.setParameter("legalId", le).getSingleResult();

	}

}
