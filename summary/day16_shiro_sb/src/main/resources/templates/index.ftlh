<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>请登录:admin</h1>
<form action="/admin/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码： <input type="text" name="password"><br>
    <input type="submit" name="登录">
</form>
<hr/>
<h1>请登录:wx</h1>
<form action="/wx/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码： <input type="text" name="password"><br>
    <input type="submit" name="登录">
</form>
</body>
</html>