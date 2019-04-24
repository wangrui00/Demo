# 白板SDK的Demo
.用spring boot工程编写的SDK服务,依赖maven
# 编译打包
用maven打包
maven install 在target目录下生成 demo-0.0.1-SNAPSHOT.jar 包
# 启动
java -jar demo-0.0.1-SNAPSHOT.jar
# 配置文件
全局的配置文件：
application-test.yml

  server:
  
  tomcat:
  
    uri-encoding: UTF-8
  ssl:
    
    key-store: 123456.jks   
    
    key-store-password: 123456
    
    key-store-type: JKS
  port: 8989
  servlet:
    context-path: /Demo

context:
  applicationPath: demo

role:
  #{1: 管理员, 2: 嘉宾, 3: 观众}
  manager: 1
  guest: 2
  audience: 3

sdk:
  appId: *********************************
  appSecret: *********************************
  sdkUrl: https://****************************

meeting:
  width: 1920   //白板宽
  height: 1080  //白板高
  bgColor: 1    //白板背景色 目前只支持三种 1:白色 2：黑色  3：绿色
