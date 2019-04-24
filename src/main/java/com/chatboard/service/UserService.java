package com.chatboard.service;

import com.chatboard.entity.BaseUser;
import com.chatboard.util.RandomHeadPicUtil;
import com.chatboard.util.RandomNameUtil;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 12:06 2019/3/28
 **/
@Service("userService")
public class UserService extends BaseService{

    private Map<String,BaseUser> userMap = new HashMap<>();

    public BaseUser getUser(String userId){
       return userMap.get(userId);
    }

    public BaseUser login(String userId){
        userMap.keySet().forEach(user->{
            log.debug("user is {}",user);
        });
        if(userMap.get(userId) != null){
            return userMap.get(userId);
        }
        BaseUser user = BaseUser.create(UUID.randomUUID().toString(),RandomNameUtil.getRandomName(),RandomHeadPicUtil.getRandomHeadPic());
        this.userMap.put(user.getUserId(),user);
        return user;
    }

    @Override
    public boolean onStart() {
        return true;
    }

    @Override
    public boolean onClose() {
        return true;
    }
}
