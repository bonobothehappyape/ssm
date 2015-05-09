package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.GasStation;

import javax.ejb.Local;

@Local
public interface GasStationData extends GenericData<GasStation,Long> {

	GasStation findByLegalId(Long id);
	
}
