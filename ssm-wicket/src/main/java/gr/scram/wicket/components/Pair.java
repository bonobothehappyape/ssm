package gr.scram.wicket.components;

import gr.scram.wicket.utils.Utils;


/**
 * Pair helpoer class to be used in generating link menus.
 * @author asvesdi
 * @param <L>
 * @param <R>
 */
public class Pair<L, R>  {
	
	/**
	 * creates a new pair from the first two elements of an array.
	 * 
	 * @param array Array.
	 * @param <T> Type of elements.
	 * 
	 * @return Returns a pair.
	 */
	public static <T> Pair<T, T> pair(T[] array) {
		return new Pair<T,T>(array[0],array[1]);
	}
	
	/**
	 * left object.
	 */
	private L left;
	
	/**
	 * right object.
	 */
	private R right;
	
	/**
	 * Creates a new Pair object. 
	 *
	 */
	public Pair() {
		super();		
	}

	/**
	 * Creates a new Pair object. 
	 * @param left left side
	 * @param right right side.
	 */
	public Pair(L left, R right) {
		this();
		this.left = left;
		this.right = right;
	}

	/**
	 * Gets the left.
	 *
	 * @return Returns the left
	 */
	public L getLeft() {
		return left;
	}

	/**
	 * Assigns a new value to the left.
	 *
	 * @param left the left to set
	 */
	public void setLeft(L left) {
		this.left = left;
	}

	/**
	 * Gets the right.
	 *
	 * @return Returns the right
	 */
	public R getRight() {
		return right;
	}

	/**
	 * Assigns a new value to the right.
	 *
	 * @param right the right to set
	 */
	public void setRight(R right) {
		this.right = right;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		if (obj instanceof Pair) {
			@SuppressWarnings("rawtypes") 
			Pair that = (Pair) obj;
			return Utils.equals(this.getLeft(), that.getLeft())
			    && Utils.equals(this.getRight(), that.getRight());
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {		
		Object[] fields = {left,right};
		return Utils.generateHashCode(fields);
	}
}
