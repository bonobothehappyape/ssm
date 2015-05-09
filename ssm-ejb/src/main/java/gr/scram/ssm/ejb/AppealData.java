package gr.scram.ssm.ejb;

import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.Appeal;

import javax.ejb.Local;

@Local
public interface AppealData extends GenericData<Appeal, Long> {

	Appeal findByAdminProcessingId(Long id);

}
