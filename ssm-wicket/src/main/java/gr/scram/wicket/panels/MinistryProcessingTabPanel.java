/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.MinistryProcessingData;
import gr.scram.ssm.model.MinistryProcessing;
import gr.scram.wicket.pages.ProcessPage;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
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
public class MinistryProcessingTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponentFeedbackPanel cFeedbackPanel;

	@Inject
	protected MinistryProcessingData data;

	/**
	 * @param id
	 */
	public MinistryProcessingTabPanel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public MinistryProcessingTabPanel(String id,
			IModel<MinistryProcessing> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<MinistryProcessing> cModel = new CompoundPropertyModel<MinistryProcessing>(
				(IModel<MinistryProcessing>) getDefaultModel());

//		cFeedbackPanel = new ComponentFeedbackPanel("cFeedback", this);
//		cFeedbackPanel.setOutputMarkupId(true);
//		add(cFeedbackPanel);

		final Form<MinistryProcessing> form = new Form<MinistryProcessing>(
				"form", cModel);

		form.add(new TextField<String>("suitabilityApplication"));
		form.add(new TextField<String>("autopsy"));
		form.add(new TextField<String>("suitabilityAdoption"));

		form.add(new TextField<String>("establishLicenceApplication"));
		form.add(new TextField<String>("establishLicenceDecision"));
		form.add(new TextField<String>("tax"));
		form.add(new TextField<String>("decisionEstablishDecision"));
		form.add(new TextField<String>("operationApplicationStart"));
		form.add(new TextField<String>("operationDecisionStart"));

		form.add(new TextField<String>("blueprintApplication"));
		form.add(new TextField<String>("tax2"));
		form.add(new TextField<String>("blueprintDecision"));

		form.add(new TextField<String>("operationApplicationEnd"));
		form.add(new TextField<String>("operationDecisionEnd"));
		form.add(new TextArea<String>("comments"));

		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				data.save((MinistryProcessing) form2.getModelObject());
				((ProcessPage) MinistryProcessingTabPanel.this.getParent()
						.getParent()).info("Οι αλλαγές έγιναν!");
				target.add(((ProcessPage) MinistryProcessingTabPanel.this
						.getParent().getParent()).getFeedbackPanel());
			}

		};

		form.add(save);

		add(form);

	}

}
