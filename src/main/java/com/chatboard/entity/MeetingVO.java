package com.chatboard.entity;

import com.chatboard.service.ServiceManager;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangrui
 * @Description: 给客户端的结构
 * @Date:Created in 14:48 2019/3/28
 **/
@Getter
@Setter
public class MeetingVO extends BaseMeeting{

    private String author;

    private List<UserVO> members;

    public static MeetingVO create(Meeting meeting){
        MeetingVO vo = new MeetingVO();
        vo.build(meeting.getMeetingId(),meeting.getName(),meeting.getMeetingNum());
        vo.setAuthor(meeting.getUserId());
        List<UserVO> members = new ArrayList<>();
        for(Member member:meeting.getMembers()){
            UserVO userVO = UserVO.create(member);
            members.add(userVO);
        }
        vo.setMembers(members);
        return vo;
    }
}
