package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.ProductionData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Production;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductionDataBean extends GenericDataBean<Production, Long>
		implements ProductionData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Production findByLegalId(final Long legaId) {
		return (Production) getEntityManager()
				.createQuery(
						" select p from Production p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", legaId).getSingleResult();
	}

}
