package com.chatboard.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 19:38 2019/3/28
 **/
@Getter
@Setter
public class BaseUser {

    private String userId;

    private String nickName;

    private String headPic;

    public void build(String userId,String nickName,String headPic){
        setHeadPic(headPic);
        setNickName(nickName);
        setUserId(userId);
    }

    public static BaseUser create(String userId,String nickName,String headPic){
        BaseUser baseUser = new BaseUser();
        baseUser.build(userId,nickName,headPic);
        return baseUser;
    }
}
