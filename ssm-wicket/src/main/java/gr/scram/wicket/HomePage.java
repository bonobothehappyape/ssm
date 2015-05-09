package gr.scram.wicket;

import gr.scram.ssm.ejb.LegalEntityData;
import gr.scram.ssm.model.LegalEntity;
import gr.scram.wicket.components.AbstractEditDeleteColumnPanel;
import gr.scram.wicket.components.EntityDataProvider;
import gr.scram.wicket.components.EntityModel;
import gr.scram.wicket.pages.AddLegalEntityPage;
import gr.scram.wicket.pages.EditLegalEntityPage;
import gr.scram.wicket.pages.InformationPage;
import gr.scram.wicket.pages.WebPageESSSimple;
import gr.scram.wicket.utils.ColumnUtils;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPageESSSimple {
	private static final long serialVersionUID = 1L;

	private boolean changed;

	private AjaxFallbackDefaultDataTable<LegalEntity, String> table;

	private ModalWindow modal1;

	private AjaxLink<String> ajaxLink;

	@Inject
	private LegalEntityData data;

	public HomePage(final PageParameters parameters) {
		super(parameters);
	}

	public HomePage() {
		super();
	}

	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("home-page-title")));
		final WindowClosedCallback callback = new ModalWindow.WindowClosedCallback() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClose(final AjaxRequestTarget target) {
				LOG.info("on close: " + isChanged());
				if (isChanged()) {
					target.add(table);
				}
			}
		};

		modal1 = new ModalWindow("modal1");
		modal1.setCookieName("modal-1");
		modal1.setWindowClosedCallback(callback);
		modal1.setPageCreator(pageCreator(null, modal1));
		add(modal1);

		createTable();

		addButton();
	}

	private void addButton() {
		ajaxLink = new AjaxLink<String>("add-legal-entity") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				modal1.setInitialHeight(40);
				modal1.setInitialWidth(50);
				modal1.show(target);
			}

		};
		add(ajaxLink);
	}

	private void createTable() {

		final IColumn<LegalEntity, String> callback = new AbstractColumn<LegalEntity, String>(
				new ResourceModel("actions")) {
			/**
			 * 
			 **/
			private static final long serialVersionUID = 1L;

			@Override
			public void populateItem(
					final Item<ICellPopulator<LegalEntity>> cellItem,
					final String componentId, final IModel<LegalEntity> rowModel) {

				final AbstractEditDeleteColumnPanel<LegalEntity> panel = new AbstractEditDeleteColumnPanel<LegalEntity>(
						componentId) {

					/**
						 * 
						 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onDeleteClicked(final AjaxRequestTarget target) {
						data.delete(rowModel.getObject().getId());
						target.add(table);
					}

					@Override
					public void onEditClicked(final AjaxRequestTarget target) {
						final EntityModel<LegalEntity, Long> entityModel = new EntityModel<LegalEntity, Long>(
								LegalEntity.class, rowModel.getObject());
						setResponsePage(new InformationPage(entityModel));
					}
				};
				cellItem.add(panel);
			}
		};

		final List<IColumn<LegalEntity, String>> cols = ColumnUtils
				.createPropertyColumns(new String[] { "name",
						"personInCharge.surname", "addressInfo.addressStreet",
						"addressInfo.addressNo",
						"addressInfo.municipality.name",
						"personToCommunicate.surname", "contactInfo.tel1"

				}, new String[] { "Επωνυμία", "Υπεύθυνος", "Οδός", "Αριθμός",
						"Δήμος", "Επικοινωνία", "Τηλέφωνο"

				});

		cols.add(cols.size(), callback);

		final EntityDataProvider<LegalEntity> provider = new EntityDataProvider<LegalEntity>(
				LegalEntity.class, "name", null);

		table = new AjaxFallbackDefaultDataTable<LegalEntity, String>(
				"legal-entities-table", cols, provider, 10);
		add(table);
	}

	private PageCreator pageCreator(final IModel<LegalEntity> rowModel,
			final ModalWindow modalLoc) {
		return new ModalWindow.PageCreator() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Page createPage() {
				return new AddLegalEntityPage(rowModel,
						HomePage.this.getPageReference(), modalLoc);
			}
		};
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(final boolean changed) {
		this.changed = changed;
	}
}
