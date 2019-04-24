package com.chatboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:10 2019/3/28
 **/
@Component
public class AppConfig {

    public static String sdkUrl = "http://192.168.0.31:8080/Chatboard";

    public static String appId = "b289e574dbae4ed9b63702877ff2b51f";

    public static String appSecret = "88e8a386e663492c8d08dc63902b2c7c";

    @Value("${sdk.appId}")
    public void setAppId(String appId){
        AppConfig.appId=appId;
    }

    @Value("${sdk.appSecret}")
    public void setCertificate(String appSecret) {
        AppConfig.appSecret = appSecret;
    }

    @Value("${sdk.sdkUrl}")
    public void setSdkUrl(String sdkUrl) {
        AppConfig.sdkUrl = sdkUrl;
    }
}
