package com.pispower.video.sdk.video;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.util.QueryString;

class EmbedCodeTrait {

	private static final String TAG = EmbedCodeTrait.class.getName();

	/**
	 * 获取指定视频指定的分配率的EmbedCode
	 * 
	 * @param videoId
	 * @param clarity
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 * @throws IOException
	 */
	public Map<String, String> getVideoEmbedCode(String videoId, String clarity)
			throws JSONException, ParseException, IOException {
		Map<String, String> clarityUrlMap = new HashMap<String, String>();

		BaseClient client = new BaseClient();
		QueryString qs = new QueryString();
		qs.addParam("videoId", videoId);
		JSONObject jo;

		jo = client.get("/video/get.api", qs);

		if ((int) jo.getInt("statusCode") != 0) {
			Log.i(TAG, "/video/get.api return statusCode is not zero");
			return clarityUrlMap;
		}
		if (jo.length() == 0) {
			Log.i(TAG, "/video/get.api return json is empty");
			return clarityUrlMap;
		}
		JSONArray jsonArrayVideoCodes = jo.getJSONArray("embedCodes");
		int embedCodesNums = jsonArrayVideoCodes.length();
		if (embedCodesNums == 0) {
			Log.i(TAG, "embedCodes is empty");
			return clarityUrlMap;
		}

		for (int i = 0; i < embedCodesNums; i++) {
			JSONObject embedCodeJO = jsonArrayVideoCodes.getJSONObject(i);
			String clarityName = embedCodeJO.getString("clarity");
			String android_IOS_embedCode = embedCodeJO.getString("html5Code");
			String remoteUrl = getUrlFromEmbedCode(android_IOS_embedCode);
			clarityUrlMap.put(clarityName, remoteUrl);
		}

		return clarityUrlMap;
	}


	/**
	 * 从EmbedCode中获得url
	 * 
	 * @param embedCode
	 * @return 字符串
	 */
	private String getUrlFromEmbedCode(String embedCode) {
		if (embedCode == null) {
			return null;
		}
		Pattern p = Pattern.compile("src='http:[\\w/\\.]+'");
		Matcher m = p.matcher(embedCode);
		if (m.find()) {
			String src = m.group();
			src = src.substring(5, src.length() - 1);
			return src;
		}
		return null;
	}
}
