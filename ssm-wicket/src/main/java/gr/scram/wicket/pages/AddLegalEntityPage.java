/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.LegalEntityData;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.wicket.HomePage;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author asvesdi
 * 
 */
public class AddLegalEntityPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LegalEntityData data;

	private final ModalWindow modal;

	private final PageReference pageRef;

	private IModel<LegalEntity> model;

	private Form<LegalEntity> form;

	/**
	 * @param modal
	 * @param pageReference
	 * 
	 */
	public AddLegalEntityPage(final IModel<LegalEntity> leModel,
			final PageReference pageReference, final ModalWindow modal) {
		super();
		this.modal = modal;
		this.pageRef = pageReference;
		this.model = leModel;
	}

	private static final Logger LOG = LoggerFactory
			.getLogger(AddLegalEntityPage.class);

	@Override
	protected void onInitialize() {
		super.onInitialize();

		if (model == null) {
			model = new Model<LegalEntity>(new LegalEntity());
		}
		final IModel<LegalEntity> cModel = new CompoundPropertyModel<LegalEntity>(
				model);
		form = new Form<LegalEntity>("le-form", cModel);
		form.add(new TextField<String>("name"));
		form.add(new TextField<String>("addressInfo.addressStreet"));
		form.add(new TextField<String>("addressInfo.addressNo"));
		form.add(new TextField<String>("addressInfo.poCode"));
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
			protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
				LOG.info("saving button");
				LOG.info(((LegalEntity) form.getModelObject()).getName());
				data.save((LegalEntity) form.getModelObject());
				if (pageRef != null)
					((HomePage) pageRef.getPage()).setChanged(Boolean.TRUE);
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
					((HomePage) pageRef.getPage()).setChanged(Boolean.FALSE);
				modal.close(target);

			}
		});
		add(form);
	}

}
