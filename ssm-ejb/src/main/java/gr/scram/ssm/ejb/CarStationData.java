package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.CarStation;

import javax.ejb.Local;

@Local
public interface CarStationData extends GenericData<CarStation,Long> {

	CarStation findByLegalId(Long id);
	
}
