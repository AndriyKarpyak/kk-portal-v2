package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CardTableStateRequestEvent extends GwtEvent<CardTableStateRequestEvent.CardTableStateRequestEventHandler> {

	public interface CardTableStateRequestEventHandler extends EventHandler {
		void onStateRequest(CardTableStateRequestEvent event);
	}

	public static Type<CardTableStateRequestEventHandler> TYPE = new Type<CardTableStateRequestEvent.CardTableStateRequestEventHandler>();

	private int stateIndex;

	public CardTableStateRequestEvent(int stateIndex) {
		super();
		this.stateIndex = stateIndex;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CardTableStateRequestEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final CardTableStateRequestEventHandler handler) {
		handler.onStateRequest(this);
	}

	public int getStateIndex() {
		return stateIndex;
	}

	public void setStateIndex(int stateIndex) {
		this.stateIndex = stateIndex;
	}

}
