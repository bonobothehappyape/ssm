/**
 * 
 */
package gr.scram.wicket.panels;


import gr.scram.ssm.ejb.CarStationData;
import gr.scram.ssm.model.CarStation;
import gr.scram.wicket.utils.DropDownChoiceUtils;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.google.common.collect.Lists;

/**
 * @author asvesdi
 * 
 */
public class CarStationTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponentFeedbackPanel cFeedback;

	@Inject
	protected CarStationData carStationData;

	/**
	 * @param id
	 * @param model
	 */
	public CarStationTabPanel(final String id, final IModel<CarStation> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<CarStation> cModel = new CompoundPropertyModel<CarStation>(
				(IModel<CarStation>) getDefaultModel());

		final Form<CarStation> form = new Form<CarStation>("form", cModel);
		cFeedback = new ComponentFeedbackPanel("cFeedback", form);
		form.add(cFeedback.setOutputMarkupId(true));

		final DropDownChoice<CarStation.CarStationType> type = DropDownChoiceUtils
				.createEnumDropdown("type",
						Lists.newArrayList(CarStation.CarStationType.values()));
		form.add(type);

		final DropDownChoice<CarStation.CarStationSize> size = DropDownChoiceUtils
				.createEnumDropdown("size",
						Lists.newArrayList(CarStation.CarStationSize.values()));
		form.add(size);

		final DropDownChoice<CarStation.CarStationSystem> system = DropDownChoiceUtils
				.createEnumDropdown("system", Lists
						.newArrayList(CarStation.CarStationSystem.values()));
		form.add(system);

		final DropDownChoice<CarStation.CarStationFloorConnection> floor = DropDownChoiceUtils
				.createEnumDropdown("floor", Lists
						.newArrayList(CarStation.CarStationFloorConnection
								.values()));
		form.add(floor);
		
		form.add(new TextField<String>("usefulArea"));
		form.add(new TextField<Integer>("parkingPositions"));
		form.add(new TextField<String>("floorsOver"));
		form.add(new TextField<String>("floorsUnder"));
		form.add(new CheckBox("pumps"));
		form.add(new CheckBox("laundry"));
		form.add(new CheckBox("lubrication"));
		form.add(new TextArea<String>("comments"));
		
		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				carStationData.save((CarStation) form2.getModelObject());
				info("Οι αλλαγές σώθηκαν!");
				target.add(cFeedback);
			}

		};
		
		add(save);
		add(form);
	
	}

}
