<%--
  Created by IntelliJ IDEA.
  User: 叶刘辉
  Date: 2019/10/23
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <a href="/account/findAll">测试查询</a>
</head>
<body>

<form action="/account/insert" method="post">
    姓名：<input type="text" name="name">
    <br>
    金钱: <input type="text" name="money">
    <br>
    <input type="submit" value="上传">
</form>

</body>
</html>
