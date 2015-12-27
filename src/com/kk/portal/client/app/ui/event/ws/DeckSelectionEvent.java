package com.kk.portal.client.app.ui.event.ws;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DeckSelectionEvent extends GwtEvent<DeckSelectionEvent.DeckSelectionEventHandler> {

	public interface DeckSelectionEventHandler extends EventHandler {
		void onSelection(DeckSelectionEvent event);
	}

	public static Type<DeckSelectionEventHandler> TYPE = new Type<DeckSelectionEvent.DeckSelectionEventHandler>();

	private final Integer selectedTabIndex;

	public DeckSelectionEvent(Integer selectedTabIndex) {
		super();
		this.selectedTabIndex = selectedTabIndex;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeckSelectionEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeckSelectionEventHandler handler) {
		handler.onSelection(this);
	}

	public Integer getSelectedTabIndex() {
		return selectedTabIndex;
	}
}
