//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import com.pispower.video.sdk.advertising.AdvertisingPosition;
import com.pispower.video.sdk.advertising.AdvertisingStatus;
import java.util.Date;

public class Advertising {
    private String id;
    private String name;
    private String adId;
    private AdvertisingPosition position;
    private AdvertisingStatus status;
    private Date onlineDate;
    private Date offlineDate;
    private Date createTime;
    private String link;
    private String[] catalogIds;

    public Advertising() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdId() {
        return this.adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public AdvertisingPosition getPosition() {
        return this.position;
    }

    public void setPosition(AdvertisingPosition position) {
        this.position = position;
    }

    public AdvertisingStatus getStatus() {
        return this.status;
    }

    public void setStatus(AdvertisingStatus status) {
        this.status = status;
    }

    public Date getOnlineDate() {
        return this.onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public Date getOfflineDate() {
        return this.offlineDate;
    }

    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String[] getCatalogIds() {
        return this.catalogIds;
    }

    public void setCatalogIds(String[] catalogIds) {
        this.catalogIds = catalogIds;
    }
}
