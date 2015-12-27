package com.kk.portal.client.app.ui.module.graph.event;

import java.util.logging.Logger;

import com.google.gwt.event.shared.SimpleEventBus;

public class GraphModuleEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(GraphModuleEventBus.class.getName());

	public GraphModuleEventBus() {
		super();
		LOG.info(GraphModuleEventBus.class.getName() + " for Graph Module  instance created.");
	}
}
