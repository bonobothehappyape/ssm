package gr.scram.wicket.utils;

import gr.scram.wicket.factories.FactoryType;
import gr.scram.wicket.factories.impl.ModalFactory;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.model.IModel;

/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class ModalUtils {

	/**
	 * Factory for modals.
	 */
	private static final ModalFactory FACTORY = (ModalFactory) FactoryType.MODAL_FACTORY
			.get();

	/**
	 * defeat instantiation.
	 * 
	 * @throws IllegalAccessException
	 *             thrown when accessed inside class
	 */
	private ModalUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	/**
	 * Create a simple modal window with default size.
	 * 
	 * @param markup
	 *            markup id
	 * @param model
	 *            model object
	 * @return {@link ModalWindow}.
	 */
	public static ModalWindow createModalWindow(final String markup,
			final IModel<String> model) {
		return model != null ? FACTORY.createComponent(markup, model) : FACTORY
				.createComponent(markup);

	}
	
	/**
	 * Create a simple modal window with default size.
	 * 
	 * @param markup
	 *            markup id
	 * @param creator
	 *            the {@link PageCreator}
	 * @return {@link ModalWindow}.
	 */
	public static ModalWindow createPageModalWindow(final String markup,
			final PageCreator creator) {
		return FACTORY.createComponent(markup, creator) ;
	}
	

	/**
	 * Create a simple modal window with default size.
	 * 
	 * @param markup
	 *            markup id
	 * @param model
	 *            model object
	 * @param height
	 *            height
	 * @param width
	 *            width
	 * @return {@link ModalWindow}.
	 */
	public static ModalWindow createModalWindow(final String markup,
			final IModel<String> model, final int height, final int width) {
		return FACTORY.createComponent(markup, model, height, width);

	}
	
	/**
	 * Create a simple modal window with default size.
	 * 
	 * @param markup
	 *            markup id
	 * @param model
	 *            model object
	 * @param callback window closed callback.
	 * @return {@link ModalWindow}.
	 */
	public static ModalWindow createModalWindow(final String markup,
			final IModel<String> model,
			final ModalWindow.WindowClosedCallback callback) {
		final ModalWindow modal = model != null ? FACTORY.createComponent(
				markup, model) : FACTORY.createComponent(markup);
		modal.setWindowClosedCallback(callback);
		return modal;
	}

	/**
	 * Create a simple modal window with default size.
	 * 
	 * @param markup
	 *            markup id
	 * @param model
	 *            model object
	 * @param height
	 *            height
	 * @param width
	 *            width
	 * @param callback the action class to use when the modal is closed.
	 * @return {@link ModalWindow}.
	 */
	public static ModalWindow createModalWindow(final String markup,
			final IModel<String> model, final int height, final int width,
			final ModalWindow.WindowClosedCallback callback) {
		final ModalWindow modal = FACTORY.createComponent(markup, model, height, width);
		modal.setWindowClosedCallback(callback);
		return modal;

	}
	
}