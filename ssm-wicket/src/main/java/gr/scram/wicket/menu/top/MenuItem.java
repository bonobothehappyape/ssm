package gr.scram.wicket.menu.top;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu.
 * @author asvesdi
 */
public abstract class MenuItem implements Serializable {
	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 0L;

	/**
     * 
     */
	private boolean topLevel = true;
	/**
	 * children.
	 */
	private final List<MenuItem> subMenuItems = new ArrayList<MenuItem>();

	/**
	 * Add one menu item.
	 * @param menu menu item.
	 **/
	public void addMenuItem(final MenuItem menu) {
		this.subMenuItems.add(menu);
		menu.setTopLevel(false);
	}

	/**
	 * get children.
	 * @return List of items.
	 */
	public List<MenuItem> getChildren() {
		return this.subMenuItems;
	}

	/**
	 * true if the item is top-level.
	 * @return true if the item is top-level.
	 */
	public boolean isTopLevel() {
		return this.topLevel;
	}

	/**
	 * set-top level.
	 * @param topLevel true if the item is top-level.
	 */
	private void setTopLevel(final boolean topLevel) {
		this.topLevel = topLevel;
	}

}
