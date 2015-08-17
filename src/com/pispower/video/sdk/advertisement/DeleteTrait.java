package com.pispower.video.sdk.advertisement;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;

class DeleteTrait {

	private static final String Tag = DeleteTrait.class.getName();

	public boolean delete(String id) {

		try {
			getResponseJSON(id);
			return true;
		} catch (ParseException | HTTPJSONResponseValidException | IOException
				| JSONException e) {

			Log.e(Tag, "delete fail", e);
			return false;
		}
	}

	private JSONObject getResponseJSON(String id) throws ParseException,
			HTTPJSONResponseValidException, IOException, JSONException {
		BaseClient client = new BaseClient();

		QueryString qs = new QueryString();
		qs.addParam("id", id);

		return client.post("/ad/delete.api", qs);
	}
}
