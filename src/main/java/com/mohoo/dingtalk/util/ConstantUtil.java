/*
 * ConstantUtil.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.util;

import com.mohoo.dingtalk.Env;

/**
 * 类描述
 * <p>
 * 创建日期：2016年9月2日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class ConstantUtil {
	private final static String unLoginUrl = "https://oa.dingtalk.com/omp/api/micro_app/admin/landing";

	public static String unLoginUrl(String url) {
		return unLoginUrl + "?corpid=" + Env.CORP_ID + "&redirect_url=" + url;
	}

	public static String SECRET = "A6allQ3JirgfJz-n1mw947MhHpWHrikQe2s2BoSnAsz4bRDX3m3A8F7p1RU2ofo_";

	public static String APPID = "dinga3eb47eed8679fa3";
	
	public static String agentId = "36805200";
	
	public static String web_url = "http://mhoa.iceinto.com.ngrok.cc/";

	private static final String tokenUrl = "https://oapi.dingtalk.com/gettoken?corpid=id&corpsecret=secrect";
	
	private static String getAccessTokenUrl() {
		return tokenUrl + "?corpid=" + Env.CORP_ID + "&corpsecret=" + SECRET;
	};
}
