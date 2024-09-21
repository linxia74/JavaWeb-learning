<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>响应不同类型的文件</title>
  <style>
    ul li {
      list-style: none;
      float: left;
      margin-top: 40px;
    }
    ul li a{
      padding: 20px 50px;
      height: 40px;
      background-color: #00b7ee;
      color: #ffffff;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;

    }
    ul li a:hover{
      background-color: #00a2d4;
    }

  </style>
</head>
<body>
<h1><%= "设置Cnotent-Type" %>
</h1>
<h2><%="根据不同的参数返回不同资源"%>></h2>
<br/>
<ul>
  <li>
    <a href="res?type=img">返回图片</a></li>
</ul>
<ul>
  <li>
    <a href="res?type=text">返回文本</a></li>
</ul>
<ul>
  <li>
    <a href="res?type=pdf">返回pdf</a></li>
</ul>
<ul>
  <li>
    <a href="res?type=web">返回网页</a></li>
</ul>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>