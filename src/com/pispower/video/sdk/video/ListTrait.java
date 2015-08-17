package com.pispower.video.sdk.video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;

class ListTrait {

	private static final String TAG = ListTrait.class.getName();

	public List<VideoInfo> list(String catalogId) {

		List<VideoInfo> videoInfoList = new ArrayList<VideoInfo>();
		try {
			JSONArray jsonArray = listVideo(catalogId);
			if (jsonArray == null) {
				return videoInfoList;
			}
			if (jsonArray.length() == 0) {
				return videoInfoList;
			}
			for (int i = 0; i < jsonArray.length(); i++) {
				VideoInfo videoInfo = new VideoInfo();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				videoInfo.setId(jsonObject.getString("id"));
				String fileName = jsonObject.getString("name");
				videoInfo.setName(fileName);
				// 现在restful api 中的返回不包含大小，所以设置为空字符串
				videoInfo.setSize("0");
				String status = jsonObject.getString("status");
				VideoStatus videoStatus = VideoStatus.valueOf(status
						.toUpperCase());

				videoInfo.setStatus(videoStatus.getChineseName());

				if (videoStatus == VideoStatus.AUDIT_SUCCESS) {
					Map<String, String> clarityUrlMap = new EmbedCodeTrait()
							.getVideoEmbedCode(jsonObject.getString("id"), "标准");
					videoInfo.setClarityUrlMap(clarityUrlMap);
				} else {
					videoInfo.setClarityUrlMap(null);
				}
				videoInfoList.add(videoInfo);
			}
			return videoInfoList;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	/**
	 * 获得分类下的所有视频信息
	 * 
	 * @param catalogId
	 * @return JSONArray 对象
	 * @throws JSONException
	 * @throws ParseException
	 * @throws IOException
	 * @throws org.apache.http.ParseException 
	 * @throws HTTPJSONResponseValidException 
	 */
	private JSONArray listVideo(String catalogId) throws JSONException,
			ParseException, IOException, HTTPJSONResponseValidException {
		BaseClient client = new BaseClient();
		QueryString qs = new QueryString();
		qs.addParam("catalogId", catalogId);

		JSONObject jo = client.get("/video/list.api", qs);

		if ((int) jo.getInt("statusCode") != 0) {
			Log.i(TAG, "/video/list return statusCode is not zero");
			return null;
		}
		if (jo.length() == 0) {
			Log.i(TAG, "/video/list return json is empty");
			return null;
		}
		JSONArray jsonArrayVideos = jo.getJSONArray("videos");
		return jsonArrayVideos;
	}
}