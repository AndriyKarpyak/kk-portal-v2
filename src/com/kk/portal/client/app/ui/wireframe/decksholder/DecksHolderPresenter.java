package com.kk.portal.client.app.ui.wireframe.decksholder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateReceivedEvent.DeckManagerStateReceivedEventHandler;
import com.kk.portal.client.app.ui.wireframe.FramePresenter;

@Singleton
public class DecksHolderPresenter extends FramePresenter<DecksHolderView, DecksHolderService> implements DeckManagerStateReceivedEventHandler {

	@Inject
	WorkspaceEventBus wsBus;

	@Override
	protected void initEventSubscriptions() {
		wsBus.addTabBarStateReceivedHandler(this);
	}

	public void handleTabSelection(Integer selectedItem) {
		wsBus.notifyTabSelection(selectedItem);
	}

	@Override
	public void onStateReceive(DeckManagerStateReceivedEvent event) {
		view.addTabs(event.getState().getTabs());
		view.selectTab(event.getState().getSelectedIndex());
	}
}
