/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.GasStationData;
import gr.scram.ssm.model.GasStation;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * @author asvesdi
 * 
 */
public class GasStationTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponentFeedbackPanel cFeedback;

	@Inject
	protected GasStationData gasStationData;

	/**
	 * @param id
	 * @param model
	 */
	public GasStationTabPanel(String id, IModel<GasStation> model) {
		super(id, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<GasStation> cModel = new CompoundPropertyModel<GasStation>(
				(IModel<GasStation>) getDefaultModel());

		final Form<GasStation> form = new Form<GasStation>("form", cModel);
		cFeedback = new ComponentFeedbackPanel("cFeedback", form);
		form.add(cFeedback.setOutputMarkupId(true));

		createTextField(form, "unleadeGas");
		createTextField(form, "lpg");
		createTextField(form, "superGas");
		createTextField(form, "unleadedSuperPlusGas");
		createTextField(form, "dieselVehicle");
		createTextField(form, "dieselHeating");
		createNumberField(form, "gasTankTotal");
		createNumberField(form, "dieselTotal");
		
		createTextField(form, "certifiedPumps.single");
		createNumberField(form, "certifiedPumps.singleNo");
		
		createTextField(form, "certifiedPumps.simpleTwin");
		createNumberField(form, "certifiedPumps.simpleTwinNo");
		
		createTextField(form, "certifiedPumps.simpleTriplet");
		createNumberField(form, "certifiedPumps.simpleTripletNo");
		
		createTextField(form, "certifiedPumps.doubleTwin");
		createNumberField(form, "certifiedPumps.doubleTwinNo");
		
		createTextField(form, "certifiedPumps.doubleTriplet");
		createNumberField(form, "certifiedPumps.doubleTripletNo");
		
		form.add(new CheckBox("certifiedPumps.hasCarLubrication"));
		form.add(new TextArea<String>("certifiedPumps.carLubricationComments"));
		
		form.add(new CheckBox("certifiedPumps.hasCarLaundry"));
		form.add(new TextArea<String>("certifiedPumps.carLaundryComments"));
		
		form.add(new TextArea<String>("comments"));

		add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				gasStationData.save((GasStation) form2.getModelObject());
				info("Οι αλλαγές σώθηκαν!");
				target.add(cFeedback);
			}

		});
		add(form);

	}

	private void createTextField(final Form<GasStation> form,
			final String expression) {
		form.add(new TextField<String>(expression));
	}

	private void createNumberField(final Form<GasStation> form,
			final String expression) {
		form.add(new TextField<Integer>(expression));
	}
}
