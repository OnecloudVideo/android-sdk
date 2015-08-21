//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.pispower.video.sdk.core.VideoSDKException;

import static com.pispower.video.sdk.util.DateUtil.*;

class AdvertisingCreator {

    public Advertising create(JSONObject jo) throws JSONException, VideoSDKException {
        Advertising advertising = new Advertising();
        advertising.setId(jo.getString("id"));
        advertising.setAdId(jo.getString("adId"));
        advertising.setName(jo.getString("name"));
        advertising.setPosition(AdvertisingPosition.valueOf(jo.getString("position")));
        advertising.setStatus(AdvertisingStatus.valueOf(jo.getString("status")));
        
        try {
			advertising.setCreateTime(stringToDate(jo.getString("createTime")));
	        advertising.setOnlineDate(stringToDate(jo.getString("onlineDate")));
	        advertising.setOfflineDate(stringToDate(jo.getString("offlineDate")));
		} catch (ParseException e) {
			throw new VideoSDKException(e);
		}

        advertising.setCatalogIds(jo.getString("catalogIds").split(","));
        advertising.setLink(jo.getString("link"));
        return advertising;
    }
}
