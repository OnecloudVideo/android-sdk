package com.pispower.video.sdk.catalog.request;

public class CatalogCreateRequest {
	private String name;

	public CatalogCreateRequest(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
