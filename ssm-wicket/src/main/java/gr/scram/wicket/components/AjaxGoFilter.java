package gr.scram.wicket.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * Go filter that uses ajax submit.
 * 
 * @author asvesdi
 * 
 */
public class AjaxGoFilter extends Panel {
	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default model resource.
	 */
	protected static final IModel<String> DEFAULT_GO_MODEL = new ResourceModel(
			"datatable.go", "filter");

	/**
	 * Go button.
	 */
	private final AjaxButton go;

	/**
	 * Constructor.
	 * 
	 * This constructor will use the default model for the button's text
	 * 
	 * @param id
	 *            component id
	 */
	public AjaxGoFilter(final String id) {
		this(id, DEFAULT_GO_MODEL);
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            component id
	 * @param goModel
	 *            model for the button's text
	 */
	public AjaxGoFilter(final String id, final IModel<String> goModel) {
		super(id);

		go = new BlockUIAjaxButton("go", goModel) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				onGoSubmit(this, target);
			}

		};

		add(go);
	}

	/**
	 * Getter for go {@link AjaxButton}.
	 * @return the button.
	 */
	protected AjaxButton getGoButton() {
		return go;
	}

	/**
	 * This method can be overridden by subclasses to provide non-standard
	 * Behaviour for the 'go' button. ex. add the calling component in target.
	 * 
	 * @param blockUIAjaxButton
	 *            the 'go' button, can be used to get to the Form object and
	 *            through that to the filter state object by retrieving the
	 *            form's model object
	 * @param target the {@link AjaxRequestTarget} current request target.
	 * 
	 */
	protected void onGoSubmit(final AjaxButton blockUIAjaxButton,
			AjaxRequestTarget target) {
	}

}