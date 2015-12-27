package com.kk.portal.client.app.ui.module;

import com.kk.portal.client.app.ui.ApplicationView;

@SuppressWarnings("rawtypes")
public interface ModuleView<T extends ModulePresenter> extends ApplicationView<T> {
	
	String getModuleTitle();
}
