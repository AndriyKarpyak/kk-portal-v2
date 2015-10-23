package com.kk.portal.server;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkResponseList<T> {

	@JsonDeserialize(as = ArrayList.class)
	public List<T> Result;

	@JsonProperty
	public int TotalResults;

	@Override
	public String toString() {
		return "ParkResponseList [Result=" + Result + ", TotalResults=" + TotalResults + "]";
	}
}
