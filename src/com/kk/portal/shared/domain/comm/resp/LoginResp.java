package com.kk.portal.shared.domain.comm.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kk.portal.shared.domain.comm.Resp;

public class LoginResp extends Resp<LoginRespErr> {
	
	@JsonProperty
	private String username;

	@JsonProperty
	private boolean loggedin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
}
