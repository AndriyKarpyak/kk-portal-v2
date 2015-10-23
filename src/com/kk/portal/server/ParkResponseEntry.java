package com.kk.portal.server;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ParkResponseEntry<T> {

	@JsonDeserialize(as = ArrayList.class, contentAs = String.class)
	public List<String> Errors;

	@JsonProperty
	public T Result;

	@Override
	public String toString() {
		return "ParkResponse [Errors=" + Errors + ", Result=" + Result + "]";
	}
}
