package com.cskaoyan.config;

import com.cskaoyan.shiro.AdminRealm;
import com.cskaoyan.shiro.WxRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    /*
     * ShiroFilterFactoryBean
     * */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/unauthc");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/wx/login", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/unauthc", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }


    /*
     * SecurityManager
     *
     * */
    @Bean
    public DefaultWebSecurityManager securityManager(AdminRealm adminRealm,
                                                     DefaultWebSessionManager sessionManager,
                                                     CustomAuthenticator authenticator) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(adminRealm);
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setAuthenticator(authenticator);
        return defaultWebSecurityManager;
    }

    /*
     * DefaultWebSessionManager
     * */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();

        return defaultWebSessionManager;
    }

    /*
     * AuthorizationAttributeSourceAdvisor
     * */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public CustomAuthenticator authenticator(AdminRealm adminRealm, WxRealm wxRealm) {
        CustomAuthenticator customAuthenticator = new CustomAuthenticator();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        customAuthenticator.setRealms(realms);
        return customAuthenticator;
    }
}
