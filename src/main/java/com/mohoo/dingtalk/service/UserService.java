package com.mohoo.dingtalk.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUser;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.mohoo.dingtalk.util.FileUtils;

/**
 * 用户管理
 * 
 * @author mohoo
 *
 */
public class UserService {
	
	public static void main(String[] args) throws Exception {
		CorpUserList cul=UserService.getDepartmentUser(new TokenService().getAccessToken(), 6314478, 0l, 20, "");
		List<CorpUser> list= cul.getUserlist();
		System.out.println("================================="+list.size());
		for (CorpUser corpUser : list) {
			System.out.println(corpUser.getName()+","+corpUser.getUserid()+","+corpUser.getActive());
		}
		CorpUserDetail cud=new UserService().getUser(new TokenService().getAccessToken(), 31001+"");
		System.out.println("=========================================");
		System.out.println(cud);
		System.out.println("=========================================");
	}

	/**
	 * 获取成员<br>
	 * {“active“:true,“avatar“:“http://i01.lw.aliimg.com/media/
	 * lADOaL_1gc0DwM0C0A_720_960.jpg“,“department“:[6314478],“dingId“:“$:
	 * LWCP_v1:$/rDLw5RP88TXOyBDXy/Q5w==“,“email“:“iceinto@163.com“,“errcode“:0,
	 * “errmsg“:“ok“,“isAdmin“:true,“isBoss“:true,“isHide“:false,“
	 * isLeaderInDepts“:“{6314478:false}“,“jobnumber“:“10003“,“mobile“:“
	 * 17721222359“,“name“:“李冰成“,“openId“:“Tun7xK0RkzAiE“,“orderInDepts“:“{
	 * 6314478:1}“,“position“:“总经理“,“remark“:““,“tel“:““,“userid“:“31001“,“
	 * workPlace“:“上海市静安区北京西路833号京泰楼7楼“}
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

	/**
	 * 创建成员
	 * 
	 * @param accessToken
	 * @param userDetail
	 * @throws Exception
	 */
	public static void createUser(String accessToken, CorpUserDetail userDetail) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		JSONObject js = (JSONObject) JSONObject.parse(userDetail.getOrderInDepts());
		Map<Long, Long> orderInDepts = FileUtils.toHashMap(js);

		corpUserService.createCorpUser(accessToken, userDetail.getUserid(), userDetail.getName(), orderInDepts,
				userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(),
				userDetail.getWorkPlace(), userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
				userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
	}

	/**
	 * 更新成员
	 * 
	 * @param accessToken
	 * @param userDetail
	 * @throws Exception
	 */
	public static void updateUser(String accessToken, CorpUserDetail userDetail) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		JSONObject js = (JSONObject) JSONObject.parse(userDetail.getOrderInDepts());
		Map<Long, Long> orderInDepts = FileUtils.toHashMap(js);

		corpUserService.updateCorpUser(accessToken, userDetail.getUserid(), userDetail.getName(), orderInDepts,
				userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(),
				userDetail.getWorkPlace(), userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
				userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
	}

	/**
	 * 删除成员
	 * 
	 * @param accessToken
	 * @param userid
	 * @throws Exception
	 */
	public static void deleteUser(String accessToken, String userid) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		corpUserService.deleteCorpUser(accessToken, userid);
	}

	/**
	 * 批量删除成员
	 * 
	 * @param accessToken
	 * @param useridlist
	 * @throws Exception
	 */
	public static void batchDeleteUser(String accessToken, List<String> useridlist) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		corpUserService.batchdeleteCorpUserListByUserids(accessToken, useridlist);
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
	public static CorpUserList getDepartmentUser(String accessToken, long departmentId, Long offset, Integer size,
			String order) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUserSimpleList(accessToken, departmentId, offset, size, order);
	}
	

	/**
	 * 获取部门成员详细信息
	 * 
	 * @param accessToken
	 * @param departmentId
	 * @param offset
	 * @param size
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public static CorpUserDetailList getDepartmentUserDetail(String accessToken, long departmentId, Long offset, Integer size,
			String order) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUserList(accessToken, departmentId, offset, size, order);
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
	public static CorpUserDetailList getUserDetails(String accessToken, long departmentId, Long offset, Integer size,
			String order) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getCorpUserList(accessToken, departmentId, offset, size, order);
	}

	/**
	 * 获取成员详细信息
	 * 
	 * @param accessToken
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static CorpUserDetail getUserInfo(String accessToken, String code) throws Exception {
		CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
		return corpUserService.getUserinfo(accessToken, code);
	}

}
