/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.PersonData;
import gr.scram.ssm.model.Person;
import gr.scram.wicket.components.AbstractEditDeleteColumnPanel;
import gr.scram.wicket.components.EntityDataProvider;
import gr.scram.wicket.components.EntityModel;
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

/**
 * @author bonobo
 * 
 */
public class PersonsPage extends WebPageESSSimple {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	protected PersonData data;

	private AjaxFallbackDefaultDataTable<Person, String> table;

	private boolean changed;

	private ModalWindow modal1;

	private AjaxLink<String> ajaxLink;

	/**
	 * 
	 */
	public PersonsPage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Label("page-title", new ResourceModel("page-title")));
		final IColumn<Person, String> action = new AbstractColumn<Person, String>(
				new ResourceModel("actions")) {
			/**
			 * 
			 **/
			private static final long serialVersionUID = 1L;

			@Override
			public void populateItem(
					final Item<ICellPopulator<Person>> cellItem,
					final String componentId, final IModel<Person> rowModel) {

				final AbstractEditDeleteColumnPanel<Person> panel = new AbstractEditDeleteColumnPanel<Person>(
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
						final EntityModel<Person, Long> edit = new EntityModel<Person, Long>(
								Person.class, rowModel.getObject().getId());
						modal1.setPageCreator(pageCreator(edit, modal1));
						modal1.show(target);
						
					}
				};
				cellItem.add(panel);
			}
		};

		final List<IColumn<Person, String>> cols = ColumnUtils
				.createPropertyColumns(new String[] { "name",
						"surname", "addressInfo.addressStreet",
						"addressInfo.addressNo",
						"addressInfo.municipality.name",
						"contactInfo.tel1",
						"contactInfo.email"

				}, new String[] { "'Ονομα", "Επώνυμο", "Οδός", "Αριθμός",
						"Δήμος", "Τηλέφωνο", "e-mail"

				});

		cols.add(cols.size(), action);

		final EntityDataProvider<Person> provider = new EntityDataProvider<Person>(
				Person.class, "name", null);

		table = new AjaxFallbackDefaultDataTable<Person, String>(
				"persons-table", cols, provider, 10);
		add(table);

		final WindowClosedCallback callback = new ModalWindow.WindowClosedCallback() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClose(final AjaxRequestTarget target) {
				if (isChanged()) {
					target.add(table);
				}
			}
		};

		modal1 = new ModalWindow("modal1");
		modal1.setCookieName("modal-1");
		modal1.setWindowClosedCallback(callback);
		add(modal1);

		addButton();
	}

	private void addButton() {
		ajaxLink = new AjaxLink<String>("add-person") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target) {
				modal1.setPageCreator(pageCreator(null, modal1));
				modal1.setInitialHeight(40);
				modal1.setInitialWidth(50);
				modal1.show(target);
			}

		};
		add(ajaxLink);
	}

	private PageCreator pageCreator(final IModel<Person> rowModel,
			final ModalWindow modalLoc) {
		return new ModalWindow.PageCreator() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Page createPage() {
				return new AddPersonPage(rowModel,
						PersonsPage.this.getPageReference(), modalLoc);
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
