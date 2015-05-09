package gr.scram.ssm.ejb.core;

import javax.ejb.Local;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

@Local
public interface BeanFactory {
	<T extends AbstractJPAEntity> GenericData<T, Long> createProvider(
			Class<T> clazz);
}
