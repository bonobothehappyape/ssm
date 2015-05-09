package gr.scram.wicket.utils;

/**
 * String formats used.
 * @author asvesdi
 *
 */
public enum Format {
	
	/**
	 * Number format used for labels.
	 */
	FinancialFormat("###,###,###,###,##0.00"),
	
	/**
	 * Date format used for date text fields DatePiker.
	 */
	DateFormatJS("dd/mm/yy"),
	
	/**
	 * Date format used for date text fields DateTextField.
	 */
	DateFormat("dd/MM/yyyy");
	
	/**
	 * Format string.
	 */
	private String format;

	/**
	 * Private constructor.
	 * @param format the format to use.
	 */
	private Format(final String format) {
		this.format = format;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
}
