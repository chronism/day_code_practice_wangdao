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
免费开通人人网账号
<br/><br/>
<form action="/formdata/register" method="post" enctype="multipart/form-data">
    注册邮箱：<input type="email" name="email" placeholder="请输入你的邮箱号">
    <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你还可以使用账号注册或者手机号注册

    <br><br/>创建密码:<input type="password" name="password" placeholder="输入你的密码">
    <br><br/>真实姓名:<input type="text" name="username" placeholder="输入你的姓名">
    <br><br>性别: <input type="radio" name="gender" value="male"/>男
              <input type="radio" name="gender" value="female"/>女

    <br>上课老师: <select name="teacher.name">
                        <option value="刘中磊" selected>刘中磊</option>
                        <option value="何志鹏">何志鹏</option>
                        <option value="兰钊">兰钊</option>
                </select>
    <br>课程: <select name="teacher.course.course">
                        <option value="javaspring" >javaspring</option>
                        <option value="javase">javase</option>
                        <option value="springboot" selected>springboot</option>
                </select>

    <br><br>生日:<input type="datetime-local" name="birthday"><br/>
    <br>爱好:&nbsp;&nbsp;游泳<input type="checkbox" name="hobbys" value="swim">
                &nbsp;&nbsp;乒乓<input type="checkbox" name="hobbys" value="pingpang">
                &nbsp;&nbsp;舞蹈<input type="checkbox" name="hobbys" value="dance">
                &nbsp;&nbsp;篮球<input type="checkbox" name="hobbys" value="basketball">

    <br>我现在: <select name="state">
                    <option value="study" selected>正在上学</option>
                    <option value="work">正在工作</option>
                    <option value="free">自由职业</option>
                </select>
    <br>请选择上传的文件：<input type="file" name="myfile">
    <br><br><img src="/pic/static/verycode.gif"> 看不清楚换一张?
    <br>验证码:<input type="text" name="code">
    <br><br><input type="image" src="/pic/static/btn_reg.gif" >
</form>
</body>
</html>
