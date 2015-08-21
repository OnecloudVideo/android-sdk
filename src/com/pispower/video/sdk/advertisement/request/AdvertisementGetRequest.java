package com.pispower.video.sdk.advertisement.request;

public class AdvertisementGetRequest {
	private String id;

	public AdvertisementGetRequest(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}