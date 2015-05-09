/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.DecisionData;
import gr.scram.ssm.model.Decision;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.ssm.model.Ministry;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.utils.DropDownChoiceUtils;
import gr.scram.wicket.utils.TextFieldUtils;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author asvesdi
 * 
 */
public class DecisionsPage extends WebPageESSMenuLeft {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private DecisionData decisionData;

	public DecisionsPage(final IModel<LegalEntity> model) {
		super(model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		@SuppressWarnings("unchecked")
		final IModel<LegalEntity> defaultModel = (IModel<LegalEntity>) getDefaultModel();

		final Decision prod = decisionData.findByLegalId(defaultModel
				.getObject().getId());

		final CompoundPropertyModel<Decision> cModel = new CompoundPropertyModel<Decision>(
				prod);
		final Form<Decision> form = new Form<Decision>("form", cModel);

		final DropDownChoice<Ministry> ministry = DropDownChoiceUtils
				.createManagedDropDownChoice("ministry", Ministry.class, "name");
		form.add(new Label("page-title", new ResourceModel("page-title")));
		form.add(ministry);

		createTextField(form, "envelopeNumber");
		createTextField(form, "workPermission");
		createTextField(form, "lastApprovedPlans");
		createTextField(form, "newEnvelopeNumber");
		createTextField(form, "newSuitability");
		createTextField(form, "newEstablishLicense");
		createTextField(form, "newWorkPermission");
		createTextField(form, "electricCerticifate");
		createTextField(form, "fireStudyApproval");
		createTextField(form, "fireStudyModification");
		createTextField(form, "fireStudyCertificate");
		createTextField(form, "fireUpdate");
		createTextField(form, "envMPE");
		createTextField(form, "envUpdate");

		form.add(TextFieldUtils.createDatePickerField("envRenewal"));
		form.add(TextFieldUtils.createDatePickerField("fireRenewal"));
		add(form);

		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				decisionData.save((Decision) form2.getModelObject());
				info("Οι αλλαγές έγιναν!");
				target.add(getFeedbackPanel());
			}

			@Override
			protected void onError(final AjaxRequestTarget target,
					final Form<?> form) {
				target.add(getFeedbackPanel());
			}

		});
		add(form);

	}

	private void createTextField(final Form<Decision> form,
			final String expression) {
		form.add(new TextField<String>(expression));
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractLeftMenu<?> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(LEFT_MENU,
				(IModel<LegalEntity>) getDefaultModel());
	}
}
