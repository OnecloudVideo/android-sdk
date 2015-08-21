package com.pispower.video.sdk.advertisement;

import java.util.List;

import com.pispower.video.sdk.advertisement.request.AdvertisementDeleteRequest;
import com.pispower.video.sdk.advertisement.request.AdvertisementGetRequest;
import com.pispower.video.sdk.advertisement.request.AdvertisementListRequest;
import com.pispower.video.sdk.advertisement.request.AdvertisementUpdateRequest;
import com.pispower.video.sdk.advertisement.request.AdvertisementUploadRequest;
import com.pispower.video.sdk.core.AccessPropertiesConfig;
import com.pispower.video.sdk.core.VideoSDKException;

/**
 * 
 * CatalogService manage all opertaions of advertisement.
 * @author kinghai
 *
 */
public class AdvertisementService extends AccessPropertiesConfig{

	public AdvertisementService(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public Advertisement upload(AdvertisementUploadRequest req) {
		return new UploadTrait(getAccessKey(), getAccessSecret()).upload(req.file, req.name);
	}

	public Advertisement get(AdvertisementGetRequest req) throws VideoSDKException {
		return new GetTrait(getAccessKey(), getAccessSecret()).get(req);
	}

	public List<Advertisement> list(AdvertisementListRequest req) throws VideoSDKException {
		return new ListTrait(getAccessKey(), getAccessSecret()).list(req);
	}

	public String update(AdvertisementUpdateRequest req) throws VideoSDKException {
		return new UpdateTrait(getAccessKey(), getAccessSecret()).update(req);
	}

	public String delete(AdvertisementDeleteRequest req) throws VideoSDKException {
		return new DeleteTrait(getAccessKey(), getAccessSecret()).delete(req);
	}
}
