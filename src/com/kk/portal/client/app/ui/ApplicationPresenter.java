package com.kk.portal.client.app.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class ApplicationPresenter<T extends ApplicationView & IsWidget, H extends ApplicationService> {

	@Inject
	protected H service;

	@Inject
	protected T view;

	private boolean initialized = false;

	protected void initEventSubscriptions() {
	}

	protected void init() {

		view.setPresenter(this);
		view.initLayout();

		service.initEventSubscriptions();
		this.initEventSubscriptions();

		initialized = true;
	}

	public T view() {
		return view;
	}

	public boolean isInitialized() {
		return initialized;
	}
}
