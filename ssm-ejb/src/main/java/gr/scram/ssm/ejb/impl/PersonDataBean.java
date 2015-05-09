package gr.scram.ssm.ejb.impl;

import gr.scram.ssm.ejb.PersonData;
import gr.scram.ssm.ejb.core.impl.GenericDataBean;
import gr.scram.ssm.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDataBean extends GenericDataBean<Person, Long> implements
		PersonData {
	
	@PersistenceContext(unitName = "poc-pu")
	private EntityManager entityManager;


	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
