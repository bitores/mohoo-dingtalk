/*
 * UnloginController.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import com.dingtalk.open.client.utils.StringUtils;
import com.mohoo.dingtalk.service.JsApiService;
import com.mohoo.dingtalk.service.TokenService;
import com.mohoo.dingtalk.service.UserService;
import com.mohoo.dingtalk.util.ConstantUtil;
import com.mohoo.dingtalk.util.RestFulUtil;
import com.mohoo.dingtalk.util.aes.DingTalkEncryptException;
import com.mohoo.dingtalk.util.aes.DingTalkJsApiSingnature;

/**
 * 免登 创建日期：2016年9月2日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
@RequestMapping("dingtalk/v1.0/unlogin")
@Controller
public class UnloginController {

	private static JsApiService jsApiService = new JsApiService();

	/**
	 * 生成免登链接 方法描述
	 * 
	 * @param url
	 * @return
	 */
	@RequestMapping(value = "/findLink")
	@ResponseBody
	public ModelAndView findLink(ModelMap model,HttpServletRequest request) {
		try {
			String access_token = TokenService.getAccessToken();
			String jsTicket = jsApiService.getTicket(access_token);
			String nonceStr = "mohoo2011";
			Long timeStamp = System.currentTimeMillis() / 1000;
			String url = request.getParameter("url");
			String linkUrl = "";
			if (StringUtils.isEmpty(url)) {
				url = ConstantUtil.web_url+"dingtalk/v1.0/unlogin/findLink";
				linkUrl = ConstantUtil.web_url + "dingtalk/v1.0/unlogin/getUserInfo";
			}
			System.out.println("===================" + url);
			String signature = DingTalkJsApiSingnature.getJsApiSingnature(url, nonceStr, timeStamp, jsTicket);
			model.put("url", linkUrl);
			model.put("nonceStr", nonceStr);
			model.put("agentId", ConstantUtil.agentId);
			model.put("corpId", ConstantUtil.APPID);
			model.put("signature", signature);
			model.put("timeStamp", timeStamp);
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
		} catch (SdkInitException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (DingTalkEncryptException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/index.jsp");
	}

	@RequestMapping("setConfig")
	public Map<String, Object> setConfig(String secret) {
		ConstantUtil.SECRET = secret;
		return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS);
	}

	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(HttpServletRequest request) {
		String message = "";
		try {
			String access_token = TokenService.getAccessToken();
			String code = request.getParameter("code");
			System.out.println("================mycode" + code);
			CorpUserDetail user = UserService.getUserDetail(access_token, code);
			return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, user);
		} catch (ServiceNotExistException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (SdkInitException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (ServiceException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return RestFulUtil.restFulInfo(RestFulUtil.RES_FAULT_INTER, message);
	}
}
