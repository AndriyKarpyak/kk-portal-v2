package com.kk.portal.shared.domain.comm;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Resp<T> {

	@JsonProperty
	private T error;

	public T getError() {
		return error;
	}

	public void setError(T error) {
		this.error = error;
	}
	
	
}
