<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>通过ID转账</h1>
<form action="/user/transaction/id" >
    转账方的ID：<input type="text" name="from_id"><br>
    接收方的ID：<input type="text" name="to_id"><br>
    金额：<input type="text" name="money">
    确认提交：<input type="submit">
</form>
<br><hr>
<h1>通过名字转账</h1>
<form action="/user/transaction/username" >
    转账方的ID：<input type="text" name="from_id"><br>
    接收方的ID：<input type="text" name="to_id"><br>
    金额：<input type="text" name="money">
    确认提交：<input type="submit">
</form>
</body>
</html>