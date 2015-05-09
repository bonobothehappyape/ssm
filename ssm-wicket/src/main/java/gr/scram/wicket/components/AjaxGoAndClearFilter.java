package gr.scram.wicket.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.core.util.lang.WicketObjects;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * ajax Filter component that generates a 'go' and 'clear' buttons. it can be
 * use in {@link AjaxFallbackDefaultDataTable} components combined with
 * {@link FilterForm}. It is useful inside {@link ModalWindow} tables because it
 * uses {@link AjaxButton} components and we don't have to close the modal after
 * form submission.
 * 
 * @author asvesdi
 * 
 */
public class AjaxGoAndClearFilter extends AjaxGoFilter {
	
	/**
	 * Cosntant.
	 */
	private static final String CLEAR2 = "clear";

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default clear resource model.
	 */
	private static final IModel<String> DEFAULT_CLEAR_MODEL = new ResourceModel(
			"datatable.clear", CLEAR2);

	/**
	 * The clear ajax button.
	 * 
	 */
	private final AjaxButton clear;

	/**
	 * the model original state before cloning.
	 */
	private final Object originalState;

	/**
	 * Constructor.
	 * 
	 * This constructor will use default models for the 'clear' and 'go' button
	 * labels
	 * 
	 * @param id
	 *            component id
	 * @param form
	 *            filter form of the filter toolbar
	 */
	public AjaxGoAndClearFilter(final String id, final FilterForm<?> form) {
		this(id, form, DEFAULT_GO_MODEL, DEFAULT_CLEAR_MODEL);
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            component id
	 * @param form
	 *            filter form of the filter toolbar
	 * @param goModel
	 *            model for the label of the 'go' button
	 * @param clearModel
	 *            model for the label of the 'clear' button
	 */
	public AjaxGoAndClearFilter(final String id, final FilterForm<?> form,
			final IModel<String> goModel, final IModel<String> clearModel) {
		super(id, goModel);

		originalState = WicketObjects.cloneModel(form.getDefaultModelObject());

		clear = new BlockUIAjaxButton(CLEAR2, clearModel) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form) {
				onClearSubmit(this, target);
			}
		};

		clear.setDefaultFormProcessing(true);

		add(clear);
	}

	/**
	 * @return button component representing the clear button
	 */
	protected AjaxButton getClearButton() {
		return clear;
	}

	/**
	 * This method should be implemented by subclasses to provide behavior for
	 * the clear button.
	 * 
	 * @param blockUIAjaxButton
	 *            the 'clear' button
	 * @param target
	 *            the current {@link AjaxRequestTarget}
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void onClearSubmit(final AjaxButton blockUIAjaxButton,
			final AjaxRequestTarget target) {
		final Form<Object> form = (Form<Object>) blockUIAjaxButton.getForm();
		form.setDefaultModelObject(WicketObjects.cloneModel(originalState));
	}

}