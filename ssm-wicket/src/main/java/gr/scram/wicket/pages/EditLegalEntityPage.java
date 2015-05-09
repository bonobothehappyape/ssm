/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.model.LegalEntity;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author bonobo
 * 
 */
public class EditLegalEntityPage extends WebPageESSMenuLeft {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EditLegalEntityPage(final IModel<LegalEntity> leModel) {
		super(leModel);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("page-title")));
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractLeftMenu<LegalEntity> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(
				WebPageESSMenuLeft.LEFT_MENU,
				(IModel<LegalEntity>) getDefaultModel());
	}

}
