package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.AppealData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Appeal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AppealDataBean extends GenericDataBean<Appeal, Long> implements
		AppealData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Appeal findByAdminProcessingId(Long id) {
		return (Appeal) getEntityManager()
				.createQuery(
						" select p from Appeal p where p.adminProcessing.id =:adminProcessingId ")
				.setParameter("adminProcessingId", id).getSingleResult();
	}

}
