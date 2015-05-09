package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.LPGStationData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.LPGStation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LPGStationDataBean extends GenericDataBean<LPGStation, Long>
		implements LPGStationData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public LPGStation findByLegalId(Long id) {
		return (LPGStation) getEntityManager()
				.createQuery(
						" select p from LPGStation p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", id).getSingleResult();
	}

}
