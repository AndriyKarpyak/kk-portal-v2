package com.kk.portal.client.app.ui.module.graph.flot;

import java.util.LinkedHashMap;
import java.util.Map;

import com.kk.portal.client.app.ui.module.graph.flot.event.StationThreadsCreatedEvent;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThread;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThreadID;
import com.kk.portal.shared.domain.model.StationHighResData;
import com.kk.portal.shared.domain.model.VariableHighResData;

public class HighResGraphData {

	private final Map<String, Map<String, GraphThread>> stationsMap = new LinkedHashMap<String, Map<String, GraphThread>>();

	private final HighResGraphEventBus eventBus;

	public HighResGraphData(HighResGraphEventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void setStationData(StationHighResData stationData) {

		for (VariableHighResData variableData : stationData.getDataElementLogs()) {

			GraphThreadID threadID = new GraphThreadID(stationData.getStationGUID(), variableData.getMappingGUID());

			if (stationsMap.containsKey(threadID.firstKey)) {

				Map<String, GraphThread> threadMap = stationsMap.get(threadID.firstKey);
				if (threadMap.containsKey(threadID.secondKey)) {
					threadMap.get(threadID.secondKey).setNewData(variableData.getTimeStamps(), variableData.getValues());
				} else {
					threadMap.put(threadID.secondKey, new GraphThread(threadID, variableData, eventBus));
				}
			} else {

				Map<String, GraphThread> threadMap = new LinkedHashMap<String, GraphThread>();
				threadMap.put(threadID.secondKey, new GraphThread(threadID, variableData, eventBus));
				stationsMap.put(threadID.firstKey, threadMap);
			}
		}

		eventBus.notifyStationThreadsCreated(new StationThreadsCreatedEvent(stationData.getStationGUID()));
	};
}
