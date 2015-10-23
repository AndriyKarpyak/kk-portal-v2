package com.kk.portal.shared.domain.comm.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kk.portal.shared.domain.model.StationHighResData;
import com.kk.portal.shared.domain.model.VariableHighResData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationHighResDataResp implements StationHighResData {

	@JsonProperty
	public String StationGUID;

	@JsonProperty
	public String StationName;

	@JsonDeserialize(as = ArrayList.class, contentAs = VariableHighResDataResp.class)
	public List<VariableHighResData> DataElementLogs;

	public String getStationGUID() {
		return StationGUID;
	}

	public void setStationGUID(String stationGUID) {
		StationGUID = stationGUID;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public List<VariableHighResData> getDataElementLogs() {
		return DataElementLogs;
	}

	public void setDataElementLogs(List<VariableHighResData> dataElementLogs) {
		DataElementLogs = dataElementLogs;
	}

	@Override
	public String toString() {
		return "StationHighResDataResp [StationGUID=" + StationGUID + ", StationName=" + StationName + ", DataElementLogs=" + DataElementLogs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataElementLogs == null) ? 0 : DataElementLogs.hashCode());
		result = prime * result + ((StationGUID == null) ? 0 : StationGUID.hashCode());
		result = prime * result + ((StationName == null) ? 0 : StationName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationHighResDataResp other = (StationHighResDataResp) obj;
		if (DataElementLogs == null) {
			if (other.DataElementLogs != null)
				return false;
		} else if (!DataElementLogs.equals(other.DataElementLogs))
			return false;
		if (StationGUID == null) {
			if (other.StationGUID != null)
				return false;
		} else if (!StationGUID.equals(other.StationGUID))
			return false;
		if (StationName == null) {
			if (other.StationName != null)
				return false;
		} else if (!StationName.equals(other.StationName))
			return false;
		return true;
	}

}
