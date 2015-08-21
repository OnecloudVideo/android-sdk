package com.pispower.video.sdk.core;

import org.json.JSONException;
import org.json.JSONObject;

public interface TraitResponseHandler {
	Object handle(JSONObject jo) throws JSONException, VideoSDKException;
}
