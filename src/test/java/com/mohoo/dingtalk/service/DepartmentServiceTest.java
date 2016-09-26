package com.mohoo.dingtalk.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.api.model.corp.DepartmentDetail;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;

public class DepartmentServiceTest {
	@Test
	public void getList() {
		DepartmentService ds = new DepartmentService();
		try {
			List<Department> deptList = ds.list(TokenService.getAccessToken(), "");
			for (Department dept : deptList) {
				System.out.println(dept.getName());
				System.out.println(dept.getId());
				System.out.println(dept.getParentid());
				System.out.println("======");
			}
			Assert.assertNotNull(deptList);
		} catch (ServiceNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SdkInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取部门详细
	 */
	@Test
	public void getDetail() {
		DepartmentService ds = new DepartmentService();
		try {
			DepartmentDetail detail = ds.detail(TokenService.getAccessToken(), "3372098");
			System.out.println("=== 3372098 ===");
			System.out.println(detail.getName());
			System.out.println(detail.getId());
			System.out.println(detail.getDeptManagerUseridList());
			System.out.println("=== 3372098 ===");
			Assert.assertNotNull(detail);
		} catch (ServiceNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SdkInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 部门用户详细
	 */
	@Test
	public void getUserDetails() {
		DepartmentService ds = new DepartmentService();
		try {
			CorpUserDetailList list = ds.getUserDetails(TokenService.getAccessToken(), 3372098, Long.valueOf(0), 10, "");
			List<CorpUserDetail> userList = list.getUserlist();
			System.out.println("userList size: " + userList.size());
			for (CorpUserDetail detail : userList) {
				System.out.println("userinfo : " + detail.getName() + " Userid: " + detail.getUserid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
