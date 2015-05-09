package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.MinistryProcessing;

import javax.ejb.Local;

@Local
public interface MinistryProcessingData extends GenericData<MinistryProcessing,Long> {

	MinistryProcessing findByLegalId(Long legaId);
	
}
