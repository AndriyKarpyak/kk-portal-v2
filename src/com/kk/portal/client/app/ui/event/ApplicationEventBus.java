package com.kk.portal.client.app.ui.event;

import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.app.LoginEvent;
import com.kk.portal.client.app.ui.event.app.LoginFaildEvent;
import com.kk.portal.client.app.ui.event.app.LoginSuccessEvent;
import com.kk.portal.client.app.ui.event.app.LogoutEvent;
import com.kk.portal.client.app.ui.event.app.LogoutResetEvent;

@Singleton
public class ApplicationEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(ApplicationEventBus.class.getName());

	public ApplicationEventBus() {
		super();
		LOG.info("Main EventBus for application created.");
	}

	public HandlerRegistration addLoginHandler(final LoginEvent.LoginEventHandler handler) {
		LOG.info("Add LoginHandler: [" + handler.getClass().getName() + "]");
		return addHandler(LoginEvent.TYPE, handler);
	}

	public void notifyLogin(final String username, final String password, final boolean stay) {
		fireEvent(new LoginEvent(username, password, stay));
	}

	public HandlerRegistration addLoginSuccessHandler(final LoginSuccessEvent.LoginSuccessEventHandler handler) {
		LOG.info("Add LoginSuccessHandler: [" + handler.getClass().getName() + "]");
		return addHandler(LoginSuccessEvent.TYPE, handler);
	}

	public void notifyLoginSuccess(boolean stay) {
		fireEvent(new LoginSuccessEvent(stay));
	}

	public HandlerRegistration addLoginFaildHandler(final LoginFaildEvent.LoginFaildEventHandler handler) {
		LOG.info("Add LoginFaildHandler: [" + handler.getClass().getName() + "]");
		return addHandler(LoginFaildEvent.TYPE, handler);
	}

	public void notifyLoginFaild(final String reason) {
		fireEvent(new LoginFaildEvent(reason));
	}

	public HandlerRegistration addLogoutHandler(final LogoutEvent.LogoutEventHandler handler) {
		LOG.info("Add LogoutHandler: [" + handler.getClass().getName() + "]");
		return addHandler(LogoutEvent.TYPE, handler);
	}

	public void notifyLogout() {
		fireEvent(new LogoutEvent());
	}

	public HandlerRegistration addResetLogoutHandler(final LogoutResetEvent.LogoutResetEventHandler handler) {
		LOG.info("Add ResetLogoutHandler: [" + handler.getClass().getName() + "]");
		return addHandler(LogoutResetEvent.TYPE, handler);
	}

	public void notifyLogoutReset() {
		fireEvent(new LogoutResetEvent());
	}
}
