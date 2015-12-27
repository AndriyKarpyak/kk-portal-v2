package com.kk.portal.client.app.ui.module.test_dnd;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class DNDTestModuleView extends Composite implements ModuleView<DNDTestModulePresenter> {

	private static DNDTestModuleViewUiBinder uiBinder = GWT.create(DNDTestModuleViewUiBinder.class);

	interface DNDTestModuleViewUiBinder extends UiBinder<Widget, DNDTestModuleView> {}

	@UiField HTML show;
	@UiField HTMLPanel filter;
	
	public DNDTestModuleView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(DNDTestModulePresenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initLayout() {
		filter.setVisible(false);
		show.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				filter.setVisible(true);
			}
		});
		
	}

	@Override
	public String getModuleTitle() {
		return DNDTestModuleView.class.getSimpleName();
	}

}
