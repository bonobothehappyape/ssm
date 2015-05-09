package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.MinistryData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Ministry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MinistryDataBean extends GenericDataBean<Ministry, Long> implements
		MinistryData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
