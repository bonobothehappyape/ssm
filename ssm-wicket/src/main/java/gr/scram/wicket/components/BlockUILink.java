package gr.scram.wicket.components;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

/**
 * Link blocking page when pressed. <br/>
 * The jQuery core library has to be added manually.<br />
 * The jQuery block ui library is automatically added. <br />
 * Pages using this component have to declare the functions:<br>
 * <li><b>blockPage():</b> blocks the page.</li>
 * @param <T>
 * @see BlockUICallDecorator
 */
public abstract class BlockUILink<T> extends Link<T>{
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id mark-up
	 * @param model model
	 */
	public BlockUILink (final String id,final IModel<T> model) {
		super(id, model);
	}

	/**
	 * Constructor.
	 * @param id mark-up
	 */
	public BlockUILink(final String id) {
		super(id);
	}

	@Override
	protected CharSequence getOnClickScript (final CharSequence url) {
		CharSequence orig = super.getOnClickScript(url);
		orig = orig == null ? "" : orig;
		return String.format("%s%s", BlockUICallDecorator.BLOCK_SCRIPT, orig);
	}

}