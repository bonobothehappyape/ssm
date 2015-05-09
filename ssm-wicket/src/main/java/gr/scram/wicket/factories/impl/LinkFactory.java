package gr.scram.wicket.factories.impl;

import gr.scram.wicket.components.GeneratedMenuLink;
import gr.scram.wicket.factories.IFactory;

import java.io.Serializable;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * 
 * @author asvesdi
 */
public final class LinkFactory implements IFactory<String, AbstractLink> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public AbstractLink createComponent(final String markup,
			final IModel<String> model) throws IllegalAccessException {
		throw new IllegalAccessException("You cannot use this factory method. ");
	}
	
	/**
	 * Creates alink that opens a page.
	 * @param id markup id.
	 * @param page page class
	 * @return the link
	 */
	public Link<String> createComponent(final String id,
			final Class<? extends Page> page){
		final Link<String> link = new Link<String>(id) {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(page);
			}
		};
		return link;
	}

	/**
	 * Create a {@link GeneratedMenuLink} that redirects to another page.
	 * 
	 * @param markup
	 *            link markup
	 * @param pageModel
	 *            page model
	 * @param redirect
	 *            redirect page
	 * @return the link
	 * @throws ClassNotFoundException
	 *             when page does not exist
	 * @param <T>
	 *            page model type
	 */
	public <T extends Serializable> AbstractLink createComponent(
			final String markup, final IModel<T> pageModel,
			final String redirect) throws ClassNotFoundException {

		final GeneratedMenuLink<T> link = new GeneratedMenuLink<T>(markup,
				pageModel, redirect);
		return link;
	}

	/**
	 * Creates a link that opens a modal and sets content.
	 * @param markup markup id
	 * @param panel panel content
	 * @param modal modal window opener
	 * @return the link.
	 */
	public AjaxLink<String> createComponent(final String markup, final Panel panel,
			final ModalWindow modal) {

		final AjaxLink<String> link = new AjaxLink<String>(markup) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onClick(final AjaxRequestTarget target) {
				modal.setContent(panel);
				modal.show(target);
			}

		};

		return link;
	}

}
