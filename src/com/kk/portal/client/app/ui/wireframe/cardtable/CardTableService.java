package com.kk.portal.client.app.ui.wireframe.cardtable;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.comm.WebServiceCommunicationInterface;
import com.kk.portal.client.app.ui.event.WorkspaceEventBus;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent;
import com.kk.portal.client.app.ui.event.ws.CardTableStateRequestEvent.CardTableStateRequestEventHandler;
import com.kk.portal.client.app.ui.wireframe.FrameService;
import com.kk.portal.shared.domain.comm.resp.UIStateResp;
import com.kk.portal.shared.domain.state.CardTableState;

@Singleton
public class CardTableService implements FrameService, CardTableStateRequestEventHandler {

	private static final Logger LOG = Logger.getLogger(CardTableService.class.getName());

	@Inject
	WebServiceCommunicationInterface comm;

	@Inject
	WorkspaceEventBus wsBus;

	@Override
	public void initEventSubscriptions() {
		wsBus.addCardTableStateRequestHandler(this);
	}

	@Override
	public void onStateRequest(CardTableStateRequestEvent event) {
		LOG.info("Requesting cards for tab index " + event.getStateIndex() + ".");

		comm.getCardTableState(event.getStateIndex(), new MethodCallback<UIStateResp<CardTableState>>() {

			@Override
			public void onSuccess(Method method, UIStateResp<CardTableState> response) {
				LOG.info("Received cards.");
				wsBus.notifyCardTableStateReceived(response.getState());
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				LOG.log(Level.SEVERE, method.getResponse().getHeadersAsString(), exception);
			}
		});

	}

}
