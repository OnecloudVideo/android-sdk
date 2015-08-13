package com.pispower.video.sdk.advertisement;

import org.json.JSONException;
import org.json.JSONObject;

class AdvertisementCreator {

	public Advertisement create(JSONObject jo) throws JSONException {
		Advertisement ad = new Advertisement();
		ad.setId(jo.getString("id"));
		
		ad.setName(jo.getString("name"));
		
		ad.setSize(jo.getLong("size"));
		ad.setDuration(jo.getLong("duration"));
		
		ad.setCode(jo.getString("code"));
		ad.setStatus(AdvertisementStatus.valueOf(jo.getString("status")));
		
		return ad;
	}
	
}
