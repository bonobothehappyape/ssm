package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.AdminProcessing;
import gr.scram.ssm.model.LegalEntity;

import javax.ejb.Local;

@Local
public interface AdminProcessingData extends GenericData<AdminProcessing,Long> {

	AdminProcessing findByLegalId(LegalEntity le);

	AdminProcessing findByLegalId(Long legalId);

	
}
