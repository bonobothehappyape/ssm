/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.FireProcessingData;
import gr.scram.ssm.model.FireProcessing;
import gr.scram.ssm.model.Person;
import gr.scram.wicket.pages.ProcessPage;
import gr.scram.wicket.utils.DropDownChoiceUtils;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
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
public class FireProcessingTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponentFeedbackPanel cFeedbackPanel;

	@Inject
	protected FireProcessingData data;

	/**
	 * @param id
	 */
	public FireProcessingTabPanel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public FireProcessingTabPanel(String id, IModel<?> model) {
		super(id, model);
		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<FireProcessing> cModel = new CompoundPropertyModel<FireProcessing>(
				(IModel<FireProcessing>) getDefaultModel());

		cFeedbackPanel = new ComponentFeedbackPanel("cFeedback", this);
		cFeedbackPanel.setOutputMarkupId(true);
		add(cFeedbackPanel);

		final Form<FireProcessing> form = new Form<FireProcessing>("form",
				cModel);

		form.add(new TextField<String>("studyApplication"));
		form.add(new TextField<String>("studyDecision"));
		form.add(new TextField<String>("studyChangeApplication"));
		form.add(new TextField<String>("certificateApplication"));
		form.add(new TextField<String>("certificateGrant"));

		DropDownChoice<Person> spDD = DropDownChoiceUtils
				.createManagedDropDownChoice("studyPerson", Person.class,
						"surname");
		form.add(spDD);
		
		form.add(new TextField<String>("autopsy"));
		DropDownChoice<Person> autDD = DropDownChoiceUtils
				.createManagedDropDownChoice("autopsyPerson", Person.class,
						"surname");
		form.add(autDD);

		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				data.save((FireProcessing) form2.getModelObject());
				((ProcessPage) FireProcessingTabPanel.this.getParent()
						.getParent()).info("Οι αλλαγές έγιναν!");
				target.add(((ProcessPage) FireProcessingTabPanel.this
						.getParent().getParent()).getFeedbackPanel());
			}

		};

		form.add(save);

		add(form);
	}

}
