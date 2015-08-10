package com.pispower.video.sdk.video;

import java.util.List;

public class VideoService {
	public List<VideoInfo> list(String catalogId) {
		return new ListTrait().list(catalogId);
	}
}
