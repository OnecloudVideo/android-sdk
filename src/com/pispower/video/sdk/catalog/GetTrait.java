package com.pispower.video.sdk.catalog;

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
	
	public CatalogInfo get(String catalogId) {

		CatalogInfo info = new CatalogInfo();
		info.setId(catalogId);
		
		try {
			JSONObject jo = getCatalog(catalogId);
			info.setName(jo.getString("name"));
			info.setHoldVideoNums(jo.getString("videoNumber"));
			info.setLastModifiedTime(jo.getString("lastModifiedTime"));
			
		} catch (ParseException | JSONException | IOException | HTTPJSONResponseValidException e) {
			Log.i(Tag, e.getMessage());
		}
		
		return info;
	}
	
	/**
	 * 获得指定的分类
	 * 
	 * @param catalogId
	 * @return JSONObject 对象
	 * @throws JSONException
	 * @throws ParseException
	 * @throws IOException
	 * @throws HTTPJSONResponseValidException 
	 */
	private JSONObject getCatalog(String catalogId) throws JSONException,
			ParseException, IOException, HTTPJSONResponseValidException {
		BaseClient client = new BaseClient();
		QueryString queryString = new QueryString();
		queryString.addParam("catalogId", catalogId);
		JSONObject specialCatalogJson;
		specialCatalogJson = client.get("/catalog/get.api", queryString);
		if ((int) specialCatalogJson.getInt("statusCode") != 0) {
			Log.i(Tag, "statusCode is not zero");
			return null;
		}
		if (specialCatalogJson.length() == 0) {
			Log.i(Tag, "return json is empty");
			return null;
		}
		return specialCatalogJson;
	}
}
