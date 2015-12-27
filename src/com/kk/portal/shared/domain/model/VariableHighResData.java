package com.kk.portal.shared.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kk.portal.shared.domain.comm.model.VariableHighResDataResp;

@JsonTypeInfo(use = Id.CLASS, defaultImpl = VariableHighResDataResp.class)
@JsonSubTypes({ @Type(value = VariableHighResDataResp.class) })
public interface VariableHighResData {

	String getMappingGUID();

	void setMappingGUID(String mappingGUID);

	String getMappingName();

	void setMappingName(String mappingName);

	String getUnits();

	void setUnits(String units);

	int getTotalValues();

	void setTotalValues(int totalValues);

	List<String> getTimeStamps();

	void setTimeStamps(List<String> timeStamps);

	List<Double> getValues();

	void setValues(List<Double> values);
}
