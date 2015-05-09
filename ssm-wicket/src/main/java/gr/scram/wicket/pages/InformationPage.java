/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.LegalEntityData;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.ssm.model.Municipality;
import gr.scram.wicket.menu.left.AbstractLeftMenu;
import gr.scram.wicket.menu.left.LegalEntityLeftMenuPanel;
import gr.scram.wicket.utils.DropDownChoiceUtils;

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
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author asvesdi
 * 
 */
public class InformationPage extends WebPageESSMenuLeft {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LegalEntityData leData;

	private CompoundPropertyModel<LegalEntity> cModel;

	public InformationPage(final IModel<LegalEntity> model) {
		super(model);
	}
	
	public InformationPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InformationPage(PageParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void onInitialize() {
		super.onInitialize();
		cModel = new CompoundPropertyModel<LegalEntity>(
				(IModel<LegalEntity>) getDefaultModel());
		final Form<LegalEntity> form = new Form<LegalEntity>("form", cModel);
		form.add(new Label("page-title", new ResourceModel("page-title")));
		
		form.add(new TextField<String>("name"));

		form.add(new TextField<String>("addressInfo.addressStreet"));
		form.add(new TextField<String>("addressInfo.addressNo"));
		form.add(new TextField<String>("addressInfo.poCode"));

		DropDownChoice<Municipality> muni = DropDownChoiceUtils
				.createManagedDropDownChoice("addressInfo.municipality",
						Municipality.class, "name");
		form.add(muni);

		form.add(new TextField<String>("contactInfo.email"));
		form.add(new TextField<String>("contactInfo.tel1"));
		form.add(new TextField<String>("contactInfo.tel2"));
		form.add(new TextField<String>("contactInfo.fax"));
		form.add(new TextField<String>("contactInfo.url"));

		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				leData.save((LegalEntity) form2.getModelObject());
				info("Οι αλλαγές σώθηκαν!");
				target.add(getFeedbackPanel());
			}

		});
		add(form);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractLeftMenu<?> getLeftMenu() {
		return new LegalEntityLeftMenuPanel<LegalEntity>(LEFT_MENU,
				(IModel<LegalEntity>) getDefaultModel());
	}

}
