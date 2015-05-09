package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.FireProcessing;

import javax.ejb.Local;

@Local
public interface FireProcessingData extends GenericData<FireProcessing,Long> {

	FireProcessing findByLegalId(Long id);
	
}
