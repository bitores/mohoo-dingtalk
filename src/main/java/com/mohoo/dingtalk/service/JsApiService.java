package com.mohoo.dingtalk.service;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.JsapiTicket;
import com.dingtalk.open.client.api.service.corp.JsapiService;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;

public class JsApiService {

	public String getTicket(String accessToken) throws ServiceNotExistException, SdkInitException, ServiceException {
		JsapiService jss = ServiceFactory.getInstance().getOpenService(JsapiService.class);
		JsapiTicket jt = jss.getJsapiTicket(accessToken, "jsapi");
		return jt.getTicket();
	}
}
