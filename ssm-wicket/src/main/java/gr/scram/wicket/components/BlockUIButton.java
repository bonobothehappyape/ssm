package gr.scram.wicket.components;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;


/**
 * Simple blocking UI button.
 * @author asvesdi
 *
 */
public class BlockUIButton extends Button implements IHeaderContributor {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id mark-up
	 * @param model model
	 */
	public BlockUIButton (final String id,final IModel<String> model) {
		super(id, model);
	}

	/**
	 * Constructor.
	 * @param id mark-up
	 */
	public BlockUIButton (String id) {
		super(id);
	}


	@Override
	protected String getOnClickScript () {
		CharSequence orig = super.getOnClickScript();
		orig = orig == null ? "" : orig;
		return String.format("%s%s", BlockUICallDecorator.BLOCK_SCRIPT, orig);
	}

}
