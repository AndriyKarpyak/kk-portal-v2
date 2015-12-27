package com.kk.portal.client.app.ui.event;

import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateReceivedEvent.CardTableStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent.CardTableStateRequestEventHandler;
import com.kk.portal.client.app.ui.event.ws.DeckSelectionEvent;
import com.kk.portal.client.app.ui.event.ws.DeckSelectionEvent.DeckSelectionEventHandler;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateReceivedEvent;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateReceivedEvent.DeckManagerStateReceivedEventHandler;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.DeckManagerStateRequestEvent.DeckManagerStateRequestEventHandler;
import com.kk.portal.shared.domain.state.CardTableState;
import com.kk.portal.shared.domain.state.TabBarState;

@Singleton
public class WorkspaceEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(WorkspaceEventBus.class.getName());

	public WorkspaceEventBus() {
		super();
		LOG.info(WorkspaceEventBus.class.getName() + " for application created.");
	}

	public HandlerRegistration addTabSelectionHandler(final DeckSelectionEventHandler handler) {
		return addHandler(DeckSelectionEvent.TYPE, handler);
	}

	public void notifyTabSelection(Integer selectedTabIndex) {
		fireEvent(new DeckSelectionEvent(selectedTabIndex));
	}

	public HandlerRegistration addTabBarStateRequestHandler(final DeckManagerStateRequestEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(DeckManagerStateRequestEvent.TYPE, handler);
	}

	public void notifyDeckManagerStateRequest() {
		fireEvent(new DeckManagerStateRequestEvent());
	}

	public HandlerRegistration addTabBarStateReceivedHandler(final DeckManagerStateReceivedEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(DeckManagerStateReceivedEvent.TYPE, handler);
	}

	public void notifyTabBarStateReceived(TabBarState tabBarState) {
		fireEvent(new DeckManagerStateReceivedEvent(tabBarState));
	}

	public HandlerRegistration addCardTableStateRequestHandler(final CardTableStateRequestEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(CardTableStateRequestEvent.TYPE, handler);
	}

	public void notifyCardTableStateRequest(int stateIndex) {
		fireEvent(new CardTableStateRequestEvent(stateIndex));
	}

	public HandlerRegistration addCardTableStateReceivedHandler(final CardTableStateReceivedEventHandler handler) {
		LOG.info("Add handler: [" + handler.getClass().getName() + "]");
		return addHandler(CardTableStateReceivedEvent.TYPE, handler);
	}

	public void notifyCardTableStateReceived(CardTableState cardTableState) {
		fireEvent(new CardTableStateReceivedEvent(cardTableState));
	}
}
