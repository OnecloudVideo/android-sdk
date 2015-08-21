package com.pispower.video.sdk.core;

public abstract class AccessPropertiesConfig {
	private String accessKey;
	private String accessSecret;
	
	public AccessPropertiesConfig(String accessKey, String accessSecret) {
		setAccessKey(accessKey);
		setAccessSecret(accessSecret);
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}
}
