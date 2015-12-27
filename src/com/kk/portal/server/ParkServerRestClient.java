package com.kk.portal.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kk.portal.shared.domain.comm.model.StationHighResDataResp;
import com.kk.portal.shared.domain.comm.model.VariableHighResDataResp;
import com.kk.portal.shared.domain.model.StationHighResData;
import com.kk.portal.shared.domain.model.VariableHighResData;

public class ParkServerRestClient {

	Client client = ClientBuilder.newClient();
	String getStartUrl = "http://10.20.131.11:8732/ParkServices/ParkService/JSON/GetDataElementFastLogBegin?stationGUID=67dd1cd1-d551-4087-9ac1-fb74a4277d97&function=0&MappingGUID=1c855de9-75d7-425c-a8ef-3974385a2358&resolution=250&LocalizationGUID=5efb93a5-b04c-4f82-b8b8-4c80a13f9dfb&startTime=2015-10-20+08%3A24%3A00&userkey=token&endTime=2015-10-20+09%3A23%3A12&FunctionList=2";
	String getEndUrl = "http://10.20.131.11:8732/ParkServices/ParkService/JSON/GetDataElementFastLogEnd?stationGUID=67dd1cd1-d551-4087-9ac1-fb74a4277d97&function=0&MappingGUID=1c855de9-75d7-425c-a8ef-3974385a2358&userkey=token&FunctionList=0&localizationGUID=5efb93a5-b04c-4f82-b8b8-4c80a13f9dfb&RequestGUID=";

	public List<StationHighResData> get() {

		return mockResult();
		
//		WebTarget target = client.target(getStartUrl);
//		Response response = target.request(MediaType.APPLICATION_JSON).get();
//		ParkResponseEntry<GetHighResStartResp> startResponse = response.readEntity(new GenericType<ParkResponseEntry<GetHighResStartResp>>() {});
//
//		target = client.target(getEndUrl + startResponse.Result.RequestGUID);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		response = target.request(MediaType.APPLICATION_JSON).get();
//		ParkResponseList<StationHighResData> readEntity = response.readEntity(new GenericType<ParkResponseList<StationHighResData>>() {});
//
//		return readEntity.Result;
	}

	private List<StationHighResData> mockResult() {
		List<StationHighResData> mockedResult = new ArrayList<StationHighResData>();
		
		StationHighResData mockedStationHighResData = new StationHighResDataResp();
		
		mockedStationHighResData.setStationGUID("67dd1cd1-d551-4087-9ac1-fb74a4277d97");
		mockedStationHighResData.setStationName("Mocked Station");
		
		List<VariableHighResData> mockedVariableHighResDataList = new ArrayList<VariableHighResData>();
		
		VariableHighResData mockedVariableHighResData = new VariableHighResDataResp();
		
		mockedVariableHighResData.setMappingGUID("1c855de9-75d7-425c-a8ef-3974385a2358");
		mockedVariableHighResData.setMappingName("Mocked wind speed");
		mockedVariableHighResData.setUnits("m/s");
		mockedVariableHighResData.setTotalValues(10);
		mockedVariableHighResData.setTimeStamps(createMockedTimeStamps());
		mockedVariableHighResData.setValues(createMockedValues());
		
		mockedVariableHighResDataList.add(mockedVariableHighResData);
		
		mockedStationHighResData.setDataElementLogs(mockedVariableHighResDataList);
		
		mockedResult.add(mockedStationHighResData);
		return mockedResult;
	}

	private List<Double> createMockedValues() {
		List<Double> res = new ArrayList<Double>();
		res.add(0.);
		res.add(0.5);
		res.add(1.);
		res.add(1.5);
		res.add(2.);
		res.add(2.5);
		res.add(3.);
		return res;
	}

	private List<String> createMockedTimeStamps() {
		List<String> res = new ArrayList<String>();
		res.add("2015-10-20 10:00:00");
		res.add("2015-10-20 10:00:10");
		res.add("2015-10-20 10:00:20");
		res.add("2015-10-20 10:00:30");
		res.add("2015-10-20 10:00:40");
		res.add("2015-10-20 10:00:50");
		res.add("2015-10-20 10:00:60");
		return res;
	}
}
