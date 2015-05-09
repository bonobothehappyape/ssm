package gr.scram.wicket.factories.impl;

import gr.scram.wicket.factories.IFactory;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.model.IModel;

/**
 * 
 * @author asvesdi
 */
public final class ModalFactory implements IFactory<String, ModalWindow> {

	/**
	 * Initial modal width.
	 */
	private static final int INIT_WIDTH = 210;

	/**
	 * Initial modal height.
	 */
	private static final int INIT_HEIGHT = 180;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public ModalWindow createComponent(final String markup,
			final IModel<String> model) {
		final ModalWindow modalWindow = new ModalWindow(markup);
		modalWindow.setCookieName(markup);
		modalWindow.setInitialWidth(ModalFactory.INIT_WIDTH);
		modalWindow.setInitialHeight(ModalFactory.INIT_HEIGHT);
		return modalWindow;
	}
	
	/**
	 * Creates a modal window container (add the modal window).
	 * @param markup markup id.
	 * @return the {@link ModalWindow}.
	 */
	public ModalWindow createComponent(final String markup) {
		final ModalWindow modalWindow = new ModalWindow(markup);
		modalWindow.setCookieName(markup);
		modalWindow.setInitialWidth(ModalFactory.INIT_WIDTH);
		modalWindow.setInitialHeight(ModalFactory.INIT_HEIGHT);
		return modalWindow;
	}
	
	/**
	 * Creates a modal window container (add the modal window).
	 * Uses a Page creator to initialise the {@link Page} instances.
	 * @param markup
	 *            markup id.
	 * @param creator the {@link PageCreator} to use.
	 * @return the {@link ModalWindow}.
	 */
	public ModalWindow createComponent(final String markup,
			final ModalWindow.PageCreator creator) {
		final ModalWindow modalWindow = new ModalWindow(markup);
		modalWindow.setCookieName(markup);
		modalWindow.setInitialWidth(ModalFactory.INIT_WIDTH);
		modalWindow.setInitialHeight(ModalFactory.INIT_HEIGHT);
		modalWindow.setPageCreator(creator);
		return modalWindow;
	}
	
	/**
	 * Creates a modal window container (adds the modal window).
	 * Uses a Page creator to initialise the {@link Page} instances.
	 * @param markup markupid
	 * @param creator page creator
	 * @param width width
	 * @param height height
	 * @return the modal window instance
	 */
	public ModalWindow createComponent(final String markup,
			final ModalWindow.PageCreator creator, int width, int height) {
		final ModalWindow modalWindow = new ModalWindow(markup);
		modalWindow.setCookieName(markup);
		modalWindow.setInitialWidth(width);
		modalWindow.setInitialHeight(height);
		modalWindow.setPageCreator(creator);
		return modalWindow;
	}

	/**
	 * Create a modal window with given size.
	 * @param markup markup id.
	 * @param model model object
	 * @param width width
	 * @param height height
	 * @return the modal window.
	 */
	public ModalWindow createComponent(final String markup,
			final IModel<String> model, final int width, final int height) {
		final ModalWindow modalWindow = new ModalWindow(markup);
		modalWindow.setCookieName(markup);
		modalWindow.setInitialWidth(width);
		modalWindow.setInitialHeight(height);
		return modalWindow;
	}

}
