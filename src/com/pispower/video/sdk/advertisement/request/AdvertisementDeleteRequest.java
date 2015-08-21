package com.pispower.video.sdk.advertisement.request;

public class AdvertisementDeleteRequest {
	private String id;

	public AdvertisementDeleteRequest(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}