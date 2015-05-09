/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.MunicipalityData;
import gr.scram.ssm.model.Municipality;

import javax.inject.Inject;

import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author bonobo
 * 
 */
public class AddMunicipalityPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	protected MunicipalityData data;
	private Form<Municipality> form;
	private PageReference pageRef;
	private ModalWindow modal;

	/**
	 * @param model
	 */
	public AddMunicipalityPage(final IModel<Municipality> model,
			final PageReference pageReference, final ModalWindow modal) {
		super(model);
		this.pageRef = pageReference;
		this.modal = modal;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		if (getDefaultModel() == null || getDefaultModel().getObject() == null) {
			setDefaultModel(new Model<Municipality>(new Municipality()));
		}
		@SuppressWarnings("unchecked")
		final IModel<Municipality> cModel = new CompoundPropertyModel<Municipality>(
				(IModel<Municipality>) getDefaultModel());
		form = new Form<Municipality>("form", cModel);
		form.add(new TextField<String>("name"));
		form.add(new TextField<String>("code"));

		form.add(new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form) {
				data.save((Municipality) form.getModelObject());
				if (pageRef != null)
					((MunicipalitiesPage) pageRef.getPage()).setChanged(Boolean.TRUE);
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
					((MunicipalitiesPage) pageRef.getPage()).setChanged(Boolean.FALSE);
				modal.close(target);

			}
		});
		add(form);
	}

}