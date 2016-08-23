# lib 目录说明
## 钉钉服务端
JAVA版demo中使用了服务端JAVA SDK，下面是对SDK的介绍

SDK地址：https://github.com/ddtalk/client_sdk

### 1、使用场景
* SDK 对钉钉开放平台接口做了封装，方便JAVA开发者接入方使用。由于服务端接口会不断增加，SDK内的API有时会来不及增加，所以SDK内的API只是钉钉开放平台服务端接口的子集，SDK会定期增加新接口的支持，如果等不及，可以按照下述第8条的方式自己实现API。

### 2、外部主要依赖
* JDK7、slf4j-api(1.7.13)、slf4j-log4j12(1.7.9)、log4j(1.2.17)、async-http-client(1.9.32)、netty(3.10.5.Final)、commons-io(2.4)、fastjson(1.1.40)

### 3、最新版本
* 1.0.0

### 4、jar包功能区分
* client-sdk.core-{version}.jar:SDK核心类库，负责网络通信及API扫描
* client-sdk.common-{version}.jar:SDK内共用代码如注解的定义
* client-sdk.api-{version}.jar:SDK会扫描此包内的API，如需自定义新的API可按照规范在此包内增加
* client-sdk.spring-{version}.jar:如果需要在Spring环境中使用SDK才需要依赖此jar

参考地址：https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.aZzzD0&treeId=172&articleId=104964&docType=1#s5