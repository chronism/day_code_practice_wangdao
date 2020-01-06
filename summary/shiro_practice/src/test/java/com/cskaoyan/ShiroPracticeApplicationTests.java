package com.cskaoyan;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ShiroPracticeApplicationTests {

    /*shiro的核心是security*/
    @Test
    void contextLoads() {
        /*通过IniSecurityManagerFactory获得SecurityManager*/
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:first.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        /*获得实例*/
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        /*subject执行认证*/
        /*提供执行的用户和密码信息，放入到token中*/
        UsernamePasswordToken token = new UsernamePasswordToken("user1", "123456");
        subject.login(token);
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
//        authorBaseRole(subject);
        authorBasePermmison(subject);
    }

    private void authorBasePermmison(Subject subject) {
        String insert = "user:insert";
        String update = "user:update";
        String delete = "user:delete";
        String query = "user:query";
        boolean user1 = subject.isPermitted("delete");
        boolean user2 = subject.isPermitted("user");
        boolean user3 = subject.isPermitted("user:delete");
        System.out.println("delete是否具有该权限：" + user1);
        System.out.println("user是否具有该权限：" + user2);
        System.out.println("user:delete是否具有该权限：" + user3);
        boolean[] permitted = subject.isPermitted(insert, update, delete, query);
        System.out.println(Arrays.toString(permitted));
    }

    private void authorBaseRole(Subject subject) {

        boolean role1 = subject.hasRole("role1");
        System.out.println("subject是否有角色role1d：" + role1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("role1");
        arrayList.add("role2");
        arrayList.add("role3");
        arrayList.add("role4");
        arrayList.add("role5");
        boolean[] booleans = subject.hasRoles(arrayList);
        System.out.println(Arrays.toString(booleans));
    }


    @Test
    public void myTets2() {
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:custom.ini");

        /* 这个是通过引值创建的securityManager */
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken authenticationToken = new UsernamePasswordToken("user1", "654321");
        /*注意login()里面的参数一定是UsernamePasswordToken类型*/
        subject.login(authenticationToken);
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        String insert = "user:insert";
        String update = "user:update";
        String delete = "user:delete";
        String query = "user:query";

        boolean role2 = subject.hasRole("role2");
        boolean role1 = subject.hasRole("role1");
        System.out.println(authenticationToken.getUsername()+"有角色role1："+role1);
        boolean[] permitted = subject.isPermitted("user:insert", "user:delete", "user:query", "user:update");
        List<Permission> list = new ArrayList<>();
        boolean[] booleans = subject.isPermitted(insert,delete,update,query);
        System.out.println(Arrays.toString(booleans));

        System.out.println(authenticationToken.getUsername()+"有角色role2："+role2);
        System.out.println(Arrays.toString(booleans));
    }

}
