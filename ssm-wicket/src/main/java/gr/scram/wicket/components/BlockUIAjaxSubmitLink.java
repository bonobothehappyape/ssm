package gr.scram.wicket.components;


import gr.scram.wicket.utils.WicketUtils;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.form.Form;


/**
 * AjaxSubmitLink decorated with the BlockUICallDecorator.
 * @see BlockUICallDecorator
 */
public abstract class BlockUIAjaxSubmitLink extends AjaxSubmitLink implements IHeaderContributor {

	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id markup.
	 * @param form form.
	 */
	public BlockUIAjaxSubmitLink (String id, Form<?> form) {
		super(id, form);
	}

	/**
	 * Constructor.
	 * @param id markup
	 */
	public BlockUIAjaxSubmitLink (String id) {
		super(id);
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	protected IAjaxCallDecorator getAjaxCallDecorator () {
//		return new BlockUICallDecorator();
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender () {
		WicketUtils.renderComponentClasses(this);
		super.onBeforeRender();
	}

}
