package com.mohoo.dingtalk;

import org.junit.Assert;
import org.junit.Test;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.service.corp.CorpUserService;

public class UserTest {
	// 获取成员
	@Test
	public static void getUser() throws Exception {
		String userid = "";
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		CorpUserDetail user = corpUserService.getCorpUser(EnvTest.accessToken, userid);
		System.out.println(user.getDingId());
		Assert.assertNotNull(user);
	}
}
