package gr.scram.wicket.utils;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;
import gr.scram.wicket.components.EntityListModel;
import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.DropdownChoiceFactory;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.model.IModel;

/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class DropDownChoiceUtils {

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             thrown when accessed inside class
	 */
	private DropDownChoiceUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	/**
	 * Return the {@link DropDownChoice}.
	 * 
	 * @param markup
	 *            markup id
	 * @return the {@link DropDownChoice}.
	 */
	public static DropDownChoice<? extends Serializable> createPojoDropdownChoice(
			final String markup) {
		final DropdownChoiceFactory<?> factory = (DropdownChoiceFactory<?>) FactoryType.DROPDOWN_FACTORY
				.get();
		return factory.createComponent(markup, null);
	}

	/**
	 * 
	 * @param markup
	 * @param defaultModel
	 * @param displayExpression
	 * @param idExpression
	 * @return {@link DropDownChoice}
	 */
	public static <T extends Serializable> DropDownChoice<T> createPojoDropdownChoice(
			final String markup, final IModel<T> defaultModel,
			final String displayExpression, final String idExpression) {
		@SuppressWarnings("unchecked")
		final DropdownChoiceFactory<T> factory = (DropdownChoiceFactory<T>) FactoryType.DROPDOWN_FACTORY
				.get();
		return factory.createComponent(markup, defaultModel, displayExpression,
				idExpression);
	}

	public static <T extends AbstractJPAEntity> DropDownChoice<T> createManagedDropDownChoice(
			final String markup, final Class<T> type, final String display) {
		@SuppressWarnings("unchecked")
		final DropdownChoiceFactory<T> factory = (DropdownChoiceFactory<T>) FactoryType.DROPDOWN_FACTORY
				.get();

		final EntityListModel<T> model = new EntityListModel<T>(type);
		return factory.createComponent(markup, model, display);
	}

	/**
	 * 
	 * @param id
	 *            markup
	 * @param choices
	 *            list of choices
	 * @param id
	 *            id for uniquity
	 * @param descr
	 *            description shown
	 * @return the {@link Component}
	 */
	public static <T extends Enum<T>> DropDownChoice<T> createEnumDropdown(
			final String markupId, final List<? extends T> choices) {
		return new DropDownChoice<T>(markupId, choices);
	}

	/**
	 * Use this for amendment reference objects. creates a POJO backed
	 * {@link DropDownChoice} and adds a {@link ChoiceRenderer} for the
	 * properties 'description' and 'code'.
	 * 
	 * 
	 * @param id
	 *            mark up
	 * @param choices
	 *            list of choices
	 * @param <T>
	 *            the POJO type.
	 * @return the {@link DropDownChoice}.
	 */
	public static <T extends Serializable> DropDownChoice<T> createSimpleDropdown(
			final String id, final List<? extends T> choices) {
		return new DropDownChoice<T>(id, choices, new ChoiceRenderer<T>(
				"description", "code"));
	}
}