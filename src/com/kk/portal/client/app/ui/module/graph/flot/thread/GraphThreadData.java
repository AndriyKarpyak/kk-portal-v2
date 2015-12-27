package com.kk.portal.client.app.ui.module.graph.flot.thread;

import java.util.List;

public class GraphThreadData {

	public final GraphThreadID threadID;
	public final String threadName;
	public final String threadUnit;
	public final List<String> TimeStamps;
	public final List<Double> Values;

	GraphThreadData(final GraphThreadID threadID, final String threadName, final String threadUnit, final List<String> timeStamps, final List<Double> values) {
		super();
		this.threadID = threadID;
		this.threadName = threadName;
		this.threadUnit = threadUnit;
		this.TimeStamps = timeStamps;
		this.Values = values;
	}

	void setNewData(List<String> timeStamps, List<Double> values) {
		TimeStamps.clear();
		TimeStamps.addAll(timeStamps);

		Values.clear();
		Values.addAll(values);
	}

	@Override
	public String toString() {
		return "GraphThreadData [threadID=" + threadID + ", threadName=" + threadName + ", threadUnit=" + threadUnit + ", TimeStamps=" + TimeStamps + ", Values=" + Values + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TimeStamps == null) ? 0 : TimeStamps.hashCode());
		result = prime * result + ((Values == null) ? 0 : Values.hashCode());
		result = prime * result + ((threadID == null) ? 0 : threadID.hashCode());
		result = prime * result + ((threadName == null) ? 0 : threadName.hashCode());
		result = prime * result + ((threadUnit == null) ? 0 : threadUnit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphThreadData other = (GraphThreadData) obj;
		if (TimeStamps == null) {
			if (other.TimeStamps != null)
				return false;
		} else if (!TimeStamps.equals(other.TimeStamps))
			return false;
		if (Values == null) {
			if (other.Values != null)
				return false;
		} else if (!Values.equals(other.Values))
			return false;
		if (threadID == null) {
			if (other.threadID != null)
				return false;
		} else if (!threadID.equals(other.threadID))
			return false;
		if (threadName == null) {
			if (other.threadName != null)
				return false;
		} else if (!threadName.equals(other.threadName))
			return false;
		if (threadUnit == null) {
			if (other.threadUnit != null)
				return false;
		} else if (!threadUnit.equals(other.threadUnit))
			return false;
		return true;
	}
}
