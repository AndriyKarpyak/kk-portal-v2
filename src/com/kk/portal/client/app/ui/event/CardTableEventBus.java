package com.kk.portal.client.app.ui.event;

import java.util.logging.Logger;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;

@Singleton
public class CardTableEventBus extends SimpleEventBus {

	private static final Logger LOG = Logger.getLogger(CardTableEventBus.class.getName());

	public CardTableEventBus() {
		super();
		LOG.info(CardTableEventBus.class.getName() + " for application created.");
	}
}
