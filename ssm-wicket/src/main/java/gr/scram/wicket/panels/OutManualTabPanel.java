/**
 * 
 */
package gr.scram.wicket.panels;

import gr.scram.ssm.model.ProcedureManualOut;
import gr.scram.wicket.components.EntityModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author asvesdi
 * 
 */
public class OutManualTabPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param entityModel
	 */
	public OutManualTabPanel(final String id,
			final EntityModel<ProcedureManualOut, Long> entityModel) {
		super(id, entityModel);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		@SuppressWarnings("unchecked")
		final CompoundPropertyModel<ProcedureManualOut> cModel = new CompoundPropertyModel<ProcedureManualOut>(
				(IModel<ProcedureManualOut>) getDefaultModel());

		final Form<ProcedureManualOut> form = new Form<ProcedureManualOut>("form",
				cModel);

		form.add(new TextField<String>("procedureManualEmbedded.landUsage"));
		form.add(new CheckBox("procedureManualEmbedded.landUsageCheck"));

		form.add(new TextField<String>("procedureManualEmbedded.autopsyTopographic"));
		form.add(new CheckBox("procedureManualEmbedded.autopsyTopographicCheck"));

		form.add(new TextField<String>("procedureManualEmbedded.signDeclaration"));
		form.add(new CheckBox("procedureManualEmbedded.signDeclarationCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.suitability"));
		form.add(new CheckBox("procedureManualEmbedded.suitabilityCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.landUsageReceipt"));
		form.add(new CheckBox("procedureManualEmbedded.landUsageReceiptCheck"));

		form.add(new TextField<String>("procedureManualEmbedded.studies"));
		form.add(new CheckBox("procedureManualEmbedded.studiesCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.suitabilityApplication"));
		form.add(new CheckBox("procedureManualEmbedded.suitabilityApplicationCheck"));

		form.add(new TextField<String>("procedureManualEmbedded.suitabilityAutopsy"));
		form.add(new CheckBox("procedureManualEmbedded.suitabilityAutopsyCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.suitabilityDecision"));
		form.add(new CheckBox("procedureManualEmbedded.suitabilityDecisionCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.circulationDeposit"));
		form.add(new CheckBox("procedureManualEmbedded.circulationDepositCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.circulationAutopsy"));
		form.add(new CheckBox("procedureManualEmbedded.circulationAutopsyCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.circulationDecision"));
		form.add(new CheckBox("procedureManualEmbedded.circulationDecisionCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.circulation2Deposit"));
		form.add(new CheckBox("procedureManualEmbedded.circulation2DepositCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.circulation2Decision"));
		form.add(new CheckBox("procedureManualEmbedded.circulation2DecisionCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.establishLicence"));
		form.add(new CheckBox("procedureManualEmbedded.establishLicenceCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.establishLicenceDeposit"));
		form.add(new CheckBox("procedureManualEmbedded.establishLicenceDepositCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.mpeDeposit"));
		form.add(new CheckBox("procedureManualEmbedded.mpeDepositCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.mpeDecision"));
		form.add(new CheckBox("procedureManualEmbedded.mpeDecisionCheck"));
		
		form.add(new TextField<String>("procedureManualEmbedded.tax"));
		form.add(new CheckBox("procedureManualEmbedded.taxCheck"));
		
		final AjaxButton save = new AjaxButton("closeOK", form) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(final AjaxRequestTarget target,
					final Form<?> form2) {
				info("test");
			}

		};
		form.add(save);

		this.add(form);
	}

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(OutManualTabPanel.class);
}
