package com.chatboard.entity;

import com.chatboard.config.RoleConfig;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:28 2019/3/28
 **/
@Getter
@Setter
public class Meeting extends BaseMeeting{

    private String userId;//创建者

    private Set<Member> members = new HashSet<>();

    public void addMember( Member member){
        members.add(member);
    }

    public Member getMember(String userId){
        for(Member member:members){
            if(member.getUserId().equals(userId)){
                return member;
            }
        }
        return null;
    }

    public static Meeting create(String meetingId,String name,String userId,String meetingNum){
        Meeting meeting = new Meeting();
        meeting.build(meetingId,name,meetingNum);
        meeting.setUserId(userId);
        meeting.addMember(Member.build(userId,RoleConfig.manager));
        return meeting;
    }
}
