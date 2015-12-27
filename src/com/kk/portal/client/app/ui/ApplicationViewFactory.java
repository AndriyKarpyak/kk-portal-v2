package com.kk.portal.client.app.ui;

import com.google.gwt.user.client.ui.IsWidget;

public abstract class ApplicationViewFactory {

	public abstract <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType);

	protected ApplicationPresenter<?, ?> build(ApplicationPresenter<?, ?> presenter) {
		if (!presenter.isInitialized()) {
			presenter.init();
		}
		return presenter;
	}
}
