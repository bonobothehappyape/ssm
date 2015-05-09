package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.EnvironmentProcessing;

import javax.ejb.Local;

@Local
public interface EnvironmentProcessingData extends GenericData<EnvironmentProcessing,Long> {

	EnvironmentProcessing findByLegalId(Long id);
	
}
