package com.mohoo.dingtalk.service;

import org.junit.Assert;
import org.junit.Test;

import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.mohoo.dingtalk.base.exception.ApplicationError;

public class UserServiceTest {
	
	@Test
	public void getUserDetail() {
		UserService user = new UserService();
		try {
			CorpUserDetail detail = user.getUser(TokenService.getAccessToken(), "31001");
			System.out.println("userinfo : " + detail.getName() + " Userid: " + detail.getUserid());
			Assert.assertNotNull(detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUser() throws ApplicationError {
		UserServiceImpl user = new UserServiceImpl();
		try {
			CorpUserDetail detail = user.getUserinfo(TokenService.getAccessToken(), "31001");
			System.out.println("--------------实现接口类 : " + detail.getName() + " Userid: " + detail.getUserid());
			Assert.assertNotNull(detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
