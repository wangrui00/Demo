package com.chatboard.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 18:04 2019/3/28
 **/
@Getter
@Setter
public class BaseMeeting {

    private String meetingId;

    private String name;

    private long createTime;

    private String meetingNum;

    public void build(String meetingId,String name,String meetingNum){
        setMeetingId(meetingId);
        setName(name);
        setMeetingNum(meetingNum);
        setCreateTime(System.currentTimeMillis());
    }

}
