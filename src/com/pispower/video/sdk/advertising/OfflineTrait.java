//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertising.request.AdvertisingOfflineRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class OfflineTrait extends AbstractTrait {

    public OfflineTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public String offline(AdvertisingOfflineRequest req) throws VideoSDKException {
		return (String) postHTTP("/advertise/offline.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
				return jo.getString("message");
			}
		});
	}
}
