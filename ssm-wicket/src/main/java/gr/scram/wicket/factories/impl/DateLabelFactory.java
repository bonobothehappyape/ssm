package gr.scram.wicket.factories.impl;

import gr.scram.wicket.components.TooltipDateLabel;
import gr.scram.wicket.factories.IFactory;
import gr.scram.wicket.utils.Format;

import java.util.Date;

import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 * 
 * @author asvesdi
 */
public class DateLabelFactory implements IFactory<Date, Label> {

	/**
	 * Tooltip resource propperty suffix.
	 */
	private static final String TOOLTIP = "-tooltip";

	/**
	 * suffix constant for label properties.
	 */
	private static final String LABEL = "-label";

	/**
	 * Serialisation uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a date label.
	 * @param key markup
	 * @param date date
	 * @return the label.
	 */
	public DateLabel createComponent(final String key, Date date) {
		return new DateLabel(key, new Model<Date>(date),
				new PatternDateConverter(Format.DateFormat.getFormat(), true));

	}

	/**
	 * Create a tooltip date label.
	 * 
	 * @param key
	 *            key markup
	 * @param model
	 *            model data
	 * @return the label.
	 */
	public DateLabel createTooltipDateLabel(final String key,
			final IModel<Date> model) {
		return new TooltipDateLabel(key.concat(DateLabelFactory.LABEL), model,
				Format.DateFormat.getFormat(), new ResourceModel(
						key.concat(DateLabelFactory.TOOLTIP)));
	}

	/**
	 * {@inheritDoc}
	 */
	public DateLabel createComponent(String markup, IModel<Date> model) {
		return new DateLabel(markup, model, new PatternDateConverter(
				Format.DateFormat.getFormat(), true));

	}
}
