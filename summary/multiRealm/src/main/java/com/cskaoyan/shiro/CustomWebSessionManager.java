package com.cskaoyan.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class CustomWebSessionManager extends DefaultWebSessionManager {
    @Override
    protected Serializable getSessionId(ServletRequest request1, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) request1;
        String header = request.getHeader("X-cskaoyanmall-admin-token");
        if (header != null && !"".equals(header)) {
            return header;
        }
        String header2 = request.getHeader("X-cskaoyanmall-wx-token");
        if (header2 != null && !"".equals(header2)) {
            return header2;
        }
        return super.getSessionId(request, response);
    }
}
