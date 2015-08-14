//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import android.util.Log;
import com.pispower.video.sdk.advertising.Advertising;
import com.pispower.video.sdk.advertising.AdvertisingCreator;
import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;
import java.io.IOException;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

class GetTrait {
    private static final String Tag = GetTrait.class.getName();

    GetTrait() {
    }

    public Advertising get(String id) {
        try {
            return (new AdvertisingCreator()).create(this.getResponseJsonObject(id));
        } catch (JSONException | ParseException | HTTPJSONResponseValidException | IOException | org.apache.http.ParseException var3) {
            Log.e(Tag, "get fail for", var3);
            return null;
        }
    }

    private JSONObject getResponseJsonObject(String id) throws org.apache.http.ParseException, HTTPJSONResponseValidException, IOException, JSONException {
        BaseClient client = new BaseClient();
        QueryString qs = new QueryString();
        qs.addParam("id", id);
        return client.get("/advertise/get.api", qs);
    }
}
