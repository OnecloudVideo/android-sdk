package com.pispower.video.sdk.video.request;

public class VideoEmbedCodeRequest {
	private String videoId;
	private String clarity;

	public VideoEmbedCodeRequest(String videoId, String clarity) {
		this.videoId = videoId;
		this.clarity = clarity;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getClarity() {
		return clarity;
	}

	public void setClarity(String clarity) {
		this.clarity = clarity;
	}
}