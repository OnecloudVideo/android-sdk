//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertising.request.AdvertisingGetRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class GetTrait extends AbstractTrait {

	public GetTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public Advertising get(AdvertisingGetRequest req) throws VideoSDKException {
		return (Advertising) getHTTP("/advertise/get.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
				return (new AdvertisingCreator()).create(jo);
			}
		});
	}
}
