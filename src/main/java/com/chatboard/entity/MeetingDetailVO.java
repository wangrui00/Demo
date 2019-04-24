package com.chatboard.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 12:24 2019/3/29
 **/
@Getter
@Setter
public class MeetingDetailVO {

    private String meetingId;

    private String name;

    private long roleId;

    public static MeetingDetailVO build(String meetingId,String name,long roleId){
        MeetingDetailVO vo = new MeetingDetailVO();
        vo.setMeetingId(meetingId);
        vo.setName(name);
        vo.setRoleId(roleId);
        return vo;
    }
}
