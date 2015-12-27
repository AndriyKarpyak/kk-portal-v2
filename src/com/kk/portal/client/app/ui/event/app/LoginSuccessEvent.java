package com.kk.portal.client.app.ui.event.app;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginSuccessEvent extends GwtEvent<LoginSuccessEvent.LoginSuccessEventHandler> {

	public interface LoginSuccessEventHandler extends EventHandler {
		void onLoginSuccess(LoginSuccessEvent event);
	}

	public static Type<LoginSuccessEvent.LoginSuccessEventHandler> TYPE = new Type<LoginSuccessEvent.LoginSuccessEventHandler>();

	private final boolean stay;

	public LoginSuccessEvent(boolean stay) {
		super();
		this.stay = stay;
	}

	@Override
	public Type<LoginSuccessEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoginSuccessEventHandler handler) {
		handler.onLoginSuccess(this);
	}

	public boolean isStay() {
		return stay;
	}
}
