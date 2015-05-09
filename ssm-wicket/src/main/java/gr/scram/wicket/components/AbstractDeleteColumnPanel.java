package gr.scram.wicket.components;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AbstractDeleteColumnPanel<T extends Serializable> extends Panel{
	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 */
	public AbstractDeleteColumnPanel(final String id) {
		super(id);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 * @param model model row.
	 */
	public AbstractDeleteColumnPanel(final String id, final IModel<T> model) {
		super(id,model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(createDeleteLink());
	}

	/**
	 * Add the delete link.
	 * @return {@link AjaxLink}
	 */
	AjaxLink<String> createDeleteLink() {
		return new AjaxLink<String>("deleteLink") {
			/**
			 * Serialisation.
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				onDeleteClicked(target);
			}
		};
	}

	/**
	 * Delegate edit.
	 * 
	 * @param target the {@link AjaxRequestTarget} for the current component.
	 */
	public abstract void onDeleteClicked(final AjaxRequestTarget target);
}