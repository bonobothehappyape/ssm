package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.ProcedureManualOut;

import javax.ejb.Local;

@Local
public interface ProcedureManualOutData extends
		GenericData<ProcedureManualOut, Long> {

	ProcedureManualOut findByLegalId(Long id);

}
