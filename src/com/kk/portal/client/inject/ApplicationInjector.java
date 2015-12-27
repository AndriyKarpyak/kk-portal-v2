package com.kk.portal.client.inject;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.kk.portal.client.app.ui.ApplicationController;

@GinModules(ApplicationModule.class)
public interface ApplicationInjector extends Ginjector {

	ApplicationController createApplicationController();
}
