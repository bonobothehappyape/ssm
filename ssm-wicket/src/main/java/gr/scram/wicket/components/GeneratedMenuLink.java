package gr.scram.wicket.components;

import gr.scram.wicket.pages.WebPageESSMenuLeft;
import gr.scram.wicket.utils.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Link class .Redirects to given {@link Page} name. Adds
 * {@link IModel} instance
 * @param <T> the link model type.
 * @author asvesdi
 * 
 */
public final class GeneratedMenuLink<T extends Serializable> extends
		BlockUILink<T> {

	/**
	 * Class string.
	 */
	private final String page;

	/**
	 * Constructor.
	 * @param id mark-up
	 * @param model page model object 
	 * @param page page class to render
	 * @throws ClassNotFoundException thrown when page does not exist.
	 */
	public GeneratedMenuLink(final String id, final IModel<T> model, final String page)
			throws ClassNotFoundException {
		super(id, model);
		this.page = page;
		this.linkModel = model;
	}

	/**
	 * Link model.
	 */
	private final IModel<T> linkModel;

	/**
	 * @return the linkModel
	 */
	public IModel<T> getLinkModel() {
		return this.linkModel;
	}

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(GeneratedMenuLink.class);

	@Override
	public void onClick() {
		WebPageESSMenuLeft p = null;
		Constructor<?> c = null;
		try {
			c = ReflectionUtils.getConstructor(Class.forName(page),
					IModel.class);
			p = (WebPageESSMenuLeft) c.newInstance(linkModel);
		} catch (final IllegalArgumentException e) {
			LOG.warn("IllegalArgumentException :" + e.getMessage());
			throw new WicketRuntimeException("IllegalArgumentException", e);
		} catch (final InstantiationException e) {
			LOG.warn("InstantiationException :" + e.getMessage());
			throw new WicketRuntimeException("InstantiationException", e);
		} catch (final IllegalAccessException e) {
			LOG.warn("IllegalAccessException :" + e.getMessage());
			throw new WicketRuntimeException("IllegalAccessException", e);
		} catch (final InvocationTargetException e) {
			LOG.warn("InvocationTargetException :" + e.getMessage());
			throw new WicketRuntimeException("InvocationTargetException", e);
		} catch (final ClassNotFoundException e) {
			LOG.warn("ClassNotFoundException :" + e.getMessage());
			throw new WicketRuntimeException("ClassNotFoundException", e);
		} catch (final Exception e) {
			throw new WicketRuntimeException("Reflection Utils Exception", e);
		}
		setResponsePage(p);
	};
}
