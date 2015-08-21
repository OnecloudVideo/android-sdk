package com.pispower.video.sdk;

import com.pispower.video.sdk.advertisement.AdvertisementService;
import com.pispower.video.sdk.catalog.CatalogService;
import com.pispower.video.sdk.core.AccessPropertiesConfig;
import com.pispower.video.sdk.multipart.MultipartService;
import com.pispower.video.sdk.video.VideoService;

/**
 * 
 * VideoSDK give the unique interface to access business services. 
 * 
 * @author ftguang
 *
 */
public class VideoSDK extends AccessPropertiesConfig {
	
	public VideoSDK(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public CatalogService getCatalogService() {
		return new CatalogService(getAccessKey(), getAccessSecret());
	}
	
	public VideoService getVideoService() {
		return new VideoService(getAccessKey(), getAccessSecret());
	}

	public MultipartService getMultipartService() {
		return new MultipartService(getAccessKey(), getAccessSecret());
	}
	
	public AdvertisementService getAdvertisementService() {
		return new AdvertisementService(getAccessKey(), getAccessSecret());
	}
}