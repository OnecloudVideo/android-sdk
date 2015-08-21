package com.pispower.video.sdk.catalog;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.catalog.request.CatalogGetRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class GetTrait extends AbstractTrait {

	public GetTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public CatalogInfo get(final CatalogGetRequest req)
			throws VideoSDKException {

		return (CatalogInfo) getHTTP("/catalog/get.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException {
						CatalogInfo info = new CatalogInfo();
						info.setId(req.getCatalogId());

						info.setName(jo.getString("name"));
						info.setHoldVideoNums(jo.getString("videoNumber"));

						return info;
					}
				});
	}
}