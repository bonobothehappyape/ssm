package gr.scram.wicket.factories.impl;

import gr.scram.wicket.components.UnmanagedEntitySortableDataProvider;
import gr.scram.wicket.factories.IDataTableFactory;
import gr.scram.wicket.utils.ColumnUtils;
import gr.scram.wicket.utils.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete factory for {@link AjaxPojoDefaultTableFactory} data tables
 * iterating {@link IEntity} managed entities with Long keys.
 * 
 * @author asvesdi
 * @param <K>
 *            Entity type.
 * 
 */
public class AjaxPojoDefaultTableFactory<K extends Serializable> implements
		IDataTableFactory<K, AjaxFallbackDefaultDataTable<K, String>> {

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(AjaxPojoDefaultTableFactory.class);

	/**
	 * Number of rows per page.
	 */
	private static final int ROWS_10 = 10;
	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a AjaxFallbackDefaultDataTable for a java POJO with given column
	 * list.
	 * 
	 * @param markup
	 *            markup
	 * @param clazz
	 *            class type
	 * @param rows
	 *            rows
	 * @param excludedArray
	 *            list of properties to exclude
	 * @param defaultSort
	 *            default sorting.
	 * @return {@link AjaxFallbackDefaultDataTable}.
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> clazz, final List<K> rows,
			final String[] excludedArray, final String defaultSort) {

		final ISortableDataProvider<K,String> dataProvider = new UnmanagedEntitySortableDataProvider<K>(
				rows, clazz, defaultSort);

		final List<Field> fields = ReflectionUtils.allFields(clazz,
				Serializable.class);
		final List<IColumn<K,String>> columns = new ArrayList<IColumn<K,String>>();

		final List<String> excludedList = Arrays.asList(excludedArray);
		for (final Field f : fields) {
			if (!excludedList.contains(f.getName())) {
				final IColumn<K,String> col = ColumnUtils.createPropertyColumn(
						f.getName(), new ResourceModel(f.getName()));
				columns.add(col);
			}
		}
		return new AjaxFallbackDefaultDataTable<K,String>(markup,
				new ArrayList<IColumn<K,String>>(columns), dataProvider,
				AjaxPojoDefaultTableFactory.ROWS_10);
	}

	/**
	 * Create a AjaxFallbackDefaultDataTable for a java POJO with given column
	 * list.
	 * 
	 * @param markup
	 *            markup
	 * @param clazz
	 *            class type
	 * @param rows
	 *            rows
	 * @param columns
	 *            list of columns
	 * @param defaultSort
	 *            default sort column
	 * @return {@link AjaxFallbackDefaultDataTable}.
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> clazz, final List<K> rows,
			final List<IColumn<K,String>> columns, final String defaultSort) {

		final ISortableDataProvider<K,String> dataProvider = new UnmanagedEntitySortableDataProvider<K>(
				rows, clazz, defaultSort);
		return new AjaxFallbackDefaultDataTable<K,String>(markup, columns,
				dataProvider, AjaxPojoDefaultTableFactory.ROWS_10);
	}

	/**
	 * Create a AjaxFallbackDefaultDataTable for a java POJO.
	 * 
	 * @param markup
	 *            markup
	 * @param clazz
	 *            class type
	 * @param rows
	 *            rows
	 * @param propertyNames property names for object
	 * @param propertyLabels labels for properties.
	 * @param defaultSort
	 *            default sort property.
	 * @return {@link AjaxFallbackDefaultDataTable}.
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> clazz, final List<K> rows,
			final String[] propertyNames, final String[] propertyLabels,
			final String defaultSort) {

		final ISortableDataProvider<K,String> dataProvider = new UnmanagedEntitySortableDataProvider<K>(
				rows, clazz, defaultSort);

		final List<IColumn<K,String>> columns = ColumnUtils.createFilteredPropertyColumns(propertyNames, propertyLabels);

		return new AjaxFallbackDefaultDataTable<K,String>(markup, columns,
				dataProvider, AjaxPojoDefaultTableFactory.ROWS_10);
	}

	/**
	 * Create a AjaxFallbackDefaultDataTable for a java POJO.
	 * 
	 * @param markup
	 *            markup
	 * @param clazz
	 *            class type
	 * @param rows
	 *            rows
	 * @param propertyNames properties to render
	 * @param propertyLabels labels to render
	 * @param defaultSort
	 *            default sort property
	 * @param callback
	 *            callback
	 * @return {@link AjaxFallbackDefaultDataTable}.
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> clazz, 
			final List<K> rows,
			final String[] propertyNames, 
			final String[] propertyLabels,
			final String defaultSort, 
			final IColumn<K,String> callback) {
		final ISortableDataProvider<K,String> dataProvider = new UnmanagedEntitySortableDataProvider<K>(
				rows, clazz, defaultSort);

		final List<IColumn<K,String>> columns = ColumnUtils.createPropertyColumns(
				propertyNames, propertyLabels);

		if (callback != null) {
			columns.add(callback);
		}
		return new AjaxFallbackDefaultDataTable<K,String>(markup, columns,
				dataProvider, AjaxPojoDefaultTableFactory.ROWS_10);
	}

	/**
	 * Creates a filtered table for a given {@link IFilterStateLocator}.
	 * 
	 * @param markup
	 *            markup id for html
	 * @param provider
	 *            the provider
	 * @param properties
	 *            properties list
	 * @param labels
	 *            labels list
	 * @param defaultSort
	 *            default sorting
	 * @param callback
	 *            callback calumn
	 * @return the table
	 * @throws IllegalAccessException
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final IFilterStateLocator<K> provider, final String[] properties,
			final String[] labels, final String defaultSort,
			final IColumn<K,String> callback) {

		final List<IColumn<K,String>> columns = ColumnUtils
				.createFilteredPropertyColumns(properties, labels);

		if (callback != null) {
			columns.add(callback);
		}

		@SuppressWarnings("unchecked")
		final AjaxFallbackDefaultDataTable<K,String> table = new AjaxFallbackDefaultDataTable<K,String>(
				markup, columns, (ISortableDataProvider<K,String>) provider,
				AjaxPojoDefaultTableFactory.ROWS_10);
		return table;
	}

	/**
	 * Creates a filtered table for a given {@link ISortableDataProvider}.
	 * 
	 * @param markup
	 *            markup id for html
	 * @param provider
	 *            the provider
	 * @param properties
	 *            properties list
	 * @param labels
	 *            labels list
	 * @param defaultSort
	 *            default sorting
	 * @param callback
	 *            callback calumn
	 * @return the table
	 * @throws IllegalAccessException
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final ISortableDataProvider<K,String> provider, final String[] properties,
			final String[] labels, final String defaultSort,
			final IColumn<K,String> callback) {

		final List<IColumn<K,String>> columns = ColumnUtils.createPropertyColumns(
				properties, labels);

		if (callback != null) {
			columns.add(callback);
		}

		final AjaxFallbackDefaultDataTable<K,String> table = new AjaxFallbackDefaultDataTable<K,String>(
				markup, columns, provider, AjaxPojoDefaultTableFactory.ROWS_10);
		return table;
	}

	/**
	 * 
	 * @param markup markup id
	 * @param provider provider 
	 * @param cols columns
	 * @return {@link AjaxFallbackDefaultDataTable} component
	 */
	@SuppressWarnings("unchecked")
	public AjaxFallbackDefaultDataTable<K,String> createComponent(
			final String markup,
			final IFilterStateLocator<K> provider,
			final List<IColumn<K,String>> cols) {
		return new AjaxFallbackDefaultDataTable<K,String>(markup, cols,
				(ISortableDataProvider<K,String>) provider,
				AjaxPojoDefaultTableFactory.ROWS_10);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.ec.tent.pfollowup.web.components.factories.IFactory#createComponent
	 * (java.lang.String, org.apache.wicket.model.IModel)
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final IModel<K> model) throws IllegalAccessException {
		throw new UnsupportedOperationException("Not supported.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ec.tent.pfollowup.web.components.factories.IDataTableFactory#
	 * createComponent(java.lang.String, java.lang.Class, java.util.Map,
	 * java.util.List)
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> enitityClass, final Map<String, Object> map,
			final List<String> excluded) {
		throw new UnsupportedOperationException("Not supported.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ec.tent.pfollowup.web.components.factories.IDataTableFactory#
	 * createComponent(java.lang.String, java.lang.Class, java.util.Map,
	 * java.util.List,
	 * org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn)
	 */
	public AjaxFallbackDefaultDataTable<K,String> createComponent(final String markup,
			final Class<K> enitityClass, final Map<String, Object> map,
			final List<String> excludedList, final IColumn<K,String> editDelCallback) {
		throw new UnsupportedOperationException("Not supported.");
	}

}
