//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertising.request.AdvertisingAddRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class AddTrait extends AbstractTrait{

	public AddTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public Advertising add(AdvertisingAddRequest req) throws VideoSDKException {
		return (Advertising) postHTTP("/advertise/add.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
				return new AdvertisingCreator().create(jo);
			}
		});
	}
}
