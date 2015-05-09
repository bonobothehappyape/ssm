package gr.scram.wicket.components;

import gr.scram.ssm.ejb.core.BeanFactory;
import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.Entity;

import org.apache.wicket.cdi.CdiContainer;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link SortableDataProvider} for managed entities.
 * 
 * @author asvesdi
 * 
 * @param <T>
 *            - Entity
 * @param <PK>
 *            - Key.
 */
public class EntityDataProvider<T extends AbstractJPAEntity> extends
		SortableDataProvider<T, String> {
	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(EntityDataProvider.class);

	/**
	 * Factory for Data objects.
	 */
	@Inject
	private BeanFactory daoFactory;

	/**
	 * The {@link Class} of the entity.
	 */
	private Class<T> entityClass;

	/**
	 * Filter Map.
	 */
	private Map<String, Object> filterMap = new HashMap<String, Object>();

	/**
	 * Constructor.
	 * 
	 * @param entityClass
	 *            - entity {@link Class}
	 * @param defaultSortProperty
	 *            - sort property.
	 * @param map
	 *            - filter map.
	 */
	public EntityDataProvider(final Class<T> entityClass,
			final String defaultSortProperty, final Map<String, Object> map) {
		this.entityClass = entityClass;
		if (map != null) {
			this.filterMap = map;
		}
		setSort(new SortParam<String>(defaultSortProperty, true));
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * Getter for {@link IDAO}.
	 * 
	 * @return - the {@link IDAO}.
	 */
	protected GenericData<T, Long> getEntityDao() {
		return daoFactory.createProvider(getEntityClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long size() {
		return getEntityDao().countAllByFilters(filterMap);
	}

	/**
	 * {@inheritDoc}
	 */
	public IModel<T> model(T object) {
		return getEntityModel(object);
	}

	/**
	 * get the {@link Entity} Model.
	 * 
	 * @param object
	 *            - type
	 * @return - the model.
	 */
	private IModel<T> getEntityModel(T object) {
		return new EntityModel<T, Long>(getEntityClass(), object.getId());
	}

	/**
	 * @return the filterMap
	 */
	public Map<String, Object> getFilterMap() {
		return filterMap;
	}

	/**
	 * @param filterMap
	 *            the filterMap to set
	 */
	public void setFilterMap(Map<String, Object> filterMap) {
		this.filterMap = filterMap;
	}

	@Override
	public Iterator<? extends T> iterator(long first, long count) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("filters: \n");
			for (Entry<String, Object> entry : filterMap.entrySet()) {
				LOG.debug("property:" + entry.getKey());
				LOG.debug("value:" + entry.getValue());
			}
			LOG.debug("first: " + first);
			LOG.debug("count: " + count);
			LOG.debug("sort: " + getSort().getProperty());
			LOG.debug("ord: "
					+ (getSort().isAscending() ? SortOrder.ASCENDING.name()
							: SortOrder.DESCENDING.name()));
		}
		final Iterator<T> it = getEntityDao().findAllByFiltersPaged(filterMap,
				getSort().getProperty(),
				getSort().isAscending() ? true : false, first, count)
				.iterator();
		return it;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}
}
