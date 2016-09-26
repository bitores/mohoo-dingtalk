package com.mohoo.dingtalk.service;

import org.junit.Assert;
import org.junit.Test;

import com.dingtalk.open.client.api.model.corp.MessageBody;
import com.dingtalk.open.client.api.model.corp.MessageSendResult;

public class MessageServiceTest {
	/**
	 * 发送纯文本信息
	 * {"touser":"31001","agentid":"36805200","msgtype":"text","text":{"content":"test"}}
	 */
	@Test
	public void sendToCorpConversationText() {
		MessageService ms = new MessageService();
		MessageBody.TextBody textBody = new MessageBody.TextBody();
		textBody.setContent("TextMessage");
		try {
			MessageSendResult rs = ms.sendToCorpConversation(TokenService.getAccessToken(), "31001", "", "36805200", "text",
					textBody);
			System.out.println(
					"send message text: Invalidparty" + rs.getInvalidparty() + " Invaliduser" + rs.getInvaliduser());
			Assert.assertNotNull(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送链接信息
	 * {"touser":"123","agentid":"4117797","msgtype":"link","link":{"messageUrl":"","picUrl":"","title":"","text":""}}
	 */
	@Test
	public void sendToCorpConversationLink() {
		MessageService ms = new MessageService();
		MessageBody.LinkBody linkBody = new MessageBody.LinkBody();
		linkBody.setMessageUrl("http://www.mohoo.com.cn");
		linkBody.setPicUrl("http://i01.lw.aliimg.com/media/lADOCuQ84s0E2s0E1w_1239_1242.jpg");
		linkBody.setText("图文想想");
		try {
			MessageSendResult rs = ms.sendToCorpConversation(TokenService.getAccessToken(), "31001", "", "36805200", "link",
					linkBody);
			System.out.println(
					"send message link: Invalidparty" + rs.getInvalidparty() + " Invaliduser" + rs.getInvaliduser());
			Assert.assertNotNull(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
