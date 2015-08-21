package com.pispower.video.sdk.video.request;

public class VideoListRequest {
	private String catalogId;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public VideoListRequest(String catalogId) {
		super();
		this.catalogId = catalogId;
	}
}
