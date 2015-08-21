package com.pispower.video.sdk.multipart;

import com.pispower.video.sdk.core.AccessPropertiesConfig;

/**
 * 
 * CatalogService manage all opertaions of multipart uploading.
 * @author kinghai
 *
 */
public class MultipartService extends AccessPropertiesConfig {

	public MultipartService(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public void upload(MultipartUploadRequest req) {
		new UploadTrait(getAccessKey(), getAccessSecret(), req).upload();
	}
}