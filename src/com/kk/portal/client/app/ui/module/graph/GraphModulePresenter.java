package com.kk.portal.client.app.ui.module.graph;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.kk.portal.client.app.ui.module.ModulePresenter;
import com.kk.portal.client.app.ui.module.graph.flot.HighResGraphData;
import com.kk.portal.client.app.ui.module.graph.flot.HighResGraphEventBus;
import com.kk.portal.client.app.ui.module.graph.flot.HighResGraphWidget;
import com.kk.portal.shared.domain.comm.model.StationHighResDataResp;

public class GraphModulePresenter extends ModulePresenter<GraphModuleView, GraphModuleService> {

	@Inject
	HighResGraphEventBus graphEventBus;
	
	private HighResGraphWidget highResGraphWidget;
	private HighResGraphData highResGraphData;
	
	@Override
	protected void initModuleComponents() {
		highResGraphData = new HighResGraphData(graphEventBus);
		highResGraphWidget = new HighResGraphWidget(graphEventBus);
	}

	@Override
	protected void initEventSubscriptions() {
		super.initEventSubscriptions();
	}
	
	public void requestHihgResData() {
		service.requestHihgResData(new MethodCallback<StationHighResDataResp>() {
			
			@Override
			public void onSuccess(final Method method, final StationHighResDataResp response) {
				highResGraphData.setStationData(response);
			}
			
			@Override
			public void onFailure(final Method method, final Throwable exception) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public Widget getHighResGraphWidget() {
		requestHihgResData();
		return highResGraphWidget;
	}


}
