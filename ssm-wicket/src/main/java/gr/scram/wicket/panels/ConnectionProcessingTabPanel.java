/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.ConnectionProcessingData;
import gr.scram.ssm.model.ConnectionProcessing;
import gr.scram.wicket.pages.ProcessPage;

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
public class ConnectionProcessingTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected ConnectionProcessingData data;

	private ComponentFeedbackPanel cFeedbackPanel;

	/**
	 * @param id
	 * @param model
	 */
	public ConnectionProcessingTabPanel(final String id,
			final IModel<ConnectionProcessing> model) {
		super(id, model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<ConnectionProcessing> cModel = new CompoundPropertyModel<ConnectionProcessing>(
				(IModel<ConnectionProcessing>) getDefaultModel());
		
		cFeedbackPanel = new ComponentFeedbackPanel(
				"cFeedback", this);
		cFeedbackPanel.setOutputMarkupId(true);
		add(cFeedbackPanel);
		
		final Form<ConnectionProcessing> form = new Form<ConnectionProcessing>("form",
				cModel);
		
		form.add(new TextField<String>("preApprovalApplication"));
		form.add(new TextField<String>("preApprovalAutopsy"));
		form.add(new TextField<String>("preApprovalDecision"));
		form.add(new TextField<String>("approvalApplication"));
		form.add(new TextField<String>("approvalDecision"));
		form.add(new TextField<String>("consensusApplication"));
		form.add(new TextField<String>("consensusAutopsy"));
		form.add(new TextField<String>("decision"));
		form.add(new TextField<String>("townshipApplication"));
		form.add(new TextField<String>("townshipDecision"));
		form.add(new TextField<String>("approvalApplication2"));
		form.add(new TextField<String>("approvalAutopsy2"));
		form.add(new TextField<String>("approvalDecision2"));
		form.add(new TextField<String>("consensusApplication2"));
		form.add(new TextField<String>("consensusAutopsy2"));
		form.add(new TextField<String>("decision2"));
		
		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				data.save((ConnectionProcessing) form2.getModelObject());
				((ProcessPage) ConnectionProcessingTabPanel.this
						.getParent().getParent()).info("Οι αλλαγές έγιναν!");
				target.add(((ProcessPage) ConnectionProcessingTabPanel.this
						.getParent().getParent()).getFeedbackPanel());
			}

		};
		
		form.add(save);

		add(form);
	}

}
