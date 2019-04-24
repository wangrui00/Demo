package com.chatboard.servlet;

import com.chatboard.entity.BaseUser;
import com.chatboard.entity.MeetingDetailVO;
import com.chatboard.entity.MeetingVO;
import com.chatboard.entity.UserVO;
import com.chatboard.lib.MobileResult;
import com.chatboard.message.MeetingProperty;
import com.chatboard.service.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 12:04 2019/3/28
 **/
@RestController
@RequestMapping("meeting")
public class MeetingServlet extends BaseServlet{

    private Logger log = LoggerFactory.getLogger(MeetingServlet.class);

    @PostMapping(value = "create")
    public void createMeeting(@RequestParam String userId, @RequestParam String name, HttpServletRequest request, HttpServletResponse response) throws Exception{
        BaseUser user = ServiceManager.getInstance().getUserService().getUser(userId);
        if(user==null){
            log.error("user is null");
            return ;
        }
        MeetingVO meetingVO = ServiceManager.getInstance().getMeetingService().createMeeting(user,name);
        MobileResult result = new MobileResult();
        result.setErrorCode(0);
        result.setState(true);
        result.setResult(meetingVO);
        this.response(request,response,result);
    }

    @GetMapping(value = "get")
    public void getMeeting(@RequestParam String userId,@RequestParam String meetingNum,HttpServletRequest request, HttpServletResponse response) throws Exception{
        BaseUser user = ServiceManager.getInstance().getUserService().getUser(userId);
        if(user==null){
            log.error("user is null");
            return ;
        }
        MobileResult result = new MobileResult();
        result.setErrorCode(0);
        result.setState(true);
        MeetingDetailVO vo = ServiceManager.getInstance().getMeetingService().getMeeting(userId,meetingNum);
        result.setResult(vo);
        log.debug("getMeeting result {}",result.serialize());
        this.response(request,response,result);
    }

    @GetMapping(value = "getList")
    public void getMeetingList(@RequestParam String userId,HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<MeetingVO> meetingVOList = ServiceManager.getInstance().getMeetingService().getMyMeetingList(userId);
        MobileResult result = new MobileResult();
        result.setState(true);
        result.setErrorCode(0);
        result.setResult(meetingVOList);
        this.response(request,response,result);
    }
}
