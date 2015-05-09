/**
 * 
 */
package gr.scram.wicket.pages;

import gr.scram.ssm.ejb.MunicipalityData;
import gr.scram.ssm.model.Municipality;
import gr.scram.wicket.components.AbstractEditDeleteColumnPanel;
import gr.scram.wicket.components.EntityModel;
import gr.scram.wicket.utils.TableUtils;

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
public class MunicipalitiesPage extends WebPageESSSimple {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	protected MunicipalityData data;

	private boolean changed;

	private AjaxFallbackDefaultDataTable<Municipality, String> table;

	private ModalWindow modal1;

	/**
	 * 
	 */
	public MunicipalitiesPage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", new ResourceModel("page-title")));

		final IColumn<Municipality, String> action = new AbstractColumn<Municipality, String>(
				new ResourceModel("actions")) {
			/**
			 * 
			 **/
			private static final long serialVersionUID = 1L;

			@Override
			public void populateItem(
					final Item<ICellPopulator<Municipality>> cellItem,
					final String componentId,
					final IModel<Municipality> rowModel) {

				final AbstractEditDeleteColumnPanel<Municipality> panel = new AbstractEditDeleteColumnPanel<Municipality>(
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
						final EntityModel<Municipality, Long> entityModel = new EntityModel<Municipality, Long>(
								Municipality.class, rowModel.getObject());
						modal1.setPageCreator(pageCreator(entityModel, modal1));
						modal1.setInitialHeight(40);
						modal1.setInitialWidth(50);
						modal1.show(target);
					}
				};
				cellItem.add(panel);
			}
		};

		table = TableUtils.createAjaxDataTable("municipalities-table",
				Municipality.class, null, new String[] { "id" }, action);
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
		AjaxLink<String> ajaxLink = new AjaxLink<String>("add-municipality") {
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

	private PageCreator pageCreator(final IModel<Municipality> rowModel,
			final ModalWindow modalLoc) {
		return new ModalWindow.PageCreator() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Page createPage() {
				return new AddMunicipalityPage(rowModel,
						MunicipalitiesPage.this.getPageReference(), modalLoc);
			}
		};
	}

	/**
	 * @return the changed
	 */
	public boolean isChanged() {
		return changed;
	}

	/**
	 * @param changed
	 *            the changed to set
	 */
	public void setChanged(boolean changed) {
		this.changed = changed;
	}

}
