package com.kk.portal.client.app.ui.module;

import com.google.gwt.user.client.ui.IsWidget;
import com.kk.portal.client.app.ui.ApplicationPresenter;

@SuppressWarnings("rawtypes")
public abstract class ModulePresenter<T extends ModuleView & IsWidget, H extends ModuleService> extends ApplicationPresenter<T, H> {

	protected abstract void initModuleComponents();

	@Override
	protected void init() {
		initModuleComponents();
		super.init();
	}

}
