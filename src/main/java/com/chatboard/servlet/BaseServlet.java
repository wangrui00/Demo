package com.chatboard.servlet;

import com.chatboard.lib.MobileResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class BaseServlet {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@ModelAttribute
	public void invokeBeforeRequestMapping(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logStart(request);
	}
	
	/**
	 * 打印请求参数
	 * @param request
	 */
	private void logStart(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String servletPath = request.getServletPath();
    	sb.append("path=");
    	sb.append(servletPath);
    	sb.append(", ");
        @SuppressWarnings("unchecked")
		Enumeration<String> paramNames = request.getParameterNames();
        if (paramNames == null) {
            log.debug("[logprint] [logStart] {}", sb.toString());
        	return;
        }
        int iii = 0;
        while (paramNames.hasMoreElements()) {
        	if (iii > 0) {
            	sb.append(", ");
        	}
        	iii++;
            String key = (String) paramNames.nextElement();
        	sb.append(key);
            String[] values = request.getParameterValues(key);
            if (values == null || values.length <= 0) {
            	continue;
            }
            sb.append("=");
            Object value = values[0];
        	sb.append(value);
        }
        log.info("[logprint] [logStart] {}", sb.toString());
    }
	
	protected void response(HttpServletRequest request, HttpServletResponse response, MobileResult mobileResult) throws IOException {
		log.info("[logprint] [logEnd] path={}, mobileResult={}", request.getServletPath(), mobileResult);
		if (mobileResult == null) {
			return;
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mobileResult.serialize());
		response.getWriter().close();
	}
	
}
