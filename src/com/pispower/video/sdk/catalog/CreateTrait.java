package com.pispower.video.sdk.catalog;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.catalog.request.CatalogCreateRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class CreateTrait extends AbstractTrait {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public CreateTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public CatalogInfo create(CatalogCreateRequest req) throws VideoSDKException {

		return (CatalogInfo) postHTTP("/catalog/create.api", req,
				new TraitResponseHandler() {

					@Override
					public Object handle(JSONObject jo) throws JSONException,
							VideoSDKException {
						// 创建分类信息实例对象
						CatalogInfo catalogInfo = new CatalogInfo();

						catalogInfo.setId(jo.getString("id"));
						catalogInfo.setName(jo.getString("name"));
						catalogInfo.setHoldVideoNums("0");

						catalogInfo.setLastModifiedTime(dateFormat
								.format(new Date()));
						return catalogInfo;

					}
				});
	}
}
