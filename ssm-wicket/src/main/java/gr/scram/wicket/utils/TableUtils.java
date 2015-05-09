package gr.scram.wicket.utils;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;
import gr.scram.wicket.components.AjaxGoAndClearFilter;
import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.AjaxDefaultTableFactory;
import gr.scram.wicket.factories.impl.AjaxPojoDefaultTableFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class TableUtils {

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(TableUtils.class);

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             thrown when accessed inside class
	 */
	private TableUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	/**
	 * Create an AjaxFallbackDefaultDataTable. This is the simplest/fastest
	 * table possible, without sorting, filtering. only paging
	 * 
	 * @param markup
	 *            markup for table
	 * @param enitityClass
	 *            entity type
	 * @param map
	 *            filter map
	 * @param excludedList
	 *            list of columns to exclude from showing
	 * @param <T>
	 *            Entity type.
	 * @return a {@link AjaxFallbackDefaultDataTable}
	 */
	public static <T extends AbstractJPAEntity> AjaxFallbackDefaultDataTable<T,String> createAjaxDataTable(
			final String markup,
			final Class<T> enitityClass,
			final Map<String, Object> map,
			final String[] excludedList) {

		@SuppressWarnings("unchecked")
		final AjaxDefaultTableFactory<T> factory = (AjaxDefaultTableFactory<T>) FactoryType.AJAX_TABLE_FACTORY
				.get();
		return factory.createComponent(
				markup,
				enitityClass,
				map,
				excludedList == null ? new ArrayList<String>() : Arrays
						.asList(excludedList));
	}

	/**
	 * Create an AjaxFallbackDefaultDataTable backed with the given type.
	 * 
	 * @param markup
	 *            markup for table
	 * @param enitityClass
	 *            entity type
	 * @param map
	 *            filter map
	 * @param excludedList
	 *            list of columns to exclude from showing
	 * @param actionColumn
	 *            the actions column
	 * @param <T>
	 *            Entity type.
	 * @return a {@link AjaxFallbackDefaultDataTable}
	 */
	public static <T extends AbstractJPAEntity> AjaxFallbackDefaultDataTable<T,String> createAjaxDataTable(
			final String markup,
			final Class<T> enitityClass,
			final Map<String, Object> map,
			final String[] excludedList,
			final IColumn<T,String> actionColumn) {
	
		@SuppressWarnings("unchecked")
		final AjaxDefaultTableFactory<T> factory = (AjaxDefaultTableFactory<T>) FactoryType.AJAX_TABLE_FACTORY
				.get();
		return factory.createComponent(
				markup,
				enitityClass,
				map,
				excludedList == null ? new ArrayList<String>() : Arrays
						.asList(excludedList), 
				actionColumn);
	}

	/**
	 * Create a {@link ISortableDataProvider} backed table (no filters).
	 * 
	 * @param markup
	 *            mark up id
	 * @param dataProvider
	 *            the provider
	 * @param properties
	 *            list of properties
	 * @param labels
	 *            list of labels
	 * @param defaultSort
	 *            default sorting
	 * @param actionColumn
	 *            action column
	 * @param <T>
	 *            the rows type
	 * @return the table.
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> createPojoAjaxDataTable(
			final String markup,
			final ISortableDataProvider<T,String> dataProvider,
			final String[] properties,
			final String[] labels,
			final String defaultSort,
			final IColumn<T,String> actionColumn) {
		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory = (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, dataProvider, properties,
				labels, defaultSort, actionColumn);
	}

	/**
	 * Create a List backed table (no filtering).
	 * 
	 * @param markup
	 *            mark-up id
	 * @param clazz
	 *            for row type
	 * @param rows
	 *            data (because the type is a pojo)
	 * @param properties
	 *            visible properties
	 * @param labels
	 *            visible properties labels
	 * @param defaultSort
	 *            default sort property
	 * @param callbackColumn
	 *            callback {@link IColumn}. Add an action column component
	 * @return the table
	 * @param <T>
	 *            the type of the row for the table.
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> createPojoAjaxDataTable(
			final String markup,
			final Class<T> clazz,
			final List<T> rows,
			final String[] properties,
			final String[] labels,
			final String defaultSort,
			final IColumn<T,String> callbackColumn) {
	
		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory = (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, clazz, rows, properties, labels,
				defaultSort, callbackColumn);
	}

	/**
	 * Create a Pojo backed AjaxFallbackDefaultDataTable;.
	 * 
	 * @param markup
	 *            markup string.
	 * @param clazz
	 *            class type
	 * @param rows
	 *            data rows
	 * @param excluded
	 *            excluded list
	 * @param defaultSort
	 * @return the table.
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> createPojoAjaxDataTable(
			final String markup,
			final Class<T> clazz,
			final List<T> rows,
			final List<IColumn<T,String>> columns,
			final String defaultSort) {

		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory = (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, clazz, rows, columns,
				defaultSort);
	}

	/**
	 * Create a POJO backed AjaxFallbackDefaultDataTable;.
	 * 
	 * @param markup
	 *            markup string.
	 * @param clazz
	 *            class type
	 * @param rows
	 *            data rows
	 * @param excluded
	 *            excluded list
	 * @param defaultSort
	 * @return the table.
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> createPojoAjaxDataTable(
			final String markup,
			final Class<T> clazz,
			final List<T> rows,
			final String[] excluded,
			final String defaultSort) {

		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory = (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, clazz, rows, excluded,
				defaultSort);
	}

	/**
	 * Create a POJO backed table with specific property names and labels.
	 * 
	 * @param markup
	 *            mark up id
	 * @param clazz
	 *            class type for table rows
	 * @param rows
	 *            data
	 * @param propertyNames
	 *            string property names
	 * @param propertyLables
	 *            string property labels
	 * @param defaultSort
	 *            sort property
	 * @return the table.
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> 
		createPojoAjaxDataTable(
			final String markup, 
			final Class<T> clazz,
			final List<T> rows,
			final String[] propertyNames,
			final String[] propertyLables,
			final String defaultSort) {

		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory 
			= (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, clazz, rows, propertyNames,
				propertyLables, defaultSort);
	}

	/**
	 * Create a pojo filtered table. Provide the columns and the provider.
	 * @param markup markup id
	 * @param provider data provider
	 * @param cols columns
	 * @return the {@link AjaxFallbackDefaultDataTable}
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> 
		createFilteredPojoAjaxDataTable(
			final String markup,
			final IFilterStateLocator<T> provider,
			final List<IColumn<T,String>> cols) {
		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory
			= (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.createComponent(markup, provider, cols);
	}

	/**
	 * Create a {@link IFilterStateLocator} backed table and a filtering tool
	 * bar .
	 * 
	 * @param markup
	 *            mark up id
	 * @param provider
	 *            the provider
	 * @param properties
	 *            properties
	 * @param labels
	 *            labels
	 * @param defaultSort
	 *            default sorting
	 * @param callback
	 *            action column
	 * @param <T>
	 *            the type.
	 * @return the table
	 */
	public static <T extends Serializable> AjaxFallbackDefaultDataTable<T,String> createFilteredPojoAjaxDataTable(
			final String markup,
			final IFilterStateLocator<T> provider,
			final String[] properties,
			final String[] labels,
			final String defaultSort,
			final IColumn<T,String> callback) {
		@SuppressWarnings("unchecked")
		final AjaxPojoDefaultTableFactory<T> factory 
			= (AjaxPojoDefaultTableFactory<T>) FactoryType.AJAX_POJO_TABLE_FACTORY
				.get();
		return factory.
				createComponent(markup,
					provider,
				    	properties,
					    	labels,
					    		defaultSort, 
					    			callback);
	}

	/**
	 * Create an {@link AjaxGoAndClearFilter} instance.
	 * @param componentId markup
	 * @param form form for filtering
	 * @param table table attached to
	 * @return the {@link AjaxGoAndClearFilter}
	 */
	public static <T extends Serializable> AjaxGoAndClearFilter createGoandClearFilterforTable(
			final String componentId,
			final FilterForm<T> form,
			final AjaxFallbackDefaultDataTable<T,String> table) {
		final Model<String> go = new Model<String>("go");
		final Model<String> clear = new Model<String>("clear");
		
		final AjaxGoAndClearFilter filter = new AjaxGoAndClearFilter(componentId,
				form, go, clear) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onGoSubmit(final AjaxButton blockUIAjaxButton,
					final AjaxRequestTarget target) {
				super.onGoSubmit(blockUIAjaxButton, target);
				target.add(table);
			}

			@Override
			protected void onClearSubmit(final AjaxButton blockUIAjaxButton,
					final AjaxRequestTarget target) {
				super.onClearSubmit(blockUIAjaxButton, target);
				target.add(table);
			}

		};
		return filter;

	}

}