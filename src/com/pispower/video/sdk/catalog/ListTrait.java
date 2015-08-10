package com.pispower.video.sdk.catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.util.QueryString;

class ListTrait {
	
	private static final String Tag = ListTrait.class.getName();

	public List<CatalogInfo> list() {

		// 创建空的分类信息列表
		List<CatalogInfo> catalogInfos = new ArrayList<CatalogInfo>();
		try {
			// 获取所有的分类
			JSONArray catalogs = listJSON();

			if (catalogs == null) {
				return catalogInfos;
			}

			for (int i = 0; i < catalogs.length(); i++) {

				JSONObject catalog = catalogs.getJSONObject(i);
				CatalogInfo catalogInfo = new CatalogInfo();
				catalogInfo.setId(catalog.getString("id"));
				catalogInfo.setName(catalog.getString("name"));
				catalogInfo.setHoldVideoNums(new GetTrait().get(catalogInfo.getId()).getHoldVideoNums());
				
				catalogInfos.add(catalogInfo);
			}

		} catch (Exception localException) {
			Log.e(Tag, localException.getMessage());
			return null;
		}

		Log.d(Tag, "list catalogs :" + catalogInfos);
		return catalogInfos;
	}

	/**
	 * 列出所有的分类
	 * 
	 * @return JSONArray 对象
	 * @throws ParseException
	 * @throws IOException
	 * @throws JSONException
	 */
	private JSONArray listJSON() throws ParseException, IOException,
			JSONException {
		BaseClient client = this.getBaseClient();
		final QueryString queryString = new QueryString();
		final JSONObject json = client.get("/catalog/list.api", queryString);
		if (json.length() == 0) {
			Log.i(Tag, "JSONObject is empty");
			return null;
		}
		int statusCode = (int) json.getInt("statusCode");
		if (statusCode != 0) {
			Log.i(Tag, "statusCode is not zero");
			return null;
		}
		JSONArray catalogs = json.getJSONArray("catalogs");

		if (catalogs.length() == 0) {
			Log.i(Tag, "catalogs is empty");
			return null;
		}
		return catalogs;
	}

	private BaseClient getBaseClient() {
		return new BaseClient();
	}
}
