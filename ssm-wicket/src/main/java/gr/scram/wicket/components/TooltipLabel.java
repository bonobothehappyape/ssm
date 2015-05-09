package gr.scram.wicket.components;

import gr.scram.wicket.img.ImageProvider;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.SharedResourceReference;

/**
 * Tooltip label.
 * @author asvesdi
 *
 */
public class TooltipLabel extends Panel {
	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * String model value.
	 */
	private IModel<?> model;
	
	/**
	 * String model tooltip.
	 */
	private IModel<String> tooltip;

	/**
	 * Constructor.
	 * @param id mark-up for the label.
	 * @param model model model for the label value
	 * @param tooltip the tool-tip text model.
	 */
	public TooltipLabel(final String id,final IModel<?> model, final IModel<String> tooltip) {
		super(id, model);
		this.model = model;
		this.tooltip = tooltip;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("label", model));
		AjaxLink<Void> tooltipLink = new AjaxLink<Void>("tooltip") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {

			}
			
			@Override
			public boolean isEnabled() {
				return false;
			}
			
		};
		tooltipLink.add(AttributeModifier.replace("data-original-title", model));
		tooltipLink.add(AttributeModifier.replace("data-content", tooltip));
		final Image image = new Image("img", new SharedResourceReference(
				ImageProvider.class, "help.png"));
		tooltipLink.add(image);
		add(tooltipLink);
	}

	
	/**
	 * Constructor.
	 * @param id markup
	 * @param tooltip the tooltip model to show.
	 */
	public TooltipLabel(final String id,final IModel<String> tooltip) {
		super(id);
	}
}
