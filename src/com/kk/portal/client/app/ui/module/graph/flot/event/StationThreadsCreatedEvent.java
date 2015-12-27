package com.kk.portal.client.app.ui.module.graph.flot.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class StationThreadsCreatedEvent extends GwtEvent<StationThreadsCreatedEvent.StationThreadsCreatedEventHandler> {

	public interface StationThreadsCreatedEventHandler extends EventHandler {
		void onStationThreadsCreated(StationThreadsCreatedEvent event);
	}

	public static Type<StationThreadsCreatedEventHandler> TYPE = new Type<StationThreadsCreatedEvent.StationThreadsCreatedEventHandler>();

	private String stationGUID;

	public StationThreadsCreatedEvent(String stationGUID) {
		this.stationGUID = stationGUID;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<StationThreadsCreatedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final StationThreadsCreatedEventHandler handler) {
		handler.onStationThreadsCreated(this);
	}

	public String getStationGUID() {
		return stationGUID;
	}

	public void setStationGUID(String stationGUID) {
		this.stationGUID = stationGUID;
	}

	@Override
	public String toString() {
		return "StationDataAppliedEvent [stationGUID=" + stationGUID + "]";
	}
}
