package gr.scram.wicket.factories;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

/**
 * Interafce for wicket component factories.
 * 
 * @author asvesdi
 * 
 * @param <T>
 *            component type.
 * @param <K>
 *            model type.
 */
public interface IFormComponentFactory<K extends Serializable, T extends FormComponent<K>>
		extends IFactory<K, T> {

	/**
	 * Create a {@link FormComponent}.
	 * 
	 * @param markup
	 *            markup
	 * @param model
	 *            model
	 * @return {@link Component}
	 */
	T createComponent(final String markup, final IModel<K> model);
}
