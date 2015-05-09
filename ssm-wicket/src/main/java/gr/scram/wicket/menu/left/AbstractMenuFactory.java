package gr.scram.wicket.menu.left;


import java.io.Serializable;

import org.apache.wicket.model.IModel;

/**
 * Factory to create menus based on user privileges.
 * @param <T> model type.
 * @author asvesdi
 */
public interface AbstractMenuFactory<T extends Serializable> extends Serializable {
	
	/**
	 * create Menu for each user.
	 * @param user the user
	 * @param model model
	 * @return the left menu
	 */
	AbstractLeftMenu<T> getMenuFor(String user, IModel<T> model);
	
	/**
	 * create Menu for each user.
	 * @param user the user
	 * @param model model
	 * @return the left menu
	 */
	AbstractLeftMenu<T> getCollapsibleMenuFor(String user, IModel<T> model);
	
}
