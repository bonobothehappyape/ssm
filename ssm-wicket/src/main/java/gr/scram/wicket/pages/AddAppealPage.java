/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.AppealData;
import gr.scram.ssm.model.AdminProcessing;
import gr.scram.ssm.model.Appeal;
import gr.scram.ssm.model.Person;
import gr.scram.wicket.utils.DropDownChoiceUtils;

import javax.inject.Inject;

import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author asvesdi
 * 
 */
public class AddAppealPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AppealData data;

	private final ModalWindow modal;

	private IModel<Appeal> model;

	private IModel<AdminProcessing> adminModel;

	/**
	 * @param modal
	 * @param pageReference
	 * 
	 */
	public AddAppealPage(final IModel<Appeal> appModel,
			final IModel<AdminProcessing> adminModel,
			final PageReference pageReference, 
			final ModalWindow modal) {
		super();
		this.modal = modal;
		this.adminModel = adminModel;
		this.model = appModel;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		if (model == null) {
			model = new Model<Appeal>(new Appeal());
		}
		final IModel<Appeal> cModel = new CompoundPropertyModel<Appeal>(model);
		final Form<Appeal> form = new Form<Appeal>("app-form", cModel);
		form.add(new TextField<String>("prefects"));
		form.add(new TextField<String>("stateCouncil"));
		form.add(new TextArea<String>("comments"));

		final DropDownChoice<Person> lawyer = DropDownChoiceUtils
				.createManagedDropDownChoice("lawyer", Person.class, "surname");
		form.add(lawyer);

		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				Appeal appeal = (Appeal) form2.getModelObject();
				if (appeal.getAdminProcessing() == null)
					appeal.setAdminProcessing(getAdminModel().getObject());
				data.save(appeal);
				modal.close(target);
			}

		});

		form.add(new AjaxLink<Void>("closeCancel") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
//				if (pageRef != null)
//					((HomePage) pageRef.getPage()).setChanged(Boolean.FALSE);
				modal.close(target);

			}
		});
		add(form);
	}

	/**
	 * @return the adminModel
	 */
	public IModel<AdminProcessing> getAdminModel() {
		return adminModel;
	}

	/**
	 * @param adminModel
	 *            the adminModel to set
	 */
	public void setAdminModel(final IModel<AdminProcessing> adminModel) {
		this.adminModel = adminModel;
	}

}
