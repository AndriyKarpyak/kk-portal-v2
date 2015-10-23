package com.kk.portal.shared.domain.comm.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kk.portal.shared.domain.model.VariableHighResData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableHighResDataResp implements VariableHighResData {

	@JsonProperty
	public String MappingGUID;

	@JsonProperty
	public String MappingName;

	@JsonProperty
	public String Units;

	@JsonProperty
	public int TotalValues;

	@JsonDeserialize(as = ArrayList.class)
	public List<String> TimeStamps;

	@JsonDeserialize(as = ArrayList.class)
	public List<Double> Values;

	public String getMappingGUID() {
		return MappingGUID;
	}

	public void setMappingGUID(String mappingGUID) {
		MappingGUID = mappingGUID;
	}

	public String getMappingName() {
		return MappingName;
	}

	public void setMappingName(String mappingName) {
		MappingName = mappingName;
	}

	public String getUnits() {
		return Units;
	}

	public void setUnits(String units) {
		Units = units;
	}

	public int getTotalValues() {
		return TotalValues;
	}

	public void setTotalValues(int totalValues) {
		TotalValues = totalValues;
	}

	public List<String> getTimeStamps() {
		return TimeStamps;
	}

	public void setTimeStamps(List<String> timeStamps) {
		TimeStamps = timeStamps;
	}

	public List<Double> getValues() {
		return Values;
	}

	public void setValues(List<Double> values) {
		Values = values;
	}

	@Override
	public String toString() {
		return "VariableHighResData [MappingGUID=" + MappingGUID + ", MappingName=" + MappingName + ", Units=" + Units + ", TotalValues=" + TotalValues + ", TimeStamps="
				+ TimeStamps + ", Values=" + Values + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MappingGUID == null) ? 0 : MappingGUID.hashCode());
		result = prime * result + ((MappingName == null) ? 0 : MappingName.hashCode());
		result = prime * result + ((TimeStamps == null) ? 0 : TimeStamps.hashCode());
		result = prime * result + TotalValues;
		result = prime * result + ((Units == null) ? 0 : Units.hashCode());
		result = prime * result + ((Values == null) ? 0 : Values.hashCode());
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
		VariableHighResDataResp other = (VariableHighResDataResp) obj;
		if (MappingGUID == null) {
			if (other.MappingGUID != null)
				return false;
		} else if (!MappingGUID.equals(other.MappingGUID))
			return false;
		if (MappingName == null) {
			if (other.MappingName != null)
				return false;
		} else if (!MappingName.equals(other.MappingName))
			return false;
		if (TimeStamps == null) {
			if (other.TimeStamps != null)
				return false;
		} else if (!TimeStamps.equals(other.TimeStamps))
			return false;
		if (TotalValues != other.TotalValues)
			return false;
		if (Units == null) {
			if (other.Units != null)
				return false;
		} else if (!Units.equals(other.Units))
			return false;
		if (Values == null) {
			if (other.Values != null)
				return false;
		} else if (!Values.equals(other.Values))
			return false;
		return true;
	}
}
