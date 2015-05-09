package gr.scram.wicket.components;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.ChoiceFilter;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.ChoiceFilteredPropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.model.IModel;

/**
 * Filtered property column for drop down.
 * @author asvesdi
 *
 * @param <T> 
 * @param <Y>
 */
public final class DropDownChoiceFilteredPropertyColumn<T extends Serializable,
	Y extends Serializable>	extends ChoiceFilteredPropertyColumn<T, Y,String> {


	/**
			 * 
			 */
	private static final long serialVersionUID = 1L;

	/**
	 * Cosntructor.
	 * @param displayModel model to display.
	 * @param propertyExpression expression
	 * @param filterChoices filter list choices.
	 */
	public DropDownChoiceFilteredPropertyColumn(
			final IModel<String> displayModel, final String propertyExpression,
			final IModel<List<? extends Y>> filterChoices) {
		super(displayModel, propertyExpression, filterChoices);
	}

	@Override
	public Component getFilter(final String componentId,
			final FilterForm<?> form) {
		final ChoiceFilter<Y> filter = new DropDownChoiceFilter<Y>(componentId,
				getFilterModel(form), form, getFilterChoices(), true);
		return filter;
	}
}