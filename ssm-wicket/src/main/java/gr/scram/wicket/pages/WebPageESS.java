package gr.scram.wicket.pages;

import gr.scram.wicket.panels.FooterPanel;
import gr.scram.wicket.panels.HeaderPanel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author asvesdi
 */
public class WebPageESS extends WebPage {
	
	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	protected static final Logger LOG = LoggerFactory.getLogger(WebPageESS.class);
	
	/**
	 * left-menu-mark up.
	 */
	public static final String LEFT_MENU = "left-menu";

	/**
	 * {@inheritDoc}
	 */
	public WebPageESS() {
		super();
	}
	
	/**
	 * the {@link FeedbackPanel} .
	 */
	private FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new HeaderPanel("headerPanel"));
		add(new FooterPanel("footerPanel"));
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
	
	}

	/**
	 * Constructor.
	 * @param model the model wrapper.
	 */
	public WebPageESS(final IModel<?> model) {
		super(model);
	}

	/**
	 * Constructor.
	 * @param parameters - page parameters.
	 */
	public WebPageESS(final PageParameters parameters) {
		super(parameters);
	}

	/**
	 * @return the feedbackPanel
	 */
	public FeedbackPanel getFeedbackPanel() {
		return feedbackPanel;
	}

	/**
	 * @param feedbackPanel the feedbackPanel to set
	 */
	public void setFeedbackPanel(final FeedbackPanel feedbackPanel) {
		this.feedbackPanel = feedbackPanel;
	}

}
