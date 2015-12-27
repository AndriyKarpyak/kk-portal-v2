package com.kk.portal.client.app.ui.module.graph.flot.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThreadData;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThreadID;
import com.kk.portal.client.app.ui.module.graph.flot.thread.GraphThreadStyle;

public class ThreadCreatedEvent extends GwtEvent<ThreadCreatedEvent.ThreadCreatedEventHandler> {

	public interface ThreadCreatedEventHandler extends EventHandler {
		void onThreadCreated(ThreadCreatedEvent event);
	}

	public static Type<ThreadCreatedEventHandler> TYPE = new Type<ThreadCreatedEvent.ThreadCreatedEventHandler>();

	private final GraphThreadID threadID;
	private final GraphThreadData threadData;
	private final GraphThreadStyle threadStyle;

	public ThreadCreatedEvent(final GraphThreadID threadID, final GraphThreadData threadData, final GraphThreadStyle threadStyle) {
		super();
		this.threadID = threadID;
		this.threadData = threadData;
		this.threadStyle = threadStyle;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ThreadCreatedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final ThreadCreatedEventHandler handler) {
		handler.onThreadCreated(this);
	}

	public GraphThreadID getThreadID() {
		return threadID;
	}

	public GraphThreadData getThreadData() {
		return threadData;
	}

	public GraphThreadStyle getThreadStyle() {
		return threadStyle;
	}

	@Override
	public String toString() {
		return "ThreadDataCreatedEvent [threadID=" + threadID + ", threadData=" + threadData + ", threadStyle=" + threadStyle + "]";
	}
}
