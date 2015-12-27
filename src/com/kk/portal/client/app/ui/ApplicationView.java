package com.kk.portal.client.app.ui;

import com.google.gwt.user.client.ui.IsWidget;

@SuppressWarnings("rawtypes")
public interface ApplicationView<T extends ApplicationPresenter> extends IsWidget {

	void setPresenter(T presenter);

	void initLayout();
}
