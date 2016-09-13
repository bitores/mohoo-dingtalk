/*
 * UnloginController.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohoo.dingtalk.util.ConstantUtil;
import com.mohoo.dingtalk.util.RestFulUtil;

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
@RestController
public class UnloginController {

	/**
	 * 生成免登链接 方法描述
	 * 
	 * @param url
	 * @return
	 */
	@RequestMapping(value = "/findLink", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> findLink(String url) {
		return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS, ConstantUtil.unLoginUrl(url));
	}

	@RequestMapping("setConfig")
	public Map<String, Object> setConfig(String secret) {
		ConstantUtil.SECRET = secret;
		return RestFulUtil.restFulMap(RestFulUtil.RES_SUCCESS);
	}

}
