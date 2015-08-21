package com.pispower.video.sdk.advertisement.request;

public class AdvertisementListRequest {
	private String nameLike;
	private int page;
	private int maxResult;

	public AdvertisementListRequest(String nameLike, int page, int maxResult) {
		this.nameLike = nameLike;
		this.page = page;
		this.maxResult = maxResult;
	}

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
}