package com.pispower.video.sdk.advertisement;

import java.io.File;
import java.util.List;

public class AdvertisementService {

	public Advertisement upload(File file, String name) {
		return new UploadTrait().upload(file, name);
	}

	public Advertisement get(String id) {
		return new GetTrait().get(id);
	}

	public List<Advertisement> list(String nameLike, int page, int maxResult) {
		return new ListTrait().list(nameLike, page, maxResult);
	}

	public boolean update(String id, String name) {
		return new UpdateTrait().update(id, name);
	}

	public boolean delete(String id) {
		return new DeleteTrait().delete(id);
	}
}
