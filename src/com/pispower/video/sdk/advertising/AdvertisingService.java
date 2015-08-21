//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import java.util.List;

import com.pispower.video.sdk.advertising.request.AdvertisingAddRequest;
import com.pispower.video.sdk.advertising.request.AdvertisingDeleteRequest;
import com.pispower.video.sdk.advertising.request.AdvertisingGetRequest;
import com.pispower.video.sdk.advertising.request.AdvertisingListRequest;
import com.pispower.video.sdk.advertising.request.AdvertisingOfflineRequest;
import com.pispower.video.sdk.advertising.request.AdvertisingUpdateRequest;
import com.pispower.video.sdk.core.AccessPropertiesConfig;
import com.pispower.video.sdk.core.VideoSDKException;

/**
 * 
 * CatalogService manage all opertaions of advertising. advertising determining the way to play advertisement.
 * @author kinghai
 *
 */
public class AdvertisingService extends AccessPropertiesConfig{

    public AdvertisingService(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);
	}

	public Advertising add(AdvertisingAddRequest req) throws VideoSDKException {
        return new AddTrait(getAccessKey(), getAccessSecret()).add(req);
    }

    public Advertising get(AdvertisingGetRequest req) throws VideoSDKException {
        return new GetTrait(getAccessKey(), getAccessSecret()).get(req);
    }

    public List<Advertising> list(AdvertisingListRequest req) throws VideoSDKException {
        return new ListTrait(getAccessKey(), getAccessSecret()).list(req);
    }

    public String update(AdvertisingUpdateRequest req) throws VideoSDKException {
        return new UpdateTrait(getAccessKey(), getAccessSecret()).update(req);
    }

    public String offline(AdvertisingOfflineRequest req) throws VideoSDKException {
        return new OfflineTrait(getAccessKey(), getAccessSecret()).offline(req);
    }

    public String delete(AdvertisingDeleteRequest req) throws VideoSDKException {
        return new DeleteTrait(getAccessKey(), getAccessSecret()).delete(req);
    }
}
