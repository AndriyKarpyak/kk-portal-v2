package com.kk.portal.client.app.ui.event.app;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.shared.domain.comm.req.LoginReq;

public class LoginEvent extends GwtEvent<LoginEvent.LoginEventHandler> {

	public interface LoginEventHandler extends EventHandler {
		void onLogin(LoginEvent event);
	}

	public static Type<LoginEventHandler> TYPE = new Type<LoginEvent.LoginEventHandler>();

	private final LoginReq login = new LoginReq();
	private final boolean stay;

	public LoginEvent(final String username, final String password, final boolean stay) {
		super();

		this.login.setUsername(username);
		this.login.setPassword(password);

		this.stay = stay;
	}

	@Override
	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final LoginEventHandler handler) {
		handler.onLogin(this);
	}

	public LoginReq getLogin() {
		return login;
	}

	public boolean isStay() {
		return stay;
	}
}
