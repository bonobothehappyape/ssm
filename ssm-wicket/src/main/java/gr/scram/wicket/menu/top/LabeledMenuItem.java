package gr.scram.wicket.menu.top;

import java.io.Serializable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;

/**
 * Lightweight menu object that stores a menu and its label.
 * @author asvesdi
 *
 */
public class LabeledMenuItem extends MenuItem implements Serializable {
	
	/**
	 * Constant.
	 */
	private static final String ERROR_CONSTANT = "error constant";

	/**
     * Serialisation unique id.
     */
	private static final long serialVersionUID = 1L;

	/**
	 * menu Link.
	 */
	private final AbstractLink link;

	/**
     * Menu label.
     */
	private final Label label;

	/**
	 * Creates a new LabeledMenuItem object.
	 * 
	 * @param ajaxLink Ajax link.
	 * @param displayModel the display model
	 */
	public LabeledMenuItem(final AbstractLink ajaxLink,
			@SuppressWarnings("rawtypes") final IModel displayModel) {
		this.link = ajaxLink;
		if (!ajaxLink.getId().equals(QuickMenu.LINK_ID)) {
			throw new IllegalArgumentException(ERROR_CONSTANT);//$NON-NLS-1$
		}
		this.label = new Label(QuickMenu.LINK_TEXT_ID, displayModel);
		this.link.add(this.label);
	}

	/**
	 * Creates a new LabeledMenuItem object.
	 * @param displayModel the model object.
	 */
	public LabeledMenuItem(final IModel<String> displayModel) {
		this.link = null;
		this.label = new Label(QuickMenu.LINK_TEXT_ID, displayModel);
	}

	/**
	 * get link.
	 * 
	 * @return - the link
	 */
	public AbstractLink getLink() {
		return this.link;
	}

	/**
	 * label getter.
	 * @return the label
	 */
	public Label getLabel() {
		return this.label;
	}
}
