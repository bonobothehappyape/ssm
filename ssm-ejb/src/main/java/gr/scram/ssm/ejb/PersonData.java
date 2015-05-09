package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Person;

import javax.ejb.Local;

@Local
public interface PersonData extends GenericData<Person,Long> {
	
}
