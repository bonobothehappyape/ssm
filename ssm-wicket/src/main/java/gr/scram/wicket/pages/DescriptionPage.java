/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.CarStationData;
import gr.scram.ssm.ejb.CarWashData;
import gr.scram.ssm.ejb.GarageData;
import gr.scram.ssm.ejb.GasStationData;
import gr.scram.ssm.ejb.LPGStationData;
import gr.scram.ssm.model.CarStation;
import gr.scram.ssm.model.CarWash;
import gr.scram.ssm.model.Garage;
import gr.scram.ssm.model.GasStation;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.wicket.components.BootstrapTabbedPanel;
import gr.scram.wicket.components.EntityModel;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.panels.CarStationTabPanel;
import gr.scram.wicket.panels.CarWashTabPanel;
import gr.scram.wicket.panels.GarageTabPanel;
import gr.scram.wicket.panels.GasStationTabPanel;

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
public class DescriptionPage extends WebPageESSMenuLeft {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CarWashData carWashData;
	
	@Inject
	private CarStationData carStationData;

	@Inject
	protected GarageData garageData;

	@Inject
	private GasStationData gasStationData;

	@Inject
	private LPGStationData lpgStationData;

	public DescriptionPage(final IModel<LegalEntity> model) {
		super(model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("page-title")));

		final List<ITab> tabs = new ArrayList<ITab>();
		// CarWash / Πλυντηριο / Λιπαντηριο
		tabs.add(new AbstractTab(new ResourceModel("car-wash-tab-panel")) {
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
				final CarWash cw = carWashData.findByLegalId(entity.getId());
				final EntityModel<CarWash, Long> entityModel = new EntityModel<CarWash, Long>(
						CarWash.class, cw);
				return new CarWashTabPanel(panelId, entityModel);
			}
		});

		// Garage / Συνεργείο
		tabs.add(new AbstractTab(new ResourceModel("garage-tab-panel")) {
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
				final Garage g = garageData.findByLegalId(entity.getId());
				final EntityModel<Garage, Long> entityModel = new EntityModel<Garage, Long>(
						Garage.class, g);
				return new GarageTabPanel(panelId, entityModel);
			}
		});

		// GasStation 
		tabs.add(new AbstractTab(new ResourceModel("gas-station-tab-panel")) {
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
				final GasStation g = gasStationData.findByLegalId(entity
						.getId());
				final EntityModel<GasStation, Long> entityModel = new EntityModel<GasStation, Long>(
						GasStation.class, g);
				return new GasStationTabPanel(panelId, entityModel);
			}
		});

		// CarStation
		tabs.add(new AbstractTab(new ResourceModel("car-station-tab-panel")) {
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
				final CarStation g = carStationData.findByLegalId(entity
						.getId());
				final EntityModel<CarStation, Long> entityModel = new EntityModel<CarStation, Long>(
						CarStation.class, g);
				return new CarStationTabPanel(panelId, entityModel);
			}
		});
		add(new BootstrapTabbedPanel<ITab>("tabs", tabs));
	}

	@SuppressWarnings("unchecked")
	protected IModel<LegalEntity> getLeModel() {
		return (IModel<LegalEntity>) getDefaultModel();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractLeftMenu<?> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(LEFT_MENU,
				(IModel<LegalEntity>) getDefaultModel());
	}
}
