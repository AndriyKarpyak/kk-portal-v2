package com.kk.portal.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetHighResStartResp {
	// {"IsCancelAvailable":false,"IsCanceled":false,"IsCompleted":false,"MethodName":null,"PercentComplete":0,"Progress":{"CurrentInterval":0,"IntervalPercent":0,"NumberOfIntervals":1},"RequestGUID":"b173873a-11d6-42f3-957c-00b222107d94","State":0}

	@JsonProperty
	public boolean IsCancelAvailable;

	@JsonProperty
	public boolean IsCanceled;

	@JsonProperty
	public boolean IsCompleted;

	@JsonProperty
	public int PercentComplete;

	@JsonProperty
	public String RequestGUID;

	@JsonProperty
	public int State;

	@Override
	public String toString() {
		return "GetHighResStartResp [IsCancelAvailable=" + IsCancelAvailable + ", IsCanceled=" + IsCanceled + ", IsCompleted=" + IsCompleted + ", PercentComplete="
				+ PercentComplete + ", RequestGUID=" + RequestGUID + ", State=" + State + "]";
	}
}
