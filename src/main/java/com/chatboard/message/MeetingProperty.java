package com.chatboard.message;

import com.chatboard.config.AppConfig;
import com.chatboard.config.MeetingConfig;
import com.chatboard.lib.BaseMessage;
import com.chatboard.lib.Md5Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 14:34 2018/12/11
 **/
@Getter
@Setter
@ToString
public class MeetingProperty extends BaseMessage {

    private String token;

    private int width;

    private int height;

    private int bgColor;//1：白板 2：黑板 3:绿板

    public static MeetingProperty create() {
        MeetingProperty property = new MeetingProperty();
        property.setWidth(MeetingConfig.width);
        property.setHeight(MeetingConfig.height);
        property.setBgColor(MeetingConfig.bgColor);
        String token  = Md5Util.getMd5(AppConfig.appId + AppConfig.appSecret);
        property.setToken(token);
        return property;
    }

}
