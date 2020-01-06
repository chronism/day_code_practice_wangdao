package com.cskaoyan.auth;

import com.cskaoyan.bean.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    /* 认证模块  */
    @Override
    /* 从subject.login()那里得到AuthenticationToken信息 */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*通过token获得用户名信息（token中的信息就是认证时传入的信息）*/
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        /*得到username去查询数据库里面的密码*/
        String username = usernamePasswordToken.getUsername();
        char[] password1 = usernamePasswordToken.getPassword();
        String password = password1.toString();
        /*相当于模拟数据库查询*/
//        String dbPassword = queryPasswordByDbUsername(username);

        /*构造一个传入的User*/
        User user = new User(username, password);
        /*dbPassword可以认为是数据库存储的密码*/
        String dbPassword = null;
        if ("zhangsan".equals(username)) {
            dbPassword = "123456";
        } else {
            dbPassword = "654321";
        }
        /* 核心模块，通过用户名来查询数据库的密码，查询不到就是用户名有问题，查出来之后与用户携带的密码进行比较，第三个参数是realm的名字 */
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, dbPassword, this.getName());
        return authenticationInfo;
    }

    /* 授权模块*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*得到PrincipalCollection的第一个参数User*/
        User user = (User) principalCollection.getPrimaryPrincipal();
        List permissions = queryPermission(user.getUsername());

        /*这个是语句的核心，可以对其进行操作，注意author还是authen*/
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if ("zhangsan".equals(user.getUsername())) {
            /* 角色添加 */
            authorizationInfo.addRole("role1");
        } else {
            authorizationInfo.addRole("role2");
        }
        /*权限添加*/
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    private List<String> queryPermission(String username) {
        ArrayList<String> arrayList = new ArrayList<>();
        if ("zhangsan".equals(username)) {
            arrayList.add("user:insert");
            arrayList.add("user:query");
            arrayList.add("user:update");
        } else {
            arrayList.add("user:query");
        }
        return arrayList;
    }


}



