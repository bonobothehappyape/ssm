package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.MunicipalityData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Municipality;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MunicipalityDataBean extends GenericDataBean<Municipality, Long>
		implements MunicipalityData {

	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
