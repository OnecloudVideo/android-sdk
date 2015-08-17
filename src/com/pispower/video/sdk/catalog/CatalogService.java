package com.pispower.video.sdk.catalog;

import java.util.List;

/**
 * 
 * CatalogService manage all opertaions of catalog
 * @author kinghai
 *
 */
public class CatalogService {
	
	public List<CatalogInfo> list() {
		return new ListTrait().list();
	}
	
	public CatalogInfo get(String id) {
		return new GetTrait().get(id);
	}
	
	public CatalogInfo create(String name) {
		return new CreateTrait().create(name);
	}
}
