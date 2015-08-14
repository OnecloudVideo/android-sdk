//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

public enum AdvertisingStatus {
    APPLIED("APPLIED"),
    OFFLINE("OFFLINE");

    private String status;

    private AdvertisingStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
