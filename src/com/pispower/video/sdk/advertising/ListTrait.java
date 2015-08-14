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
import java.util.ArrayList;
import java.util.List;
import org.apache.http.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ListTrait {
    private static final String Tag = ListTrait.class.getName();

    ListTrait() {
    }

    public List<Advertising> list(String nameLike, int page, int maxResult) {
        try {
            JSONObject e = this.getResponseJsonObject(nameLike, page, maxResult);
            JSONArray joArr = e.getJSONArray("advertiseList");
            List<Advertising> advertisings = new ArrayList<Advertising>();

            for(int i = 0; i < joArr.length(); ++i) {
                advertisings.add((new AdvertisingCreator()).create(joArr.getJSONObject(i)));
            }

            return advertisings;
        } catch (ParseException | IOException | HTTPJSONResponseValidException | java.text.ParseException | JSONException var8) {
            Log.e(Tag, "list fail", var8);
            return null;
        }
    }

    private JSONObject getResponseJsonObject(String nameLike, int page, int maxResult) throws ParseException, IOException, JSONException, HTTPJSONResponseValidException {
        BaseClient client = new BaseClient();
        QueryString qs = new QueryString();
        qs.addParam("nameLike", nameLike);
        qs.addParam("page", "" + page);
        qs.addParam("maxResult", "" + maxResult);
        return client.get("/advertise/list.api", qs);
    }
}
