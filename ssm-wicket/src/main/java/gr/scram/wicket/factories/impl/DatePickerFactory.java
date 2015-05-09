package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFormComponentFactory;

import java.util.Date;

import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.form.datepicker.DatePicker;


/**
 * Concrete factory for Date fields.
 * 
 * @author asvesdi
 * 
 */
public final class DatePickerFactory
		implements IFormComponentFactory<Date, DatePicker> {

	/**
	 * Date picker option name.
	 */
	private static final String DATE_FORMAT = "dateFormat";
	/**
	 * Java script format..
	 */
	private static final String DD_MM_YY = "'dd/mm/yy'";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public DatePicker createComponent(final String markup, final IModel<Date> model) {
		final Options options = new Options();
		options.set(DATE_FORMAT, DD_MM_YY); // Java-script notation
		return new DatePicker(markup, model, options);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public DatePicker createComponent(final String markup) {
		final Options options = new Options();
		options.set(DATE_FORMAT, DD_MM_YY); // Java-script notation
		return new DatePicker(markup,  options);
	}
	
}
