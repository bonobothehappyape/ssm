package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFormComponentFactory;
import gr.scram.wicket.utils.Format;

import java.util.Date;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.model.IModel;




/**
 * Concrete factory for Date fileds.
 * @author asvesdi
 *
 */
public class DateFieldFactory
		implements IFormComponentFactory<Date, DateTextField> {

	/**
	 * Serialisable.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public DateTextField createComponent(final String markup, final IModel<Date> model) {

		final DateTextField date =  new DateTextField(markup,
				Format.DateFormat.getFormat());
		return date;
	
	}
	
	/**
	 * Create a DateTextField for a {@link CompoundPropertyModel} expression.
	 * The markup name should match the {@link CompoundPropertyModel} object expression.
	 * @param markup the markup id.
	 * @return the {@link DateTextField}.
	 */
	public DateTextField createComponent(final String markup) {

		final DateTextField date =  new DateTextField(markup,
				Format.DateFormat.getFormat());
		return date;
	
	}


}
