package com.pispower.video.sdk.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;
import com.pispower.video.sdk.video.request.VideoEmbedCodeRequest;
import com.pispower.video.sdk.video.request.VideoListRequest;

class ListTrait extends AbstractTrait {

	public ListTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	@SuppressWarnings("unchecked")
	public List<VideoInfo> list(VideoListRequest req) throws VideoSDKException {

		return (List<VideoInfo>) getHTTP("/video/list.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException,
							VideoSDKException {

						JSONArray jsonArray = jo.getJSONArray("videos");
						List<VideoInfo> videoInfoList = new ArrayList<VideoInfo>();

						for (int i = 0; i < jsonArray.length(); i++) {
							VideoInfo videoInfo = new VideoInfo();
							JSONObject jsonObject = jsonArray.getJSONObject(i);
							videoInfo.setId(jsonObject.getString("id"));
							String fileName = jsonObject.getString("name");
							videoInfo.setName(fileName);
							// 现在restful api 中的返回不包含大小，所以设置为空字符串
							videoInfo.setSize("0");
							String status = jsonObject.getString("status");
							VideoStatus videoStatus = VideoStatus
									.valueOf(status.toUpperCase());

							videoInfo.setStatus(videoStatus.getChineseName());

							if (videoStatus == VideoStatus.AUDIT_SUCCESS) {
								Map<String, String> clarityUrlMap = new EmbedCodeTrait(
										getAccessKey(), getAccessSecret())
										.getVideoEmbedCode(new VideoEmbedCodeRequest(
												jsonObject.getString("id"),
												"标准"));
								videoInfo.setClarityUrlMap(clarityUrlMap);
							} else {
								videoInfo.setClarityUrlMap(null);
							}
							videoInfoList.add(videoInfo);
						}
						return videoInfoList;
					}
				});

	}
}