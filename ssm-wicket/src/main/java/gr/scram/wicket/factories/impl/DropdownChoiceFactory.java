package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFormComponentFactory;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;

/**
 * Concrete factory for {@link DropDownChoice} components.
 * 
 * @author asvesdi
 * @param <T> the choice type
 * 
 */
public final class DropdownChoiceFactory<T extends Serializable> implements
		IFormComponentFactory<T, DropDownChoice<T>> {


	/**
	 * Property constant.
	 */
	private static final String ID = "id";

	/**
	 * Serialisable.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a simple {@link DropDownChoice} with a default model.
	 * 
	 * @param markup
	 *            markup string
	 * @param defaultModel
	 *            defualt model
	 * @param displayExpression
	 *            display expression for {@link ChoiceRenderer}. (Assumes id is
	 *            returned for idExpression)
	 * @return the {@link DropDownChoice}
	 */
	public DropDownChoice<T> createComponent(final String markup,
			final IModel<List<? extends T>> choices, final String displayExpression) {
		
		final ChoiceRenderer<T> renderer = new ChoiceRenderer<T>(
				displayExpression, DropdownChoiceFactory.ID);
		
		final DropDownChoice<T> dropDown = new DropDownChoice<T>(markup);
		
		dropDown.setChoices(choices);
		
		dropDown.setChoiceRenderer(renderer);
		dropDown.setNullValid(true);
		return dropDown;
	}
	
	/**
	 * Create a simple {@link DropDownChoice} with a default model.
	 * 
	 * @param markup
	 *            markup string
	 * @param defaultModel
	 *            defualt model
	 * @param displayExpression
	 *            display expression for {@link ChoiceRenderer}.
	 * @param idExpression the id to render
	 * @return the {@link DropDownChoice}
	 */
	public DropDownChoice<T> createComponent(final String markup,
			final IModel<T> defaultModel, final String displayExpression,
			final String idExpression) {
	final ChoiceRenderer<T> renderer = new ChoiceRenderer<T>(
				displayExpression, idExpression);
		final DropDownChoice<T> dropDown = new DropDownChoice<T>(markup);
		if (defaultModel != null) {
			dropDown.setDefaultModel(defaultModel);
		}
		dropDown.setChoiceRenderer(renderer);
		dropDown.setNullValid(true);
		return dropDown;
	}
	
	/**
	 * Create a simple {@link DropDownChoice} with a default model.
	 * 
	 * @param markup
	 *            markup string
	 * @param defaultModel
	 *            Default model
	 * @param displayExpression
	 *            display expression for {@link ChoiceRenderer}.
	 * @param choices List model with choices.
	 * @param idExpression the id to render
	 * @return the {@link DropDownChoice}
	 */
	public DropDownChoice<T> createComponent(final String markup,
			final IModel<T> defaultModel, final IModel<List<T>> choices,
			final String displayExpression, final String idExpression) {
		final ChoiceRenderer<T> renderer = new ChoiceRenderer<T>(
			displayExpression, idExpression);
		final DropDownChoice<T> dropDown = new DropDownChoice<T>(markup);
		if (defaultModel != null) {
			dropDown.setDefaultModel(defaultModel);
		}
		dropDown.setChoices(choices);
		dropDown.setChoiceRenderer(renderer);
		dropDown.setNullValid(true);
		return dropDown;
	}

	/**
	 * 
	 * @param markup  markup string
	 * @param defaultModel  Default model
	 * @param choices List model with choices.
	 * @param displayExpression  display expression for {@link ChoiceRenderer}
	 * @return  the {@link DropDownChoice}
	 */
	public DropDownChoice<T> createComponent(final String markup,
			final IModel<T> defaultModel, final IModel<List<T>> choices,
			final String displayExpression) {
		final ChoiceRenderer<T> renderer = new ChoiceRenderer<T>(
				displayExpression, DropdownChoiceFactory.ID);
		final DropDownChoice<T> dropDown = new DropDownChoice<T>(markup);
		if (defaultModel != null) {
			dropDown.setDefaultModel(defaultModel);
		}
		dropDown.setChoices(choices);
		dropDown.setChoiceRenderer(renderer);
		dropDown.setNullValid(true);
		return dropDown;
	}

	/**
	 * Create a simple {@link DropDownChoice} with a default model.
	 * 
	 * @param markup
	 *            the markup id
	 * @param model
	 *            default model
	 * @return the {@link DropDownChoice}
	 */
	public DropDownChoice<T> createComponent(final String markup,
			final IModel<T> model) {
		final DropDownChoice<T> dd = new DropDownChoice<T>(markup);
		dd.setDefaultModel(model);
		return dd;
	}

}
