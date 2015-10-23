package com.kk.portal.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kk.portal.shared.domain.comm.req.LoginReq;
import com.kk.portal.shared.domain.comm.resp.LoginResp;
import com.kk.portal.shared.domain.comm.resp.LoginRespErr;
import com.kk.portal.shared.domain.comm.resp.UIStateResp;
import com.kk.portal.shared.domain.model.StationHighResData;
import com.kk.portal.shared.domain.state.CardTableState;
import com.kk.portal.shared.domain.state.TabBarState;

@Path("comm")
@Produces(MediaType.APPLICATION_JSON)
public class WebServiceCommunicationTarget {

	@POST
	@Path("/Login")
	public LoginResp Login(LoginReq req) {

		LoginResp resp = new LoginResp();

		if ("1".equals(req.getPassword())) {
			resp.setUsername(req.getUsername());
			resp.setLoggedin(false);
		} else {
			LoginRespErr error = new LoginRespErr();
			error.setErrorText("Incorrect username/password.");
			resp.setError(error);
		}

		return resp;
	}

	@GET
	@Path("/GetTabBarState")
	public UIStateResp<TabBarState> GetTabBarState() {

		UIStateResp<TabBarState> resp = new UIStateResp<TabBarState>();

		TabBarState state = new TabBarState();

		List<String> tabsNames = new ArrayList<String>();
		tabsNames.add("Empty tab");
		tabsNames.add("Drag and drop");
		tabsNames.add("Graph excample");

		state.setTabs(tabsNames);

		state.setSelectedIndex(1);

		resp.setState(state);

		return resp;
	}

	@GET
	@Path("/GetCardTableState/{table}")
	public UIStateResp<CardTableState> GetCardTableState(@PathParam("table") Integer deckIndex) {
		UIStateResp<CardTableState> resp = new UIStateResp<CardTableState>();

		CardTableState state = new CardTableState();
		state.setText("Hello! I'm dummy card table " + deckIndex + ".");

		resp.setState(state);

		return resp;
	}

	@GET
	@Path("/GetHighResData")
	public StationHighResData getHighResData() {
		
		System.out.println("Requesting High res data!!!");
		
		ParkServerRestClient client = new ParkServerRestClient();
		List<StationHighResData> list = client.get();

		return list.get(0);
	}
}
