package com.mohoo.dingtalk.service;

import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.MessageBody;
import com.dingtalk.open.client.api.model.corp.MessageSendResult;


/**
 * 普通信息
 * 
 * @author mohoo
 *
 */
public class MessageService {
	/**
	 * 发送企业会话消息
	 * 1.文本
	 * {"touser":"31001","agentid":"36805200","msgtype":"text","text":{"content":"test"}}
	 * 
	 * 2.链接
	 * {"touser":"123","agentid":"4117797","msgtype":"link","link":{"messageUrl":"","picUrl":"","title":"","text":""}}
	 * 
	 * @param accessToken
	 * @param touser
	 * @param toparty
	 * @param agentid
	 * @param msgType
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public MessageSendResult sendToCorpConversation(String accessToken, String touser, String toparty, String agentid,
			String msgType, MessageBody message) throws Exception {
		com.dingtalk.open.client.api.service.corp.MessageService messageService = ServiceFactory.getInstance()
				.getOpenService(com.dingtalk.open.client.api.service.corp.MessageService.class);
		MessageSendResult reulst = messageService.sendToCorpConversation(accessToken, touser, toparty, agentid, msgType,
				message);
		return reulst;
	}

	/**
	 * 发送企业通话
	 * @param accessToken
	 * @param sender
	 * @param cid
	 * @param msgType
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String sendToNormalConversation(String accessToken, String sender, String cid, String msgType, MessageBody message)
			throws Exception {
		com.dingtalk.open.client.api.service.corp.MessageService messageService = ServiceFactory.getInstance().getOpenService(com.dingtalk.open.client.api.service.corp.MessageService.class);
		return messageService.sendToNormalConversation(accessToken, sender, cid, msgType, message);
	}
}
