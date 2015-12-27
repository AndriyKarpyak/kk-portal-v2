package com.kk.portal.client.app.ui.module.empty;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class EmptyModuleView extends Composite implements ModuleView<EmptyModulePresenter> {

	private static ParkOverviewModuleUiBinder uiBinder = GWT.create(ParkOverviewModuleUiBinder.class);

	interface ParkOverviewModuleUiBinder extends UiBinder<Widget, EmptyModuleView> {
	}

	public EmptyModuleView() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	public void setPresenter(EmptyModulePresenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getModuleTitle() {
		return EmptyModuleView.class.getSimpleName();
	}

}
