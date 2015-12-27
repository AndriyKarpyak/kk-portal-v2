package com.kk.portal.client.app.ui.event.app;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginFaildEvent extends GwtEvent<LoginFaildEvent.LoginFaildEventHandler> {

	public interface LoginFaildEventHandler extends EventHandler {
		void onLoginFaild(LoginFaildEvent event);
	}

	public static Type<LoginFaildEventHandler> TYPE = new Type<LoginFaildEvent.LoginFaildEventHandler>();

	private String reason;

	public LoginFaildEvent(String reason) {
		super();
		this.reason = reason;
	}

	@Override
	public Type<LoginFaildEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoginFaildEventHandler handler) {
		handler.onLoginFaild(this);
	}

	public String getReason() {
		return reason;
	}
}
