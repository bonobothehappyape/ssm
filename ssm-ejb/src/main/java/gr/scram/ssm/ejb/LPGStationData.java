package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.LPGStation;

import javax.ejb.Local;

@Local
public interface LPGStationData extends GenericData<LPGStation,Long> {

	LPGStation findByLegalId(Long id);
	
}
