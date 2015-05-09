package gr.scram.wicket.components;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Simple delete/edit panel.
 * 
 * @author asvesdi
 * 
 * @param <T>
 *            row model.
 */
public abstract class AbstractEditDeleteColumnPanel<T extends Serializable>
		extends Panel {
	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 * @param rowModel
	 *            the model of the current row.
	 */
	public AbstractEditDeleteColumnPanel(final String id, final IModel<T> rowModel) {
		super(id, rowModel);
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 */
	public AbstractEditDeleteColumnPanel(final String id) {
		super(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(createEditLink());
		add(createDeleteLink());
	};

	/**
	 * get the delete link {@link AjaxLink}.
	 * 
	 * @return the delete link
	 */
	AjaxLink<String> createDeleteLink() {
		return new AjaxLink<String>("deleteLink") {
			/**
			 * Serialisation.
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * Go to the Edit page, passing this page and the id of the Contact
			 * involved.
			 */
			@Override
			public void onClick(final AjaxRequestTarget target) {
				onDeleteClicked(target);
			}
		};
	}

	/**
	 * @return {@link AjaxLink}.
	 */
	AjaxLink<String> createEditLink() {
		return new AjaxLink<String>("editLink") {
			/**
			 * Serialisation.
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * Go to the Edit page, passing this page and the id of the Contact
			 * involved.
			 */
			@Override
			public void onClick(final AjaxRequestTarget target) {
				onEditClicked(target);
			}
		};
	}

	/**
	 * Delegate delete.
	 * 
	 * @param target
	 *            the request target that produces ajax response.
	 */
	public abstract void onDeleteClicked(AjaxRequestTarget target);

	/**
	 * Delegate edit.
	 * 
	 * @param target
	 *            the request target that produces ajax response.
	 */
	public abstract void onEditClicked(AjaxRequestTarget target);
}