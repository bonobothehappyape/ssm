package gr.scram.wicket.panels;

import gr.scram.wicket.HomePage;
import gr.scram.wicket.pages.MunicipalitiesPage;
import gr.scram.wicket.pages.PersonsPage;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.cookies.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Header panel.
 * 
 * @author asvesdi
 * 
 */
public class HeaderPanel extends Panel {
	private static final CookieUtils CUTILS = new CookieUtils();
	private final WebMarkupContainer home = new WebMarkupContainer("home");
	private final WebMarkupContainer persons = new WebMarkupContainer("persons");
	private final WebMarkupContainer municipalitites = new WebMarkupContainer(
			"municipalitites");

	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            mark-up
	 */
	public HeaderPanel(final String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		home.setOutputMarkupId(true);
		home.setOutputMarkupPlaceholderTag(true);
		persons.setOutputMarkupId(true);
		persons.setOutputMarkupPlaceholderTag(true);
		municipalitites.setOutputMarkupId(true);
		municipalitites.setOutputMarkupPlaceholderTag(true);

		final Link<String> homeLink = new Link<String>("home-link") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				CUTILS.save("nav-bar", "home");
				setResponsePage(new HomePage());
			}
		};

		home.add(homeLink);
		add(home);

		final Link<String> muni = new Link<String>("municipalities-link") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				CUTILS.save("nav-bar", "municipalities");
				setResponsePage(new MunicipalitiesPage());
			}

		};
		municipalitites.add(muni);
		add(municipalitites);
		
		final Link<String> personsLink = new Link<String>("persons-link") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				CUTILS.save("nav-bar", "persons");
				setResponsePage(new PersonsPage());
			}

		};
		persons.add(personsLink);
		add(persons);
		
		if ("home".equals(CUTILS.load("nav-bar"))) {
			home.add(AttributeModifier.replace("class", "active"));
		} else if ("municipalities".equals(CUTILS.load("nav-bar"))) {
			municipalitites.add(AttributeModifier.replace("class", "active"));
		} else if ("persons".equals(CUTILS.load("nav-bar"))) {
			persons.add(AttributeModifier.replace("class", "active"));
		} else {
			home.add(AttributeModifier.replace("class", "active"));
		}

	}

}
