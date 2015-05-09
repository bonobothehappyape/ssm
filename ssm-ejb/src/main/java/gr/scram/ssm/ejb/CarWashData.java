package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.CarWash;

import javax.ejb.Local;

@Local
public interface CarWashData extends GenericData<CarWash,Long> {

	CarWash findByLegalId(Long id);
	
}
