package gr.scram.wicket.utils;

import gr.scram.wicket.components.GeneratedMenuLink;
import gr.scram.wicket.components.Pair;
import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.LinkFactory;

import java.io.Serializable;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class LinkUtils {

	/**
	 * The link factory.
	 */
	private static final LinkFactory FACTORY = (LinkFactory) FactoryType.LINK_FACTORY
			.get();

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             thrown when accessed inside class
	 */
	private LinkUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	/**
	 * Creates a link to a page.
	 * 
	 * @param id
	 *            Id of the link.
	 * @param page
	 *            Class of the page where the link links.
	 * 
	 * @return Returns the link.
	 */
	public static Link<String> createLink(final String id,
			final Class<? extends Page> page) {
		return FACTORY.createComponent(id, page);
	}

	/**
	 * Creates a link.
	 * 
	 * The name of the page class is used as id of the link.
	 * 
	 * @param page
	 *            Class of the page where the link links.
	 * 
	 * @return Returns the link.
	 */
	public static Link<String> createLink(final Class<? extends Page> page) {
		final String id = page.getName();
		return LinkUtils.createLink(id, page);
	}

	/**
	 * Creates a {@link GeneratedMenuLink} that redirects to a given page class.
	 * 
	 * @param markup
	 *            markup id
	 * @param pageModel
	 *            page model
	 * @param page
	 *            page
	 * @return the link
	 * @throws ClassNotFoundException
	 *             page was not found
	 * @param <T>
	 *            page model type
	 */
	public static <T extends Serializable> AbstractLink createRedirectLink(
			final String markup, final IModel<T> pageModel, final String page)
			throws ClassNotFoundException {
		return FACTORY.createComponent(markup, pageModel, page);
	}

	/**
	 * Create a link that opens a given modal and sets content.
	 * 
	 * @param markup
	 *            link id
	 * @param panel
	 *            panel content
	 * @param modal
	 *            modal window
	 * @return the link
	 */
	public static AjaxLink<String> createModalLink(final String markup, final Panel panel,
			final ModalWindow modal) {
		return FACTORY.createComponent(markup, panel, modal);
	}

	/**
	 * Creates a link from a given pair..
	 * 
	 * @param linkDesc
	 *            Link description.
	 * 
	 * @return Returns the link.
	 */
	public static Link<String> createPairLink(
			final Pair<String, Class<? extends Page>> linkDesc) {
		return LinkUtils.createLink(linkDesc.getLeft(), linkDesc.getRight());
	}

}