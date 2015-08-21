package com.pispower.video.sdk.catalog;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.catalog.request.CatalogGetRequest;
import com.pispower.video.sdk.catalog.request.CatalogListRequest;
import com.pispower.video.sdk.core.AbstractTrait;
import com.pispower.video.sdk.core.TraitResponseHandler;
import com.pispower.video.sdk.core.VideoSDKException;

class ListTrait extends AbstractTrait {

	public ListTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	protected TraitResponseHandler getHandler() {
		return new TraitResponseHandler() {

			@Override
			public Object handle(JSONObject jo) throws JSONException,
					VideoSDKException {
				// 创建空的分类信息列表
				List<CatalogInfo> catalogInfos = new ArrayList<CatalogInfo>();

				// 获取所有的分类
				JSONArray catalogs = jo.getJSONArray("catalogs");
				if (catalogs == null) {
					return catalogInfos;
				}

				for (int i = 0; i < catalogs.length(); i++) {

					JSONObject catalog = catalogs.getJSONObject(i);
					CatalogInfo catalogInfo = new CatalogInfo();
					catalogInfo.setId(catalog.getString("id"));
					catalogInfo.setName(catalog.getString("name"));

					CatalogGetRequest getRequest = new CatalogGetRequest(
							catalogInfo.getId());
					GetTrait getTrait = new GetTrait(getAccessKey(),
							getAccessSecret());

					catalogInfo.setHoldVideoNums(getTrait.get(getRequest)
							.getHoldVideoNums());

					catalogInfos.add(catalogInfo);
				}

				return catalogInfos;
			}
		};
	}

	@SuppressWarnings("unchecked")
	public List<CatalogInfo> list(CatalogListRequest req)
			throws VideoSDKException {
		return (List<CatalogInfo>) getHTTP("/catalog/list.api", req,
				getHandler());
	}
}
