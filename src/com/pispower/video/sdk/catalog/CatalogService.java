package com.pispower.video.sdk.catalog;

import java.util.List;

import com.pispower.video.sdk.catalog.request.CatalogCreateRequest;
import com.pispower.video.sdk.catalog.request.CatalogGetRequest;
import com.pispower.video.sdk.catalog.request.CatalogListRequest;
import com.pispower.video.sdk.core.AccessPropertiesConfig;
import com.pispower.video.sdk.core.VideoSDKException;

/**
 * 
 * CatalogService manage all opertaions of catalog
 * @author kinghai
 *
 */
public class CatalogService extends AccessPropertiesConfig {
	
	public CatalogService(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public List<CatalogInfo> list(CatalogListRequest req) throws VideoSDKException {
		return new ListTrait(getAccessKey(), getAccessSecret()).list(req);
	}
	
	public CatalogInfo get(CatalogGetRequest req) throws VideoSDKException {
		return new GetTrait(getAccessKey(), getAccessSecret()).get(req);
	}
	
	public CatalogInfo create(CatalogCreateRequest req) throws VideoSDKException {
		return new CreateTrait(getAccessKey(), getAccessSecret()).create(req);
	}
}