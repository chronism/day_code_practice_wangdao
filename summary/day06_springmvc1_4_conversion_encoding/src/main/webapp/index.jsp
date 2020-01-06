<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/13
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单提交</title>
</head>
<body>
提交的是全部数据
<form action="/formdata/all" method="post">
    姓名 <input type="text" name="username" placeholder="username">
    <br>
    密码<input type="password" name="password" placeholder="password">
    <input type="submit">
    <br/>
    <input type="checkbox" name="hobby" value="basketball"/>篮球
    <input type="checkbox" name="hobby" value="pingpang"/>乒乓
    <input type="checkbox" name="hobby" value="swim"/>游泳
    <br>
    生日<input type="text" name="birthday" placeholder="birthday">
</form>
<hr/>
提交的是user
<form action="/formdata/user" method="post">
    姓名 <input type="text" name="username" placeholder="username">
    <br>
    密码<input type="password" name="password" placeholder="password">
    <br>
    提交<input type="submit">
</form>
<hr/>
提交的是的hobby
<form action="/formdata/hobby" method="post">
    <input type="checkbox" name="hobby" value="basketball"/>篮球
    <input type="checkbox" name="hobby" value="pingpang"/>乒乓
    <input type="checkbox" name="hobby" value="swim"/>游泳
    <br>
    提交<input type="submit">
</form>
<hr/>
提交的是生日
<form action="/formdata/date" method="post">
    生日<input type="text" name="birthday" placeholder="birthday">
    <br>
    提交<input type="submit">
</form>
</body>
</html>
