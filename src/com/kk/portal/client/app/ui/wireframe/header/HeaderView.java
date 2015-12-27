package com.kk.portal.client.app.ui.wireframe.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.wireframe.FrameView;

public class HeaderView extends Composite implements FrameView<HeaderPresenter> {

	interface HeaderViewUiBinder extends UiBinder<Widget, HeaderView> {}

	private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

	@UiField
	Button logout;

	@UiConstructor
	public HeaderView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private HeaderPresenter presenter;

	@Override
	public void setPresenter(HeaderPresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("logout")
	void logout(ClickEvent e) {
		presenter.logout();
	}

	@Override
	public void initLayout() {

	}

}
