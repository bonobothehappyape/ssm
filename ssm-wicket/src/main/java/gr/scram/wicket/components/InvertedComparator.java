package gr.scram.wicket.components;

import java.util.Comparator;

/**
 * This comparator is an wrapper around another comparator,
 * inverting its comparison result.
 * 
 * The real comparator is passed as an argument to the constructor
 * of this comparator. This comparator will use the specified real
 * comparator for comparison, but this comparator will always return
 * the opposite result that the initial comparator. 
 * 
 * @param <T> Type of objects compared by this comparator. 
 * @author asvesdi
 */
public class InvertedComparator<T> implements Comparator<T> {
	
	/**
	 * Comparator.
	 */
	private Comparator<T> comparator;

	/**
	 * Creates a new InvertedComparator object. 
	 * @param comparator the comparator to invert.
	 */
	public InvertedComparator(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	/**
	 * {@inheritDoc}
	 */
	public int compare(T o1, T o2) {		
		return (-1) * comparator.compare(o1, o2);
	}

}