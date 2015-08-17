package com.pispower.video.sdk.advertisement;

import java.io.File;
import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;

class UploadTrait {

	private static final String Tag = UploadTrait.class.getName();

	public Advertisement upload(File file, String name) {

		try {
			return new AdvertisementCreator()
					.create(getResponseJson(file, name));
		} catch (ParseException | JSONException
				| HTTPJSONResponseValidException | IOException e) {

			Log.e(Tag, "upload fail", e);
			return null;
		}
	}

	private JSONObject getResponseJson(File file, String name)
			throws ParseException, HTTPJSONResponseValidException, IOException,
			JSONException {

		BaseClient client = new BaseClient();

		QueryString qs = new QueryString();
		if (null != name) {
			qs.addParam("name", name);
		}

		return client.postFile("/ad/upload.api", qs, file);
	}
}
