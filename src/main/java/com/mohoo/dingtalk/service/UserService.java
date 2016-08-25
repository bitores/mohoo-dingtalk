package com.mohoo.dingtalk.service;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.service.corp.CorpUserService;

/**
 * 用户管理
 * 
 * @author mohoo
 *
 */
public class UserService {
	/**
	 * 获取成员
	 * {“active“:true,“avatar“:“http://i01.lw.aliimg.com/media/lADOaL_1gc0DwM0C0A_720_960.jpg“,“department“:[6314478],“dingId“:“$:LWCP_v1:$/rDLw5RP88TXOyBDXy/Q5w==“,“email“:“iceinto@163.com“,“errcode“:0,“errmsg“:“ok“,“isAdmin“:true,“isBoss“:true,“isHide“:false,“isLeaderInDepts“:“{6314478:false}“,“jobnumber“:“10003“,“mobile“:“17721222359“,“name“:“李冰成“,“openId“:“Tun7xK0RkzAiE“,“orderInDepts“:“{6314478:1}“,“position“:“总经理“,“remark“:““,“tel“:““,“userid“:“31001“,“workPlace“:“上海市静安区北京西路833号京泰楼7楼“}
	 * 
	 * @param accessToken
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public CorpUserDetail getUser(String accessToken, String userid) throws Exception {

		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUser(accessToken, userid);
	}
}
