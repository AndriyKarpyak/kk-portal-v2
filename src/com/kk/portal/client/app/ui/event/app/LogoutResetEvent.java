package com.kk.portal.client.app.ui.event.app;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LogoutResetEvent extends GwtEvent<LogoutResetEvent.LogoutResetEventHandler> {

	public interface LogoutResetEventHandler extends EventHandler {
		void onResetLogout();
	}

	public static Type<LogoutResetEvent.LogoutResetEventHandler> TYPE = new Type<LogoutResetEvent.LogoutResetEventHandler>();

	@Override
	public Type<LogoutResetEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LogoutResetEventHandler handler) {
		handler.onResetLogout();
	}
}
