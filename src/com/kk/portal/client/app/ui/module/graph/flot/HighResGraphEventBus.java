package com.kk.portal.client.app.ui.module.graph.flot;

import java.util.logging.Logger;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.kk.portal.client.app.ui.module.graph.flot.event.StationThreadsCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadDataUpdatedEvent;

public class HighResGraphEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(HighResGraphEventBus.class.getName());

	public HighResGraphEventBus() {
		super();
		LOG.info("High Res Graph Module EventBus created.");
	}

	public HandlerRegistration addThreadDataUpdatedHandler(final ThreadDataUpdatedEvent.ThreadDataUpdatedEventHandler handler) {
		return addHandler(ThreadDataUpdatedEvent.class, ThreadDataUpdatedEvent.TYPE, handler);
	}

	public void notifyThreadDataUpdated(ThreadDataUpdatedEvent event) {
		fireEvent(event);
	}

	public HandlerRegistration addThreadCreatedHandler(final ThreadCreatedEvent.ThreadCreatedEventHandler handler) {
		return addHandler(ThreadCreatedEvent.class, ThreadCreatedEvent.TYPE, handler);
	}

	public void notifyThreadCreated(ThreadCreatedEvent event) {
		fireEvent(event);
	}

	public HandlerRegistration addStationThreadsCreatedHandler(final StationThreadsCreatedEvent.StationThreadsCreatedEventHandler handler) {
		return addHandler(StationThreadsCreatedEvent.class, StationThreadsCreatedEvent.TYPE, handler);
	}

	public void notifyStationThreadsCreated(StationThreadsCreatedEvent event) {
		fireEvent(event);
	}

	private <H extends EventHandler> com.google.gwt.event.shared.HandlerRegistration addHandler(Class<?> event, GwtEvent.Type<H> type, H handler) {
		LOG.info("Added event handler: [" + handler.getClass().getName() + "] for " + event.getName());
		return addHandler(type, handler);
	}
}
