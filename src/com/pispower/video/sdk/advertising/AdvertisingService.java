//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import com.pispower.video.sdk.advertising.AddTrait;
import com.pispower.video.sdk.advertising.Advertising;
import com.pispower.video.sdk.advertising.AdvertisingPosition;
import com.pispower.video.sdk.advertising.DeleteTrait;
import com.pispower.video.sdk.advertising.GetTrait;
import com.pispower.video.sdk.advertising.ListTrait;
import com.pispower.video.sdk.advertising.OfflineTrait;
import com.pispower.video.sdk.advertising.UpdateTrait;
import java.util.Date;
import java.util.List;

public class AdvertisingService {
    public AdvertisingService() {
    }

    public Advertising add(String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) {
        return (new AddTrait()).add(name, adId, position, onlineDate, offlineDate, link, catalogIds);
    }

    public Advertising get(String id) {
        return (new GetTrait()).get(id);
    }

    public List<Advertising> list(String nameLike, int page, int maxResult) {
        return (new ListTrait()).list(nameLike, page, maxResult);
    }

    public String update(String id, String name, String adId, AdvertisingPosition position, Date onlineDate, Date offlineDate, String link, String[] catalogIds) {
        return (new UpdateTrait()).update(id, name, adId, position, onlineDate, offlineDate, link, catalogIds);
    }

    public String offline(String id) {
        return (new OfflineTrait()).offline(id);
    }

    public String delete(String id) {
        return (new DeleteTrait()).delete(id);
    }
}
