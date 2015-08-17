package com.pispower.video.sdk.net;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HTTPJSONResponseValidator {

	private static final String Tag = HTTPJSONResponseValidator.class.getName();

	public JSONObject valid(JSONObject json)
			throws HTTPJSONResponseValidException {

		if (0 == json.length()) {
			Log.i(Tag, "return json is empty");

			throw new HTTPJSONResponseValidException("emtpy json");
		}

		int code;
		try {
			code = json.getInt("statusCode");
		} catch (JSONException e) {
			throw new HTTPJSONResponseValidException("illegal property");
		}

		if (0 != code) {
			Log.i(Tag, "statusCode is not zero");

			throw new HTTPJSONResponseValidException("error code " + code);
		}

		return json;
	}
}