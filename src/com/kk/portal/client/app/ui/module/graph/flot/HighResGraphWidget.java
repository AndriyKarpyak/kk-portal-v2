package com.kk.portal.client.app.ui.module.graph.flot;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.graph.flot.event.StationThreadsCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.StationThreadsCreatedEvent.StationThreadsCreatedEventHandler;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadCreatedEvent.ThreadCreatedEventHandler;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadDataUpdatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadDataUpdatedEvent.ThreadDataUpdatedEventHandler;

public class HighResGraphWidget extends Composite implements StationThreadsCreatedEventHandler, ThreadCreatedEventHandler, ThreadDataUpdatedEventHandler {

	interface HighResGraphWidgetUiBinder extends UiBinder<Widget, HighResGraphWidget> {}

	private static final HighResGraphWidgetUiBinder uiBinder = GWT.create(HighResGraphWidgetUiBinder.class);
	private static final Logger LOG = Logger.getLogger(HighResGraphEventBus.class.getName());

	private final HighResGraphEventBus eventBus;

	public HighResGraphWidget(HighResGraphEventBus eventBus) {

		this.eventBus = eventBus;

		this.eventBus.addThreadCreatedHandler(this);
		this.eventBus.addThreadDataUpdatedHandler(this);
		this.eventBus.addStationThreadsCreatedHandler(this);

		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void onStationThreadsCreated(StationThreadsCreatedEvent event) {
		LOG.info("Created all data threads for station: [" + event.getStationGUID() + "]");
	}

	@Override
	public void onThreadDataUpdated(ThreadDataUpdatedEvent event) {
		LOG.info("Updated data thread for variable: [" + event.getThreadID().secondKey + "] on station: [" + event.getThreadID().firstKey + "]");
	}

	@Override
	public void onThreadCreated(ThreadCreatedEvent event) {
		LOG.info("Created data thread for variable: [" + event.getThreadData().threadName + "] on station: [" + event.getThreadID().firstKey + "]");
	}
}
