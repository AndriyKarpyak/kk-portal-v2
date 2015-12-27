package com.kk.portal.client.app.ui.dialog;

import com.google.gwt.user.client.ui.PopupPanel;

@SuppressWarnings("rawtypes")
public abstract class DialogPresenter<T extends DialogView> {

	protected T view;

	@SuppressWarnings("unchecked")
	public DialogPresenter(T view) {
		this.view = view;
		this.view.setPresenter(this);
	}

	public PopupPanel getDialog() {
		return view.getDialog();
	}
}
