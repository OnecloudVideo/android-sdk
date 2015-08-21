package com.pispower.video.sdk.advertisement;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertisement.request.AdvertisementDeleteRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class DeleteTrait extends AbstractTrait {

	public DeleteTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public String delete(AdvertisementDeleteRequest req) throws VideoSDKException {
		return (String) postHTTP("/ad/delete.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
				return jo.getString("message");
			}
		});
	}
}
