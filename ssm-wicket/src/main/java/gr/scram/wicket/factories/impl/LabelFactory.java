package gr.scram.wicket.factories.impl;

import gr.scram.wicket.components.CurrencyLabel;
import gr.scram.wicket.components.TooltipLabel;
import gr.scram.wicket.factories.IFactory;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 * 
 * @author asvesdi
 */
public final class LabelFactory implements IFactory<String, Label> {
	
	/**
	 * Tooltip resource propperty suffix.
	 */
	private static final String TOOLTIP = "-tooltip";

	/**
	 * suffix constant for label properties.
	 */
	private static final String LABEL = "-label";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Create a new {@link TooltipLabel} instance.
	 * @param key the key value
	 * @return a {@link TooltipLabel} instance.
	 */
	public TooltipLabel createTooltipLabel(final String key){
		return new TooltipLabel(key.concat(LabelFactory.LABEL),
					new ResourceModel(key.concat(LabelFactory.LABEL)),
					new ResourceModel(key.concat(LabelFactory.TOOLTIP)));
		
	}
	
	/**
	 * Create a new {@link TooltipLabel} instance.
	 * @param key the key value
	 * @param model model value
	 * @return a {@link TooltipLabel} instance.
	 */
	public TooltipLabel createTooltipPropertyLabel(final String key, final IModel<String> model){
		return new TooltipLabel(key.concat(LabelFactory.LABEL),model,
					new ResourceModel(key.concat(LabelFactory.TOOLTIP)));
		
	}
	
	/**
	 * Create a new {@link TooltipLabel} instance.
	 * @param key the key value
	 * @param modelVal model Value.
	 * @return a {@link TooltipLabel} instance.
	 */
	public TooltipLabel createTooltipPropertyLabel(final String key, final String modelVal){
		return new TooltipLabel(key.concat(LabelFactory.LABEL),new Model<String>(modelVal),
					new ResourceModel(key.concat(LabelFactory.TOOLTIP)));
		
	}
	
	
	/**
	 * Create a new {@link TooltipLabel} instance.
	 * @param key the key value
	 * @param modelVal model Value.
	 * @return a {@link TooltipLabel} instance.
	 */
	public CurrencyLabel createCurrencyLabel(final String key, final Number modelVal){
		return new CurrencyLabel(key,new Model<Number>(modelVal));
		
	}
	
	/**
	 * Create a simple {@link Label} component.
	 * @param markup the mark up id.
	 * @param model the {@link String} model.
	 * @return a {@link Label}.
	 */
	public Label createComponent(final String markup, final IModel<String> model) {
		return new Label(markup, model);
	}

}
