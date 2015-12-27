package com.kk.portal.client.app.ui.wireframe.login;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.comm.WebServiceCommunicationInterface;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.event.app.LoginEvent;
import com.kk.portal.client.app.ui.event.app.LoginEvent.LoginEventHandler;
import com.kk.portal.client.app.ui.wireframe.FrameService;
import com.kk.portal.shared.domain.comm.resp.LoginResp;

@Singleton
public class LoginService implements FrameService, LoginEventHandler {

	private static final Logger LOG = Logger.getLogger(LoginService.class.getName());

	@Inject
	WebServiceCommunicationInterface comm;

	@Inject
	ApplicationEventBus appBus;

	@Override
	public void initEventSubscriptions() {
		appBus.addLoginHandler(this);
	}

	@Override
	public void onLogin(final LoginEvent event) {
		LOG.info("Sending login request: [" + event.toDebugString() + "]");

		comm.login(event.getLogin(), new MethodCallback<LoginResp>() {

			@Override
			public void onFailure(Method method, Throwable exception) {
				LOG.log(Level.WARNING, method.getResponse().getHeadersAsString());
				appBus.notifyLoginFaild("Server error during authentification.");
			}

			@Override
			public void onSuccess(Method method, LoginResp response) {
				LOG.info("User successfuly signed in.");
				if (response.getError() == null) {
					appBus.notifyLoginSuccess(event.isStay());
				} else {
					appBus.notifyLoginFaild(response.getError().getErrorText());
				}
			}
		});
	}

}
