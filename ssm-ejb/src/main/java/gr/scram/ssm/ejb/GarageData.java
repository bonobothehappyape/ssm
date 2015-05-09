package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Garage;

import javax.ejb.Local;

@Local
public interface GarageData extends GenericData<Garage,Long> {

	Garage findByLegalId(Long id);
	
}
