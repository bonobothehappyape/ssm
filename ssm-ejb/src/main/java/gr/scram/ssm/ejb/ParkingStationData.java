package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.ParkingStation;

import javax.ejb.Local;

@Local
public interface ParkingStationData extends GenericData<ParkingStation,Long> {
	
}
