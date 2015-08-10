package com.pispower.video.sdk.multipart;

import java.io.File;

import android.os.Handler;

public class MultipartService {

	public void upload(File uploadFile, File tempDir,
			Handler handler, String curCatalogId) {
		new UploadTrait(uploadFile, tempDir, handler, curCatalogId).upload();
	}
}