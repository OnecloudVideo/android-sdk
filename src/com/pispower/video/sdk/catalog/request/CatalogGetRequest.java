package com.pispower.video.sdk.catalog.request;

public class CatalogGetRequest {
	private String catalogId;

	public CatalogGetRequest(String id) {
		setCatalogId(id);
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
}
