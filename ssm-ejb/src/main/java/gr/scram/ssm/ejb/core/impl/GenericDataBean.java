package gr.scram.ssm.ejb.core.impl;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

@Local(GenericData.class)
public abstract class GenericDataBean<E extends AbstractJPAEntity, P>
		implements GenericData<E, P> {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(GenericDataBean.class);

	private Class<E> entityClass;

	@Override
	public E insert(final E entity) {
		getEntityManager().persist(entity);
		getEntityManager().flush();
		getEntityManager().refresh(entity);
		return entity;
	}

	@Override
	public E save(final E entity) {
		if (entity.getId() == null)
			getEntityManager().persist(entity);
		else
			update(entity);
		return entity;
	}

	public abstract EntityManager getEntityManager();

	public GenericDataBean() {
		super();
	}

	public GenericDataBean(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public E find(final P id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	@Override
	public void update(final E entity) {
		getEntityManager().merge(entity);
	}

	@Override
	public void delete(final E entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public void delete(final P entity) {
		getEntityManager().remove(find(entity));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<E> getEntityClass() {
		if (entityClass == null) {
			final Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				final ParameterizedType paramType = (ParameterizedType) type;
				entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
			} else {
				throw new IllegalArgumentException(
						"Could not fetch entity class by reflection");
			}
		}
		return entityClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return getEntityManager().createNamedQuery(
				getEntityClass().getSimpleName() + ".findAll").getResultList();
	}

	@Override
	public long countAllByFilters(final Map<String, Object> filterMap) {
		
		final CriteriaQuery<Long> cq = getCriteriaBuilder().createQuery(Long.class);
		Root<E> root = cq.from(getEntityClass());
		cq.select(getCriteriaBuilder().count(root));
		for (final Entry<String, Object> entry : filterMap.entrySet()) {
			final Predicate condition = getCriteriaBuilder().equal(
					root.<E> get(entry.getKey()), entry.getValue());
			cq.where(condition);
		}
		return (Long) getEntityManager().createQuery(cq).getSingleResult();
	}

	/**
	 * get {@link Criteria} for a given type.
	 * 
	 * @param clazz
	 *            the type
	 * @return the {@link Criteria}.
	 */
	public CriteriaQuery<E> getCriteria() {

		final CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();

		return qb.createQuery(getEntityClass());
	}

	private int safeLongToInt(final long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l
					+ " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<E> findAllByFiltersPaged(final Map<String, Object> filterMap,
			final String property, final boolean asc, final long first,
			final long count) {
		final CriteriaQuery<E> crit = getCriteria();
		final Root<E> root = crit.from(getEntityClass());
		for (final Entry<String, Object> entry : filterMap.entrySet()) {
			final Predicate condition = getCriteriaBuilder().equal(
					root.<E> get(entry.getKey()), entry.getValue());
			crit.where(condition);
		}
		if (asc) {
			crit.orderBy(getCriteriaBuilder().asc(root.<E> get(property)));
		} else {
			crit.orderBy(getCriteriaBuilder().desc(root.<E> get(property)));
		}
		final Query typedQuery = getTypedQuery(crit);
		typedQuery.setFirstResult(safeLongToInt(first));
		typedQuery.setMaxResults(safeLongToInt(count));
		
		return Sets.newHashSet(typedQuery.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<E> findAllByFilters(final Map<String, Object> filters) {
		final CriteriaQuery<E> crit = getCriteria();
		final Root<E> root = crit.from(getEntityClass());
		for (final Entry<String, Object> entry : filters.entrySet()) {
			final Predicate condition = getCriteriaBuilder().equal(
					root.<E> get(entry.getKey()), entry.getValue());
			crit.where(condition);
		}
		return Sets.newHashSet(getTypedQuery(crit).getResultList());
	}

	private Query getTypedQuery(final CriteriaQuery<E> crit) {
		final TypedQuery<E> q = getEntityManager().createQuery(crit);
		return q;
	}

	private CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<E> findAllByFilters(final Map<String, Object> filters,
			final String property, final boolean asc) {
		final CriteriaQuery<E> crit = getCriteria();
		final Root<E> root = crit.from(getEntityClass());
		for (final Entry<String, Object> entry : filters.entrySet()) {
			final Predicate condition = getCriteriaBuilder().equal(
					root.<E> get(entry.getKey()), entry.getValue());
			crit.where(condition);
		}
		if (asc) {
			crit.orderBy(getCriteriaBuilder().asc(root.<E> get(property)));
		} else {
			crit.orderBy(getCriteriaBuilder().desc(root.<E> get(property)));
		}
		return Sets.newHashSet(getTypedQuery(crit).getResultList());
	}

}