package gr.scram.wicket.components;

import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * Ajax button that enables UI blocking page.
 * @author asvesdi
 *
 */
public abstract class BlockUIAjaxButton extends AjaxButton implements IHeaderContributor {

	/**
	 * Serialisation version unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id - markup id.
	 * @param form - Form.
	 */
	public BlockUIAjaxButton (final String id,final Form<?> form) {
		super(id, form);
	}

	/**
	 * Constructor.
	 * @param id - markup id.
	 * @param model - model object.
	 * @param form - form.
	 */
	public BlockUIAjaxButton (final String id, final IModel<String> model,final Form<?> form) {
		super(id, model, form);
	}

	/**
	 * Constructor.
	 * @param id - markup id.
	 * @param model - model object.
	 */
	public BlockUIAjaxButton (final String id, final IModel<String> model) {
		super(id, model);
	}

	/**
	 * Constructor.
	 * @param id - markup id.
	 */
	public BlockUIAjaxButton (final String id) {
		super(id);
	}
	
//	@Override
//	public void renderHead(IHeaderResponse response) {
//		response.renderJavaScriptReference(BlockUICallDecorator.JQUERY_BLOCKUI_JS);
//	}
	
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	protected IAjaxCallDecorator getAjaxCallDecorator () {
//		return new BlockUICallDecorator();
//	}

}
