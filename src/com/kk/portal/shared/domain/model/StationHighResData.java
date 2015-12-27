package com.kk.portal.shared.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kk.portal.shared.domain.comm.model.StationHighResDataResp;

@JsonTypeInfo(use = Id.CLASS, defaultImpl = StationHighResDataResp.class)
@JsonSubTypes({ @Type(value = StationHighResDataResp.class) })
public interface StationHighResData {

	String getStationGUID();

	void setStationGUID(String stationGUID);

	String getStationName();

	void setStationName(String stationName);

	List<VariableHighResData> getDataElementLogs();

	void setDataElementLogs(List<VariableHighResData> dataElementLogs);
}