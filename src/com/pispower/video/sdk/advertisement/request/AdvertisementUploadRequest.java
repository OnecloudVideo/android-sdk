package com.pispower.video.sdk.advertisement.request;

import java.io.File;

public class AdvertisementUploadRequest {
	public File file;
	public String name;

	public AdvertisementUploadRequest(File file, String name) {
		this.file = file;
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}