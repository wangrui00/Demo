package com.chatboard.servlet;

import com.chatboard.entity.BaseUser;
import com.chatboard.lib.MobileResult;
import com.chatboard.service.ServiceManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:46 2019/3/28
 **/
@RestController
@RequestMapping("user")
public class UserServlet extends BaseServlet{

    @PostMapping(value="login")
    public void login(@RequestParam(required = false) String userId, HttpServletRequest request, HttpServletResponse response)throws Exception{
        BaseUser user = ServiceManager.getInstance().getUserService().login(userId);
        MobileResult result = new MobileResult();
        result.setErrorCode(0);
        result.setState(true);
        result.setResult(user);
        log.debug("login function result {}",result.serialize());
        response(request,response,result);
    }
}
