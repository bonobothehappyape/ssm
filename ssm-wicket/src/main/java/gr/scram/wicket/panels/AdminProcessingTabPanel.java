/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.ejb.AdminProcessingData;
import gr.scram.ssm.ejb.AppealData;
import gr.scram.ssm.model.AdminProcessing;
import gr.scram.ssm.model.Appeal;
import gr.scram.wicket.components.AbstractDeleteColumnPanel;
import gr.scram.wicket.pages.AddAppealPage;
import gr.scram.wicket.utils.TableUtils;
import gr.scram.wicket.utils.TextFieldUtils;

import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

/**
 * @author asvesdi
 * 
 */
public class AdminProcessingTabPanel extends Panel {

	@Inject
	private AdminProcessingData data;

	@Inject
	private AppealData appealData;

	private AjaxFallbackDefaultDataTable<Appeal, String> table;

	private ModalWindow modal1;

	private ComponentFeedbackPanel cFeedbackPanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param model
	 */
	public AdminProcessingTabPanel(final String id,
			final IModel<AdminProcessing> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<AdminProcessing> cModel = new CompoundPropertyModel<AdminProcessing>(
				(IModel<AdminProcessing>) getDefaultModel());

		final Form<AdminProcessing> form = new Form<AdminProcessing>("form",
				cModel);
		cFeedbackPanel = new ComponentFeedbackPanel(
				"cFeedback", this);
		cFeedbackPanel.setOutputMarkupId(true);
		add(cFeedbackPanel);

		form.add(new TextField<String>("permitRecall"));
		TextFieldUtils.addDateField("permitDate", form);
		form.add(new TextField<String>("recallGov"));

		form.add(new TextField<String>("sealInstallation"));
		form.add(new TextField<String>("sealGov"));
		TextFieldUtils.addDateField("sealDate", form);

		final Map<String, Object> filters = Maps.newHashMap();
		final IColumn<Appeal, String> actionColumn = new AbstractColumn<Appeal, String>(
				new Model<String>("Επιλογές")) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void populateItem(
					final Item<ICellPopulator<Appeal>> cellItem,
					final String componentId, final IModel<Appeal> rowModel) {
				cellItem.add(new AbstractDeleteColumnPanel<Appeal>(
						componentId) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onDeleteClicked(final AjaxRequestTarget target) {
						appealData.delete(rowModel.getObject().getId());
						target.add(table);
					}

				});
			}
		};
		table = TableUtils.createAjaxDataTable("appeals", Appeal.class,
				filters, new String[] { "id" }, actionColumn);
		add(table);

		modal1 = new ModalWindow("modal1");
		modal1.setCookieName("modal-1");

		final WindowClosedCallback callback = new WindowClosedCallback() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClose(final AjaxRequestTarget target) {
				target.add(table);
			}
		};
		modal1.setWindowClosedCallback(callback);
		modal1.setPageCreator(pageCreator(null, modal1));
		add(modal1);

		add(new AjaxLink<String>("add-appeal") {

			@Override
			public void onClick(final AjaxRequestTarget target) {
				modal1.show(target);
			}

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		});

		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				data.save((AdminProcessing) form2.getModelObject());
				info("test");
				target.add(cFeedbackPanel);
			}

		};

		form.add(save);

		add(form);
	}

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(AdminProcessingTabPanel.class);

	private PageCreator pageCreator(final IModel<Appeal> rowModel,
			final ModalWindow modalLoc) {
		return new ModalWindow.PageCreator() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public Page createPage() {
				return new AddAppealPage(rowModel,
						(IModel<AdminProcessing>) AdminProcessingTabPanel.this
								.getDefaultModel(),
						AdminProcessingTabPanel.this.getPage()
								.getPageReference(), modalLoc);
			}
		};
	}
}
