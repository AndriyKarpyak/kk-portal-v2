package com.kk.portal.client.app.ui.wireframe.login;

import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.wireframe.FrameView;
import com.kk.portal.resource.messages.AppStringConstants;

@Singleton
public class LoginView extends Composite implements FrameView<LoginPresenter> {

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {}

	private static final LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);
	private static final AppStringConstants scnst = GWT.create(AppStringConstants.class);

	@UiField(provided = true)
	InlineLabel productNameLbl = new InlineLabel(scnst.General_product_name_upcase());
	@UiField(provided = true)
	Label formCaption = new Label(scnst.LoginView_lbl_caption());
	@UiField(provided = true)
	InlineLabel usernameLbl = new InlineLabel(scnst.LoginView_lbl_username());
	@UiField(provided = true)
	InlineLabel passwordLbl = new InlineLabel(scnst.LoginView_lbl_password());
	@UiField(provided = true)
	InlineLabel stayLbl = new InlineLabel(scnst.LoginView_lbl_stay_loged_in());

	@UiField
	FormPanel form;

	@UiField
	TextBox username;

	@UiField
	PasswordTextBox password;

	@UiField
	CheckBox stay;

	@UiField
	Label error;

	@UiField
	SubmitButton ok;

	private LoginPresenter presenter;

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));

		form.getElement().setId("login-form");
		form.setAction("login");
		form.setMethod("POST");

		ok.setText(scnst.LoginView_btn_login());

		username.setName("username");
		password.setName("password");

		error.setVisible(false);
	}

	@UiHandler("form")
	void onSubmit(SubmitEvent event) {
		clearServerError();
		lockControlls(true);
	}

	@UiHandler("ok")
	void onOK(final ClickEvent event) {
		form.submit();
		presenter.login(username.getValue(), password.getValue(), stay.getValue());
	}

	@UiHandler("username")
	void onUsernameFocus(final FocusEvent event) {
		clearServerError();
		clearFieldError(username);
	}

	@UiHandler("password")
	void onPasswordFocus(final FocusEvent event) {
		clearServerError();
		clearFieldError(password);
	}

	@Override
	public void setPresenter(final LoginPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
	}

	public void resetView() {
		lockControlls(false);
		resetInputs();
	}

	public void showServerError(final String message) {
		lockControlls(false);
		resetInputs();

		error.setText(message);
		error.setTitle(message);
		error.setVisible(true);
	}

	public void showUserNameError(final String message) {
		markFieldError(username, message);
	}

	public void showPasswordError(final String message) {
		markFieldError(password, message);
	}

	private void markFieldError(final Widget target, final String message) {
		lockControlls(false);
		target.setTitle(message);
		target.setStyleName("input-error", true);
	}

	private void clearFieldError(final Widget target) {
		target.setStyleName("input-error", false);
		target.setTitle("");
	}

	private void clearServerError() {
		error.setVisible(false);
		error.setText("");
	}

	private void lockControlls(boolean lock) {
		ok.setEnabled(!lock);
		username.setEnabled(!lock);
		password.setEnabled(!lock);
		stay.setEnabled(!lock);
	}

	private void resetInputs() {
		username.setText("");
		password.setText("");
		stay.setValue(false);
	}
}
