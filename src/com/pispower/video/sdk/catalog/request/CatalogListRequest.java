package com.pispower.video.sdk.catalog.request;

public class CatalogListRequest {
	private String nameLike;
	private Integer page = 1;
	private Integer maxResult = 100;

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public CatalogListRequest() {
		this(null, 1, 100);
	}
	
	public CatalogListRequest(String nameLike, Integer page, Integer maxResult) {
		super();
		this.nameLike = nameLike;
		this.page = page;
		this.maxResult = maxResult;
	}
}