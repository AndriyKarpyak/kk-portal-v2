package com.kk.portal.client.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.kk.portal.client.app.ui.ApplicationController;

class ApplicationModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(ApplicationController.class);
	}

}
