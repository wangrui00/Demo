package com.chatboard.service;

import com.chatboard.lib.SpringContextUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:06 2019/3/27
 **/
@Getter
@Setter
@Service("serviceManager")
public class ServiceManager {

    private static ServiceManager instance;

    public static ServiceManager getInstance(){
        if(instance==null){
            instance = (ServiceManager) SpringContextUtils.getBeanById("serviceManager");
        }
        return instance;
    }

    @Resource
    public MeetingService meetingService;

    @Resource
    public UserService userService;

    public ServiceManager(){

    }

    public boolean appStart(){
        meetingService.onStart();
        userService.onStart();
        return true;
    }

}
