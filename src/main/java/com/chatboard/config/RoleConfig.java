package com.chatboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 14:09 2019/3/28
 **/
@Component
public class RoleConfig {

    public static long manager = 1L;

    public static long guest = 2L;

    public static long audience = 3L;

    @Value("${role.manager}")
    public void setManager(long manager){
        RoleConfig.manager=manager;
    }

    @Value("${role.guest}")
    public void setGuest(long guest){
        RoleConfig.guest=guest;
    }

    @Value("${role.audience}")
    public void setAudience(long audience){
        RoleConfig.audience=audience;
    }

}
