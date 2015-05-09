package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.GasStationData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.GasStation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GasStationDataBean extends GenericDataBean<GasStation, Long>
		implements GasStationData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public GasStation findByLegalId(Long id) {
		return (GasStation) getEntityManager()
				.createQuery(
						" select p from GasStation p where p.legalEntity.id =:legalId ")
				.setParameter("legalId", id).getSingleResult();
	}

}
