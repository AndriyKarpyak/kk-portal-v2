package com.kk.portal.client.app.ui.wireframe.stage;

import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.wireframe.FramePresenter;
import com.kk.portal.client.app.ui.wireframe.FrameViewFactory;
import com.kk.portal.client.app.ui.wireframe.header.HeaderView;
import com.kk.portal.client.app.ui.wireframe.playroom.PlayRoomView;

@Singleton
public class StagePresenter extends FramePresenter<StageView, StageService> {

	@Inject
	ApplicationEventBus appBus;

	@Inject
	Provider<FrameViewFactory> views;

	public HeaderView getHeader() {
		return views.get().view(HeaderView.class);
	}

	public Widget getNavigation() {
		return new InlineHTML("Will be implemented.");
	}

	public PlayRoomView getWorkspace() {
		return views.get().view(PlayRoomView.class);
	}

}
