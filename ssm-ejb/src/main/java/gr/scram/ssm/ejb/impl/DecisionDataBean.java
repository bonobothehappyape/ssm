package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.DecisionData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Decision;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DecisionDataBean extends GenericDataBean<Decision, Long> implements
		DecisionData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Decision findByLegalId(final Long legaId) {
		return (Decision) getEntityManager()
				.createQuery(
						" select p from Decision p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

}
