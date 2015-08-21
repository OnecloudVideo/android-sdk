package com.pispower.video.sdk.advertisement;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertisement.request.AdvertisementListRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class ListTrait extends AbstractTrait {

	public ListTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	@SuppressWarnings("unchecked")
	public List<Advertisement> list(AdvertisementListRequest req)
			throws VideoSDKException {

		return (List<Advertisement>) getHTTP("/ad/list.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException,
							VideoSDKException {
						List<Advertisement> advertisements = new ArrayList<>();
						JSONArray jsonArray = jo.getJSONArray("ads");

						AdvertisementCreator creator = new AdvertisementCreator();
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject joItem = jsonArray.getJSONObject(i);
							advertisements.add(creator.create(joItem));
						}

						return advertisements;
					}
				});
	}
}
