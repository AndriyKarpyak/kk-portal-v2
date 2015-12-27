package com.kk.portal.client.app.ui.module.graph.flot.thread;

import java.util.List;

import com.kk.portal.client.app.ui.module.graph.flot.HighResGraphEventBus;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.event.ThreadDataUpdatedEvent;
import com.kk.portal.shared.domain.model.VariableHighResData;

public class GraphThread {

	private final GraphThreadID threadID;

	private final GraphThreadData threadData;
	private final GraphThreadStyle threadStyle;

	private final HighResGraphEventBus eventBus;

	public GraphThread(final GraphThreadID threadID, final VariableHighResData variableData, final HighResGraphEventBus eventBus) {

		this.threadID = threadID;

		this.threadData = new GraphThreadData(
				threadID,
				variableData.getMappingName(),
				variableData.getUnits(),
				variableData.getTimeStamps(),
				variableData.getValues());

		this.threadStyle = new GraphThreadStyle(
				threadID);

		this.eventBus = eventBus;
		this.eventBus.notifyThreadCreated(new ThreadCreatedEvent(this.threadID, this.threadData, this.threadStyle));
	}

	public void setNewData(final List<String> timeStamps, final List<Double> values) {
		threadData.setNewData(timeStamps, values);
		eventBus.notifyThreadDataUpdated(new ThreadDataUpdatedEvent(threadID, timeStamps, values));
	}
}
