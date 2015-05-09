package gr.scram.wicket.factories.impl;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;
import gr.scram.wicket.components.EntityDataProvider;
import gr.scram.wicket.factories.IDataTableFactory;
import gr.scram.wicket.utils.ColumnUtils;
import gr.scram.wicket.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;

/**
 * Concrete factory for {@link AjaxDefaultTableFactory} data tables iterating
 * {@link IEntity} managed entities with Long keys.
 * 
 * @author asvesdi
 * @param <K>
 *            Entity type.
 * 
 */
public class AjaxDefaultTableFactory<K extends AbstractJPAEntity> implements
		IDataTableFactory<K, AjaxFallbackDefaultDataTable<K, String>> {

	/**
	 * Property for sorting.
	 */
	private static final String DEF_SORT = "id";

	/**
	 * Number of rows per page.
	 */
	private static final int ROWS_10 = 10;
	/**
	 * Serialization unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public AjaxFallbackDefaultDataTable<K, String> createComponent(final String markup,
			final Class<K> enitityClass, final Map<String, Object> map,
			final List<String> excludedList) {

		final ISortableDataProvider<K,String> dataProvider = new EntityDataProvider<K>(
				enitityClass, AjaxDefaultTableFactory.DEF_SORT, map);

		final List<Field> fields = ReflectionUtils.getAnnotated(
				ReflectionUtils.allFields(enitityClass, AbstractJPAEntity.class),
				Column.class);
		final List<IColumn<K,String>> columns = new ArrayList<IColumn<K,String>>();

		for (final Field f : fields) {
			if (!excludedList.contains(f.getName())) {
				final PropertyColumn<K,String> col = ColumnUtils.createPropertyColumn(f.getName() );
				columns.add(col);
			}
		}
		return new AjaxFallbackDefaultDataTable<K,String>(markup,
				new ArrayList<IColumn<K,String>>(columns), dataProvider,
				AjaxDefaultTableFactory.ROWS_10);
	}
	
	/**
	 * Create a table for a given persisted entity type and a given provider.
	 * @param markup mark-up id
	 * @param entityClass class type
	 * @param provider provider
	 * @param excluded excluded columns
	 * @return the table
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(
			final String markup,
			final Class<K> entityClass,
			final ISortableDataProvider<K,String> provider, 
			final List<String> excluded) {
		
		final List<Field> fields = ReflectionUtils.getAnnotated(
				ReflectionUtils.allFields(entityClass, AbstractJPAEntity.class),
				Column.class);
		final List<IColumn<K,String>> columns = new ArrayList<IColumn<K,String>>();

		for (final Field f : fields) {
			if (!excluded.contains(f.getName())) {
				final PropertyColumn<K,String> col = ColumnUtils.createPropertyColumn(f
						.getName());
				columns.add(col);
			}
		}
		return new AjaxFallbackDefaultDataTable<K,String>(markup,
				new ArrayList<IColumn<K,String>>(columns), provider,
				AjaxDefaultTableFactory.ROWS_10);

	}

	/**
	 * Create a simple table for a given persisted entity type. Iterates through
	 * the class members and finds the mapped attributes with {@link Column}.
	 * 
	 * @param markup
	 *            the markup id of the table
	 * @param enitityClass
	 *            the entity type
	 * @param map
	 *            filtering.
	 * @param excluded
	 *            array of properties to exclude.
	 * @param callback
	 *            calumn callback for actions.
	 * @return the {@link DataTable} component
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> enitityClass, final Map<String, Object> map,
			final List<String> excluded, final IColumn<K,String> callback) {

		final ISortableDataProvider<K,String> dataProvider = new EntityDataProvider<K>(
				enitityClass, AjaxDefaultTableFactory.DEF_SORT, map);

		final List<Field> fields = ReflectionUtils.getAnnotated(
				ReflectionUtils.allFields(enitityClass, AbstractJPAEntity.class),
				Column.class);
		final List<IColumn<K,String>> columns = new ArrayList<IColumn<K,String>>();

		for (final Field f : fields) {
			if (!excluded.contains(f.getName())) {
				final PropertyColumn<K,String> col = ColumnUtils.createPropertyColumn(f
						.getName());
				columns.add(col);
			}
		}

		if (callback != null && columns != null) {
			columns.add(columns.size(), callback);
		}

		return new AjaxFallbackDefaultDataTable<K,String>(markup,
				new ArrayList<IColumn<K,String>>(columns), dataProvider,
				AjaxDefaultTableFactory.ROWS_10);
	}

	/**
	 * {@inheritDoc}
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final IModel<K> model) throws IllegalAccessException {
		throw new IllegalAccessException();
	}
}
