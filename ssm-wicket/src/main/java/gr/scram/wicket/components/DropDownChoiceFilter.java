package gr.scram.wicket.components;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.ChoiceFilter;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

/**
 * Choice Filter used for Dropdown filtering.
 * 
 * @author asvesdi
 * 
 * @param <Y>
 */
public final class DropDownChoiceFilter<Y extends Serializable> extends
		ChoiceFilter<Y> {

	/**
	 * Serialisation uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Cosntructor.
	 * 
	 * @param markupId markup id.
	 * @param model model object
	 * @param form filter form.
	 * @param choices list of choices
	 * @param autoSubmit autosubmit flag.
	 */
	public DropDownChoiceFilter(final String markupId, final IModel<Y> model,
			final FilterForm<?> form, final IModel<List<? extends Y>> choices,
			final boolean autoSubmit) {
		super(markupId, model, form, choices, autoSubmit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DropDownChoice<Y> newDropDownChoice(final String markupId,
			final IModel<Y> model, final IModel<List<? extends Y>> choices,
			final IChoiceRenderer<Y> renderer) {
		final DropDownChoice<Y> dropDown = new DropDownChoice<Y>(markupId, model, choices,
				renderer);
		dropDown.setNullValid(true);
		return dropDown;
	}
}