package com.pispower.video.sdk.advertisement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;

class ListTrait {

	private static final String Tag = ListTrait.class.getName();

	public List<Advertisement> list(String nameLike, int page, int maxResult) {

		try {
			List<Advertisement> advertisements = new ArrayList<>();
			JSONArray jsonArray = getJsonObject(nameLike, page, maxResult)
					.getJSONArray("ads");

			AdvertisementCreator creator = new AdvertisementCreator();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jo = jsonArray.getJSONObject(i);
				advertisements.add(creator.create(jo));
			}

			return advertisements;

		} catch (ParseException | IOException | JSONException
				| HTTPJSONResponseValidException e) {
			Log.e(Tag, e.getMessage());
			return null;
		}
	}

	private JSONObject getJsonObject(String nameLike, int page, int maxResult)
			throws ParseException, IOException, JSONException,
			HTTPJSONResponseValidException {
		BaseClient client = new BaseClient();

		QueryString qs = new QueryString();
		qs.addParam("nameLike", nameLike);
		qs.addParam("page", "" + page);
		qs.addParam("maxResult", "" + maxResult);

		return client.get("/ad/list.api", qs);
	}
}
