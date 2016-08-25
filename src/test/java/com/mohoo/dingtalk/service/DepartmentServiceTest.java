package com.mohoo.dingtalk.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.api.model.corp.DepartmentDetail;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.mohoo.dingtalk.EnvTest;

public class DepartmentServiceTest {
	@Test
	public void getList() {
		DepartmentService ds = new DepartmentService();
		try {
			List<Department> deptList = ds.list(EnvTest.accessToken, "");
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
	
	@Test
	public void getDetail(){
		DepartmentService ds = new DepartmentService();
		try {
			DepartmentDetail detail = ds.detail(EnvTest.accessToken, "6314478");
			System.out.println("=== 6314478 ===");
			System.out.println(detail.getName());
			System.out.println(detail.getId());
			System.out.println(detail.getDeptManagerUseridList());
			System.out.println("=== 6314478 ===");
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
}
