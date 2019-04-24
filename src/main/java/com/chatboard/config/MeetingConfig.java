package com.chatboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:00 2019/3/29
 **/
@Component
public class MeetingConfig {

    public static int width=1920;

    public static int height=1080;

    public static int bgColor=1;

    @Value("${meeting.width}")
    public void setWidth(int width){
        MeetingConfig.width=width;
    }

    @Value("${meeting.height}")
    public void setHeight(int height){
        MeetingConfig.height=height;
    }

    @Value("${meeting.bgColor}")
    public void setBgColor(int bgColor){
        MeetingConfig.bgColor=bgColor;
    }
}
