package com.kk.portal.client.app.ui.dialog.autologout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.kk.portal.client.app.ui.dialog.DialogPresenter;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.resource.messages.AppMessages;

public class AutoLogoutPresenter extends DialogPresenter<AutoLogoutDialogView> {

	private static AppMessages msgs = GWT.create(AppMessages.class);

	private final ApplicationEventBus appBus;

	private Timer counter;

	@Inject
	public AutoLogoutPresenter(final AutoLogoutDialogView view, final ApplicationEventBus appBus) {
		super(view);
		this.appBus = appBus;
	}

	public void stay() {
		counter.cancel();
		appBus.notifyLogoutReset();
		view.hide();
	}

	public void startCountDown() {
		view.setMessage(msgs.AutoLogoutDialogView_login_trminated(20));
		view.center();

		this.counter = new Timer() {

			private int count = 20;

			@Override
			public void run() {
				--count;
				if (count != 0) {
					view.setMessage(msgs.AutoLogoutDialogView_login_trminated(count));
				} else {
					counter.cancel();
					appBus.notifyLogout();
					view.hide();
				}
			}
		};
		counter.scheduleRepeating(1000);
	}
}
