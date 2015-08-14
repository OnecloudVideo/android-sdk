//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import com.pispower.video.sdk.advertising.Advertising;
import com.pispower.video.sdk.advertising.AdvertisingPosition;
import com.pispower.video.sdk.advertising.AdvertisingStatus;
import com.pispower.video.sdk.advertising.DateTrait;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

class AdvertisingCreator {
    AdvertisingCreator() {
    }

    public Advertising create(JSONObject jo) throws JSONException, ParseException {
        Advertising advertising = new Advertising();
        advertising.setId(jo.getString("id"));
        advertising.setAdId(jo.getString("adId"));
        advertising.setName(jo.getString("name"));
        advertising.setPosition(AdvertisingPosition.valueOf(jo.getString("position")));
        advertising.setStatus(AdvertisingStatus.valueOf(jo.getString("status")));
        advertising.setCreateTime((new DateTrait()).stringToDate(jo.getString("createTime")));
        advertising.setOnlineDate((new DateTrait()).stringToDate(jo.getString("onlineDate")));
        advertising.setOfflineDate((new DateTrait()).stringToDate(jo.getString("offlineDate")));
        advertising.setCatalogIds(jo.getString("catalogIds").split(","));
        advertising.setLink(jo.getString("link"));
        return advertising;
    }
}
