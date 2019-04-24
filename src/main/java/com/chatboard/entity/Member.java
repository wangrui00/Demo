package com.chatboard.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:50 2019/3/28
 **/
@Getter
@Setter
public class Member {

    private String userId;

    private long roleId;

    public Member(String userId,long roleId){
        this.userId=userId;
        this.roleId=roleId;
    }

    public static Member build(String userId,long roleId){
        Member member = new Member(userId,roleId);
        return member;
    }
}
