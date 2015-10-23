package com.kk.portal.server;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kk.portal.shared.domain.model.StationHighResData;

public class ParkServerRestClient {

	Client client = ClientBuilder.newClient();
	String getStartUrl = "http://10.20.131.11:8732/ParkServices/ParkService/JSON/GetDataElementFastLogBegin?stationGUID=67dd1cd1-d551-4087-9ac1-fb74a4277d97&function=0&MappingGUID=1c855de9-75d7-425c-a8ef-3974385a2358&resolution=250&LocalizationGUID=5efb93a5-b04c-4f82-b8b8-4c80a13f9dfb&startTime=2015-10-20+08%3A24%3A00&userkey=token&endTime=2015-10-20+09%3A23%3A12&FunctionList=2";
	String getEndUrl = "http://10.20.131.11:8732/ParkServices/ParkService/JSON/GetDataElementFastLogEnd?stationGUID=67dd1cd1-d551-4087-9ac1-fb74a4277d97&function=0&MappingGUID=1c855de9-75d7-425c-a8ef-3974385a2358&userkey=token&FunctionList=0&localizationGUID=5efb93a5-b04c-4f82-b8b8-4c80a13f9dfb&RequestGUID=";

	public List<StationHighResData> get() {

		WebTarget target = client.target(getStartUrl);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		ParkResponseEntry<GetHighResStartResp> startResponse = response.readEntity(new GenericType<ParkResponseEntry<GetHighResStartResp>>() {});

		target = client.target(getEndUrl + startResponse.Result.RequestGUID);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = target.request(MediaType.APPLICATION_JSON).get();
		ParkResponseList<StationHighResData> readEntity = response.readEntity(new GenericType<ParkResponseList<StationHighResData>>() {});

		return readEntity.Result;
	}
}
