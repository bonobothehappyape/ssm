package gr.scram.wicket.components;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilteredPropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * Extension of a {@link FilteredPropertyColumn} that allows property
 * expressions that do not evaluate against the given instance. In this
 * scenario, a default value will be placed in the cell instead. The user may
 * specify this value.
 * 
 * @param <T> Model object type.
 * @param <F>  Filter's model object type
 * @author asvesdi
 */
public final class FaulseExpressionTolerantTextFilteredPropertyColumn<T, F>
		extends	TextFilteredPropertyColumn<T,F,String> {

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Property expression.
	 */
	private final String propertyExpression;
	
	/**
	 * Default value for empty cells.
	 */
	private String faultyValue = "N/A"; //$NON-NLS-1$
	/**
	 * Creates a new NrPropertyColumn object.
	 * 
	 * @param displayModel the model to display
	 * @param propertyExpression property expression.
	 */
	public FaulseExpressionTolerantTextFilteredPropertyColumn(IModel<String> displayModel,
			String propertyExpression) {
		super(displayModel, propertyExpression);
		this.propertyExpression = propertyExpression;
	}

	/**
	 * Creates a new NrPropertyColumn object.
	 * @param faultyValue value that could throw error
	 * @param displayModel model
	 * @param propertyExpression property expression
	 */
	public FaulseExpressionTolerantTextFilteredPropertyColumn(String faultyValue,
			IModel<String> displayModel, String propertyExpression) {
		this(displayModel, propertyExpression);
		this.faultyValue = faultyValue;
	}

	/**
	 * Creates a new NrPropertyColumn object.
	 * @param displayModel model
	 * @param sortProperty sort property
	 * @param propertyExpression expression
	 */
	public FaulseExpressionTolerantTextFilteredPropertyColumn(IModel<String> displayModel,
			String sortProperty, String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
		this.propertyExpression = propertyExpression;
	}

	/**
	 * Creates a new NrPropertyColumn object.
	 * 
	 * @param faultyValue faulty
	 * @param displayModel model
	 * @param sortProperty sorting
	 * @param propertyExpression expression
	 */
	public FaulseExpressionTolerantTextFilteredPropertyColumn(String faultyValue,
			IModel<String> displayModel, String sortProperty,
			String propertyExpression) {
		this(displayModel, sortProperty, propertyExpression);
		this.faultyValue = faultyValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		try {
			BeanUtilsBean
					.getInstance()
					.getPropertyUtils()
					.getNestedProperty(rowModel.getObject(), propertyExpression);
		} catch (NestedNullException e) {
			item.add(new Label(componentId, new Model<String>(faultyValue)));
			return;
		} catch (IllegalAccessException e) {
			throw new WicketRuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new WicketRuntimeException(e);
		} catch (NoSuchMethodException e) {
			item.add(new Label(componentId, new Model<String>(faultyValue)));
			return;
		}
		super.populateItem(item, componentId, rowModel);
	}
	
}
