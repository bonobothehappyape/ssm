package gr.scram.wicket.factories;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IClusterable;


/**
 * Interafce for wicket component factories.
 * @author asvesdi
 *
 * @param <T> component type.
 * @param <K> model type.
 */
public interface IFactory<K extends Serializable, T extends IClusterable>
		extends Serializable {

	/**
	 * Create {@link Component}. 
	 * @param markup markup
	 * @param model model
	 * @return {@link Component}
	 * @throws IllegalAccessException 
	 */
	T createComponent(final String markup,final IModel<K> model) throws IllegalAccessException;
}
