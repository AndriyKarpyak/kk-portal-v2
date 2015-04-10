package com.kk.portal.client.app.ui.view.login;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.event.LoginFaildEvent;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent.LoginSuccessEventHandler;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;

@Singleton
public class LoginPresenter extends ApplicationPresenter<LoginView, LoginService> implements LoginFaildEvent.LoginFaildEventHandler, LoginSuccessEventHandler {

	private static final Logger LOG = Logger.getLogger(LoginPresenter.class.getName());

	@Inject
	ApplicationEventBus appBus;

	@Override
	protected void initEventSubscriptions() {
		appBus.addLoginFaildHandler(this);
		appBus.addLoginSuccessHandler(this);

		LOG.info("LoginPresenter subscribed for events.");
	}

	@Override
	public void onLoginFaild(final LoginFaildEvent event) {
		LOG.info("User can't be signed in due to: [" + event.getReason() + "]");
		view.showServerError(event.getReason());
	}

	@Override
	public void onLoginSuccess(final LoginSuccessEvent event) {
		view.resetView();
	}

	void login(final String username, final String password, final Boolean stay) {
		LOG.info("Accepted login data: [username: " + username + "; password: " + password + "; stay logged in flag: " + stay + "]");

		if (!username.isEmpty() && !password.isEmpty()) {
			appBus.notifyLogin(username, password, stay);
		} else {
			if (username.isEmpty()) {
				view.showUserNameError("Field can't be empty.");
			}
			if (password.isEmpty()) {
				view.showPasswordError("Field can't be empty.");
			}
		}
	}
}
