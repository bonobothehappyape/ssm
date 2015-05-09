package gr.scram.wicket.factories;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

/**
 * Interafce for wicket component factories.
 * 
 * @author asvesdi
 * 
 * @param <T> component type.
 * @param <K> model type.
 */
public interface IDataTableFactory<K extends Serializable, T extends DataTable<K, String>>
		extends Serializable, IFactory<K, T> {

	
	/**
	 * Create a simple table for a given persisted entity type.
	 * @param markup the markup id of the table
	 * @param enitityClass the entity type
	 * @param map filtering.
	 * @param excluded array of properties to exclude.
	 * @return the {@link DataTable} component 
	 */
	T createComponent(final String markup, final Class<K> enitityClass,
			final Map<String, Object> map, final List<String> excluded);

	/**
	 * Create a simple table for a given persisted entity type.
	 * @param markup markup the markup id of the table
	 * @param enitityClass the entity type
	 * @param map filtering.
	 * @param excludedList array of properties to exclude.
	 * @param editDelCallback callback for delete.
	 * @return the {@link DataTable} component 
	 */
	T createComponent(final String markup, final Class<K> enitityClass,
			final Map<String, Object> map, final List<String> excludedList,
			final IColumn<K, String> editDelCallback);

}
