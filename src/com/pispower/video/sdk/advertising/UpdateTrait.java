//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import android.util.Log;
import com.pispower.video.sdk.advertising.AdvertisingPosition;
import com.pispower.video.sdk.advertising.DateTrait;
import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

class UpdateTrait {
    private static final String Tag = UpdateTrait.class.getName();

    UpdateTrait() {
    }

    public String update(String id, String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) {
        try {
            return this.getResponseJsonObject(id, name, adId, position, onlineDate, offlineDate, link, catalogIds).getString("message");
        } catch (JSONException | IOException | HTTPJSONResponseValidException | ParseException var10) {
            Log.e(Tag, "update fail for", var10);
            return null;
        }
    }

    private JSONObject getResponseJsonObject(String id, String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) throws ParseException, IOException, JSONException, HTTPJSONResponseValidException {
        if(id == null) {
            throw new IllegalArgumentException("id is needed");
        } else {
            BaseClient client = new BaseClient();
            QueryString qs = new QueryString();
            qs.addParam("id", id);
            if(name != null) {
                qs.addParam("name", name);
            }

            if(adId != null) {
                qs.addParam("adId", adId);
            }

            if(position != null) {
                qs.addParam("position", position.getPostion());
            }

            if(onlineDate != null) {
                qs.addParam("onlineDate", (new DateTrait()).dateToString(onlineDate));
            }

            if(offlineDate != null) {
                qs.addParam("offlineDate", (new DateTrait()).dateToString(offlineDate));
            }

            if(link != null) {
                qs.addParam("link", link);
            }

            if(catalogIds != null) {
                qs.addParam("catalogIds", Arrays.toString(catalogIds));
            }

            return client.post("/advertise/update.api", qs);
        }
    }
}
