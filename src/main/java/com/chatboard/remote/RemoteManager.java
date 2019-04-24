package com.chatboard.remote;

import com.chatboard.config.AppConfig;
import com.chatboard.lib.MobileResult;
import com.chatboard.message.MeetingProperty;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:10 2019/3/28
 **/
public class RemoteManager {

    /**
     * 创建会议
     */
    public static String createMeeting(MeetingProperty property) {
        String url = AppConfig.sdkUrl + "/meeting";
        Object[] params = new Object[] { AppConfig.appId, property };
        MobileResult invoke = JsonRpcManager.invoke(params, MobileResult.class, url, "createMeeting");
        if (invoke == null || !invoke.isState()) {
            return null;
        }
        return (String) invoke.getResult();
    }

}
