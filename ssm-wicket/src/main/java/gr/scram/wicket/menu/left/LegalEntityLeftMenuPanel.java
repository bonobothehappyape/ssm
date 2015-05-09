package gr.scram.wicket.menu.left;

import gr.scram.ssm.model.LegalEntity;
import gr.scram.wicket.components.GeneratedMenuLink;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Empty left menu null.
 * 
 * @param <K>
 *            menu model.
 * @author asvesdi
 * 
 */
public class LegalEntityLeftMenuPanel<T extends LegalEntity> extends
		AbstractLeftMenu<T> {

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 * @param model
	 *            model id
	 */
	public LegalEntityLeftMenuPanel(String id, IModel<T> model) {
		super(id, model);
	}

	/**
	 * link page pairs.
	 */
	public static final String[][] LINKS = {
			{ "le-info", "gr.scram.wicket.pages.InformationPage" },
			{ "le-decisions", "gr.scram.wicket.pages.DecisionsPage" },
			{ "le-production", "gr.scram.wicket.pages.ProductionPage" },
			{ "le-proc-manual", "gr.scram.wicket.pages.ProcManualPage" },
			{ "le-descr", "gr.scram.wicket.pages.DescriptionPage" },
			{ "le-process", "gr.scram.wicket.pages.ProcessPage" }, };

	/**
	 * Serialization unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(LegalEntityLeftMenuPanel.class);

	/**
	 * List of components.
	 */
	private List<Component> components = new ArrayList<Component>();

	/**
	 * get the components to load.
	 * 
	 * @return the components.
	 */
	public List<Component> getLinks() {
		if (!components.isEmpty()) {
			components.clear();
		}
		Link<T> link = null;
		IModel<T> model = null;
		for (String[] pair : LegalEntityLeftMenuPanel.LINKS) {
			try {
				model = getMenuModel();
				link = new GeneratedMenuLink<T>(pair[0], model, pair[1]);
			} catch (ClassNotFoundException e) {
				LOG.error("GeneratedMenuLink exception", e);
			}
			components.add(link);
		}
		return components;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		for (Component c : getLinks()) {
			c.setOutputMarkupId(true).setMarkupId(c.getId());
			add(c);
		}

	}

}