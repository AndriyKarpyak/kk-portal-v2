package com.kk.portal.shared.domain.comm.resp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoidResp {

	@JsonProperty
	private boolean state;

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
