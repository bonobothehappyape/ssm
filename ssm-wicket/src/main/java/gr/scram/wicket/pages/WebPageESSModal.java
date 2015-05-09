package gr.scram.wicket.pages;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Modal content Pages should extend this one..
 * @author asvesdi
 */
public class WebPageESSModal extends WebPage {
	
	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	protected static final Logger LOG = LoggerFactory.getLogger(WebPageESSModal.class);

	/**
	 * Constructor.
	 */
	public WebPageESSModal() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void renderHead(final IHeaderResponse response) {
		super.renderHead(response);
		
		//TODO
//		response.renderOnLoadJavaScript("$( document ).ready(function() " +
//				"{ $('.pover').popover();});");
	}
	
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
	}

	/**
	 * Constructor.
	 * @param model the model wrapper.
	 */
	public WebPageESSModal(final IModel<?> model) {
		super(model);
	}

	/**
	 * Constructor.
	 * @param parameters - page parameters.
	 */
	public WebPageESSModal(final PageParameters parameters) {
		super(parameters);
	}
}
