package com.kk.portal.client.app.comm;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.google.inject.Singleton;
import com.kk.portal.shared.domain.comm.model.StationHighResDataResp;
import com.kk.portal.shared.domain.comm.req.LoginReq;
import com.kk.portal.shared.domain.comm.resp.LoginResp;
import com.kk.portal.shared.domain.comm.resp.UIStateResp;
import com.kk.portal.shared.domain.state.CardTableState;
import com.kk.portal.shared.domain.state.TabBarState;

@Singleton
@Path("/api/comm")
public interface WebServiceCommunicationInterface extends RestService {

	@POST
	@Path("/Login")
	public void login(LoginReq login, MethodCallback<LoginResp> callback);

	@GET
	@Path("/GetTabBarState")
	public void getTabBarState(MethodCallback<UIStateResp<TabBarState>> callback);

	@GET
	@Path("/GetCardTableState/{table}")
	public void getCardTableState(@PathParam("table") Integer deckIndex, MethodCallback<UIStateResp<CardTableState>> callback);
	
	@GET
	@Path("/GetHighResData")
	public void getHighResData(MethodCallback<StationHighResDataResp> callback);
}