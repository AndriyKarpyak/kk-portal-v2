package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.shared.domain.state.TabBarState;

public class DeckManagerStateReceivedEvent extends GwtEvent<DeckManagerStateReceivedEvent.DeckManagerStateReceivedEventHandler> {

	public interface DeckManagerStateReceivedEventHandler extends EventHandler {
		void onStateReceive(DeckManagerStateReceivedEvent event);
	}

	public static Type<DeckManagerStateReceivedEventHandler> TYPE = new Type<DeckManagerStateReceivedEvent.DeckManagerStateReceivedEventHandler>();

	private final TabBarState tabBarState;

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeckManagerStateReceivedEventHandler> getAssociatedType() {
		return TYPE;
	}

	public DeckManagerStateReceivedEvent(TabBarState tabBarState) {
		super();
		this.tabBarState = tabBarState;
	}

	@Override
	protected void dispatch(DeckManagerStateReceivedEventHandler handler) {
		handler.onStateReceive(this);
	}

	public TabBarState getState() {
		return tabBarState;
	}

}
