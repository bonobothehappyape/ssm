package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Ministry;

import javax.ejb.Local;

@Local
public interface MinistryData extends GenericData<Ministry,Long> {
	
}
