package com.kk.portal.client.app.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class ModuleCard extends Composite {

	private static ModuleCardUiBinder uiBinder = GWT.create(ModuleCardUiBinder.class);

	interface ModuleCardUiBinder extends UiBinder<Widget, ModuleCard> {}

	@UiField
	InlineLabel title;
	
	@UiField
	HTMLPanel content;

	public ModuleCard(ModuleView<?> content) {
		initWidget(uiBinder.createAndBindUi(this));

		this.title.setText(content.getModuleTitle());
		this.content.add(content);
	}
}
