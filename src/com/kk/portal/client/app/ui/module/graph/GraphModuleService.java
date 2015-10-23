package com.kk.portal.client.app.ui.module.graph;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.kk.portal.client.app.comm.WebServiceCommunicationInterface;
import com.kk.portal.client.app.ui.module.ModuleService;
import com.kk.portal.shared.domain.comm.model.StationHighResDataResp;

public class GraphModuleService implements ModuleService {

	private static final Logger LOG = Logger.getLogger(GraphModuleService.class.getName());

	@Inject
	WebServiceCommunicationInterface comm;

	@Override
	public void initEventSubscriptions() {
	}

	public void requestHihgResData(final MethodCallback<StationHighResDataResp> callback) {
		LOG.info("Requesting high resolution data.");
		comm.getHighResData(new MethodCallback<StationHighResDataResp>() {

			@Override
			public void onSuccess(final Method method, final StationHighResDataResp response) {
				LOG.info("Rseived responce with content: " + response.toString());
				callback.onSuccess(method, response);
			}

			@Override
			public void onFailure(final Method method, final Throwable exception) {
				LOG.log(Level.SEVERE, exception.getMessage(), exception);
				callback.onFailure(method, exception);
			}
		});
	}
}
