package com.pispower.video.sdk.advertisement;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.net.HTTPJSONResponseValidator;
import com.pispower.video.sdk.util.QueryString;

class UpdateTrait {

	private static final String Tag = UpdateTrait.class.getName();

	public boolean update(String id, String name) {

		try {
			getJsonObject(id, name);

			return true;

		} catch (ParseException | HTTPJSONResponseValidException | IOException
				| JSONException e) {

			Log.e(Tag, "update fail", e);
			return false;
		}
	}

	private JSONObject getJsonObject(String id, String name)
			throws ParseException, HTTPJSONResponseValidException, IOException,
			JSONException {
		BaseClient client = new BaseClient();

		QueryString qs = new QueryString();
		qs.addParam("id", id);
		qs.addParam("name", name);

		return new HTTPJSONResponseValidator().valid(client.post(
				"/ad/update.api", qs));
	}
}
