/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.CarWashData;
import gr.scram.ssm.model.CarWash;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * @author asvesdi
 * 
 */
public class CarWashTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected CarWashData carWashData;

	private ComponentFeedbackPanel cFeedback;

	/**
	 * @param id
	 */
	public CarWashTabPanel(final String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public CarWashTabPanel(final String id, final IModel<CarWash> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<CarWash> cModel = new CompoundPropertyModel<CarWash>(
				(IModel<CarWash>) getDefaultModel());
		
		final Form<CarWash> form = new Form<CarWash>("form", cModel);
		cFeedback= new ComponentFeedbackPanel("cFeedback", form);
		form.add(cFeedback.setOutputMarkupId(true));
		
		createTextField(form, "wheelWashersTruck");
		createNumberField(form, "wheelWashersNoTruck");
		createTextField(form, "hydraulicLiftTruck");
		createNumberField(form, "hydraulicLiftNoTruck");
		createTextField(form, "automaticLaundrieTruck");
		createNumberField(form, "automaticLaundrieNoTruck");
		
		createTextField(form, "outdoorInfo.wheelWashers");
		createNumberField(form, "outdoorInfo.wheelWashersNo");
		createTextField(form, "outdoorInfo.hydraulicLift");
		createNumberField(form, "outdoorInfo.hydraulicLiftNo");
		createTextField(form, "outdoorInfo.automaticLaundrie");
		createNumberField(form, "outdoorInfo.automaticLaundrieNo");
		createTextField(form, "outdoorInfo.tunnel");
		createNumberField(form, "outdoorInfo.tunnelNo");
		
		createTextField(form, "passengerVehicleData.airCompressor");
		createNumberField(form, "passengerVehicleData.airCompressorNo");
		createTextField(form, "passengerVehicleData.electricLift2Weel");
		createNumberField(form, "passengerVehicleData.electricLift2WeelNo");
		createTextField(form, "passengerVehicleData.electricLift4Wheel");
		createNumberField(form, "passengerVehicleData.electricLift4WheelNo");
		createTextField(form, "passengerVehicleData.tunnel");
		createNumberField(form, "passengerVehicleData.tunnelNo");
		createTextField(form, "passengerVehicleData.selfServicePosition");
		createNumberField(form, "passengerVehicleData.selfServicePositionNo");
		add(form);
		
		add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				carWashData.save((CarWash) form2.getModelObject());
				info("Οι αλλαγές σώθηκαν!");
				target.add(cFeedback);
			}

		});
	}

	
	private void createTextField(final Form<CarWash> form,
			final String expression) {
		form.add(new TextField<String>(expression));
	}
	
	private void createNumberField(final Form<CarWash> form,
			final String expression) {
		form.add(new TextField<Integer>(expression));
	}
}
