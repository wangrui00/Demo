package com.chatboard.service;

import com.chatboard.config.RoleConfig;
import com.chatboard.entity.*;
import com.chatboard.message.MeetingProperty;
import com.chatboard.remote.RemoteManager;
import com.chatboard.util.RandomNumUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:25 2019/3/28
 **/
@Service("meetingService")
public class MeetingService extends BaseService{

    private Map<String,Meeting> meetingMap = new HashMap<>();

    private Map<String,String> meetingNumMap = new HashMap<>();

    /***
     * 创建会议
     * ***/
    public MeetingVO createMeeting(BaseUser user, String name){
        MeetingProperty meetingProperty = MeetingProperty.create();
        String meetingId = RemoteManager.createMeeting(meetingProperty);
        String meetingNum = RandomNumUtil.shuffleRandom();
        this.meetingNumMap.put(meetingNum,meetingId);
        Meeting meeting = Meeting.create(meetingId,name,user.getUserId(),meetingNum);
        this.meetingMap.put(meetingId,meeting);
        MeetingVO meetingVO = MeetingVO.create(meeting);
        return meetingVO;
    }

    /**
     * 获取会议详情
     * ****/
    public MeetingDetailVO getMeeting(String userId,String meetingNum){
        String meetingId = this.meetingNumMap.get(meetingNum);
        Meeting meeting = meetingMap.get(meetingId);
        Member member = meeting.getMember(userId);
        long roleId = RoleConfig.audience;
        if(member==null){
            member = Member.build(userId, roleId);
            meeting.addMember(member);
        }
        return MeetingDetailVO.build(meetingId,meeting.getName(),member.getRoleId());
    }

    /**
     * 获取会议列表
     * ***/
    public List<MeetingVO> getMyMeetingList(String userId){
        //此处应该用数据库
        List<Meeting> meetingList = new ArrayList<>();
        meetingMap.values().forEach(meeting -> {
            Set<Member> members = meeting.getMembers();
            for(Member member:members){
                if(member.getUserId().equals(userId)){
                    meetingList.add(meeting);
                }
            }
        });

        List<MeetingVO> meetingVOList = new ArrayList<>();
        meetingList.forEach(meeting -> {
            meetingVOList.add(MeetingVO.create(meeting));
        });
        return meetingVOList;
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
