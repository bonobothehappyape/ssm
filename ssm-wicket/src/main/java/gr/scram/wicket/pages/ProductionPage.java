/**
 * 
 */
package gr.scram.wicket.pages;

import javax.inject.Inject;

import gr.scram.ssm.ejb.ProductionData;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.ssm.model.Person;
import gr.scram.ssm.model.Production;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.utils.DropDownChoiceUtils;
import gr.scram.wicket.utils.TextFieldUtils;

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
public class ProductionPage extends WebPageESSMenuLeft {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductionPage(final IModel<LegalEntity> model) {
		super(model);
	}

	@Inject
	private ProductionData prodData;

	@SuppressWarnings("unchecked")
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		final IModel<LegalEntity> defaultModel = (IModel<LegalEntity>) getDefaultModel();
		Production prod = prodData.findByLegalId(defaultModel.getObject()
				.getId());
		final CompoundPropertyModel<Production> cModel = new CompoundPropertyModel<Production>(
				prod);
		final Form<Production> form = new Form<Production>("form", cModel);
		form.add(new Label("page-title", new ResourceModel("page-title")));

		createTextField(form, "assignment");
		createTextField(form, "designCharge");
		createTextField(form, "techCharge");
		createTextField(form, "secretariatCharge");
		DropDownChoice<Person> designDesigner = DropDownChoiceUtils
				.createManagedDropDownChoice("designDesigner", Person.class,
						"surname");
		form.add(designDesigner);

		DropDownChoice<Person> techTechnician = DropDownChoiceUtils
				.createManagedDropDownChoice("techTechnician", Person.class,
						"surname");
		form.add(techTechnician);

		DropDownChoice<Person> secretariatTechnician = DropDownChoiceUtils
				.createManagedDropDownChoice("secretariatTechnician",
						Person.class, "surname");
		form.add(secretariatTechnician);

		TextFieldUtils.addDateField("secretariatDeadline", form);
		TextFieldUtils.addDateField("secretariatExec", form);

		TextFieldUtils.addDateField("autopsyDeadline", form);
		TextFieldUtils.addDateField("techDeadline", form);
		TextFieldUtils.addDateField("autopsyExec", form);
		TextFieldUtils.addDateField("techExec", form);
		TextFieldUtils.addDateField("designDeadline", form);
		TextFieldUtils.addDateField("designExec", form);
		add(form);

		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form) {
				LOG.info("saving button");
				prodData.save((Production) form.getModelObject());
				target.add(getFeedbackPanel());
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				target.add(getFeedbackPanel());
			}

		});
		add(form);

	}

	private void createTextField(final Form<Production> form,
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
