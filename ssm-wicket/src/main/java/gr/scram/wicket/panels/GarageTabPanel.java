/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.GarageData;
import gr.scram.ssm.model.Garage;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * @author asvesdi
 *
 */
public class GarageTabPanel extends Panel {
	
	@Inject
	private GarageData garageData;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public GarageTabPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param model
	 */
	public GarageTabPanel(String id, IModel<Garage> model) {
		super(id, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<Garage> cModel = new CompoundPropertyModel<Garage>(
				(IModel<Garage>) getDefaultModel());
		final Form<Garage> form = new Form<Garage>("form", cModel);
		
		form.add(new TextField<String>("specialty"));
		form.add(new TextArea<String>("machinery"));
		form.add(new TextField<Double>("mainArea"));
		form.add(new TextField<Double>("helpArea"));
		form.add(new TextField<Double>("power"));
		form.add(new TextArea<String>("comments"));
		
		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				garageData.save((Garage) form2.getModelObject());
				info("Οι αλλαγές έγιναν!!");
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form2) {
				// TODO Auto-generated method stub
				super.onError(target, form2);
			}

		});
		add(form);
	}

}
