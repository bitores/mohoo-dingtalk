/*
 * UserTestService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.service;

import java.util.List;
import java.util.Map;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.mohoo.dingtalk.base.exception.ApplicationError;

/**
 * 用户管理
 * <p>
 * 创建日期：2016年8月30日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author caonn
 * @version 1.0
 */
public class UserServiceImpl implements CorpUserService {

	private CorpUserService corpUserService;

	public UserServiceImpl() throws ApplicationError {
		try {
			corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		} catch (ServiceNotExistException e) {
			throw new ApplicationError("接口服务不存在异常！", e);
		} catch (SdkInitException e) {
			throw new ApplicationError("接口初始化异常!", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dingtalk.open.client.api.service.corp.CorpUserService#
	 * batchdeleteCorpUserListByUserids(java.lang.String, java.util.List)
	 */
	public CorpUserDetailList batchdeleteCorpUserListByUserids(String arg0, List<String> arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#createCorpUser(
	 * java.lang.String, java.lang.String, java.lang.String, java.util.Map,
	 * java.util.List, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.Boolean, java.lang.Boolean, java.util.Map)
	 */
	public String createCorpUser(String arg0, String arg1, String arg2, Map<Long, Long> arg3, List<Long> arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, Boolean arg12,
			Boolean arg13, Map<String, String> arg14) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#deleteCorpUser(
	 * java.lang.String, java.lang.String)
	 */
	public CorpUserDetail deleteCorpUser(String arg0, String arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#getCorpUser(
	 * java.lang.String, java.lang.String)
	 */
	public CorpUserDetail getCorpUser(String arg0, String arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#getCorpUserList
	 * (java.lang.String, long, java.lang.Long, java.lang.Integer,
	 * java.lang.String)
	 */
	public CorpUserDetailList getCorpUserList(String arg0, long arg1, Long arg2, Integer arg3, String arg4)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dingtalk.open.client.api.service.corp.CorpUserService#
	 * getCorpUserListByUserids(java.lang.String, java.util.List)
	 */
	public CorpUserDetailList getCorpUserListByUserids(String arg0, List<String> arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dingtalk.open.client.api.service.corp.CorpUserService#
	 * getCorpUserSimpleList(java.lang.String, long, java.lang.Long,
	 * java.lang.Integer, java.lang.String)
	 */
	public CorpUserList getCorpUserSimpleList(String arg0, long arg1, Long arg2, Integer arg3, String arg4)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#getUserinfo(
	 * java.lang.String, java.lang.String)
	 */
	public CorpUserDetail getUserinfo(String accessToken, String userid) throws ServiceException {
		return corpUserService.getCorpUser(accessToken, userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dingtalk.open.client.api.service.corp.CorpUserService#updateCorpUser(
	 * java.lang.String, java.lang.String, java.lang.String, java.util.Map,
	 * java.util.List, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.Boolean, java.lang.Boolean, java.util.Map)
	 */
	public String updateCorpUser(String arg0, String arg1, String arg2, Map<Long, Long> arg3, List<Long> arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, Boolean arg12,
			Boolean arg13, Map<String, String> arg14) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
