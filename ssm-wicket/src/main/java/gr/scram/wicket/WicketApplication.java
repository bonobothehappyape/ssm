package gr.scram.wicket;

import gr.scram.wicket.pages.AddAppealPage;
import gr.scram.wicket.pages.DecisionsPage;
import gr.scram.wicket.pages.DescriptionPage;
import gr.scram.wicket.pages.InformationPage;
import gr.scram.wicket.pages.MunicipalitiesPage;
import gr.scram.wicket.pages.PersonsPage;
import gr.scram.wicket.pages.ProcManualPage;
import gr.scram.wicket.pages.ProcessPage;
import gr.scram.wicket.pages.ProductionPage;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.cdi.ConversationPropagation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see gr.scram.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		// Enable CDI
		BeanManager bm;
		try {
			bm = (BeanManager) new InitialContext()
					.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			throw new IllegalStateException("Unable to obtain CDI BeanManager",
					e);
		}
		// Configure CDI, disabling Conversations as we aren't using them
		new CdiConfiguration(bm).setPropagation(ConversationPropagation.NONE)
				.configure(this);
		
		mountPage("legal-ent", HomePage.class);
		mountPage("persons", PersonsPage.class);
		mountPage("municipalities", MunicipalitiesPage.class);
		mountPage("legal-ent-info", InformationPage.class);
		mountPage("legal-ent-prod", ProductionPage.class);
		mountPage("legal-ent-process", ProcessPage.class);
		mountPage("legal-ent-decisions", DecisionsPage.class);
		mountPage("legal-ent-manual", ProcManualPage.class);
		mountPage("legal-ent-descr", DescriptionPage.class);
		mountPage("add-appeal", AddAppealPage.class);
	}
}
