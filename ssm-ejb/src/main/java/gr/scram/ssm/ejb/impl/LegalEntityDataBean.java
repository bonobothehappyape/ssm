package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.LegalEntityData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.LegalEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LegalEntityDataBean extends GenericDataBean<LegalEntity, Long> implements
		LegalEntityData {
	
	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
