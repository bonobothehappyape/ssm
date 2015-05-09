package gr.scram.wicket.utils;

import gr.scram.wicket.components.DropDownChoiceFilteredPropertyColumn;
import gr.scram.wicket.components.FaulseExpressionTolerantTextFilteredPropertyColumn;
import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.PropertyColumnFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.ChoiceFilteredPropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilteredPropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.model.util.ListModel;

/**
 * Factory for {@link DataTable} columns.
 * 
 * @author asvesdi
 */
public final class ColumnUtils {

	/**
	 * Factory instance.
	 */
	private static final PropertyColumnFactory COL_FACTORY
		= (PropertyColumnFactory) FactoryType.COLUMN_FACTORY
			.get();

	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            Name of property.
	 * 
	 * @param <T>
	 *            Type of column model object.
	 * 
	 * @return Returns a {@link PropertyColumn} for the specified property.
	 */
	public static <T extends Serializable> PropertyColumn<T,String> createPropertyColumn(
			final String propertyName) {
		return COL_FACTORY.createComponent(propertyName, false, null);
	}
	
	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            Name of property.
	 * 
	 * @param <T>
	 *            Type of column model object.
	 * 
	 * @return Returns a {@link PropertyColumn} for the specified property.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> PropertyColumn<T,String> createPropertyColumn(
			final String propertyName, IModel<String> display) {
		return (PropertyColumn<T,String>) COL_FACTORY.createComponent(propertyName, display);
	}

	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            property name
	 * @param faultyTolerant
	 *            is tolerant to fault nested name
	 * @param faultyValue
	 *            value to show on error * @param <T> Type of column model
	 *            object.
	 * @return Returns a {@link PropertyColumn} for the specified property.
	 */
	public static <T extends Serializable> PropertyColumn<T,String> createPropertyColumn(
			final String propertyName, final boolean faultyTolerant,
			final String faultyValue) {
		return COL_FACTORY.createComponent(propertyName, faultyTolerant,
				faultyValue);
	}

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             when constructor is called by clients.
	 */
	private ColumnUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            Name of property.
	 * @param propertyLabel
	 *            Label to put on table header for this column.
	 * @param faultyExpressionTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a {@link PropertyColumn} for the specified property and
	 *         the specified column label.
	 */
	public static <T extends Serializable> FilteredPropertyColumn<T,String> createFilteredPropertyColumn(
			final String propertyName, final String propertyLabel,
			final boolean faultyExpressionTolerant, final String faultyValue) {
		final Model<String> model = new Model<String>(propertyLabel);
		if (faultyExpressionTolerant) {
			return new FaulseExpressionTolerantTextFilteredPropertyColumn<T, String>(
					faultyValue, model, propertyName, propertyName);
		}
		return new TextFilteredPropertyColumn<T, String,String>(model, propertyName,
				propertyName);
	}

	/**
	 * Create a {@link ChoiceFilteredPropertyColumn}.
	 * 
	 * @param propertyName
	 *            property name
	 * @param propertyLabel
	 *            label
	 * @param list
	 *            list of choices
	 * @param <T>
	 *            column model type.
	 * @param <Y>
	 *            droip down choice type
	 * @return column.
	 */
	public static <T extends Serializable, Y extends Serializable> 
		ChoiceFilteredPropertyColumn<T, Y,String> createChoiceFilteredPropertyColumn(
			final String propertyName, final String propertyLabel,
			final List<? extends Y> list) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final IModel<List<? extends Y>> listModel = new ListModel(list);
		return new DropDownChoiceFilteredPropertyColumn<T, Y>(
				new ResourceModel(propertyLabel), propertyName, listModel);
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String[] propertyNames) {
		return createPropertyColumns(propertyNames, false, null);
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param faultyExpressionTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String[] propertyNames,
			final boolean faultyExpressionTolerant, final String faultyValue) {
		final List<IColumn<T,String>> list = new ArrayList<IColumn<T,String>>();
		PropertyColumn<T,String> column = null;
		for (final String property : propertyNames) {
			if (faultyExpressionTolerant) {
				column = COL_FACTORY.createComponent(property,
						faultyExpressionTolerant, faultyValue);
			} else {
				column = COL_FACTORY.createComponent(property,
						faultyExpressionTolerant, null);
			}
			list.add(column);
		}
		return list;
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param propertyLabels
	 *            Labels to put on table header of each column.
	 * @param <T>
	 *            Type of column model object.
	 * 
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String[] propertyNames, final String[] propertyLabels) {
		return createPropertyColumns(propertyNames, propertyLabels, false, null);
	}

	/**
	 * Creates a list of filtered property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param propertyLabels
	 *            Labels to put on table header of each column.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createFilteredPropertyColumns(
			final String[] propertyNames, final String[] propertyLabels) {
		return createFilteredPropertyColumns(propertyNames, propertyLabels,
				false, null);
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param propertyLabels
	 *            Labels to put on table header of each column.
	 * @param faultyExpressionTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String[] propertyNames, final String[] propertyLabels,
			final boolean faultyExpressionTolerant, final String faultyValue) {
		if (propertyNames.length != propertyLabels.length) {
			final String msg = "Size mismatch between property and label matrices."; //$NON-NLS-1$
			throw new ArrayIndexOutOfBoundsException(msg);
		}
		final List<IColumn<T,String>> list = new ArrayList<IColumn<T,String>>();
		for (int i = 0; i < propertyLabels.length; i++) {
			PropertyColumn<T,String> column = null;
			if (faultyExpressionTolerant) {
				column = COL_FACTORY.createComponent(propertyNames[i],
						propertyLabels[i], faultyExpressionTolerant,
						faultyValue);
			} else {
				column = COL_FACTORY.createComponent(propertyNames[i],
						propertyLabels[i], faultyExpressionTolerant, null);
			}
			list.add(column);
		}
		return list;
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            Names of properties.
	 * @param propertyLabels
	 *            Labels to put on table header of each column.
	 * @param faultyExpressionTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createFilteredPropertyColumns(
			final String[] propertyNames, final String[] propertyLabels,
			final boolean faultyExpressionTolerant, final String faultyValue) {
		if (propertyNames.length != propertyLabels.length) {
			final String msg = "Size mismatch between property and label matrices. "; //$NON-NLS-1$
			throw new ArrayIndexOutOfBoundsException(msg);
		}
		final List<IColumn<T,String>> list = new ArrayList<IColumn<T,String>>();
		for (int i = 0; i < propertyLabels.length; i++) {
			FilteredPropertyColumn<T,String> column = null;
			if (faultyExpressionTolerant) {
				column = createFilteredPropertyColumn(propertyNames[i],
						propertyLabels[i], faultyExpressionTolerant,
						faultyValue);
			} else {
				column = createFilteredPropertyColumn(propertyNames[i],
						propertyLabels[i], faultyExpressionTolerant, null);
			}
			list.add(column);
		}
		return list;
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            String containing the property names, separated by commas.
	 * @param <T>
	 *            Type of column model object.
	 * 
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String propertyNames) {
		return createPropertyColumns(propertyNames, false, null);
	}

	/**
	 * Creates a list of property columns.
	 * 
	 * @param propertyNames
	 *            String containing the property names, separated by commas.
	 * @param faultyExpressionTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * 
	 * @return Returns a list of {@link PropertyColumn} objects for the
	 *         specified properties.
	 */
	public static <T extends Serializable> List<IColumn<T,String>> createPropertyColumns(
			final String propertyNames, final boolean faultyExpressionTolerant,
			final String faultyValue) {
		final String[] properties = TokenUtils.splitTrim(propertyNames, ",",
				false);
		return createPropertyColumns(properties, faultyExpressionTolerant,
				faultyValue);
	}
}
