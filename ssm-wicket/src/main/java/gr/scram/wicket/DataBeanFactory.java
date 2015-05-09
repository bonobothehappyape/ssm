/**
 * 
 */
package gr.scram.wicket;

import gr.scram.ssm.ejb.core.BeanFactory;
import gr.scram.ssm.ejb.core.GenericData;
import gr.scram.ssm.model.core.impl.AbstractJPAEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bonobo
 * 
 */
@ApplicationScoped
public class DataBeanFactory implements BeanFactory {

	/**
	 * Constructor
	 */
	public DataBeanFactory() {
		super();
	}

	private static final Logger LOG = LoggerFactory
			.getLogger(DataBeanFactory.class);

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractJPAEntity> GenericData<T, Long> createProvider(
			final Class<T> clazz) {
		GenericData<T, Long> provider = null;
		try {
			final InitialContext ic = new InitialContext();
			provider = (GenericData<T, Long>) ic.lookup("java:module/"
					.concat(clazz.getSimpleName().concat("DataBean")));
		} catch (final NamingException e) {
			LOG.error(e.getMessage(), e);
		} catch (final Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return provider;
	}

}
