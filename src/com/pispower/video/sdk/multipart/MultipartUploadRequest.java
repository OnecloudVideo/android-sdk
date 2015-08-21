package com.pispower.video.sdk.multipart;

import java.io.File;

import android.os.Handler;

public class MultipartUploadRequest {
	private File uploadFile;
	private File tempDir;
	private Handler handler;
	private String curCatalogId;

	public MultipartUploadRequest(File uploadFile, File tempDir,
			Handler handler, String curCatalogId) {
		this.uploadFile = uploadFile;
		this.tempDir = tempDir;
		this.handler = handler;
		this.curCatalogId = curCatalogId;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public File getTempDir() {
		return tempDir;
	}

	public void setTempDir(File tempDir) {
		this.tempDir = tempDir;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public String getCurCatalogId() {
		return curCatalogId;
	}

	public void setCurCatalogId(String curCatalogId) {
		this.curCatalogId = curCatalogId;
	}
}