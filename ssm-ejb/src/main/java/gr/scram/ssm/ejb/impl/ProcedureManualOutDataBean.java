package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.ProcedureManualOutData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.ProcedureManualOut;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProcedureManualOutDataBean extends
		GenericDataBean<ProcedureManualOut, Long> implements
		ProcedureManualOutData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public ProcedureManualOut findByLegalId(Long id) {
		return (ProcedureManualOut) getEntityManager()
				.createQuery(
						" select p from ProcedureManualOut p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", id).getSingleResult();
	}

}
