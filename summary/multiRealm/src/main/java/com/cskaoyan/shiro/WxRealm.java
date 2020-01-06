package com.cskaoyan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class WxRealm extends AuthorizingRealm {


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        MallToken token = (MallToken) authenticationToken;
        String type = token.getType();
        AuthenticationInfo info = dealInfoByType(type);
        return info;
    }

    private AuthenticationInfo dealInfoByType(String type) {
        //根据info不同处理不同的认证信息
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
