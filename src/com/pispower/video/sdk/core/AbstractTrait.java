package com.pispower.video.sdk.core;

import java.io.IOException;

import org.json.JSONException;

import android.util.Log;

import com.pispower.video.sdk.net.BaseClient;
import com.pispower.video.sdk.net.HTTPJSONResponseValidException;
import com.pispower.video.sdk.util.QueryString;
import com.pispower.video.sdk.util.QueryStringBuilder;

public abstract class AbstractTrait extends AccessPropertiesConfig {

	protected BaseClient client;

	public AbstractTrait(String accessKey, String accessSecret) {
		super(accessKey, accessSecret);

		client = new BaseClient(getAccessKey(), getAccessSecret());
	}

	protected Object getHTTP(String action, Object request,
			TraitResponseHandler handler) throws VideoSDKException {
		try {
			return handler.handle(client.get(action,
					getRequestQueryString(request)));
		} catch (IOException | JSONException | HTTPJSONResponseValidException e) {
			createAndThrowVideoSDKException(e);
		}
		return null;
	}

	protected Object postHTTP(String action, Object request,
			TraitResponseHandler handler) throws VideoSDKException {
		try {
			return handler.handle(client.post(action,
					getRequestQueryString(request)));
		} catch (IOException | JSONException | HTTPJSONResponseValidException e) {
			createAndThrowVideoSDKException(e);
		}
		return null;
	}

	private QueryString getRequestQueryString(Object obj) {
		return new QueryStringBuilder().build(obj);
	}

	private VideoSDKException createAndThrowVideoSDKException(Throwable t)
			throws VideoSDKException {
		logE("parse reponse fail for" + t.getMessage());
		
		throw new VideoSDKException(t);
	}

	protected void logD(String msg) {
		Log.d(getLogTag(), msg);
	}

	protected void logI(String msg) {
		Log.i(getLogTag(), msg);
	}

	protected void logE(String msg) {
		Log.e(getLogTag(), msg);
	}

	protected String getLogTag() {
		return getClass().getName();
	}
}