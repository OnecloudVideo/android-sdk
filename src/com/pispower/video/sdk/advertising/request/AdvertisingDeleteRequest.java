package com.pispower.video.sdk.advertising.request;

public class AdvertisingDeleteRequest {
	private String id;

	public AdvertisingDeleteRequest(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}