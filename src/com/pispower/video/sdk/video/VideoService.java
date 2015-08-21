package com.pispower.video.sdk.video;

import java.util.List;

import com.pispower.video.sdk.core.AccessPropertiesConfig;
import com.pispower.video.sdk.core.VideoSDKException;
import com.pispower.video.sdk.video.request.VideoListRequest;

public class VideoService extends AccessPropertiesConfig{
	public VideoService(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public List<VideoInfo> list(VideoListRequest req) throws VideoSDKException {
		return new ListTrait(getAccessKey(), getAccessSecret()).list(req);
	}
}
