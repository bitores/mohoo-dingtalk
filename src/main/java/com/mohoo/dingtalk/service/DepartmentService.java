package com.mohoo.dingtalk.service;

import java.util.List;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.api.model.corp.DepartmentDetail;
import com.dingtalk.open.client.api.service.corp.CorpDepartmentService;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;

/**
 * 部门 管理
 * 
 * @author mohoo
 *
 */
public class DepartmentService {
	/**
	 * 获取部门列表
	 * 
	 * @param accessToken
	 *            密钥
	 * @param parentDeptId
	 *            上级部门
	 * @return
	 * @throws ServiceNotExistException
	 * @throws SdkInitException
	 * @throws ServiceException
	 */
	public List<Department> list(String accessToken, String parentDeptId)
			throws ServiceNotExistException, SdkInitException, ServiceException {
		CorpDepartmentService corpDepartmentService = ServiceFactory.getInstance()
				.getOpenService(CorpDepartmentService.class);
		List<Department> deptList = corpDepartmentService.getDeptList(accessToken, parentDeptId);
		return deptList;
	}

	/**
	 * 获取部门详情
	 * @param accessToken
	 * @param deptId
	 * @return
	 * @throws ServiceNotExistException
	 * @throws SdkInitException
	 * @throws ServiceException
	 */
	public DepartmentDetail detail(String accessToken, String deptId)
			throws ServiceNotExistException, SdkInitException, ServiceException {
		CorpDepartmentService corpDepartmentService = ServiceFactory.getInstance()
				.getOpenService(CorpDepartmentService.class);
		return corpDepartmentService.getDeptDetail(accessToken, deptId);
	}
}
