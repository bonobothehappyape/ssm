package gr.scram.wicket.components;

import gr.scram.ssm.ejb.core.BeanFactory;
import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.wicket.cdi.CdiContainer;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.model.LoadableDetachableModel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Collections' Detachable model used for drop downs. lists etc.
 * 
 * @author asvesdi
 * 
 * @param <T>
 * @param <PK>
 */
public class EntityListModel<T extends AbstractJPAEntity> extends
		LoadableDetachableModel< List < ? extends T > > {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Injected data object factory.
	 */
	@Inject
	private BeanFactory daoFactory;

	/**
	 * Class type.
	 */
	private final Class<T> entityClass;

	/**
	 * sorting property.
	 */
	private String sortProperty = "id";

	/**
	 * Order.
	 */
	private SortOrder sortOrder = SortOrder.ASCENDING;

	/**
	 * Filters.
	 */
	private Map<String, Object> filters = Maps.newHashMap();

	/**
	 * Constructor.
	 * 
	 * @param entityClass
	 *            type
	 * @param sortProperty
	 *            sort property
	 * @param sortOrder
	 *            order property
	 */
	public EntityListModel(final Class<T> entityClass,
			final String sortProperty, final SortOrder sortOrder) {
		this.entityClass = entityClass;
		this.sortProperty = sortProperty;
		this.sortOrder = sortOrder;
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param entityClass
	 *            type.
	 */
	public EntityListModel(final Class<T> entityClass) {
		this.entityClass = entityClass;
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param entityClass
	 *            typr
	 * @param sortProperty
	 *            sort property
	 * @param filters
	 *            filter map
	 */
	public EntityListModel(final Class<T> entityClass,
			final String sortProperty, final Map<String, Object> filters) {
		super();
		this.entityClass = entityClass;
		this.sortProperty = sortProperty;
		this.filters = filters;
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * Constructor.
	 * 
	 * @param entityClass
	 *            type
	 * @param filters
	 *            filter map
	 */
	public EntityListModel(final Class<T> entityClass,
			final Map<String, Object> filters) {
		super();
		this.entityClass = entityClass;
		this.filters = filters;
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * Loads and returns the (temporary) model object.
	 * 
	 * @return the (temporary) model object
	 */
	@Override
	protected List<T> load() {
		final Set<T> findAllByFilters 
			= getDao().findAllByFilters(
				filters, 
				sortProperty,
				SortOrder.ASCENDING.equals(sortOrder) ? true : false);
		return Lists.newArrayList(findAllByFilters);
	}

	/**
	 * @return the daoFactory
	 */
	private GenericData<T, Long> getDao() {
		return daoFactory.createProvider(getEntityClass());
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}
}
