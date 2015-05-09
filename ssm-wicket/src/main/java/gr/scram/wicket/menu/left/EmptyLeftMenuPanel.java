package gr.scram.wicket.menu.left;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;

/**
 * Empty left menu null.
 * @author asvesdi
 *
 */
public class EmptyLeftMenuPanel extends AbstractLeftMenu<String> {

	/**
	 * Constructor.
	 * @param id mark-up
	 */
	public EmptyLeftMenuPanel(final String id) {
		super(id);
	}

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * List of components.
	 */
	private List<Component> components = new ArrayList<Component>();


	/**
	 * get the components to load.
	 * @return the components.
	 */
	public List<Component> getLinks() {
		return components;
	}
	

	@Override
	protected void onBeforeRender() {
		if (!hasBeenRendered()) {
			onInitialRender();
		}
		super.onBeforeRender();
	}
	
	/**
	 * on initial render.
	 */
	void onInitialRender() {
		for (Component c : getLinks()) {
			add(c);
		}
	}
}