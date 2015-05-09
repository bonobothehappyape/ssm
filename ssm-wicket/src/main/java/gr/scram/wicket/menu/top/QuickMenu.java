package gr.scram.wicket.menu.top;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Quick menu.
 * @param <T> the menu item.
 * @author asvesdi
 *
 */
public class QuickMenu<T extends MenuItem> extends Panel {

	/**
	 * Constant.
	 */
	private static final String BACKGROUND_COLOR = "background-color:#5E721B;width:auto;";
	/**
	 * Constant.
	 */
	private static final String FONT_SIZE_1PX_WIDTH_8PX_HEIGHT_54PX
		= "font-size:1px;width:8px;height:54px;";
	/**
	 * Constant.
	 */
	private static final String RIGHT2 = "right";
	/**
	 * Constant.
	 */
	private static final String LEFT2 = "left";
	/**
	 * Constant.
	 */
	private static final String BACKGROUND = "background";
	/**
	 * Constant.
	 */
	private static final String STYLE = "style";

	/**
	 * link id used by menu item.
	 */
	public static final String LINK_ID = "linkid";

	/**
	 * link text used by menu item.
	 */
	public static final String LINK_TEXT_ID = "linktext";

	/**
	 * top menu items .
	 */
	private final List<T> topMenuItems;

	/**
	 * Serialisation.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new QuickMenu object.
	 * 
	 * @param id mark-up
	 * @param topLevelEntries top level
	 */
	public QuickMenu(final String id, final List<T>  topLevelEntries) {
		super(id);
		setOutputMarkupId(true);
		setRenderBodyOnly(true);
		this.topMenuItems = topLevelEntries;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();

		final WebMarkupContainer div = new WebMarkupContainer(BACKGROUND);
		final WebMarkupContainer left = new WebMarkupContainer(LEFT2);
		final WebMarkupContainer right = new WebMarkupContainer(RIGHT2);

//		left.add(AttributeModifier.replace(STYLE,
//				FONT_SIZE_1PX_WIDTH_8PX_HEIGHT_54PX + BACKGROUND_COLOR));
//		right.add(AttributeModifier.replace(STYLE,
//				FONT_SIZE_1PX_WIDTH_8PX_HEIGHT_54PX + BACKGROUND_COLOR));

//		div.add(AttributeModifier.replace(STYLE, BACKGROUND_COLOR));
		div.add(left);
		div.add(right);

		SubMenuListView sublistView = 
				new SubMenuListView("topmenuitems", new PropertyModel<List<?>>(
				this, "topMenuItems"));
		div.add(sublistView);
		add(div);
	}
	
	/**
	 * @return the topMenuItems
	 */
	public List<T> getTopMenuItems() {
		return topMenuItems;
	}

	/**
	 * nested class for link fragment.
	 */
	final class LinkFragment extends Fragment {
		/**
		 * Constant.
		 */
		public static final String LINKFRAGMENT2 = "linkfragment";
		/**
		 * Constant.
		 */
		private static final String LINKFRAGMENT = "LINKFRAGMENT";
		
		/**
		 * Serialisation.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Creates a new LinkFragment object.
		 * @param link menu link
		 */
		public LinkFragment(final AbstractLink link) {
			super(LINKFRAGMENT2, LINKFRAGMENT, QuickMenu.this);
			add(link);
			setRenderBodyOnly(true);
		}
	}

	/**
	 * nested class for text fragment.
	 */
	final class TextFragment extends Fragment {
		/**
         * Serialisation.
         */
		private static final long serialVersionUID = 1L;

		/**
		 * Creates a new TextFragment object.
		 * @param label label
		 */
		public TextFragment(final Label label) {
			super(LinkFragment.LINKFRAGMENT2, "TEXTFRAGMENT", QuickMenu.this);
			add(label);
			setRenderBodyOnly(true);
		}
	}

	/**
	 * nested group name class.
	 */
	final class GroupNameFragment extends Fragment {
		/**
		 * Serialisation.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Creates a new GroupNameFragment object.
		 * @param label link  label.
		 */
		public GroupNameFragment(final Label label) {
			super(LinkFragment.LINKFRAGMENT2, "GROUPNAMEFRAGMENT", QuickMenu.this);
			add(label);
			setRenderBodyOnly(true);
		}
	}

	/**
     * 
     */
	final class SeparatorFragment extends Fragment {
		/**
		 * Creates a new SeparatorFragment object.
		 * 
		 */
		public SeparatorFragment() {
			super(LinkFragment.LINKFRAGMENT2, "SEPARATORFRAGMENT", QuickMenu.this);
		}

		/**
		 * Serialisation .
		 */
		private static final long serialVersionUID = 1L;
	}

	/**
	 * Sum menu list.
	 * @author asvesdi
	 * @param <K> {@link MenuItem}.
	 */
	private final class SubMenuListView extends ListView<Object> {
		/**
		 * Serialisation .
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Creates a new SubMenuListView object.
		 * @param id mark-up
		 * @param model model object.
		 */
		private SubMenuListView(final String id, final IModel<List<?>> model) {
			super(id, model);
			setRenderBodyOnly(true);
		}

		/**
		 * Creates a new SubMenuListView object.
		 * 
		 * @param id mark-up.
		 * @param list list.
		 */
		private SubMenuListView(final String id, final List<MenuItem> list) {
			super(id, list);
			setRenderBodyOnly(true);
		}

		@Override
		protected void populateItem(ListItem<Object> item) {
			final MenuItem menuItem = (MenuItem) item.getModelObject();
			item.add(menuItem.isTopLevel() ? new MenuItemFragment(menuItem,
					true) : new MenuItemFragment(menuItem, false));
		}
	}

	/**
	 * Nested Fragment Class. menu item fragment.
	 */
	private final class MenuItemFragment extends Fragment {
		/**
		 * Serialisation.
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * menu item.
		 */
		private WebMarkupContainer menuitemul;

		/**
		 * Constructor.
		 * @param menuItem {@link MenuItem}
		 * @param isTopLevel true if this is top level entry.
		 */
		public MenuItemFragment(final MenuItem menuItem,
				final boolean isTopLevel) {
			super("menuitemfragment", "MENUITEMFRAGMENT", QuickMenu.this);
			setRenderBodyOnly(true);

			menuitemul = new WebMarkupContainer("menuitemlist");
			add(menuitemul);

			if (!menuItem.getChildren().isEmpty()) {
				menuitemul.add(new SubMenuListView("menuitemlinks", menuItem
						.getChildren()));
			} else {
				menuitemul.setVisible(false);
			}

			createMenuFragment(menuItem);

			final WebMarkupContainer sep = new WebMarkupContainer(
					"toplevelseparator");
			sep.setVisible(isTopLevel);
			add(sep);
		}

		/**
		 * Create menu.
		 * @param menuItem menu item
		 */
		private void createMenuFragment(final MenuItem menuItem) {
			if (menuItem instanceof MenuSeparator) {
				add(new SeparatorFragment());
			} else if (menuItem instanceof LabeledMenuItem) {
				final LabeledMenuItem lmenuItem = (LabeledMenuItem) menuItem;
				if (lmenuItem instanceof MenuGroupName) {
					add(new GroupNameFragment(lmenuItem.getLabel()));
				} else {
					if (lmenuItem.getLink() != null) {
						add(new LinkFragment(lmenuItem.getLink()));
					} else {
						add(new TextFragment(lmenuItem.getLabel()));
					}
				}
			} else {
				throw new IllegalArgumentException(
						"Dont know how to handle class '"
								+ menuItem.getClass().getName() + "'");
			}
		}
	}
}
