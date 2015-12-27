package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DeckManagerStateRequestEvent extends GwtEvent<DeckManagerStateRequestEvent.DeckManagerStateRequestEventHandler> {

	public interface DeckManagerStateRequestEventHandler extends EventHandler {
		void onStateRequest(DeckManagerStateRequestEvent event);
	}

	public static Type<DeckManagerStateRequestEventHandler> TYPE = new Type<DeckManagerStateRequestEvent.DeckManagerStateRequestEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeckManagerStateRequestEventHandler> getAssociatedType() {
		return TYPE;
	}

	public DeckManagerStateRequestEvent() {
		super();
	}

	@Override
	protected void dispatch(final DeckManagerStateRequestEventHandler handler) {
		handler.onStateRequest(this);
	}
}
