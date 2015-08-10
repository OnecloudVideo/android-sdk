package com.pispower.video.sdk;

import com.pispower.video.sdk.catalog.CatalogService;
import com.pispower.video.sdk.multipart.MultipartService;
import com.pispower.video.sdk.video.VideoService;

public class VideoSDK {
	
	public static CatalogService getCatalogService() {
		return new CatalogService();
	}
	
	public static VideoService getVideoService() {
		return new VideoService();
	}

	public static MultipartService getMultipartService() {
		return new MultipartService();
	}
}