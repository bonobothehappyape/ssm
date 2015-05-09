package gr.scram.wicket.components;

import org.apache.wicket.Component;


/**
 * Call decorator to block/unblock page on ajax requests.<br />
 * The jQuery core library has to be added manually.<br />
 * The jQuery block ui library is automatically added. <br />
 * Pages using this component have to declare the functions:<br>
 * <ul>
 * <li><b>blockPage():</b> blocks the page.</li>
 * <li><b>unBlockPage():</b> unblocks the page</li>
 * </ul>
 * @author asvesdi.
 */
public class BlockUICallDecorator  {

	/**
	 * Java script file reference.
	 */
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	private static final String SCRIPT_FORMAT = "%s%s";

	/**
	 * The function that blocks the page.
	 */
	public static final String BLOCK_SCRIPT = "blockPage();";

	/**
	 * The function that removes the block.
	 */
	public static final String UNBLOCK_SCRIPT = "unBlockPage();";

	/**
	 * {@inheritDoc}
	 */
	public CharSequence decorateOnFailureScript(CharSequence script) {
		return UNBLOCK_SCRIPT;
	}

	/**
	 * {@inheritDoc}
	 */
	public CharSequence decorateScript(Component component, CharSequence script) {
		return String.format(SCRIPT_FORMAT, BLOCK_SCRIPT, script);
	}

	/**
	 * {@inheritDoc}
	 */
	public CharSequence decorateOnSuccessScript(Component component,
			CharSequence script) {
		return UNBLOCK_SCRIPT;
	}

	/**
	 * {@inheritDoc}
	 */
	public CharSequence decorateOnFailureScript(Component component,
			CharSequence script) {
		return UNBLOCK_SCRIPT;
	}
}
