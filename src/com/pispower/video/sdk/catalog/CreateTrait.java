package com.pispower.video.sdk.catalog;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.util.QueryString;

class CreateTrait {

	public static final String TAG = CreateTrait.class.getName();

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public CatalogInfo create(String name) {

		// 创建分类信息实例对象
		CatalogInfo catalogInfo = new CatalogInfo();
		try {
			// 创建分类通过VideoClient
			JSONObject catalogJSONObject = createCatalog(name);
			// 创建失败
			if (catalogJSONObject == null) {
				return null;
			}
			catalogInfo.setId(catalogJSONObject.getString("id"));
			catalogInfo.setName(catalogJSONObject.getString("name"));
			catalogInfo.setHoldVideoNums("0");

			catalogInfo.setLastModifiedTime(dateFormat.format(new Date()));
			return catalogInfo;
		} catch (Exception localException) {
			Log.e(TAG, localException.getMessage());
		}
		return null;
	}

	/**
	 * 创建指定的分类
	 * 
	 * @param fileName
	 * @return
	 * @throws ParseException
	 * @throws JSONException
	 * @throws IOException
	 */
	private JSONObject createCatalog(String name) throws ParseException,
			JSONException, IOException {
		BaseClient client = new BaseClient();
		QueryString qs = new QueryString();
		qs.addParam("name", name);

		JSONObject jsonObject = client.post("/catalog/create.api", qs);

		if (jsonObject.getInt("statusCode") == 0) {
			return jsonObject;
		}

		return null;
	}
}
