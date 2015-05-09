/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.ProcedureManualInData;
import gr.scram.ssm.ejb.ProcedureManualOutData;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.ssm.model.ProcedureManualIn;
import gr.scram.ssm.model.ProcedureManualOut;
import gr.scram.wicket.components.BootstrapTabbedPanel;
import gr.scram.wicket.components.EntityModel;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.panels.InManualTabPanel;
import gr.scram.wicket.panels.OutManualTabPanel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author asvesdi
 * 
 */
public class ProcManualPage extends WebPageESSMenuLeft {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcManualPage(final IModel<LegalEntity> model) {
		super(model);
	}
	
	@Inject
	private ProcedureManualInData inData;
	
	@Inject
	private ProcedureManualOutData outData;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("page-title")));
		final List<ITab> tabs = new ArrayList<ITab>();

		tabs.add(new AbstractTab(
				new ResourceModel("process-manual-in")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				final LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				final ProcedureManualIn admin = inData.findByLegalId(entity.getId());
				final EntityModel<ProcedureManualIn, Long> entityModel
					= new EntityModel<ProcedureManualIn, Long>(
						ProcedureManualIn.class, admin);
				return new InManualTabPanel(panelId, entityModel);
			}
		});

		tabs.add(new AbstractTab(new ResourceModel("process-manual-out")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				final LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				final ProcedureManualOut admin = outData
						.findByLegalId(entity.getId());
				final EntityModel<ProcedureManualOut, Long> entityModel 
					= new EntityModel<ProcedureManualOut, Long>(
							ProcedureManualOut.class, admin);
				return new OutManualTabPanel(panelId, entityModel);
			}
		});
		
		add(new BootstrapTabbedPanel<ITab>("tabs", tabs));
	}
	
	@SuppressWarnings("unchecked")
	protected IModel<LegalEntity> getLeModel() {
		return (IModel<LegalEntity>) getDefaultModel();
	}

	@Override
	public AbstractLeftMenu<?> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(LEFT_MENU,
				getLeModel());
	}
}
