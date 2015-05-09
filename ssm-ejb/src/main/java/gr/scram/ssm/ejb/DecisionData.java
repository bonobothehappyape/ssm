package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Decision;

import javax.ejb.Local;

@Local
public interface DecisionData extends GenericData<Decision,Long> {

	Decision findByLegalId(Long id);
	
}
