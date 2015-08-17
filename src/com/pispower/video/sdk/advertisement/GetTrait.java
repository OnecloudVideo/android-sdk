package com.pispower.video.sdk.advertisement;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;

class GetTrait {

	private static final String Tag = GetTrait.class.getName();

	public Advertisement get(String id) {
		try {
			JSONObject jo = getJsonObject(id);
			return new AdvertisementCreator().create(jo);

		} catch (ParseException | JSONException | IOException
				| HTTPJSONResponseValidException e) {
			Log.i(Tag, e.getMessage());
			return null;
		}
	}

	/**
	 * 获得指定的广告
	 * 
	 * @param id
	 * @return JSONObject 对象
	 * @throws JSONException
	 * @throws ParseException
	 * @throws IOException
	 * @throws HTTPJSONResponseValidException
	 */
	private JSONObject getJsonObject(String id) throws JSONException,
			ParseException, IOException, HTTPJSONResponseValidException {
		BaseClient client = new BaseClient();
		QueryString queryString = new QueryString();
		queryString.addParam("id", id);

		return client.get("/ad/get.api", queryString);
	}
}
