package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.ConnectionProcessing;

import javax.ejb.Local;

@Local
public interface ConnectionProcessingData extends GenericData<ConnectionProcessing,Long> {

	ConnectionProcessing findByLegalId(Long id);
	
}
