/**
 * 
 */
package gr.scram.wicket.components;

import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.model.IModel;

/**
 * @author bonobo
 *
 */
public final class BootstrapTabbedPanel<K extends ITab> extends AjaxTabbedPanel<K> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param tabs
	 */
	public BootstrapTabbedPanel(final String id, final List<K> tabs) {
		super(id, tabs);
	}

	/**
	 * @param id
	 * @param tabs
	 * @param model
	 */
	public BootstrapTabbedPanel(final String id, final List<K> tabs, final IModel<Integer> model) {
		super(id, tabs, model);
	}
	
	@Override
	protected String getSelectedTabCssClass() {
		return "active";
	}
	
	@Override
	protected String getTabContainerCssClass() {
		return "nav nav-tabs";
	}

}
