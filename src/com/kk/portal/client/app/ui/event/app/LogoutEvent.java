package com.kk.portal.client.app.ui.event.app;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LogoutEvent extends GwtEvent<LogoutEvent.LogoutEventHandler> {

	public interface LogoutEventHandler extends EventHandler {
		void onLogout();
	}

	public static Type<LogoutEvent.LogoutEventHandler> TYPE = new Type<LogoutEvent.LogoutEventHandler>();

	@Override
	public Type<LogoutEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LogoutEventHandler handler) {
		handler.onLogout();
	}
}
