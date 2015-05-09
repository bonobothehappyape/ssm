package gr.scram.wicket.utils;

import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.DateFieldFactory;
import gr.scram.wicket.factories.impl.DatePickerFactory;
import gr.scram.wicket.factories.impl.StringFieldFactory;

import java.io.Serializable;
import java.util.Date;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;


/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class TextFieldUtils {

	/**
	 * The factory to use.
	 */
	private static final DateFieldFactory DT_FACTORY 
		= (DateFieldFactory) FactoryType.DATE_TEXT_FIELD_FACTORY
			.get();
	/**
	 * Date picker factory.  
	 */
	private static final DatePickerFactory DT_PICK_FATORY 
		= (DatePickerFactory) FactoryType.DATE_PICKER_FACTORY
			.get();

	/**
	 * The factory to use.
	 */
	private static final StringFieldFactory TXT_FACTORY 
		=  (StringFieldFactory) FactoryType.TEXT_FIELD_FACTORY
		.get();

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             thrown when accessed inside class
	 */
	private TextFieldUtils() throws IllegalAccessException {
		throw new IllegalAccessException("use static call");
	}

	/**
	 * Create date field.
	 * @param markup markup id
	 * @param dateModel date model
	 * @return the field.
	 */
	public static DateTextField 
		createDateField(final String markup, final IModel<Date> dateModel) {
		return DT_FACTORY.createComponent(markup, dateModel);
	}
	
	/**
	 * Create date field with jquery date picker.
	 * 
	 * @param markup
	 *            mark-up id
	 * @param dateModel
	 *            date model
	 * @return the field.
	 */
	public static DateTextField createDatePickerField(final String markup,
			final IModel<Date> dateModel) {
		return DT_PICK_FATORY.createComponent(markup, dateModel);
	}
	
	/**
	 * Create date field with jquery date picker.
	 * 
	 * @param markup
	 *            mark-up id
	 * @param dateModel
	 *            date model
	 * @return the field.
	 */
	public static DateTextField createDatePickerField(final String markup) {
		return DT_PICK_FATORY.createComponent(markup);
	}
	
	/**
	 * Create date field.
	 * @param form the parent form.
	 * @param markup markup id
	 */
	public static void 
		addDateField(final String markup, final Form<?> form) {
		form.add(DT_FACTORY.createComponent(markup));
	}
	
	/**
	 * Create date field.
	 * @param container the parent container.
	 * @param markup markup id
	 */
	public static void 
		addDateField(final String markup, final WebMarkupContainer container) {
		container.add(DT_FACTORY.createComponent(markup));
	}

	/**
	 * Create a {@link String} backed field for a {@link CompoundPropertyModel}
	 * backed form.
	 * 
	 * @param form
	 *            the parent form.
	 * @param markup
	 *            markup id
	 */
	public static void addStringField(final String markup, final Form<?> form) {
		form.add(TXT_FACTORY.createComponent(markup));
	}


	
	/**
	 * Create a string text field.
	 * @param markup mark up id
	 * @param expression ,the property name that we want the model to populate.
	 * @param model model object to be evaluated with the property model
	 * @return the {@link TextField}.
	 */
	public static TextField<String> createStringField(final String markup,
				final String expression, final IModel<? extends Serializable> model) {
		return TXT_FACTORY.createComponent(markup, expression, model);
	}

}