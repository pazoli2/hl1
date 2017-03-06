package hu.helixlab.ui.garden;

import com.vaadin.ui.Notification;

public class StrawberryBlue extends Strawberry {

	@Override
	public String getShortName() {
		return "SB";
	}

	@Override
	public String getName() {
		return "Strawberry Blue";
	}

	@Override
	public void buttonClick(ClickEvent event) {
		Notification.show("Boooom!!!", Notification.TYPE_WARNING_MESSAGE);
	}

}
