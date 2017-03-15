package com.mohoo.dingtalk.service;


import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.service.corp.CorpConnectionService;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.mohoo.dingtalk.util.ConstantUtil;

/**
 * 连接
 * 
 * @author mohoo
 *
 */
public class TokenService {

	public static String getAccessToken() throws ServiceNotExistException, SdkInitException, ServiceException {
		CorpConnectionService con = ServiceFactory.getInstance().getOpenService(CorpConnectionService.class);
		String token = con.getCorpToken(ConstantUtil.APPID, ConstantUtil.SECRET);
		return token;
	};
}
