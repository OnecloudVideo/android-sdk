//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import android.util.Log;
import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;
import java.io.IOException;
import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineTrait {
    private static final String Tag = OfflineTrait.class.getName();

    OfflineTrait() {
    }

    public String offline(String id) {
        try {
            return this.getResponseJsonObject(id).getString("message");
        } catch (JSONException | IOException | HTTPJSONResponseValidException | ParseException var3) {
            Log.e(Tag, "offline fail for", var3);
            return null;
        }
    }

    private JSONObject getResponseJsonObject(String id) throws ParseException, IOException, JSONException, HTTPJSONResponseValidException {
        BaseClient client = new BaseClient();
        QueryString qs = new QueryString();
        qs.addParam("id", id);
        return client.post("/advertise/offline.api", qs);
    }
}
