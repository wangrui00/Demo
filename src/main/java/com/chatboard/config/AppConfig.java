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

    public static String appId = "********************************* ";

    public static String appSecret = "********************************* ";

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
