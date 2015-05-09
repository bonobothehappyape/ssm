package gr.scram.wicket.components;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.model.IModel;

/**
 * 
 * @author asvesdi
 *
 * @param <T>
 */
public abstract class BlockUIAjaxLink<T> extends AjaxLink<T> implements IHeaderContributor {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id mark-up
	 * @param model model
	 */
	public BlockUIAjaxLink(String id, IModel<T> model) {
		super(id, model);
	}

	/**
	 * Constructor.
	 * @param id mark-up
	 */
	public BlockUIAjaxLink(String id) {
		super(id);
	}

//	@Override
//	protected IAjaxCallDecorator getAjaxCallDecorator() {
//		return new BlockUICallDecorator();
//	}
}
