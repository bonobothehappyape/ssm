package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.ProcedureManualInData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.ProcedureManualIn;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProcedureManualInDataBean extends
		GenericDataBean<ProcedureManualIn, Long> implements
		ProcedureManualInData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public ProcedureManualIn findByLegalId(Long id) {
		return (ProcedureManualIn) getEntityManager()
				.createQuery(
						" select p from ProcedureManualIn p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", id).getSingleResult();
	}
}
