//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertising.request.AdvertisingDeleteRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class DeleteTrait extends AbstractTrait {

    public DeleteTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public String delete(AdvertisingDeleteRequest req) throws VideoSDKException {
		return (String) postHTTP("/advertise/delete.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
				return jo.getString("message");
			}
		});
	}
}
