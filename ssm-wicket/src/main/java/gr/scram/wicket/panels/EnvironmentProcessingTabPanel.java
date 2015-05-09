/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.EnvironmentProcessingData;
import gr.scram.ssm.model.EnvironmentProcessing;
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
public class EnvironmentProcessingTabPanel extends Panel {
	
	@Inject
	private EnvironmentProcessingData data;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ComponentFeedbackPanel cFeedbackPanel;

	public EnvironmentProcessingTabPanel(final String id,
			final IModel<EnvironmentProcessing> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<EnvironmentProcessing> cModel = new CompoundPropertyModel<EnvironmentProcessing>(
				(IModel<EnvironmentProcessing>) getDefaultModel());

		cFeedbackPanel = new ComponentFeedbackPanel("cFeedback", this);
		cFeedbackPanel.setOutputMarkupId(true);
		add(cFeedbackPanel);

		final Form<EnvironmentProcessing> form = new Form<EnvironmentProcessing>(
				"form", cModel);
		form.add(new TextField<String>("envApplication"));
		form.add(new TextField<String>("envAutopsy"));
		form.add(new TextField<String>("envApproval"));
		
		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				data.save((EnvironmentProcessing) form2.getModelObject());
				((ProcessPage) EnvironmentProcessingTabPanel.this
						.getParent().getParent()).info("Οι αλλαγές έγιναν!");
				target.add(((ProcessPage) EnvironmentProcessingTabPanel.this
						.getParent().getParent()).getFeedbackPanel());
			}

		};
		
		add(save);

		add(form);
	}

}
