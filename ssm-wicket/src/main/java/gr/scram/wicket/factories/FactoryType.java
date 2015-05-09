package gr.scram.wicket.factories;

import gr.scram.ssm.model.core.impl.AbstractJPAEntity;
import gr.scram.wicket.factories.impl.AjaxDefaultTableFactory;
import gr.scram.wicket.factories.impl.AjaxPojoDefaultTableFactory;
import gr.scram.wicket.factories.impl.DateFieldFactory;
import gr.scram.wicket.factories.impl.DateLabelFactory;
import gr.scram.wicket.factories.impl.DatePickerFactory;
import gr.scram.wicket.factories.impl.DropdownChoiceFactory;
import gr.scram.wicket.factories.impl.LabelFactory;
import gr.scram.wicket.factories.impl.LinkFactory;
import gr.scram.wicket.factories.impl.ModalFactory;
import gr.scram.wicket.factories.impl.PropertyColumnFactory;
import gr.scram.wicket.factories.impl.StringFieldFactory;

import java.io.Serializable;
import java.util.Date;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.io.IClusterable;

import com.googlecode.wicket.jquery.ui.form.datepicker.DatePicker;

/**
 * Enum factory.
 * 
 * @author asvesdi
 * 
 */
public enum FactoryType {
	
	
	/**
	 * Get the {@link DateFieldFactory}.
	 */
	COLUMN_FACTORY {
		/**
		 * get the factory.
		 * @return {@link IComponentFactory}.
		 */
		@Override
		public IFactory<String, IColumn<String,String>> get() {
			return new PropertyColumnFactory();
		}
	},
	
	/**
	 * Get the {@link DateFieldFactory}.
	 */
	DATE_PICKER_FACTORY {
		/**
		 * get the factory.
		 * @return {@link IComponentFactory}.
		 */
		@Override
		public IFormComponentFactory<Date,DatePicker> get() {
			return new DatePickerFactory();
		}
	},
	
	/**
	 * Get the {@link DateFieldFactory}.
	 */
	DATE_TEXT_FIELD_FACTORY {
		/**
		 * get the factory.
		 * @return {@link IComponentFactory}.
		 */
		@Override
		public  IFormComponentFactory<Date,DateTextField> get() {
			return new DateFieldFactory();
		}
	},
	
	/**
	 * Get the {@link DateFieldFactory}.
	 */
	TEXT_FIELD_FACTORY {

		@Override
		public IFormComponentFactory<String, 
				TextField<String>> get() {
			return new StringFieldFactory();
		}
		
	},
	
	/**
	 * get the {@link TENTDropdownChoiceFactory}.
	 */
	DROPDOWN_FACTORY{
		@Override
		public DropdownChoiceFactory<? extends Serializable> get() {
			return new DropdownChoiceFactory<Serializable>();
		}
		
	},
	
	/**
	 * Get the {@link DateFieldFactory}.
	 */
	DATE_LABEL_FACTORY {
		/**
		 * get the factory.
		 * @return {@link IFactory}.
		 */
		@Override
		public  IFactory<Date,Label> get() {
			return new DateLabelFactory();
		}
	},
	
	/**
	 * Get the {@link LabelFactory}.
	 */
	LABEL_FACTORY {

		@Override
		public IFactory<String, Label> get() {
			return new LabelFactory();
		}
		
	},
	
	/**
	 * Get the {@link AjaxDefaultTableFactory}.
	 */
	AJAX_TABLE_FACTORY {
		@Override
		public  AjaxDefaultTableFactory<AbstractJPAEntity> get() {
			return new AjaxDefaultTableFactory<AbstractJPAEntity>();
		}
		
	},
	
	/**
	 * Get the {@link AjaxPojoDefaultTableFactory}.
	 */
	AJAX_POJO_TABLE_FACTORY {
		@Override
		public  AjaxPojoDefaultTableFactory<Serializable> get() {
			return new AjaxPojoDefaultTableFactory<Serializable>();
		}
		
	},
	
	/**
	 * get the {@link ModalFactory}.
	 */
	MODAL_FACTORY{

		@Override
		public ModalFactory get() {
			return new ModalFactory();
		}
		
	},
	
//	/**
//	 * get the {@link TENTDropdownChoiceFactory}.
//	 */
//	TENTDROPDOWN_FACTORY{
//		@Override
//		public TENTDropdownChoiceFactory get() {
//			return new TENTDropdownChoiceFactory();
//		}
//		
//	},
	
	/**
	 * get the {@link LinkFactory}.
	 */
	LINK_FACTORY{

		@Override
		public LinkFactory get() {
			return new LinkFactory();
		}
		
	};
	
	/**
	 * Get the factory.
	 * @return the {@link IFactory} type.
	 */
	public abstract  IFactory<? extends Serializable, ? extends IClusterable > get();
}
