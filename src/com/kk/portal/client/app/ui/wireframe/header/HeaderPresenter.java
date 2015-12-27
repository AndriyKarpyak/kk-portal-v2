package com.kk.portal.client.app.ui.wireframe.header;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.wireframe.FramePresenter;

@Singleton
public class HeaderPresenter extends FramePresenter<HeaderView, HeaderService> {

	@Inject
	ApplicationEventBus appBus;

	public void logout() {
		appBus.notifyLogout();
	}

}