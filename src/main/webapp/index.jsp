<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://g.alicdn.com/dingding/open-develop/0.7.0/dingtalk.js"></script>
<script type="text/javascript">
	dd.config({
		agentId : "${agentId}",
		corpId : "${corpId}",
		timeStamp : "${timeStamp}",
		nonceStr : "${nonceStr}",
		signature : "${signature}",
		jsApiList : [ 'runtime.info', 'device.notification.prompt',
				'biz.chat.pickConversation', 'device.notification.confirm',
				'device.notification.alert', 'device.notification.prompt',
				'biz.chat.open', 'biz.util.open', 'biz.user.get',
				'biz.contact.choose', 'biz.telephone.call', 'biz.ding.post' ]
	});
	dd
			.ready(function() {
				dd.biz.navigation.setTitle({
					title : '钉钉demo',
					onSuccess : function(data) {
// 						test222();
					},
					onFail : function(err) {
						log.e(JSON.stringify(err));
					}
				});
				dd.runtime.info({
					onSuccess : function(info) {
						logger.e('runtime info: ' + JSON.stringify(info));
					},
					onFail : function(err) {
						logger.e('info fail: ' + JSON.stringify(err));
					}
				});

				dd.ui.pullToRefresh.enable({
					onSuccess : function() {
						alert("info");
					},
					onFail : function() {
						alert("fail");
					}
				})
				dd.biz.navigation.setMenu({
					backgroundColor : "#ADD8E6",
					items : [ {
						id : "此处可以设置帮助",//字符串
						// "iconId":"file",//字符串，图标命名
						text : "帮助"
					}, {
						"id" : "2",
						"iconId" : "photo",
						"text" : "我们"
					}, {
						"id" : "3",
						"iconId" : "file",
						"text" : "你们"
					}, {
						"id" : "4",
						"iconId" : "time",
						"text" : "他们"
					} ],
					onSuccess : function(data) {
						alert(JSON.stringify(data));

					},
					onFail : function(err) {
						alert(JSON.stringify(err));
					}
				});
				dd.runtime.permission.requestAuthCode({
					corpId : "${corpId}",
					onSuccess : function(info) {
						alert("获取code成功");
						location.href='${url}?code=' + info.code;
					},
					onFail : function(err) {
						alert('requestAuthCode fail: ' + JSON.stringify(err));
					}
				});
			});

	dd.error(function(err) {
		alert('dd error: ' + JSON.stringify(err));
	});
</script>
</head>
<body>
</body>
</html>