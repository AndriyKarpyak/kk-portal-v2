package com.kk.portal.client.app.ui.dialog;

import com.google.gwt.user.client.ui.PopupPanel;

@SuppressWarnings("rawtypes")
public interface DialogView<T extends DialogPresenter> {

	void setPresenter(T presenter);
	
	PopupPanel getDialog();
}
