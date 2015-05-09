package gr.scram.wicket.menu.top;

import org.apache.wicket.model.IModel;

/**
 * Grouped menu name.
 * 
 * @author asvesdi
 * 
 */
public class MenuGroupName extends LabeledMenuItem {

	/**
	 * Constructor.
	 * @param displayModel - model
	 */
	public MenuGroupName(final IModel<String> displayModel) {
		super(displayModel);
	}

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

}
