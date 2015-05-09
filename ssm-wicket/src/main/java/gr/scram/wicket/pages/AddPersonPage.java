/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.PersonData;
import gr.scram.ssm.model.Municipality;
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
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author bonobo
 * 
 */
public class AddPersonPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageReference pageRef;
	private ModalWindow modal;
	private Form<Person> form;

	@Inject
	protected PersonData data;

	/**
	 * @param model
	 */
	public AddPersonPage(final IModel<Person> model,
			final PageReference pageReference, final ModalWindow modal) {
		super(model);
		this.pageRef = pageReference;
		this.modal = modal;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		if (getDefaultModel() == null || getDefaultModel().getObject() == null) {
			setDefaultModel(new Model<Person>(new Person()));
		}
		@SuppressWarnings("unchecked")
		final IModel<Person> cModel = new CompoundPropertyModel<Person>(
				(IModel<Person>) getDefaultModel());
		form = new Form<Person>("form", cModel);
		form.add(new TextField<String>("name"));
		form.add(new TextField<String>("surname"));
		form.add(new TextField<String>("addressInfo.addressStreet"));
		form.add(new TextField<String>("addressInfo.addressNo"));
		form.add(new TextField<String>("addressInfo.poCode"));

		DropDownChoice<Municipality> dd = DropDownChoiceUtils
				.createManagedDropDownChoice("addressInfo.municipality",
						Municipality.class, "name");
		form.add(dd);
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
					final Form<?> form) {
				data.save((Person) form.getModelObject());
				if (pageRef != null)
					((PersonsPage) pageRef.getPage()).setChanged(Boolean.TRUE);
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
				if (pageRef != null)
					((PersonsPage) pageRef.getPage()).setChanged(Boolean.FALSE);
				modal.close(target);

			}
		});
		add(form);
	}

}
