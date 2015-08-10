package com.pispower.video.sdk.video;

public enum VideoStatus {

	PROCESSING("PROCESSING", "处理中"), AUDIT_SUCCESS("AUDIT_SUCCESS", "可发布"), AUDIT_FAIL(
			"AUDIT_FAIL", "禁播"), UNAUDIT("UNAUDIT", "未审核"), FAIL("FAIL", "转码失败"), UNKONW(
			"UNKONW", "未知");

	private String name;
	private String chineseName;

	VideoStatus(String name, String chineseName) {
		setName(name);
		setChineseName(chineseName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
}
