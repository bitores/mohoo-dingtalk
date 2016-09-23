/*
 * RestFulUtil.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.dingtalk.util;

import java.util.HashMap;
import java.util.Map;

import org.omg.PortableInterceptor.SUCCESSFUL;

import com.alibaba.fastjson.JSONObject;

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
public class RestFulUtil {
	public static Map<String, String> resultMap = new HashMap<String, String>();
	/**
	 * 成功
	 */
	public final static String RES_SUCCESS = "200";
	/**
	 * 失败
	 */
	public final static String RES_FAULT_INTER = "300";
	/**
	 * 系统异常
	 */
	public final static String RES_ERROR = "500";

	static {
		resultMap.put(RES_SUCCESS, "ok!");
		resultMap.put(RES_FAULT_INTER, "接口调用异常!");
		resultMap.put("400", "ok");
		resultMap.put(RES_ERROR, "系统错误，请稍后重试!");
		resultMap.put("600", "ok");
		resultMap.put("700", "ok");
	}

	/**
	 * 有结果值的返回
	 * 
	 * @param <T>
	 * 
	 * @param code
	 *            请使用上面的常量
	 * @param errorInfo
	 *            错误的详细信息
	 * @param paramMap
	 *            返回的数据集
	 * @return
	 */
	public static <T> Map<String, Object> restFulMap(String code, String errorInfo, T paramMap) {
		return result(code, errorInfo, paramMap);
	}

	/**
	 * 有结果值的返回
	 * 
	 * @param <T>
	 * 
	 * @param code
	 *            请使用上面的常量
	 * @param paramMap
	 *            返回的数据集
	 * @return
	 */
	public static <T> Map<String, Object> restFulMap(String code, T paramMap) {
		return result(code, "", paramMap);
	}

	/**
	 * 无结果值的返回，
	 * 
	 * @param code
	 *            请使用上面的常量
	 * @return
	 */
	public static Map<String, Object> restFulMap(String code) {
		return result(code, "", null);
	}

	/**
	 * 无结果值的返回，
	 * 
	 * @param code
	 *            请使用上面的常量
	 * @param errorInfo
	 *            错误的详细信息
	 * @return
	 */
	public static Map<String, Object> restFulInfo(String code, String errorInfo) {
		return result(code, errorInfo, null);
	}

	/**
	 * 通用返回结果 方法描述
	 * 
	 * @param <T>
	 * @param code
	 * @param errorInfo
	 * @param paramMap
	 * @return
	 */
	private static <T> Map<String, Object> result(String code, String errorInfo, T paramMap) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errorCode", code);
		result.put("errorMsg", resultMap.get(code));
		result.put("errorInfo", errorInfo);
		result.put("data", paramMap);
		return result;
	}

	public static void test(String[] args) {
		System.out.println(restFulMap(RES_FAULT_INTER, null));
		System.out.println(restFulMap(RES_SUCCESS, "1234"));
	}
}
