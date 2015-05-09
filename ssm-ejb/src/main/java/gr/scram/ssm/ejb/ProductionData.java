package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Production;

import javax.ejb.Local;

@Local
public interface ProductionData extends GenericData<Production,Long> {

	Production findByLegalId(Long id);
	
}
