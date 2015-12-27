package com.kk.portal.client.app.ui.wireframe.playroom;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ApplicationEventBus;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.wireframe.FramePresenter;
import com.kk.portal.client.app.ui.wireframe.FrameViewFactory;
import com.kk.portal.client.app.ui.wireframe.cardtable.CardTableView;
import com.kk.portal.client.app.ui.wireframe.decksholder.DecksHolderView;

@Singleton
public class PlayRoomPresenter extends FramePresenter<PlayRoomView, PlayRoomService> {

	@Inject
	ApplicationEventBus apBus;

	@Inject
	WorkspaceEventBus wsBus;

	@Inject
	Provider<FrameViewFactory> views;

	public DecksHolderView getDeckManager() {
		return views.get().view(DecksHolderView.class);
	}

	public CardTableView getCardTable() {
		return views.get().view(CardTableView.class);
	}

	public void requestDeckManagerState() {
		wsBus.notifyDeckManagerStateRequest();
	}

}
