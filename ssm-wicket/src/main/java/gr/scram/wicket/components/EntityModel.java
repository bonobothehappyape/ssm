package gr.scram.wicket.components;

import gr.scram.ssm.ejb.core.BeanFactory;
import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.wicket.cdi.CdiContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link LoadableDetachableModel}.
 * @author asvesdi
 *
 * @param <T> {@link IEntity} type.
 * @param <PK> - Long key.
 */
public class EntityModel<T extends AbstractJPAEntity, PK extends Serializable>extends
		LoadableDetachableModel<T> implements IModel<T> {
	
	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(EntityModel.class);

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Factory for Data objects.
	 */
	@Inject
	private BeanFactory daoFactory;
	
	/**
	 * class type.
	 */
	private final Class<T> entityClass;
	
	/**
	 * Hibernate id.
	 */
	private final Long entityId;

	/**
	 * Constructor.
	 * @param entityClass - type.
	 * @param entityId - unique id.
	 */
	public EntityModel(final Class<T> entityClass, final Long entityId) {
		this.entityClass = entityClass;
		this.entityId = entityId;
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * 
	 * @param entityClass - the type.
	 * @param entity - entity.
	 */
	public EntityModel(final Class<T> entityClass, final T entity) {
		this.entityClass = entityClass;
		this.entityId =  entity.getId();
		CdiContainer.get().getNonContextualManager().inject(this);
	}

	/**
	 * {@inheritDoc}
	 */
	protected T load() {
		return  getDao().find(entityId);
	}

	/**
	 * @return the daoFactory
	 */
	private GenericData<T, Long> getDao() {
		return daoFactory.createProvider(entityClass);
	}
}
