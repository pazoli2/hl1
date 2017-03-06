package hu.helixlab.ui.garden;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

/**
 * Plants in our garden
 * 
 * @author erbalazs
 */
public abstract class Plant extends Button implements ClickListener {
	
	public Plant() {
		super();

		setWidth("60px");
		setCaption(getShortName());
		
		addClickListener(this);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		Notification.show(getName());
	}

	abstract public String getName();
	
	/**
	 * Max. 2 characters
	 * 
	 * @return
	 */
	abstract public String getShortName();
	
	/**
	 * In gram
	 * 
	 * @return
	 */
	abstract public int getWeight();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Plant [getName()=");
		builder.append(getName());
		builder.append("]");
		return builder.toString();
	}
	
}
