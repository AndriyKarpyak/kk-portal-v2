package com.kk.portal.client.app.ui.dialog.autologout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.kk.portal.client.app.ui.dialog.DialogView;
import com.kk.portal.resource.messages.AppStringConstants;

public class AutoLogoutDialogView extends DialogBox implements DialogView<AutoLogoutPresenter> {

	private static AutoLogoutDialogViewUiBinder uiBinder = GWT.create(AutoLogoutDialogViewUiBinder.class);

	interface AutoLogoutDialogViewUiBinder extends UiBinder<HTMLPanel, AutoLogoutDialogView> {
	}

	private static final AppStringConstants cstr = GWT.create(AppStringConstants.class);

	@UiField
	InlineLabel counter;

	@UiField
	Button stay;

	private AutoLogoutPresenter presenter;

	public AutoLogoutDialogView() {

		getCaption().setText(cstr.AutoLogoutDialogView_header());
		setModal(true);
		setGlassEnabled(true);

		setWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("stay")
	void onClick(final ClickEvent e) {
		presenter.stay();
	}

	@Override
	public void setPresenter(final AutoLogoutPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public PopupPanel getDialog() {
		return this;
	}

	public void setMessage(final String masg) {
		counter.setText(masg);
	}
}