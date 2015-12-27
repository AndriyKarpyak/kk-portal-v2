package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.shared.domain.state.CardTableState;

public class CardTableStateReceivedEvent extends GwtEvent<CardTableStateReceivedEvent.CardTableStateReceivedEventHandler> {

	public interface CardTableStateReceivedEventHandler extends EventHandler {
		void onStateReceive(CardTableStateReceivedEvent event);
	}

	public static Type<CardTableStateReceivedEventHandler> TYPE = new Type<CardTableStateReceivedEvent.CardTableStateReceivedEventHandler>();

	private final CardTableState cardTableState;

	public CardTableStateReceivedEvent(CardTableState cardTableState) {
		super();
		this.cardTableState = cardTableState;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CardTableStateReceivedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CardTableStateReceivedEventHandler handler) {
		handler.onStateReceive(this);
	}

	public CardTableState getState() {
		return cardTableState;
	}

}
