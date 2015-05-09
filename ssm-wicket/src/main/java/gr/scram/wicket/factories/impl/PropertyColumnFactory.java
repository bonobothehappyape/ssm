package gr.scram.wicket.factories.impl;

import gr.scram.wicket.components.FaulseExpressionTolerantPropertyColumn;
import gr.scram.wicket.factories.IFactory;
import gr.scram.wicket.pages.WebPageESS;
import gr.scram.wicket.pages.WebPageESSSimple;

import java.io.Serializable;
import java.util.MissingResourceException;

import org.apache.wicket.Application;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * String property column factory.
 * 
 * @author asvesdi
 */
public final class PropertyColumnFactory implements
		IFactory<String, IColumn<String, String>> {

	/**
	 * Suffix for translation resources keys.
	 */
	private static final String LABEL = "-table-column-label";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(PropertyColumnFactory.class);

	/**
	 * Creates a simple {@link PropertyColumn} with a string display.
	 * 
	 * @param expression
	 *            expression of property
	 * @param display
	 *            display model
	 * @return the {@link PropertyColumn}
	 */
	public IColumn<String, String> createComponent(final String expression,
			final IModel<String> display) {
		return new PropertyColumn<String, String>(display, expression);
	}

	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            Name of property.
	 * @param faultyTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a {@link PropertyColumn} for the specified property.
	 */
	public <T extends Serializable> PropertyColumn<T, String> createComponent(
			final String propertyName, final boolean faultyTolerant,
			final String faultyValue) {
		final String labelResource = propertyName
				.concat(PropertyColumnFactory.LABEL);
		IModel<String> model = null;
		try {
			final String string = Application.get().getResourceSettings()
					.getLocalizer()
					.getString(labelResource, new WebPageESS(), propertyName);
			model = new Model<String>(string);
		} catch (final MissingResourceException mre) {
			LOG.warn(
					"MissingResourceException for property :".concat(
							propertyName).concat(
							". Try using a property message with name "
									.concat(labelResource)), mre.getMessage());
			
		}
		PropertyColumn<T, String> column = null;
		if (faultyTolerant) {
			column = new FaulseExpressionTolerantPropertyColumn<T>(faultyValue,
					model, propertyName, propertyName);
		} else {
			column = new PropertyColumn<T, String>(model, propertyName,
					propertyName);
		}
		return column;
	}

	/**
	 * Creates a {@link PropertyColumn}.
	 * 
	 * @param propertyName
	 *            Name of property.
	 * @param propertyLabel
	 *            Label to put on table header for this column.
	 * @param faultyTolerant
	 *            Indicates if a faulty expression is to be tolerated.
	 * @param faultyValue
	 *            Value to be placed to cells for which the expression was
	 *            faulty for the row model object.
	 * @param <T>
	 *            Type of column model object.
	 * @return Returns a {@link PropertyColumn} for the specified property and
	 *         the specified column label.
	 */
	public <T extends Serializable> PropertyColumn<T, String> createComponent(
			final String propertyName, final String propertyLabel,
			final boolean faultyTolerant, final String faultyValue) {
		final Model<String> model = new Model<String>(propertyLabel);
		PropertyColumn<T, String> col = null;

		if (faultyTolerant) {
			col = new FaulseExpressionTolerantPropertyColumn<T>(faultyValue,
					model, propertyName, propertyName);
		} else {
			col = new PropertyColumn<T, String>(model, propertyName,
					propertyName);
		}
		return col;

	}
}
