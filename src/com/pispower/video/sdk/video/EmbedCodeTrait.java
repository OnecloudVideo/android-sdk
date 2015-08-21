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

import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.video.request.VideoEmbedCodeRequest;

class EmbedCodeTrait extends AbstractTrait {

	public EmbedCodeTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	/**
	 * 获取指定视频指定的分配率的EmbedCode
	 * 
	 * @param parameterObject
	 *            TODO
	 * 
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 * @throws IOException
	 * @throws org.apache.http.ParseException
	 * @throws HTTPJSONResponseValidException
	 * @throws VideoSDKException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> getVideoEmbedCode(VideoEmbedCodeRequest req)
			throws VideoSDKException {

		return (Map<String, String>) getHTTP("/video/get.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException,
							VideoSDKException {
						Map<String, String> clarityUrlMap = new HashMap<String, String>();
						JSONArray jsonArrayVideoCodes = jo
								.getJSONArray("embedCodes");
						int embedCodesNums = jsonArrayVideoCodes.length();
						if (embedCodesNums == 0) {
							logI("embedCodes is empty");
							return clarityUrlMap;
						}

						for (int i = 0; i < embedCodesNums; i++) {
							JSONObject embedCodeJO = jsonArrayVideoCodes
									.getJSONObject(i);
							String clarityName = embedCodeJO
									.getString("clarity");
							String android_IOS_embedCode = embedCodeJO
									.getString("html5Code");
							String remoteUrl = getUrlFromEmbedCode(android_IOS_embedCode);
							clarityUrlMap.put(clarityName, remoteUrl);
						}

						return clarityUrlMap;
					}
				});

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
