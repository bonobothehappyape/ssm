package gr.scram.wicket.components;

import java.util.Date;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;

/**
 * Tooltip label.
 * @author asvesdi
 *
 */
public class TooltipDateLabel extends DateLabel {

	/**
	 * Serialisation unique id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param id mark-up for the label.
	 * @param model model model for the label value.
	 * @param tooltip the tool-tip text model.
	 * @param datePattern the date pattern.
	 */
	public TooltipDateLabel(final String id, final IModel<Date> model,
			final String datePattern, final IModel<String> tooltip) {
		super(id, model, new PatternDateConverter(datePattern, true));
		add(AttributeModifier.replace("title", tooltip));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void renderHead(IHeaderResponse response) {
//		response.renderOnLoadJavaScript("$(function() {	$('.tooltip').tooltip();});"); //TODO
	}
}
