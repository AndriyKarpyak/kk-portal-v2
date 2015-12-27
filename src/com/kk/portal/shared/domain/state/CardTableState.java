package com.kk.portal.shared.domain.state;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardTableState {

	@JsonProperty
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
