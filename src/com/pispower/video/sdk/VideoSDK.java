package com.pispower.video.sdk;

import com.pispower.video.sdk.advertisement.AdvertisementService;
import com.pispower.video.sdk.catalog.CatalogService;
import com.pispower.video.sdk.multipart.MultipartService;
import com.pispower.video.sdk.video.VideoService;

/**
 * 
 * VideoSDK give the unique interface to access business services. 
 * 
 * @author ftguang
 *
 */
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
	
	public static AdvertisementService getAdvertisementService() {
		return new AdvertisementService();
	}
}