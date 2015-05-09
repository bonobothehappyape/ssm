package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFactory;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.model.IModel;

/**
 * String property column factory.
 * @author asvesdi
 */
public final class FilteredPropertyColumnFactory implements
		IFactory<String, IColumn<String,String>> {

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public IColumn<String,String> createComponent(final String markup, final IModel<String> model) {
		// TODO Auto-generated method stub
		return null;
	}

}
