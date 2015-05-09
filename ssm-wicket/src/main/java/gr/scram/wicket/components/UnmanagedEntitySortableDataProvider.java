package gr.scram.wicket.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Data provider for a sortable table. Handles unmanaged entities/pojos. Used
 * for views and native SQL results.
 * 
 * @author asvesdi
 * @param <T>
 *            - The POJO.
 */
public class UnmanagedEntitySortableDataProvider<T extends Serializable>
		extends	SortableDataProvider<T,String> {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Rows of the table.
	 */
	private List<T> rows;

	/**
	 * Rows of the table.
	 */
	private final Class<T> clazz;
	
	/**
	 * default property.
	 */
	private final String defaultProperty;

	/**
	 * Creates a new SortableDataProvider object.
	 * @param rows Rows of the table.
	 * @param clazz Type of objects in the table.
	 * @param defaultProperty Default sorting property.
	 */
	public UnmanagedEntitySortableDataProvider(List<T> rows, Class<T> clazz,
			String defaultProperty) {
		this.defaultProperty = defaultProperty;
		this.rows = new ArrayList<T>(rows);
		if (this.defaultProperty != null) {
			Comparator<T> comparator = new PropertyBasedComparator<T>(clazz,
					this.defaultProperty);
			Collections.sort(this.rows, comparator);
		}
		this.clazz = clazz;
	}

	/**
	 * Gets the rows of the table.
	 * 
	 * @return Returns a list containing the rows of the table.
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * Sets the rows.
	 * @param rows - the object list.
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long size() {
		return getRows().size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IModel<T> model(T t) {
		return new Model<T>(t);
	}
	

	/**
	 * @return the clazz.
	 */
	public Class<T> getClazz() {
		return clazz;
	}

	@Override
	public Iterator<? extends T> iterator(long first, long count) {
		final SortParam<String> sortParam = getSort();
		if (sortParam != null) {
			String property = sortParam.getProperty();
			Comparator<T> comparator = new PropertyBasedComparator<T>(clazz,
					property);
			if (sortParam.isAscending()) {
				comparator = new InvertedComparator<T>(comparator);
			}
			Collections.sort(getRows(), comparator);
		}
		return getRows().subList( (int) first,(int) (first + count)).iterator(); //TODO change this cast 
	}
}
