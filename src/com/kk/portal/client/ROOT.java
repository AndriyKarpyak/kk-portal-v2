package com.kk.portal.client;

import java.util.Arrays;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.kk.portal.client.app.ui.ApplicationController;
import com.kk.portal.client.inject.ApplicationInjector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ROOT implements EntryPoint {

	private static final Logger LOG = Logger.getLogger(ROOT.class.getName());

	private static final String LOCALE_KEY = "locale";

	private final ApplicationInjector applicationInjector = GWT.create(ApplicationInjector.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		LOG.fine("Entering EntryPoint");

		String clientLocale = getClientLocale();

		if (checkLocale(clientLocale)) {
			setLocale(clientLocale);
		} else {
			startApplication();
		}

		LOG.fine("Exit EntryPoint");
	}

	private void setLocale(String clientLocale) {
		LOG.fine("Changing application locale to " + clientLocale);
		Window.Location.replace(GWT.getHostPageBaseURL() + "?" + LOCALE_KEY + "=" + clientLocale);
	}

	private boolean checkLocale(String clientLocale) {
		return Window.Location.getParameter(LOCALE_KEY) == null && Arrays.asList(LocaleInfo.getAvailableLocaleNames()).contains(clientLocale)
				&& !clientLocale.equals(LocaleInfo.getCurrentLocale().getLocaleName());
	}

	private void startApplication() {
		Defaults.setServiceRoot(GWT.getHostPageBaseURL());

		ApplicationController applicationController = applicationInjector.createApplicationController();

		applicationController.initApplication(RootLayoutPanel.get());
		applicationController.startApplication();
	}

	private static native String getClientLocale() /*-{
		return (navigator.language) ? navigator.language
				: navigator.userLanguage;
	}-*/;
}
