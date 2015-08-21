package com.pispower.video.sdk.advertisement;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertisement.request.AdvertisementGetRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class GetTrait extends AbstractTrait {

	public GetTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public Advertisement get(AdvertisementGetRequest req)
			throws VideoSDKException {

		return (Advertisement) getHTTP("/ad/get.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException,
							VideoSDKException {
						return new AdvertisementCreator().create(jo);
					}
				});
	}
}
