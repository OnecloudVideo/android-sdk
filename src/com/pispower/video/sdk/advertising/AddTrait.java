//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import android.util.Log;
import com.pispower.video.sdk.advertising.Advertising;
import com.pispower.video.sdk.advertising.AdvertisingCreator;
import com.pispower.video.sdk.advertising.AdvertisingPosition;
import com.pispower.video.sdk.advertising.DateTrait;
import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

class AddTrait {
    private static final String Tag = AddTrait.class.getName();

    AddTrait() {
    }

    public Advertising add(String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) {
        try {
            return (new AdvertisingCreator()).create(this.getResponseJsonObject(name, adId, position, onlineDate, offlineDate, link, catalogIds));
        } catch (JSONException | ParseException | IOException | HTTPJSONResponseValidException | org.apache.http.ParseException var9) {
            Log.e(Tag, "add fail for", var9);
            return null;
        }
    }

    private JSONObject getResponseJsonObject(String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) throws org.apache.http.ParseException, IOException, JSONException, HTTPJSONResponseValidException {
        BaseClient client = new BaseClient();
        QueryString qs = new QueryString();
        qs.addParam("name", name);
        qs.addParam("adId", adId);
        qs.addParam("position", position.getPostion());
        qs.addParam("onlineDate", (new DateTrait()).dateToString(onlineDate));
        qs.addParam("offlineDate", (new DateTrait()).dateToString(offlineDate));
        qs.addParam("link", link);
        qs.addParam("catalogIds", Arrays.toString(catalogIds));
        return client.post("/advertise/add.api", qs);
    }
}
