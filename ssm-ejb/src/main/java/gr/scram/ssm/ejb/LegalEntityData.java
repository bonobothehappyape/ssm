package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.LegalEntity;

import javax.ejb.Local;

@Local
public interface LegalEntityData extends GenericData<LegalEntity,Long> {
	
}
