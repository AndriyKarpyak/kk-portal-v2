package com.kk.portal.shared.domain.comm.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kk.portal.shared.domain.comm.Resp;

public class UIStateResp<T> extends Resp<UIStateRespErr> {

	@JsonProperty
	private T state;

	public T getState() {
		return state;
	}

	public void setState(T state) {
		this.state = state;
	}
}
