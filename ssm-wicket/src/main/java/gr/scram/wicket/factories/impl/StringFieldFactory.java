package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFormComponentFactory;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Concrete factory for Date fileds.
 * @author asvesdi
 * 
 */
public class StringFieldFactory implements
		IFormComponentFactory<String, TextField<String>> {

	/**
	 * Serialisable.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public TextField<String> createComponent(final String markup,
			final IModel<String> model) {

		final TextField<String> text = new TextField<String>(markup, model);
		return text;
	}
	
	/**
	 * Create a simple TextField for a {@link CompoundPropertyModel} backed form
	 * without a model. The markup String should match the property name of the
	 * {@link CompoundPropertyModel} model. {@inheritDoc} This component has to
	 * be added to a {@link CompoundPropertyModel} backed {@link Form}.
	 * 
	 * @return the {@link TextField}.
	 */
	public TextField<String> createComponent(final String markup) {
		final TextField<String> text = new TextField<String>(markup);
		return text;
	}

	/**
	 * Creates a {@link TextField} for the given model object and expression.
	 * 
	 * @param markup
	 *            markup id
	 * @param expression
	 *            expression property
	 * @param model
	 *            model
	 * @return the field.
	 */
	public TextField<String> createComponent(final String markup,
			final String expression, final IModel<? extends Serializable> model) {

		final TextField<String> text = new TextField<String>(markup,
				new PropertyModel<String>(model.getObject(), expression));
		return text;
	}
	
	

}
