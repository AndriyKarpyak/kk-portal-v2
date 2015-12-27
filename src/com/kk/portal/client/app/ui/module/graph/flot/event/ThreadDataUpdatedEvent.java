package com.kk.portal.client.app.ui.module.graph.flot.event;

import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThreadID;

public class ThreadDataUpdatedEvent extends GwtEvent<ThreadDataUpdatedEvent.ThreadDataUpdatedEventHandler> {

	public interface ThreadDataUpdatedEventHandler extends EventHandler {
		void onThreadDataUpdated(ThreadDataUpdatedEvent event);
	}

	public static Type<ThreadDataUpdatedEventHandler> TYPE = new Type<ThreadDataUpdatedEvent.ThreadDataUpdatedEventHandler>();

	private final GraphThreadID threadID;
	private final List<String> timeStamps;
	private final List<Double> values;

	public ThreadDataUpdatedEvent(final GraphThreadID threadID, final List<String> timeStamps, final List<Double> values) {
		super();
		this.threadID = threadID;
		this.timeStamps = timeStamps;
		this.values = values;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ThreadDataUpdatedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final ThreadDataUpdatedEventHandler handler) {
		handler.onThreadDataUpdated(this);
	}

	public GraphThreadID getThreadID() {
		return threadID;
	}

	public List<String> getTimeStamps() {
		return timeStamps;
	}

	public List<Double> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return "ThreadDataUpdatedEvent [threadID=" + threadID + ", timeStamps=" + timeStamps + ", values=" + values + "]";
	}
}
