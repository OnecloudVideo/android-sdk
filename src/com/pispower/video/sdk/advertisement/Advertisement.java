package com.pispower.video.sdk.advertisement;

public class Advertisement {
	private String id;
	private String name;
	private Long duration;
	private Long size;
	private String code;
	private AdvertisementStatus status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public AdvertisementStatus getStatus() {
		return status;
	}
	public void setStatus(AdvertisementStatus status) {
		this.status = status;
	}
}