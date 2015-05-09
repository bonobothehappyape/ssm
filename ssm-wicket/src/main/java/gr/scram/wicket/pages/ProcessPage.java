/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.AdminProcessingData;
import gr.scram.ssm.ejb.ConnectionProcessingData;
import gr.scram.ssm.ejb.EnvironmentProcessingData;
import gr.scram.ssm.ejb.FireProcessingData;
import gr.scram.ssm.ejb.MinistryProcessingData;
import gr.scram.ssm.model.AdminProcessing;
import gr.scram.ssm.model.ConnectionProcessing;
import gr.scram.ssm.model.EnvironmentProcessing;
import gr.scram.ssm.model.FireProcessing;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.ssm.model.MinistryProcessing;
import gr.scram.wicket.components.BootstrapTabbedPanel;
import gr.scram.wicket.components.EntityModel;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.panels.AdminProcessingTabPanel;
import gr.scram.wicket.panels.ConnectionProcessingTabPanel;
import gr.scram.wicket.panels.EnvironmentProcessingTabPanel;
import gr.scram.wicket.panels.FireProcessingTabPanel;
import gr.scram.wicket.panels.MinistryProcessingTabPanel;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author asvesdi
 * 
 */
public class ProcessPage extends WebPageESSMenuLeft {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory
			.getLogger(ProcessPage.class);

	private boolean changed ;
	
	@Inject
	private AdminProcessingData adminData;
	
	@Inject
	private FireProcessingData fireData;

	@Inject
	private ConnectionProcessingData connectionData;
	
	@Inject
	private MinistryProcessingData ministryData;

	@Inject
	private EnvironmentProcessingData envDat;

	public ProcessPage(final IModel<LegalEntity> model) {
		super(model);
		LOG.info("editing " + model.getObject().getName());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("page-title")));
		final List<ITab> tabs = new ArrayList<ITab>();

		tabs.add(new AbstractTab(
				new ResourceModel("admin-processing-tab-panel")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				AdminProcessing admin = adminData.findByLegalId(entity.getId());
				final EntityModel<AdminProcessing, Long> entityModel = new EntityModel<AdminProcessing, Long>(
						AdminProcessing.class, admin);
				return new AdminProcessingTabPanel(panelId, entityModel);
			}
		});

		tabs.add(new AbstractTab(new ResourceModel(
				"connection-processing-tab-panel")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				ConnectionProcessing admin = connectionData
						.findByLegalId(entity.getId());
				final EntityModel<ConnectionProcessing, Long> entityModel 
					= new EntityModel<ConnectionProcessing, Long>(
						ConnectionProcessing.class, admin);
				return new ConnectionProcessingTabPanel(panelId, entityModel);
			}
		});

		tabs.add(new AbstractTab(new ResourceModel(
				"environment-processing-tab-panel")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				EnvironmentProcessing admin = envDat.findByLegalId(entity
						.getId());
				final EntityModel<EnvironmentProcessing, Long> entityModel = new EntityModel<EnvironmentProcessing, Long>(
						EnvironmentProcessing.class, admin);
				return new EnvironmentProcessingTabPanel(panelId, entityModel);
			}
		});

		tabs.add(new AbstractTab(new ResourceModel(
				"ministry-processing-tab-panel")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				MinistryProcessing admin = ministryData.findByLegalId(entity
						.getId());
				final EntityModel<MinistryProcessing, Long> entityModel = new EntityModel<MinistryProcessing, Long>(
						MinistryProcessing.class, admin);
				return new MinistryProcessingTabPanel(panelId, entityModel);
			}
		});
		
		tabs.add(new AbstractTab(new ResourceModel(
				"fire-processing-tab-panel")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(final String panelId) {
				LegalEntity entity = getLeModel().getObject();
				if (entity == null) {
					throw new WicketRuntimeException(
							"cannot fetch Legal Entity ");
				}
				FireProcessing admin = fireData.findByLegalId(entity
						.getId());
				final EntityModel<FireProcessing, Long> entityModel 
					= new EntityModel<FireProcessing, Long>(
						FireProcessing.class, admin);
				return new FireProcessingTabPanel(panelId, entityModel);
			}
		});

		add(new BootstrapTabbedPanel<ITab>("tabs", tabs));

	}

	@SuppressWarnings("unchecked")
	public IModel<LegalEntity> getLeModel() {
		return (IModel<LegalEntity>) getDefaultModel();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractLeftMenu<LegalEntity> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(LEFT_MENU,
				(IModel<LegalEntity>) getDefaultModel());
	}

	/**
	 * @return the changed
	 */
	public boolean isChanged() {
		return changed;
	}

	/**
	 * @param changed the changed to set
	 */
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
}
