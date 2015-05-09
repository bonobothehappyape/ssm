package gr.scram.wicket.components;

import java.text.DecimalFormat;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * @Title
 * <pre>
 * A currency label to format BigDecimals into the approved format.
 * </pre>
 * 
 * @Overview
 * <pre>
 * This is a label that will format an amount of money encoded in BigDecimal 
 * e.g. 1234567.45 to 1,234,567.45 € 
 * </pre>
 * 
 * @Usage
 * <pre>
 * ...
 * 	BigDecimal amount = ....
 * 	Model amountModel = new Model(amount);
 *	CurrencyLabel label = new CurrencyLabel("wicket-id", amountModel));
 *	add(label);
 * 	...
 * 
 * </pre>
 * 
 * @author arvange
 *
 */
public class CurrencyLabel extends Label {
	
	/**
	 * Serialisation id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Formatter.
	 */
	final private DecimalFormat formatter; 

	/**
	 * Cosntructor.
	 * @param markupId markup-id.
	 * @param model model object for number.
	 */
	public CurrencyLabel(final String markupId,final IModel<Number> model) {
		super(markupId, model);
		formatter = new DecimalFormat("###,###,###,###,##0.00");
	}

	@Override
	public void onComponentTagBody(final MarkupStream markupStream,
			final ComponentTag openTag) {
		String val = "";
		
		try {
			val = formatter.format(getDefaultModelObject()); 
		}catch(Exception e) {
			error("Not a number");
			val = "NaN";
		}
		replaceComponentTagBody(markupStream, openTag, val + " €"); 
	}
	
}
