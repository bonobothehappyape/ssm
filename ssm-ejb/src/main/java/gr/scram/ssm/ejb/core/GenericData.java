package gr.scram.ssm.ejb.core;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

public interface GenericData<E extends AbstractJPAEntity, P> {
	/**
	 * Persist the indicated entity to database
	 * 
	 * @param entity
	 * @return the primary key
	 */
	E insert(E entity);

	/**
	 * Retrieve an object using indicated ID
	 * 
	 * @param id
	 * @return
	 */
	E find(P id);

	/**
	 * Update indicated entity to database
	 * 
	 * @param entity
	 */
	void update(E entity);

	/**
	 * Delete indicated entity from database
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * remove
	 * 
	 * @param entity
	 */
	void delete(P entity);

	/**
	 * Return the entity class
	 * 
	 * @return
	 */
	Class<E> getEntityClass();

	/**
	 * Get the entity manager
	 * 
	 * @return
	 */
	EntityManager getEntityManager();

	/**
	 * 
	 * @return
	 */
	List<E> findAll();

	/**
	 * 
	 * @param entity
	 * @return
	 */
	E save(E entity);

	long countAllByFilters(Map<String, Object> filterMap);
	
	Set<E> findAllByFilters(Map<String, Object> filters);
	
	Set<E> findAllByFilters(Map<String, Object> filters,String property, boolean asc);

	/**
	 * find all rows
	 * 
	 * @param filterMap
	 * @param property
	 * @param string
	 * @param first
	 * @param count
	 * @return
	 */
	Set<E> findAllByFiltersPaged(Map<String, Object> filterMap,
			String property, boolean order, long first, long count);

}