package gr.scram.wicket.pages;

import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Simple web page. No top or left menu.
 * @author asvesdi
 */
public class WebPageESSSimple extends WebPageESS {
	
	public WebPageESSSimple() {
		super();
	}

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor.
	 * @param model the model wrapper.
	 */
	public WebPageESSSimple(IModel<?> model) {
		super(model);
	}

	/**
	 * Constructor.
	 * @param parameters - page parameters.
	 */
	public WebPageESSSimple(PageParameters parameters) {
		super(parameters);
	}
}
