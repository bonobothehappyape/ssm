package gr.scram.ssm.model.core;

import java.io.Serializable;

public interface Identifiable<PK extends Serializable> extends Serializable {

	public PK getId();
	
}
