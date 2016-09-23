package com.mohoo.dingtalk.service;

import java.util.List;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.api.model.corp.DepartmentDetail;
import com.dingtalk.open.client.api.service.corp.CorpDepartmentService;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
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
	public List<Department> list(String accessToken, String parentDeptId) throws ServiceNotExistException, SdkInitException, ServiceException {
		CorpDepartmentService corpDepartmentService = ServiceFactory.getInstance().getOpenService(CorpDepartmentService.class);
		List<Department> deptList = corpDepartmentService.getDeptList(accessToken, parentDeptId);
		return deptList;
	}

	public static void test(String[] args) throws ServiceNotExistException, SdkInitException, ServiceException {
		DepartmentService ds = new DepartmentService();
		List<Department> list=ds.list(new TokenService().getAccessToken(), "1");
		for (Department department : list) {
			System.out.println(department.getName()+","+department.getId()+","+department.getParentid()+","+department.getAutoAddUser());
		}
	}

	/**
	 * 获取部门详情
	 * 
	 * @param accessToken
	 * @param deptId
	 * @return
	 * @throws ServiceNotExistException
	 * @throws SdkInitException
	 * @throws ServiceException
	 */
	public DepartmentDetail detail(String accessToken, String deptId) throws ServiceNotExistException, SdkInitException, ServiceException {
		CorpDepartmentService corpDepartmentService = ServiceFactory.getInstance().getOpenService(CorpDepartmentService.class);
		return corpDepartmentService.getDeptDetail(accessToken, deptId);
	}

	/**
	 * 获取部门成员
	 * 
	 * @param accessToken
	 * @param departmentId
	 * @param offset
	 * @param size
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public CorpUserList getDepartmentUser(String accessToken, long departmentId, Long offset, Integer size, String order) throws Exception {

		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUserSimpleList(accessToken, departmentId, offset, size, order);
	}

	/**
	 * 获取部门成员（详情）
	 * 
	 * @param accessToken
	 * @param departmentId
	 * @param offset
	 * @param size
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public CorpUserDetailList getUserDetails(String accessToken, long departmentId, Long offset, Integer size, String order) throws Exception {

		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUserList(accessToken, departmentId, offset, size, order);
	}
}
