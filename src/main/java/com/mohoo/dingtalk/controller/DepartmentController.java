/*
 * DepartMentController.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.mohoo.dingtalk.service.DepartmentService;
import com.mohoo.dingtalk.service.TokenService;
import com.mohoo.dingtalk.util.RestFulUtil;

/**
 * 部门
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
@RequestMapping("dingtalk/v1.0/dept")
public class DepartmentController {
	private TokenService tokenService = new TokenService();
	private DepartmentService ds = new DepartmentService();

	public static String departList = "https://oapi.dingtalk.com/department/list";
	
	@RequestMapping("findAllDept")
	@ResponseBody
	public Map<String, Object> findAllDept(String parentDeptId) {
		try {
			List<Department> list = ds.list(tokenService.getAccessToken(), parentDeptId);
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, list);
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
}
