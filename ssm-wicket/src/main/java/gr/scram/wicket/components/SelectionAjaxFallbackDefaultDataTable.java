/**
 * 
 */
package gr.scram.wicket.components;

import java.util.List;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * @author asvesdi
 * 
 */
public abstract class SelectionAjaxFallbackDefaultDataTable<S, T> extends
		AjaxFallbackDefaultDataTable<S, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String event;

	public SelectionAjaxFallbackDefaultDataTable(final String id,
			final List<? extends IColumn<S, T>> columns,
			final ISortableDataProvider<S, T> dataProvider,
			final int rowsPerPage, final String jScriptEvent) {
		super(id, columns, dataProvider, rowsPerPage);
		this.event = "onclick";
	}

	@Override
	protected Item<S> newRowItem(final String id, final int index, final IModel<S> rowModel) {
		final Item<S> item = new Item<S>(id, index, rowModel);
		final AjaxEventBehavior behavior = new AjaxEventBehavior(getEvent()) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onEvent(final AjaxRequestTarget target) {
				SelectionAjaxFallbackDefaultDataTable.this.onEvent(target, rowModel);

			}
		};
		item.add(behavior);
		return item;
	}

	public abstract void onEvent(AjaxRequestTarget target, IModel<S> rowModel);

	public String getEvent() {
		return event;
	}

	public void setEvent(final String event) {
		this.event = event;
	}
}
