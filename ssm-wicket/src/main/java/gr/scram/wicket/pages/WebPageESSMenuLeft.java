package gr.scram.wicket.pages;

import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.EmptyLeftMenuPanel;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Simple web page with top menu.
 * @author asvesdi
 */
public abstract class WebPageESSMenuLeft extends WebPageESS {

	public WebPageESSMenuLeft() {
		super();
	}


	public WebPageESSMenuLeft(IModel<?> model) {
		super(model);
	}


	public WebPageESSMenuLeft(PageParameters parameters) {
		super(parameters);
	}

	/**
	 * Constant.
	 */
	public static final String LEFT_MENU = "left-menu";

	/**
	 * Serialisation .
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(getLeftMenu());
	}


	/**
	 * get the left menu. Override this in subclasses.
	 * 
	 * @return a left menu {@link Panel}
	 */
	public AbstractLeftMenu<?> getLeftMenu() {
		return new EmptyLeftMenuPanel(WebPageESSMenuLeft.LEFT_MENU);
	}
}
