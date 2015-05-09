package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.ProcedureManualIn;

import javax.ejb.Local;

@Local
public interface ProcedureManualInData extends GenericData<ProcedureManualIn,Long> {

	ProcedureManualIn findByLegalId(Long id);
	
}
