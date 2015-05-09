package gr.scram.wicket.menu.left;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Abstract menu class.
 * @author asvesdi
 * @param <T> model type
 */
public abstract class AbstractLeftMenu<T extends Serializable>
		extends Panel {

	/**
	 * serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu model.
	 */
	private IModel<T> menuModel;

	/**
	 * Constructor.
	 * @param id mark-up id
	 * @param model model
	 */
	public AbstractLeftMenu(final String id,final IModel<T> model) {
		super(id, model);
		this.menuModel = model;
	}
	
	
	/**
	 * Constructor.
	 * @param id mark-up
	 */
	public AbstractLeftMenu(String id) {
		super(id);
	}

	/**
	 * {@inheritDoc}
	 * @throws ClassNotFoundException 
	 */
	public abstract List<Component> getLinks() throws ClassNotFoundException ;
	
	/**
	 * @return the menuModel
	 */
	public IModel<T> getMenuModel() {
		return this.menuModel;
	}

}
