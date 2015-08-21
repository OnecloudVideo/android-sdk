//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.advertising.request.AdvertisingListRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class ListTrait extends AbstractTrait {

    public ListTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	@SuppressWarnings("unchecked")
	public List<Advertising> list(AdvertisingListRequest req) throws VideoSDKException {
		
		return ((List<Advertising>) getHTTP("/advertise/list.api", req, new TraitResponseHandler() {
			
			@Override
			public Object handle(JSONObject jo) throws JSONException, VideoSDKException {
		            JSONArray joArr = jo.getJSONArray("advertiseList");
		            List<Advertising> advertisings = new ArrayList<Advertising>();

		            for(int i = 0; i < joArr.length(); ++i) {
		                advertisings.add((new AdvertisingCreator()).create(joArr.getJSONObject(i)));
		            }

		            return advertisings;
			}
		}));
	}
}
