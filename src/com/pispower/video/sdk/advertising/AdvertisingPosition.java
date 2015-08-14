//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

public enum AdvertisingPosition {
    HEAD("HEAD"),
    END("END");

    private String postion;

    private AdvertisingPosition(String position) {
        this.postion = position;
    }

    public String getPostion() {
        return this.postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }
}
