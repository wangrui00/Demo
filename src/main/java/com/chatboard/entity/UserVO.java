package com.chatboard.entity;

import com.chatboard.service.ServiceManager;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 19:38 2019/3/28
 **/
@Setter
@Getter
public class UserVO extends BaseUser{

    private long roleId;

    public static UserVO create(Member member){
        UserVO userVO = new UserVO();
        userVO.setRoleId(member.getRoleId());
        String userId = member.getUserId();
        BaseUser baseUser = ServiceManager.getInstance().getUserService().getUser(userId);
        userVO.build(baseUser.getUserId(),baseUser.getNickName(),baseUser.getHeadPic());
        return userVO;
    }
}
