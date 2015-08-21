package com.pispower.video.sdk.advertising.request;

import java.util.Date;

import com.pispower.video.sdk.advertising.AdvertisingPosition;

public class AdvertisingAddRequest {
	private String name;
	private String adId;
	private AdvertisingPosition position;
	private Date onlineDate;
	private Date offlineDate;
	private String link;
	private String[] catalogIds;

	public AdvertisingAddRequest(String name, String adId,
			AdvertisingPosition position, Date onlineDate, Date offlineDate,
			String link, String[] catalogIds) {
		this.name = name;
		this.adId = adId;
		this.position = position;
		this.onlineDate = onlineDate;
		this.offlineDate = offlineDate;
		this.link = link;
		this.catalogIds = catalogIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public AdvertisingPosition getPosition() {
		return position;
	}

	public void setPosition(AdvertisingPosition position) {
		this.position = position;
	}

	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}

	public Date getOfflineDate() {
		return offlineDate;
	}

	public void setOfflineDate(Date offlineDate) {
		this.offlineDate = offlineDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String[] getCatalogIds() {
		return catalogIds;
	}

	public void setCatalogIds(String[] catalogIds) {
		this.catalogIds = catalogIds;
	}
}