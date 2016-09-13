/*
 * UserController.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.api.model.corp.CorpUser;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.mohoo.dingtalk.service.TokenService;
import com.mohoo.dingtalk.service.UserService;
import com.mohoo.dingtalk.util.RestFulUtil;

/**
 * 类描述
 * <p>
 * 创建日期：2016年9月2日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
@RestController
@RequestMapping("dingtalk/v1.0/user")
public class UserController {
	private TokenService tokenService = new TokenService();

	/**
	 * 获取部门成员基本信息(仅限制该部门下人员少于100使用) 方法描述
	 * 
	 * @param deptId
	 * @return
	 */
	@RequestMapping("findUserBydeptId")
	@ResponseBody
	public Map<String, Object> findUserByDeptId(long deptId) {
		try {
			CorpUserList list = UserService.getDepartmentUser(tokenService.getAccessToken(), deptId, 0l, 100, "");
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, list.getUserlist());
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (SdkInitException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (Exception e) {
			return RestFulUtil.restFulInfo(RestFulUtil.RES_ERROR, e.getMessage());
		}
	}

	@RequestMapping("findAllUserBydeptId")
	@ResponseBody
	public Map<String, Object> findUserByDeptId(long deptId, long offset, int size, String order) {
		try {
			CorpUserList list = UserService.getDepartmentUser(tokenService.getAccessToken(), deptId, offset, size, order);
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, list.getUserlist());
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (SdkInitException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (Exception e) {
			return RestFulUtil.restFulInfo(RestFulUtil.RES_ERROR, e.getMessage());
		}
	}

	/**
	 * 获取成员详细信息(仅限制该部门下人员少于100使用) 方法描述
	 * 
	 * @param deptId
	 * @return
	 */
	@RequestMapping("findUserDetailBydeptId")
	@ResponseBody
	public Map<String, Object> findUserDetailBydeptId(long deptId) {
		try {
			CorpUserDetailList list = UserService.getDepartmentUserDetail(tokenService.getAccessToken(), deptId, 0l, 100, "");
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, list.getUserlist());
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (SdkInitException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (Exception e) {
			return RestFulUtil.restFulInfo(RestFulUtil.RES_ERROR, e.getMessage());
		}
	}

	/**
	 * 获取成员详细信息 方法描述
	 * 
	 * @param deptId
	 * @return
	 */
	@RequestMapping("findAllUserDetailBydeptId")
	@ResponseBody
	public Map<String, Object> findAllUserDetailBydeptId(long deptId, long offset, int size, String order) {
		try {
			CorpUserDetailList list = UserService.getDepartmentUserDetail(tokenService.getAccessToken(), deptId, offset, size, order);
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, list.getUserlist());
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (SdkInitException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (Exception e) {
			return RestFulUtil.restFulInfo(RestFulUtil.RES_ERROR, e.getMessage());
		}
	}

	@RequestMapping("findUserDetail")
	@ResponseBody
	public Map<String, Object> findUserDetail(String userId) {
		try {
			CorpUserDetail cud = UserService.getUserInfo(tokenService.getAccessToken(), userId);
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, cud);
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (SdkInitException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, e.getMessage());
		} catch (Exception e) {
			return RestFulUtil.restFulInfo(RestFulUtil.RES_ERROR, e.getMessage());
		}
	}

	public static void test() throws ServiceNotExistException, SdkInitException, ServiceException, Exception {
		TokenService tokenService = new TokenService();
		CorpUserList list = UserService.getDepartmentUser(tokenService.getAccessToken(), 6295481l, 0l, 100, "");
		for (CorpUser user : list.getUserlist()) {
			System.out.println(JSONObject.toJSON(user));
		}
	}
}
