package com.kk.portal.client.app.ui.module.graph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class GraphModuleView extends Composite implements ModuleView<GraphModulePresenter> {

	interface GraphModuleViewUiBinder extends UiBinder<Widget, GraphModuleView> {}

	private static GraphModuleViewUiBinder uiBinder = GWT.create(GraphModuleViewUiBinder.class);

	@UiField
	HTMLPanel wrapper;

	private GraphModulePresenter presenter;

	public GraphModuleView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(final GraphModulePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
		wrapper.add(presenter.getHighResGraphWidget());
	}

	@Override
	public String getModuleTitle() {
		return "Module To test fast log graph";
	}

}
