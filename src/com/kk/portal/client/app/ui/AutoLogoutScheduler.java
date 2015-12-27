package com.kk.portal.client.app.ui;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.dialog.autologout.AutoLogoutPresenter;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.resource.settings.AppSettings;

@Singleton
public class AutoLogoutScheduler {

	@Inject
	AppSettings cnst;

	@Inject
	ApplicationEventBus appBus;

	@Inject
	AutoLogoutPresenter autoLogout;

	private Timer scheduler = new Timer() {

		@Override
		public void run() {
			autoLogout.startCountDown();
		}
	};;

	public void start() {
		scheduler.schedule(cnst.AutoLogout_delay() * 60000);
	}

	public void stop() {
		scheduler.cancel();
	}

}
